package search;

import common.Substitution;
import common.Tuple;
import file.RepositoryHandler;
import org.antlr.v4.runtime.misc.Pair;
import org.semanticweb.HermiT.Reasoner;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.*;
import org.semanticweb.owlapi.reasoner.OWLReasoner;
import org.semanticweb.owlapi.reasoner.OWLReasonerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

//Searching in a particular repository. Necessary for doing experimentation.
public class RepositorySearch {
    private static final String
            substitutionRepositoryRequestSpecification =
               "C://xampp//htdocs//substitutions2//";
    private static final String
            implicationRepositorySpecificationSpecification =
               "C://xampp//htdocs//repositories//";
    private static String specificationsRepository;

    //Set of specifications in the repository under consideration.
    private Set<String> specifications;

    //Information space: Strong sets.
    private Map<String,Set<String>> informationSpaceStrongSetsSpecificationSpecification;

    //Information space: Weak sets.
    private Map<String,Set<String>>informationSpaceWeakSetsSpecificationSpecification;

    //State space: Strong sets.
    private Map<String,Set<String>> stateSpaceStrongSetsSpecificationSpecification;

    //State space: Weak sets.
    private Map<String,Set<String>> stateSpaceWeakSetsSpecificationSpecification;

    //Searching object creation. Specifications and implications between specifications
    //are initially read
    public RepositorySearch(String repository) throws IOException {
        readSpecifications(repository);
        readImplicationSetsSpecificationSpecification(repository);
    }

    //Read specification names in the repository
    public void readSpecifications(String repository) throws IOException {
        specificationsRepository=implicationRepositorySpecificationSpecification+
                "//"+"informationSpaceImplications"+"//"+repository+"//";
        Map<String,Set<String>> implicationSets;
        Path implicationSetsPath = Path.of(specificationsRepository+
                "implicationSets.txt");
        implicationSets = readImplicationSet(implicationSetsPath);
        specifications = new HashSet<>();
        specifications.addAll(implicationSets.keySet());
    }
    private Map<String,Set<String>> readImplicationSet(Path implicationSetPath) throws IOException {
        Map<String,Set<String>>implications = new HashMap<>();

        Stream<String> lines=Files.lines(implicationSetPath);
        lines.forEach(line->{
            String[]elements=line.split(":");
            String antecedent=elements[0].trim();
            String consequent=elements[1].trim();
            if (consequent.contains(",")){
                String[]consequentElements=consequent.split(",");
                for(String elem:consequentElements)
                    implications.computeIfAbsent(antecedent,k->new HashSet<>()).add(elem.trim());
            }
            else{
                if (consequent.isEmpty())
                    implications.put(antecedent,new HashSet<>());
                else
                    implications.computeIfAbsent(antecedent,k->new HashSet<>()).add(consequent);
            }
        });
        return implications;
    }

    //Read implication sets in the base repository
    private void readImplicationSetsSpecificationSpecification(String repository) throws IOException {
        Map<String,Set<String>> implicationSets = new HashMap<>();
        Path informationSpaceStrongSetsPath = Path.of(implicationRepositorySpecificationSpecification+
                "informationSpaceImplications//"+repository+"//strongSets.txt");
        Path informationSpaceWeakSetsPath = Path.of(implicationRepositorySpecificationSpecification+
                "informationSpaceImplications//"+repository+"//weakSets.txt");
        Path stateSpaceStrongSetsPath = Path.of(implicationRepositorySpecificationSpecification+
                "stateSpaceImplications//"+repository+"//strongSets.txt");
        Path stateSpaceStrongWeakSetsPath = Path.of(implicationRepositorySpecificationSpecification+
                "stateSpaceImplications//"+repository+"//weakSets.txt");
        informationSpaceStrongSetsSpecificationSpecification =
                readImplicationSet(informationSpaceStrongSetsPath);
        informationSpaceWeakSetsSpecificationSpecification =
                readImplicationSet(informationSpaceWeakSetsPath);
        stateSpaceStrongSetsSpecificationSpecification =
                readImplicationSet(stateSpaceStrongSetsPath);
        stateSpaceWeakSetsSpecificationSpecification =
                readImplicationSet(stateSpaceStrongWeakSetsPath);
    }

    // Information space implication (specification --> request)
    // This version is suitable for experiments which calculate search spece but not
    // search time.
    public boolean implies(String specification, String request){
        RepositoryHandler rh1 =
                new RepositoryHandler(substitutionRepositoryRequestSpecification+
                        "substitutionsI//");
        if (rh1.get_directories().stream().anyMatch(file->file.getName().equals(specification))){
            RepositoryHandler rh2 =
                    new RepositoryHandler(substitutionRepositoryRequestSpecification+
                            "substitutionsI//"+specification+"//");
            if (rh2.get_directories().stream().anyMatch(file->file.getName().equals(request)))
                return true;
            else return false;
        }
        else return false;
    }

    //////////////////////////////////////

    private static Set<Set<Substitution>> substitutions(boolean inputParameters,
                                                        boolean optimisation,
                                                        String specification,
                                                        String request,
                                                        Map<String,String>I1,
                                                        Map<String,String>I2,
                                                        Map<String,String>O1,
                                                        Map<String,String>O2) throws IOException, OWLOntologyCreationException {
        Set<Set<Substitution>>substitutions=new HashSet<>();
        Set<Map<String, String>> auxSubstitutions =
                calculateSubstitutions(inputParameters, optimisation,specification,request,I1,I2,O1,O2);
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
    private static Map<String, Set<String>> calculatePotentialSubstitution(boolean inputParameters,
                                                                           IRI vocabularyIRI,
                                                                           Map<String,String>I1,
                                                                           Map<String,String>I2,
                                                                           Map<String,String>O1,
                                                                           Map<String,String>O2) throws OWLOntologyCreationException {
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

    private static Map<String, Set<String>> calculatePotentialSubstitutions(boolean inputParameters,
                                                                            boolean optimisation,
                                                                            String specification,
                                                                            String request,
                                                                            Map<String,String>I1,
                                                                            Map<String,String>I2,
                                                                            Map<String,String>O1,
                                                                            Map<String,String>O2) throws OWLOntologyCreationException {
        String modulesPath="http://127.0.0.1/modules2/";
        String vocabulariesPath="http://127.0.0.1/ontologies2/";
        Map<String, Set<String>> potentialSubstitutions;
        IRI vocabularyIRI;

        if (optimisation)
            vocabularyIRI = IRI.create(modulesPath+specification +"/"+request +"/"+
                    "module.owl");
        else
            vocabularyIRI = IRI.create(vocabulariesPath +specification +"/"+request +"/"+
                    "vocabulary.owl");
        potentialSubstitutions = calculatePotentialSubstitution(inputParameters, vocabularyIRI,I1,I2,O1,O2);
        return potentialSubstitutions;
    }

    private static Set<Map<String, String>> calculateSubstitutions(boolean inputParameters,
                                                                   boolean optimisation,
                                                                   String specification,
                                                                   String request,
                                                                   Map<String,String>I1,
                                                                   Map<String,String>I2,
                                                                   Map<String,String>O1,
                                                                   Map<String,String>O2) throws OWLOntologyCreationException{

        Set<Map<String, String>> substitutions = new HashSet<>();

        Map<String, Set<String>> potentialSubstitutions =
                calculatePotentialSubstitutions(inputParameters, optimisation,
                        specification,request,I1,I2,O1,O2);
        if (potentialSubstitutions.entrySet().size()>0 &&
                potentialSubstitutions.entrySet().stream().allMatch(e->e.getValue().size()>0)) {
            //System.out.println("Potential substitutions: " + potentialSubstitutions);
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

    private static Pair<String,String> processLine(String line){
        Pair<String,String>r;
        String[] parts = line.split(",");
        r=new Pair<>(parts[0].trim(),parts[1].trim());
        return r;
    }
    //Information space implication (specification --> request)
    //This version (of implies) is suitable to calculate search time
    // (simulate a real context in which requests can not be anticipated).
    public boolean implies1(String specification, String request) throws IOException, OWLOntologyCreationException {
        boolean inputParameters = true;
        boolean optimisation = true;  //use of modules instead of vacabularies
        boolean b = false;

        String requestsRepository="c:/xampp/htdocs/requests/";
        String specificationsRepository="c:/xampp/htdocs/specifications/";

        Map<String,String> I1=new HashMap<>();
        Map<String,String> I2=new HashMap<>();
        Map<String,String> O1=new HashMap<>();
        Map<String,String> O2=new HashMap<>();

        Path filePathI1 =   Path.of(specificationsRepository+specification+"/I.txt");
        Path filePathI2 =   Path.of(requestsRepository+request+"/I.txt");
        Path filePathO1 =   Path.of(specificationsRepository+specification+"/O.txt");
        Path filePathO2 =   Path.of(requestsRepository+request+"/O.txt");

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

        //Only if specification covers the information space of request,
        //the substitution calculation can be done.
        if (I1.keySet().size()>=I2.keySet().size() &&
                O1.keySet().size()>=O2.keySet().size()) {
            //Calculate output parameter substitutions for the pair of descriptions under consideration.
            Set<Set<Substitution>> substitutionsO =
                    substitutions(!inputParameters,optimisation,specification,request,I1,I2,O1,O2);
            Boolean isThereSubstitutionsO = (substitutionsO.size() > 0);
            if (O1.keySet().size() == 0)
                isThereSubstitutionsO = true; //empty substitution when there are not any output parameters
            Pair<Boolean, Set<Set<Substitution>>> outputSubstitutions =
                    new Pair<>(isThereSubstitutionsO, substitutionsO);
            Pair<Boolean, Set<Set<Substitution>>> inputSubstitutions = null;
            //Only if there exist some substitution for output parameters, it is factible to
            // calculate the corresponding substitutions for input parameters
            if (outputSubstitutions.a) {
                Set<Set<Substitution>> substitutionsI =
                        substitutions(inputParameters, optimisation,specification,request,I1,I2,O1,O2);
                Boolean isThereSubstitutionsI = (substitutionsI.size() > 0);
                if (I1.keySet().size() == 0)
                    isThereSubstitutionsI = true; //empty substitution when there are not any input parameters
                inputSubstitutions = new Pair<>(isThereSubstitutionsI, substitutionsI);
            }
            b = (outputSubstitutions.a && inputSubstitutions.a);
        }
        return b;
    }

    //State space implication (specification => request) (Plug-in semantics)
    public boolean implies2(String specification, String request) throws OWLOntologyCreationException {
        RepositoryHandler rh1 =
                new RepositoryHandler(substitutionRepositoryRequestSpecification+
                        "substitutionsI//");
        if (rh1.get_directories().stream().anyMatch(file->file.getName().equals(specification))){
            RepositoryHandler rh2 =
                    new RepositoryHandler(substitutionRepositoryRequestSpecification+
                            "substitutionsI//"+specification+"//");
            if (rh2.get_directories().stream().anyMatch(file->file.getName().equals(request)))
                return StateSpaceImplication.effectsImplication(specification,request) &&
                        StateSpaceImplication.preconditionsImplication(specification,request);
            else return false;
        }
        else return false;
    }

    //State space implication (specification => request) (Plug-in post semantics)
    public boolean implies2Post(String specification, String request) throws OWLOntologyCreationException {
        RepositoryHandler rh1 =
                new RepositoryHandler(substitutionRepositoryRequestSpecification+
                        "substitutionsI//");
        if (rh1.get_directories().stream().anyMatch(file->file.getName().equals(specification))){
            RepositoryHandler rh2 =
                    new RepositoryHandler(substitutionRepositoryRequestSpecification+
                            "substitutionsI//"+specification+"//");
            if (rh2.get_directories().stream().anyMatch(file->file.getName().equals(request)))
                return StateSpaceImplication.effectsImplication(specification,request);
            else return false;
        }
        else return false;
    }

    //Inefficient information space search.
    public Tuple<Set<String>,Double,Set<String>,Double>
       inefficientSearchInformationSpace(String request) throws OWLOntologyCreationException, IOException {
        Set<String>foundSpecifications = new HashSet<>();
        Set<String>visitedSpecifications = new HashSet<>();
        Set<String>foundRemainingSpecifications = new HashSet<>();
        Set<String>visitedRemainingSpecifications = new HashSet<>();
        for (String specification:this.specifications){
            visitedSpecifications.add(specification);
            if (implies(specification,request))  //or implies1
                foundSpecifications.add(specification);
        }
        return new Tuple<>(foundSpecifications, ((double) visitedSpecifications.size()/this.specifications.size()),
                foundRemainingSpecifications, ((double) visitedRemainingSpecifications.size()/this.specifications.size()));
    }

    //Inefficient state space search (Plug-in semantics).
    public Tuple<Set<String>,Double,Set<String>,Double>
       inefficientSearchStateSpace(String request)
            throws OWLOntologyCreationException {
        Set<String>foundSpecifications = new HashSet<>();
        Set<String>visitedSpecifications = new HashSet<>();
        Set<String>foundRemainingSpecifications = new HashSet<>();
        Set<String>visitedRemainingSpecifications = new HashSet<>();
        for (String specification:this.specifications){
            visitedSpecifications.add(specification);
            if (implies2(specification,request))
                foundSpecifications.add(specification);
        }
        return new Tuple<>(foundSpecifications, ((double) visitedSpecifications.size()/this.specifications.size()),
                foundRemainingSpecifications, ((double) visitedRemainingSpecifications.size()/this.specifications.size()));
    }

    //Inefficient state space search (Plug-in semantics).
    public Tuple<Set<String>,Double,Set<String>,Double>
    inefficientSearchStateSpacePost(String request)
            throws OWLOntologyCreationException {
        Set<String>foundSpecifications = new HashSet<>();
        Set<String>visitedSpecifications = new HashSet<>();
        Set<String>foundRemainingSpecifications = new HashSet<>();
        Set<String>visitedRemainingSpecifications = new HashSet<>();
        for (String specification:this.specifications){
            visitedSpecifications.add(specification);
            if (implies2Post(specification,request))
                foundSpecifications.add(specification);
        }
        return new Tuple<>(foundSpecifications, ((double) visitedSpecifications.size()/this.specifications.size()),
                foundRemainingSpecifications, ((double) visitedRemainingSpecifications.size()/this.specifications.size()));
    }

    //Inefficient search (Plug-in semantics)
    public Tuple<Set<String>,Double,Set<String>,Double> inefficientSearch(String request)
            throws OWLOntologyCreationException, IOException {
        Set<String>foundSpecifications = new HashSet<>();
        Set<String>visitedSpecifications = new HashSet<>();
        Set<String>foundRemainingSpecifications = new HashSet<>();
        Set<String>visitedRemainingSpecifications = new HashSet<>();
        for (String specification:this.specifications){
            visitedSpecifications.add(specification);
            //System.out.println(specification+"-->"+request+"?"+
            //        "("+implies(specification,request)+"/"+implies2(specification,request)+")");
            if (implies(specification,request) && implies2(specification,request)) { //or implies1
                foundSpecifications.add(specification);
            }
        }
        return new Tuple<>(foundSpecifications, ((double) visitedSpecifications.size()/this.specifications.size()),
                foundRemainingSpecifications, ((double) visitedRemainingSpecifications.size()/this.specifications.size()));
    }

    //Inefficient search (Plug-in post semantics)
    public Tuple<Set<String>,Double,Set<String>,Double> inefficientSearchPost(String request)
            throws OWLOntologyCreationException, IOException {
        Set<String>foundSpecifications = new HashSet<>();
        Set<String>visitedSpecifications = new HashSet<>();
        Set<String>foundRemainingSpecifications = new HashSet<>();
        Set<String>visitedRemainingSpecifications = new HashSet<>();
        for (String specification:this.specifications){
            visitedSpecifications.add(specification);
            //System.out.println(specification+"-->"+request+"?"+
            //        "("+implies(specification,request)+"/"+implies2(specification,request)+")");
            if (implies(specification,request) && implies2Post(specification,request)) {
                foundSpecifications.add(specification);
            }
        }
        return new Tuple<>(foundSpecifications, ((double) visitedSpecifications.size()/this.specifications.size()),
                foundRemainingSpecifications, ((double) visitedRemainingSpecifications.size()/this.specifications.size()));
    }


    //Efficient search (1 level of abstraction) (Plug-in semantics)
    public Tuple<Set<String>,Double,Set<String>,Double>
       efficientSearch1LevelOfAbstraction(String request) throws OWLOntologyCreationException, IOException {
        Set<String>foundSpecifications = new HashSet<>();
        Set<String>visitedSpecifications = new HashSet<>();
        Set<String>discardedSpecifications = new HashSet<>();
        Set<String>foundRemainingSpecifications = new HashSet<>();
        Set<String>visitedRemainingSpecifications = new HashSet<>();
        Set<String>potentialSpecifications=new HashSet<>();
        potentialSpecifications.addAll(this.specifications);

        //Pruning
        for (String specification:this.stateSpaceStrongSetsSpecificationSpecification.keySet()) {
            visitedSpecifications.add(specification);
            if (!implies(specification,request) || !implies2(specification,request)){ //or implies1
                discardedSpecifications.add(specification);
                discardedSpecifications.addAll(this.
                        stateSpaceStrongSetsSpecificationSpecification.get(specification));
            }
        }
        potentialSpecifications.removeAll(discardedSpecifications);
        System.out.println("\nPruning (Total/Potential/Discarded/Visited) "+
                this.specifications.size()+"/"+potentialSpecifications.size()+"/"+
                discardedSpecifications.size()+"/"+visitedSpecifications.size());

        //Direct discovery
        if (!potentialSpecifications.isEmpty()) {
            Set<String>aux=new HashSet<>();
            aux.addAll(this.stateSpaceWeakSetsSpecificationSpecification.keySet());
            aux.removeAll(discardedSpecifications);
            for(String specification:aux){
                visitedSpecifications.add(specification);
                if (implies(specification,request) && implies2(specification,request)){ //or implies1
                    foundSpecifications.add(specification);
                    foundSpecifications.addAll(this.
                            stateSpaceWeakSetsSpecificationSpecification.get(specification));
                    discardedSpecifications.add(specification);
                    discardedSpecifications.addAll(this.
                            stateSpaceWeakSetsSpecificationSpecification.get(specification));
                }
            }
        }

        potentialSpecifications.removeAll(discardedSpecifications);
        System.out.println("Direct discovery (Total/Potential/Discarded/Visited) "+
                this.specifications.size()+"/"+potentialSpecifications.size()+"/"+
                discardedSpecifications.size()+"/"+visitedSpecifications.size());

        //Remaining specifications
        for(String specification:potentialSpecifications) {
            visitedSpecifications.add(specification);
            visitedRemainingSpecifications.add(specification);
            if (implies(specification,request) && implies2(specification,request)) { //or implies1
                foundSpecifications.add(specification);
                foundRemainingSpecifications.add(specification);
            }
        }

        System.out.println("Remaining specification discovery (Total/Potential/Discarded/Visited) "+
                this.specifications.size()+"/"+potentialSpecifications.size()+"/"+
                discardedSpecifications.size()+"/"+visitedSpecifications.size());

        return new Tuple<>(foundSpecifications, ((double) visitedSpecifications.size()/this.specifications.size()),
                foundRemainingSpecifications, ((double) visitedRemainingSpecifications.size()/this.specifications.size()));
    }

    //Efficient search (1 level of abstraction) (Plug-in post semantics)
    public Tuple<Set<String>,Double,Set<String>,Double>
    efficientSearch1LevelOfAbstractionPost(String request) throws OWLOntologyCreationException, IOException {
        Set<String>foundSpecifications = new HashSet<>();
        Set<String>visitedSpecifications = new HashSet<>();
        Set<String>discardedSpecifications = new HashSet<>();
        Set<String>foundRemainingSpecifications = new HashSet<>();
        Set<String>visitedRemainingSpecifications = new HashSet<>();
        Set<String>potentialSpecifications=new HashSet<>();
        potentialSpecifications.addAll(this.specifications);

        //Pruning
        for (String specification:this.stateSpaceStrongSetsSpecificationSpecification.keySet()) {
            visitedSpecifications.add(specification);
            if (!implies(specification,request) || !implies2Post(specification,request)){ //or implies1
                discardedSpecifications.add(specification);
                discardedSpecifications.addAll(this.
                        stateSpaceStrongSetsSpecificationSpecification.get(specification));
            }
        }
        potentialSpecifications.removeAll(discardedSpecifications);
        System.out.println("\nPruning (Total/Potential/Discarded/Visited) "+
                this.specifications.size()+"/"+potentialSpecifications.size()+"/"+
                discardedSpecifications.size()+"/"+visitedSpecifications.size());

        //Direct discovery
        if (!potentialSpecifications.isEmpty()) {
            Set<String>aux=new HashSet<>();
            aux.addAll(this.stateSpaceWeakSetsSpecificationSpecification.keySet());
            aux.removeAll(discardedSpecifications);
            for(String specification:aux){
                visitedSpecifications.add(specification);
                if (implies(specification,request) && implies2Post(specification,request)){
                    foundSpecifications.add(specification);
                    foundSpecifications.addAll(this.
                            stateSpaceWeakSetsSpecificationSpecification.get(specification));
                    discardedSpecifications.add(specification);
                    discardedSpecifications.addAll(this.
                            stateSpaceWeakSetsSpecificationSpecification.get(specification));
                }
            }
        }

        potentialSpecifications.removeAll(discardedSpecifications);
        System.out.println("Direct discovery (Total/Potential/Discarded/Visited) "+
                this.specifications.size()+"/"+potentialSpecifications.size()+"/"+
                discardedSpecifications.size()+"/"+visitedSpecifications.size());

        //Remaining specifications
        for(String specification:potentialSpecifications) {
            visitedSpecifications.add(specification);
            visitedRemainingSpecifications.add(specification);
            if (implies(specification,request) && implies2Post(specification,request)) { //or implies1
                foundSpecifications.add(specification);
                foundRemainingSpecifications.add(specification);
            }
        }

        System.out.println("Remaining specification discovery (Total/Potential/Discarded/Visited) "+
                this.specifications.size()+"/"+potentialSpecifications.size()+"/"+
                discardedSpecifications.size()+"/"+visitedSpecifications.size());

        return new Tuple<>(foundSpecifications, ((double) visitedSpecifications.size()/this.specifications.size()),
                foundRemainingSpecifications, ((double) visitedRemainingSpecifications.size()/this.specifications.size()));
    }
    ////////////////////////

    //Efficient space search (2 levels of abstraction: abstract level and concrete level)
    // (Plug-in semantics).
    public Tuple<Set<String>,Double,Set<String>,Double>
       efficientSearch2LevelsOfAbstraction(String request) throws OWLOntologyCreationException, IOException {
        Set<String>foundSpecifications = new HashSet<>();
        Set<String>visitedSpecifications = new HashSet<>();
        Set<String>discardedSpecifications = new HashSet<>();
        Set<String>foundRemainingSpecifications = new HashSet<>();
        Set<String>visitedRemainingSpecifications = new HashSet<>();
        Set<String>potentialSpecifications=new HashSet<>();
        potentialSpecifications.addAll(this.specifications);

        //Pruning wrt information space (abstract level)
        for (String specification:this.informationSpaceStrongSetsSpecificationSpecification.keySet()) {
            visitedSpecifications.add(specification);
            if (!implies(specification,request)){ //or implies1
                discardedSpecifications.add(specification);
                discardedSpecifications.addAll(this.
                        informationSpaceStrongSetsSpecificationSpecification.get(specification));
            }
        }
        potentialSpecifications.removeAll(discardedSpecifications);
        System.out.println("\nPruning wrt information space (Total/Potential/Discarded/Visited) "+
                this.specifications.size()+"/"+potentialSpecifications.size()+"/"+
                discardedSpecifications.size()+"/"+visitedSpecifications.size());

        //Pruning discovery wrt state space (concrete level)
        Set<String>aux=new HashSet<>();
        aux.addAll(this.stateSpaceStrongSetsSpecificationSpecification.keySet());
        aux.removeAll(discardedSpecifications);
        for (String specification:aux) {
            visitedSpecifications.add(specification);
            if (!implies(specification,request) || !implies2(specification,request)){
                discardedSpecifications.add(specification);
                discardedSpecifications.addAll(this.
                        stateSpaceStrongSetsSpecificationSpecification.get(specification));
            }
        }
        potentialSpecifications.removeAll(discardedSpecifications);
        System.out.println("\nPrunning wrt state space (Total/Potential/Discarded/Visited) "+
                this.specifications.size()+"/"+potentialSpecifications.size()+"/"+
                discardedSpecifications.size()+"/"+visitedSpecifications.size());

        //Direct discovery (concrete level)
        if (!potentialSpecifications.isEmpty()) {
            aux=new HashSet<>();
            aux.addAll(this.stateSpaceWeakSetsSpecificationSpecification.keySet());
            aux.removeAll(discardedSpecifications);
            for(String specification:aux){
                visitedSpecifications.add(specification);
                if (implies(specification,request) && implies2(specification,request)){
                    foundSpecifications.add(specification);
                    foundSpecifications.addAll(this.
                            stateSpaceWeakSetsSpecificationSpecification.get(specification));
                    discardedSpecifications.add(specification);
                    discardedSpecifications.addAll(this.
                            stateSpaceWeakSetsSpecificationSpecification.get(specification));
                }
            }
        }

        potentialSpecifications.removeAll(discardedSpecifications);
        System.out.println("Direct discovery (Total/Potential/Discarded/Visited) "+
                this.specifications.size()+"/"+potentialSpecifications.size()+"/"+
                discardedSpecifications.size()+"/"+visitedSpecifications.size());

        //Remaining specifications (concrete level)
        for(String specification:potentialSpecifications) {
            visitedSpecifications.add(specification);
            visitedRemainingSpecifications.add(specification);
            if (implies(specification,request) && implies2(specification,request)) {
                foundSpecifications.add(specification);
                foundRemainingSpecifications.add(specification);
            }
        }

        System.out.println("Remaining specification discovery (Total/Potential/Discarded/Visited) "+
                this.specifications.size()+"/"+potentialSpecifications.size()+"/"+
                discardedSpecifications.size()+"/"+visitedSpecifications.size());

        return new Tuple<>(foundSpecifications, ((double) visitedSpecifications.size()/this.specifications.size()),
                foundRemainingSpecifications, ((double) visitedRemainingSpecifications.size()/this.specifications.size()));
    }

    //Efficient space search (2 levels of abstraction: abstract level and concrete level)
    // (Plug-in post semantics).
    public Tuple<Set<String>,Double,Set<String>,Double>
    efficientSearch2LevelsOfAbstractionPost(String request) throws OWLOntologyCreationException, IOException {
        Set<String>foundSpecifications = new HashSet<>();
        Set<String>visitedSpecifications = new HashSet<>();
        Set<String>discardedSpecifications = new HashSet<>();
        Set<String>foundRemainingSpecifications = new HashSet<>();
        Set<String>visitedRemainingSpecifications = new HashSet<>();
        Set<String>potentialSpecifications=new HashSet<>();
        potentialSpecifications.addAll(this.specifications);

        //Pruning wrt information space (abstract level)
        for (String specification:this.informationSpaceStrongSetsSpecificationSpecification.keySet()) {
            visitedSpecifications.add(specification);
            if (!implies(specification,request)){ //or implies1
                discardedSpecifications.add(specification);
                discardedSpecifications.addAll(this.
                        informationSpaceStrongSetsSpecificationSpecification.get(specification));
            }
        }
        potentialSpecifications.removeAll(discardedSpecifications);
        System.out.println("\nPruning wrt information space (Total/Potential/Discarded/Visited) "+
                this.specifications.size()+"/"+potentialSpecifications.size()+"/"+
                discardedSpecifications.size()+"/"+visitedSpecifications.size());

        //Pruning discovery wrt state space (concrete level)
        Set<String>aux=new HashSet<>();
        aux.addAll(this.stateSpaceStrongSetsSpecificationSpecification.keySet());
        aux.removeAll(discardedSpecifications);
        for (String specification:aux) {
            visitedSpecifications.add(specification);
            if (!implies(specification,request) || !implies2Post(specification,request)){
                discardedSpecifications.add(specification);
                discardedSpecifications.addAll(this.
                        stateSpaceStrongSetsSpecificationSpecification.get(specification));
            }
        }
        potentialSpecifications.removeAll(discardedSpecifications);
        System.out.println("\nPrunning wrt state space (Total/Potential/Discarded/Visited) "+
                this.specifications.size()+"/"+potentialSpecifications.size()+"/"+
                discardedSpecifications.size()+"/"+visitedSpecifications.size());

        //Direct discovery (concrete level)
        if (!potentialSpecifications.isEmpty()) {
            aux=new HashSet<>();
            aux.addAll(this.stateSpaceWeakSetsSpecificationSpecification.keySet());
            aux.removeAll(discardedSpecifications);
            for(String specification:aux){
                visitedSpecifications.add(specification);
                if (implies(specification,request) && implies2Post(specification,request)){
                    foundSpecifications.add(specification);
                    foundSpecifications.addAll(this.
                            stateSpaceWeakSetsSpecificationSpecification.get(specification));
                    discardedSpecifications.add(specification);
                    discardedSpecifications.addAll(this.
                            stateSpaceWeakSetsSpecificationSpecification.get(specification));
                }
            }
        }

        potentialSpecifications.removeAll(discardedSpecifications);
        System.out.println("Direct discovery (Total/Potential/Discarded/Visited) "+
                this.specifications.size()+"/"+potentialSpecifications.size()+"/"+
                discardedSpecifications.size()+"/"+visitedSpecifications.size());

        //Remaining specifications (concrete level)
        for(String specification:potentialSpecifications) {
            visitedSpecifications.add(specification);
            visitedRemainingSpecifications.add(specification);
            if (implies(specification,request) && implies2Post(specification,request)) {
                foundSpecifications.add(specification);
                foundRemainingSpecifications.add(specification);
            }
        }

        System.out.println("Remaining specification discovery (Total/Potential/Discarded/Visited) "+
                this.specifications.size()+"/"+potentialSpecifications.size()+"/"+
                discardedSpecifications.size()+"/"+visitedSpecifications.size());

        return new Tuple<>(foundSpecifications, ((double) visitedSpecifications.size()/this.specifications.size()),
                foundRemainingSpecifications, ((double) visitedRemainingSpecifications.size()/this.specifications.size()));
    }
}
