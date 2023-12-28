package specifications;

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
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StateSpaceImplication {
    private static String specificationsRepository="C://xampp//htdocs//specifications//";
    private static final String implicationsRepository="C://xampp//htdocs//implications//";
    private static final String stateSpaceImplicationsRepository=implicationsRepository+"stateSpaceImplications//";
    private static final String rewritingPath="http://127.0.0.1/rewriting/";
    private static String rewritingRepository="c:/xampp/htdocs/rewriting/";
    private static final String modulesPath="http://127.0.0.1/modules/";
    private static OWLReasonerFactory reasonerFactory = new Reasoner.ReasonerFactory();

    //A table for storing direct information space implications between a pair of specifications
    //spec1 --> {spec1,1,...,spec1,k}
    private static Map<String, Set<String>> stateSpaceImplications = new HashMap<>();
    //For each implication speci --> {speci,1,...,speci,k}. it calculates the closure of specifications implied by
    //speci
    private static Map<String, Set<String>>stateSpaceImplicationsHorizontalClosures = new HashMap<>();
    //For each implication  {speci,1,...,speci,k} --> speci meaning that speci,1 --> speci, ..., speci,k --> speci,
    // it calculates the closure of specifications which implies each specification in {speci,1,...,speci,k}
    private static Map<String, Set<String>>stateSpaceImplicationsVerticalClosures = new HashMap<>();

    public static Map<String, Set<String>>getStateSpaceImplications(){
        return stateSpaceImplications;
    }

    private static boolean impliesState(OWLOntology state,Set<OWLReasoner> reasoners){
        boolean r=reasoners.stream().anyMatch(reasoner->reasoner.isEntailed(state.getAxioms()));
        return r;
    }

    // Given two specifications, specification1 with precondition P1 and effect E1
    // and specification2 with precondition P2 and effect E2, it calculates
    // P2 -> P1 (by following the so-called plug-in semantics)
    public static boolean preconditionsImplication(String specification1,
                                                   String specification2) throws OWLOntologyCreationException {

        String modulePath=modulesPath+specification1+"/"+specification2+"/";

        String rewritingPPath=rewritingPath+"rewritingP/"+
                specification1+"/"+specification2+"/";
        String rewritingPRepository=rewritingRepository+"rewritingP/"+
                specification1+"/"+specification2+"/";

        String rewritingP1Path=rewritingPPath+"P1/";
        String rewritingP1Repository=rewritingPRepository+"P1";
        String rewritingP2Path=rewritingPPath+"P2/";
        String rewritingP2Repository=rewritingPRepository+"P2";

        RepositoryHandler rh1 = new RepositoryHandler(rewritingP1Repository);
        RepositoryHandler rh2 = new RepositoryHandler(rewritingP2Repository);

        Set<OWLOntology>P1=new HashSet<>();
        for(File f:rh1.get_files()){
            IRI iri = IRI.create(rewritingP1Path+f.getName());
            OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
            OWLOntology precondition1 = manager.loadOntology(iri);
            P1.add(precondition1);
        }

        Set<OWLReasoner>P2=new HashSet<>();
        for(File f:rh2.get_files()){
            IRI iri = IRI.create(rewritingP2Path+f.getName());
            OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
            OWLOntology precondition2 = manager.loadOntology(iri);

            IRI iri_vocabulary = IRI.create(modulePath+"module.owl");
            IRI iri_theory = IRI.create("http://127.0.0.1/ontologies/theory.owl");
            OWLOntology vocabulary = manager.loadOntology(iri_vocabulary);
            Set<OWLAxiom>axioms = new HashSet<>();
            axioms.addAll(vocabulary.getAxioms());
            axioms.addAll(precondition2.getAxioms());
            OWLOntology theory=manager.createOntology(axioms,iri_theory);
            OWLReasoner reasoner=reasonerFactory.createReasoner(theory);
            P2.add(reasoner);
        }
        boolean r=P1.stream().allMatch(p1->impliesState(p1,P2));

        return r;
    }

    // Given two specifications, specification1 with precondition P1 and effect E1
    // and specification2 with precondition P2 and effect E2, it calculates
    // E1 -> E2 (by following the so-called plug-in semantics)
    public static boolean effectsImplication(String specification1,
                                             String specification2) throws OWLOntologyCreationException {
        String modulePath=modulesPath+specification1+"/"+specification2+"/";

        String rewritingEPath=rewritingPath+"rewritingE/"+
                specification1+"/"+specification2+"/";
        String rewritingERepository=rewritingRepository+"rewritingE/"+
                specification1+"/"+specification2+"/";

        String rewritingE1Path=rewritingEPath+"E1/";
        String rewritingE1Repository=rewritingERepository+"E1";
        String rewritingE2Path=rewritingEPath+"E2/";
        String rewritingE2Repository=rewritingERepository+"E2";

        //System.out.println(specification1+" --> "+specification2 + "   "+rewritingE1Repository+ "   "+rewritingE2Repository);

        RepositoryHandler rh1 = new RepositoryHandler(rewritingE1Repository);
        RepositoryHandler rh2 = new RepositoryHandler(rewritingE2Repository);

        Set<OWLOntology>E2=new HashSet<>();
        for(File f:rh2.get_files()){
            IRI iri = IRI.create(rewritingE2Path+f.getName());
            OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
            OWLOntology effect2 = manager.loadOntology(iri);
            E2.add(effect2);
        }

        Set<OWLReasoner>E1=new HashSet<>();
        for(File f:rh1.get_files()){
            IRI iri = IRI.create(rewritingE1Path+f.getName());
            OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
            OWLOntology effect1 = manager.loadOntology(iri);

            IRI iri_vocabulary = IRI.create(modulePath+"module.owl");
            IRI iri_theory = IRI.create("http://127.0.0.1/ontologies/theory.owl");
            OWLOntology vocabulary = manager.loadOntology(iri_vocabulary);
            Set<OWLAxiom>axioms = new HashSet<>();
            axioms.addAll(vocabulary.getAxioms());
            axioms.addAll(effect1.getAxioms());
            OWLOntology theory=manager.createOntology(axioms,iri_theory);
            OWLReasoner reasoner=reasonerFactory.createReasoner(theory);

            E1.add(reasoner);
        }
        boolean r=E2.stream().allMatch(e2->impliesState(e2,E1));

        return r;
    }

    public static void readImplications() throws OWLOntologyCreationException, OWLOntologyStorageException, IOException {
        String path1="C://xampp//htdocs//substitutions//substitutionsI//";
        RepositoryHandler rh1 = new RepositoryHandler(path1);
        for (File n1:rh1.get_directories()) {
            System.out.println("Calculating information space implications for "+n1.getName());
            String path2="C://xampp//htdocs//substitutions//substitutionsI//"+n1.getName()+"//";
            RepositoryHandler rh2 = new RepositoryHandler(path2);
            for (File n2:rh2.get_directories()){
                System.out.println("    " + n2.getName());
                if (effectsImplication(n1.getName(), n2.getName()) && preconditionsImplication(n1.getName(), n2.getName())) {
                    stateSpaceImplications.computeIfAbsent(n1.getName(), k -> new HashSet<>()).add(n2.getName());
                }
            }
        }
        //Calculation of specifications which do not imply any other specification
        RepositoryHandler rh = new RepositoryHandler(specificationsRepository);
        Set<File> files=rh.get_directories();
        Set<String>specificationsNotImplyingOthers =
                files.stream().map(f->f.getName()).collect(Collectors.toSet());
        specificationsNotImplyingOthers.removeAll(stateSpaceImplications.keySet());
        for (String spec:specificationsNotImplyingOthers) {
            stateSpaceImplications.put(spec, new HashSet<>());
        }
    }
    //For each implication specification --> {specification1,...,specificationk}. it calculates the closure of
    // specifications implied by specification
    public static Set<String>horizontalClosure(String specification){
        Set<String>impliedSpecificationsBefore=new HashSet<>();
        Set<String>impliedSpecificationsAfter=new HashSet<>();
        if (stateSpaceImplications.containsKey(specification))
            impliedSpecificationsAfter.addAll(stateSpaceImplications.get(specification));
        int sizeBefore = impliedSpecificationsBefore.size();
        int sizeAfter = impliedSpecificationsAfter.size();
        while (sizeBefore<sizeAfter){
            //System.out.println(impliedSpecificationsBefore);
            //System.out.println(impliedSpecificationsAfter);
            impliedSpecificationsBefore.clear();
            impliedSpecificationsBefore.addAll(impliedSpecificationsAfter);
            impliedSpecificationsBefore.forEach(spec->{
                if (stateSpaceImplications.containsKey(spec))
                    impliedSpecificationsAfter.addAll(stateSpaceImplications.get(spec));
            });
            sizeBefore = impliedSpecificationsBefore.size();
            sizeAfter = impliedSpecificationsAfter.size();
        }
        return impliedSpecificationsAfter;
    }

    //Calculates implication closures of the form specification --> {specification1,...,specificationk} for each specification
    public static void horizontalClosures() {
        for(String specification: stateSpaceImplications.keySet())
            stateSpaceImplicationsHorizontalClosures.
                    put(specification,StateSpaceImplication.horizontalClosure(specification));
    }

    //Calculates whether a specification speci with closure speci --> {speci,1,...,speci,k} is subsumed by another
    // specification specj with closure specj --> {specj,1,...,specj,m} in the following sense:
    // (1) speci belongs to {specj,1,...,specj,m} and
    // (2) {speci,1,...,speci,k} is contained in {specj,1,...,specj,m}

    private static boolean isSubsumed(String specification,Map<String,Set<String>>strongSets){
        return strongSets.keySet().stream().anyMatch(specification2->
                !specification.equals(specification2) &&
                        strongSets.get(specification2).contains(specification) &&
                        strongSets.get(specification2).containsAll(strongSets.get(specification)));
    }


    //Calculation of strong sets for deciding in a efficient way
    // information space implications between two specifications
    public static Map<String,Set<String>>strongSets(){
        Map<String,Set<String>>strongSetsBefore=new HashMap<>();
        Map<String,Set<String>>strongSetsAfter=new HashMap<>();
        strongSetsBefore.putAll(StateSpaceImplication.stateSpaceImplicationsHorizontalClosures);
        boolean end = false;
        while (!end){
            strongSetsAfter.clear();
            strongSetsAfter.putAll(strongSetsBefore);
            Set<String> aux=strongSetsBefore.keySet().stream().filter(s1->isSubsumed(s1,strongSetsBefore)).collect(Collectors.toSet());
            if (!aux.isEmpty()){
                strongSetsAfter.remove(aux.stream().findAny().get());
                end = false;
                strongSetsBefore.clear();
                strongSetsBefore.putAll(strongSetsAfter);
            }
            else
                end = true;
        }
        for(String k:strongSetsAfter.keySet())
            strongSetsAfter.get(k).remove(k);
        return strongSetsAfter;
    }

    //For each set of implications  {speci,1,...,speci,k} --> speci (a synonym of speci,1 --> speci, ...,
    // speci,k --> speci), it calculates the closure of specifications which implies each specification in
    // {speci,1,...,speci,k}
    public static Set<String>verticalClosure(String specification){
        Set<String>impliedSpecificationsBefore=new HashSet<>();
        Set<String>impliedSpecificationsAfter=new HashSet<>();
        if (stateSpaceImplications.values().stream().anyMatch(vs->vs.contains(specification))) {
            stateSpaceImplications.keySet().stream().forEach(k->{
                if (stateSpaceImplications.get(k).contains(specification))
                    impliedSpecificationsAfter.add(k);
            });
        }
        int sizeBefore = impliedSpecificationsBefore.size();
        int sizeAfter = impliedSpecificationsAfter.size();
        while (sizeBefore<sizeAfter){
            //System.out.println(impliedSpecificationsBefore);
            //System.out.println(impliedSpecificationsAfter);
            impliedSpecificationsBefore.clear();
            impliedSpecificationsBefore.addAll(impliedSpecificationsAfter);
            impliedSpecificationsBefore.forEach(spec->{
                if (stateSpaceImplications.values().stream().anyMatch(vs->vs.contains(spec))) {
                    stateSpaceImplications.keySet().stream().forEach(k -> {
                        if (stateSpaceImplications.get(k).contains(spec))
                            impliedSpecificationsAfter.add(k);
                    });
                }
            });
            sizeBefore = impliedSpecificationsBefore.size();
            sizeAfter = impliedSpecificationsAfter.size();
        }
        return impliedSpecificationsAfter;
    }

    // Calculates implication closures of the form {speci,1,...,speci,k} --> speci
    // for each specification speci
    public static void verticalClosures() {
        for(String specification: stateSpaceImplications.keySet()) {
            stateSpaceImplicationsVerticalClosures.
                    put(specification, StateSpaceImplication.verticalClosure(specification));
            //System.out.println(specification+" --> "+informationSpaceImplicationsVerticalClosures);
        }
    }

    //Calculation of weak sets for deciding in a efficient way
    // information space implications between two specifications
    public static Map<String,Set<String>>weakSets(){
        Map<String,Set<String>>weakSetsBefore=new HashMap<>();
        Map<String,Set<String>>weakSetsAfter=new HashMap<>();
        weakSetsBefore.putAll(StateSpaceImplication.stateSpaceImplicationsVerticalClosures);
        boolean end = false;
        while (!end){
            weakSetsAfter.clear();
            weakSetsAfter.putAll(weakSetsBefore);
            Set<String> aux=weakSetsBefore.keySet().stream().filter(s1->isSubsumed(s1,weakSetsBefore)).collect(Collectors.toSet());
            if (!aux.isEmpty()){
                weakSetsAfter.remove(aux.stream().findAny().get());
                end = false;
                weakSetsBefore.clear();
                weakSetsBefore.putAll(weakSetsAfter);
            }
            else
                end = true;
        }
        for(String k:weakSetsAfter.keySet())
            weakSetsAfter.get(k).remove(k);
        return weakSetsAfter;
    }

    public static void makePersistentImplicationsSets(Map<String,Set<String>>strongSets,
                                                      Map<String,Set<String>>weakSets) throws IOException {
        File r = new File(implicationsRepository);
        File s = new File(stateSpaceImplicationsRepository);
        if (!r.exists())  r.mkdir();
        if (!s.exists())  s.mkdir();

        //Remove non-producive implication sets (implication sets which do imply nothing)
        Set<String>aux=new HashSet();
        aux.addAll(strongSets.keySet().stream().
                filter(k->strongSets.get(k).isEmpty()).collect(Collectors.toSet()));
        aux.forEach(k->strongSets.remove(k));
        aux=new HashSet();
        aux.addAll(weakSets.keySet().stream().
                filter(k->weakSets.get(k).isEmpty()).collect(Collectors.toSet()));
        aux.forEach(k->weakSets.remove(k));

        //Persistence
        FileWriter f = new FileWriter(stateSpaceImplicationsRepository
                +"strongSets.txt");
        for(String k:strongSets.keySet()) {
            f.write(k+": ");
            int count = strongSets.get(k).size();
            for(String l:strongSets.get(k)){
                count--;
                if (count==0)
                    f.write(l);
                else
                    f.write(l+", ");
            }
            f.write("\n");
        }
        f.close();
        f = new FileWriter(stateSpaceImplicationsRepository
                +"weakSets.txt");
        for(String k:weakSets.keySet()) {
            f.write(k+": ");
            int count = weakSets.get(k).size();
            for(String l:weakSets.get(k)){
                count--;
                if (count==0)
                    f.write(l);
                else
                    f.write(l+", ");
            }
            f.write("\n");
        }
        f.close();
        f = new FileWriter(stateSpaceImplicationsRepository
                +"implicationSets.txt");
        for(String k:stateSpaceImplications.keySet()) {
            f.write(k+": ");
            int count = stateSpaceImplications.get(k).size();
            for(String l:stateSpaceImplications.get(k)){
                count--;
                if (count==0)
                    f.write(l);
                else
                    f.write(l+", ");
            }
            f.write("\n");
        }
        f.close();
    }

    public static void calculateImplicationsSets() throws OWLOntologyCreationException, IOException, OWLOntologyStorageException {
        StateSpaceImplication.readImplications();
        StateSpaceImplication.horizontalClosures();
        StateSpaceImplication.verticalClosures();
        Map<String,Set<String>>strongSets=StateSpaceImplication.strongSets();
        Map<String,Set<String>>weakSets=StateSpaceImplication.weakSets();
        StateSpaceImplication.makePersistentImplicationsSets(strongSets, weakSets);
    }
}
