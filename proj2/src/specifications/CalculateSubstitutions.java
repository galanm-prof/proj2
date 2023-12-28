package specifications;

import common.Substitution;
import file.RepositoryHandler;
import org.antlr.v4.runtime.misc.Pair;
import org.semanticweb.HermiT.Reasoner;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.*;
import org.semanticweb.owlapi.reasoner.OWLReasoner;
import org.semanticweb.owlapi.reasoner.OWLReasonerFactory;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Stream;

public class CalculateSubstitutions {
     private static final String specificationsRepository="c:/xampp/htdocs/specifications/";
     private static final String specificationsPath="http://127.0.0.1/specifications/";
     private static final String modulesPath="http://127.0.0.1/modules/";
     private static List<Substitution>substitutions=new LinkedList<>();
     private static String specificationName1;
     private static String specificationName2;
     private static Map<String,String>I1;
     private static Map<String,String>I2;
     private static Map<String,String> O1;
     private static Map<String,String>O2;
     public static List<Substitution> getSubstitutions(){
        return substitutions;
     }
     public static Map<String,String>getI1(){
        return I1;
     }
     public static Map<String,String>getI2(){
        return I2;
     }
     public static Map<String,String>getO1(){
        return O1;
     }
     public static Map<String,String>getO2(){
        return O2;
     }

     private static Pair<String,String> processLine(String line){
         Pair<String,String>r;
         String[] parts = line.split(",");
         r=new Pair<>(parts[0].trim(),parts[1].trim());
         return r;
     }
     private static void readParametersSpecifications() throws IOException {
        Path filePathI1 =   Path.of(specificationsRepository+
                specificationName1.replace(".txt","")+"/I.txt");
        Path filePathI2 =   Path.of(specificationsRepository+
                specificationName2.replace(".txt","")+"/I.txt");
        Path filePathO1 =   Path.of(specificationsRepository+
                specificationName1.replace(".txt","")+"/O.txt");
        Path filePathO2 =   Path.of(specificationsRepository+
                specificationName2.replace(".txt","")+"/O.txt");

        Stream<String> i1=Files.lines(filePathI1);
        Stream<String> i2=Files.lines(filePathI2);
        Stream<String> o1=Files.lines(filePathO1);
        Stream<String> o2=Files.lines(filePathO2);

        Stream<Pair<String,String>>inputs1=i1.map(line->
                processLine(line));
        Stream<Pair<String,String>>inputs2=i2.map(line->
                processLine(line));
        Stream<Pair<String,String>>outputs1=o1.map(line->
                processLine(line));
        Stream<Pair<String,String>>outputs2=o2.map(line->
                processLine(line));

        inputs1.forEach(e->I1.put(e.a,e.b));
        inputs2.forEach(e->I2.put(e.a,e.b));
        outputs1.forEach(e->O1.put(e.a,e.b));
        outputs2.forEach(e->O2.put(e.a,e.b));
     }

     public static void init(String name1, String name2) throws IOException {
         specificationName1=name1;
         specificationName2=name2;
         I1=new HashMap<>();
         O1=new HashMap<>();
         I2=new HashMap<>();
         O2=new HashMap<>();
         readParametersSpecifications();
     }

     //Calculate the potential substitutions of the parameters in specificationName2
     private static Map<String, Set<String>> calculatePotentialSubstitution(boolean inputParameters,IRI vocabularyIRI) throws OWLOntologyCreationException {
         Map<String, Set<String>> potentialSubstitution = new HashMap<>();

         OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
         OWLReasonerFactory reasonerFactory = new Reasoner.ReasonerFactory();
         OWLDataFactory owlDataFactory = manager.getOWLDataFactory();

         OWLOntology vocabulary = manager.loadOntology(vocabularyIRI);
         OWLReasoner reasoner=reasonerFactory.createReasoner(vocabulary);
         if (inputParameters){
             I2.keySet().stream().forEach(p2->{
                 OWLClass typeParameter2 =
                         owlDataFactory.getOWLClass(IRI.create(I2.get(p2)));
                 Set<String>inputParameters1 = new HashSet<>();
                 I1.keySet().stream().forEach(p1->{
                     OWLClass typeParameter1 =
                             owlDataFactory.getOWLClass(IRI.create(I1.get(p1)));
                     OWLAxiom axiom = owlDataFactory.getOWLSubClassOfAxiom(typeParameter2,typeParameter1);
                     if (reasoner.isEntailed(axiom))
                         inputParameters1.add(p1);
                 });
                 potentialSubstitution.put(p2,inputParameters1);
             });
         }
         else{
             O2.keySet().stream().forEach(p2->{
                 OWLClass typeParameter2 =
                         owlDataFactory.getOWLClass(IRI.create(O2.get(p2)));
                 Set<String>outputParameters1 = new HashSet<>();
                 O1.keySet().stream().forEach(p1->{
                     OWLClass typeParameter1 =
                             owlDataFactory.getOWLClass(IRI.create(O1.get(p1)));
                     OWLAxiom axiom = owlDataFactory.getOWLSubClassOfAxiom(typeParameter1,typeParameter2);
                     if (reasoner.isEntailed(axiom))
                         outputParameters1.add(p1);
                 });
                 potentialSubstitution.put(p2,outputParameters1);
             });
         }
         return potentialSubstitution;
     }

     //Pre: there exists substitutions
     private static Map<String, Set<String>> calculatePotentialSubstitutions(boolean inputParameters,
                                                                            boolean optimisation) throws OWLOntologyCreationException {
         Map<String, Set<String>> potentialSubstitutions;
         IRI vocabularyIRI;
         if (optimisation)
             vocabularyIRI = IRI.create(modulesPath +
                         specificationName1.replace(".txt", "") +"/"+
                         specificationName2.replace(".txt", "") +"/"+
                         "module.owl");
         else
             vocabularyIRI = IRI.create(specificationsPath +
                     specificationName1.replace(".txt", "") +"/"+
                     specificationName2.replace(".txt", "") +"/"+
                     "vocabulary.owl");
         potentialSubstitutions = calculatePotentialSubstitution(inputParameters, vocabularyIRI);
         return potentialSubstitutions;
     }


    //Calculate the set of substitutions of the parameters in specificationName2
    private static Set<Map<String, String>> calculateSubstitutions(boolean inputParameters,
                                                                  boolean optimisation) throws OWLOntologyCreationException{

         Set<Map<String, String>> substitutions = new HashSet<>();

        Map<String, Set<String>> potentialSubstitutions =
                calculatePotentialSubstitutions(inputParameters, optimisation);
        if (potentialSubstitutions.entrySet().size()>0 &&
                potentialSubstitutions.entrySet().stream().allMatch(e->e.getValue().size()>0)) {
            System.out.println("Potential substitutions: " + potentialSubstitutions);
            for (String p : potentialSubstitutions.keySet()) {
                if (substitutions.size() == 0) {
                    for (String q : potentialSubstitutions.get(p)) {
                        Map<String, String> substitution = new HashMap<>();
                        substitution.put(p, q);
                        substitutions.add(substitution);
                    }
                } else {
                    Set<Map<String, String>> AdditionalSubstitutions = new HashSet<>();
                    for (Map<String, String> substitution : substitutions) {
                        Set<String> parametersToBeSelected = new HashSet<>();
                        parametersToBeSelected.addAll(potentialSubstitutions.get(p));
                        parametersToBeSelected.removeAll(substitution.values());
                        if (!parametersToBeSelected.isEmpty()) {
                            for (String q : parametersToBeSelected) {
                                Map<String, String> substitution2 = new HashMap<>();
                                substitution2.putAll(substitution);
                                substitution2.put(p, q);
                                AdditionalSubstitutions.add(substitution2);
                            }
                        }
                    }
                    substitutions.clear();
                    substitutions.addAll(AdditionalSubstitutions);
                    if (substitutions.isEmpty()) return substitutions;
                }
            }
        }
         return substitutions;
    }

    public static Set<Set<Substitution>> pairSpecificationSubstitutions(boolean inputParameters,
                                                       boolean optimisation) throws IOException, OWLOntologyCreationException {
         Set<Set<Substitution>>substitutions=new HashSet<>();
         Set<Map<String, String>> auxSubstitutions =
                calculateSubstitutions(inputParameters, optimisation);
         for(Map<String, String>auxSubs:auxSubstitutions){
             Set<Substitution>substs = new HashSet<>();
             auxSubs.entrySet().stream().forEach(e->{
                 String parameter1=e.getValue();
                 String parameter2=e.getKey();
                 String type1;
                 String type2;
                 if (inputParameters) {
                     type1=I1.get(parameter1);
                     type2=I2.get(parameter2);
                 }
                 else{
                     type1=O1.get(parameter1);
                     type2=O2.get(parameter2);
                 }
                 Substitution substitution = new Substitution(parameter1,type1,parameter2,type2);
                 substs.add(substitution);
             });
             substitutions.add(substs);
         }
         return substitutions;
    }
    public static void materialiseSubtitutions(String substitutionsRepository,
                                               Set<Set<Substitution>> substitutions) throws IOException {
        String path = substitutionsRepository+
                specificationName1.replace(".txt","")+"//"+
                specificationName2.replace(".txt","")+"//";
        File x = new File(substitutionsRepository+
                specificationName1.replace(".txt","")+"//");
        File y = new File(path);
        if (!x.exists())  x.mkdir();
        if (!y.exists())  y.mkdir();

        int counter = 0;
        for(Set<Substitution>substitution:substitutions) {
            String name = "substitution"+counter+".txt";
            FileWriter f = new FileWriter(path+name);
            for(Substitution s:substitution)
                f.write(s.parameterName1()+","+s.type1()+","+s.parameterName2()+","+s.type2()+"\n");
            f.close();
            counter++;
        }
    }

    //Calculate substitutitions for each pair of specifications and then write such
    //substitutions in files for future use.
    public static void calculatePersistentSubstitutions() throws OWLOntologyCreationException, IOException {

        boolean inputParameters = true;
        boolean optimisation = true;

        String substitutionsRepository = "C://xampp//htdocs//substitutions//";
        File x = new File(substitutionsRepository);
        File y = new File(substitutionsRepository+"substitutionsI//");
        File z = new File(substitutionsRepository+"substitutionsO//");
        if (!x.exists())  x.mkdir();
        if (!y.exists())  y.mkdir();
        if (!z.exists())  z.mkdir();

        RepositoryHandler rh = new RepositoryHandler(specificationsRepository);
        //For each pair of specifications
        int n = rh.get_files().size();
        for (File n1:rh.get_files()) {
            for (File n2:rh.get_files()){
                if (!n1.getName().equals(n2.getName())) {
                    //Read IO information of each specification
                    CalculateSubstitutions.init(n1.getName(),n2.getName());
                    //Only if specification1 covers the information space of specification2,
                    //the substitution calculation can be done.
                    if (I1.keySet().size()>=I2.keySet().size() &&
                           O1.keySet().size()>=O2.keySet().size()) {
                        //Calculate output parameter substitutions for the pair of specifications under consideration.
                        Set<Set<Substitution>> substitutionsO =
                                CalculateSubstitutions.pairSpecificationSubstitutions(!inputParameters,optimisation);
                        Boolean isThereSubstitutionsO = (substitutionsO.size()>0);
                        if (O1.keySet().size()==0)
                            isThereSubstitutionsO = true; //empty substitution when there are not any output parameters
                        Pair<Boolean,Set<Set<Substitution>>> outputSubstitutions =
                                new Pair<>(isThereSubstitutionsO,substitutionsO);
                        Pair<Boolean,Set<Set<Substitution>>> inputSubstitutions=null;
                        //Only if there exist some substitution for output parameters, it is factible to
                        // calculate the corresponding substitutions for input parameters
                        if (outputSubstitutions.a) {
                            Set<Set<Substitution>> substitutionsI =
                                    CalculateSubstitutions.pairSpecificationSubstitutions(inputParameters,optimisation);
                            Boolean isThereSubstitutionsI = (substitutionsI.size()>0);
                            if (I1.keySet().size()==0)
                                isThereSubstitutionsI = true; //empty substitution when there are not any input parameters
                            inputSubstitutions = new Pair<>(isThereSubstitutionsI,substitutionsI);
                        }
                        boolean b=(outputSubstitutions.a && inputSubstitutions.a);
                        System.out.println("Calculating substitutions for " + specificationName1 +
                                " (leave" +n +"specs), "+specificationName2+": "+b);
                        //Substitutions are materialised only if both input and output parameter substititions exist
                        if (b){
                            String substitutionsRepositoryI = substitutionsRepository+"substitutionsI//";
                            materialiseSubtitutions(substitutionsRepositoryI,inputSubstitutions.b);
                            String substitutionsRepositoryO = substitutionsRepository+"substitutionsO//";
                            materialiseSubtitutions(substitutionsRepositoryO,outputSubstitutions.b);
                        }
                    }
                }
            }
            n--;
        }
    }
}
