package search;

import file.RepositoryHandler;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyStorageException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class InformationSpaceImplication {

    private static String requestsRepository="C://xampp//htdocs//requests//";
    private static String specificationsRepository="C://xampp//htdocs//specifications//";
    private static String implicationsRepository="C://xampp//htdocs//implications2//";
    private static String informationSpaceImplicationsRepository=implicationsRepository+
            "informationSpaceImplications//";

    //A table for storing direct information space implications between a pair of specifications
    //spec1 --> {spec1,1,...,spec1,k}
    private static Map<String, Set<String>>informationSpaceImplications = new HashMap<>();
    //For each implication speci --> {speci,1,...,speci,k}. it calculates the closure of specifications implied by
    //speci
    private static Map<String, Set<String>>informationSpaceImplicationsHorizontalClosures = new HashMap<>();
    //For each implication  {speci,1,...,speci,k} --> speci meaning that speci,1 --> speci, ..., speci,k --> speci,
    // it calculates the closure of specifications which implies each specification in {speci,1,...,speci,k}
    private static Map<String, Set<String>>informationSpaceImplicationsVerticalClosures = new HashMap<>();

    public static Map<String, Set<String>>getInformationSpaceImplications(){
        return informationSpaceImplications;
    }
    public static Map<String, Set<String>>getInformationSpaceImplicationsHorizontalClosures(){
        return informationSpaceImplicationsHorizontalClosures;
    }
    public static Map<String, Set<String>>getInformationSpaceImplicationsVerticalClosures(){
        return informationSpaceImplicationsVerticalClosures;
    }

    //Inferring direct information space implications of the form speci --> {reqi,1,...,reqi,k} from the directories
    //called substitutions which have been previously calculated and then stored in a persistent way in the server
    public static void readImplications() throws OWLOntologyCreationException, OWLOntologyStorageException, IOException {
        String path1="C://xampp//htdocs//substitutions2//substitutionsI//";
        RepositoryHandler rh1 = new RepositoryHandler(path1);
        for (File n1:rh1.get_directories()) {
            //System.out.println("Calculating information space implications for "+n1.getName());
            String path2="C://xampp//htdocs//substitutions2//substitutionsI//"+
                    n1.getName()+"//";
            RepositoryHandler rh2 = new RepositoryHandler(path2);
            for (File n2:rh2.get_directories()){
                //System.out.println("    " + n2.getName());
                informationSpaceImplications.
                        computeIfAbsent(n1.getName(), k -> new HashSet<>()).add(n2.getName());
            }
        }
        //Calculation of specifications which do not imply any other request
        RepositoryHandler rh = new RepositoryHandler(specificationsRepository);
        Set<File> files=rh.get_directories();
        Set<String>specificationsNotImplyingOthers =
                files.stream().map(f->f.getName()).collect(Collectors.toSet());
        specificationsNotImplyingOthers.removeAll(informationSpaceImplications.keySet());
        for (String spec:specificationsNotImplyingOthers) {
            informationSpaceImplications.put(spec, new HashSet<>());
        }
    }

    //For each implication specification --> {specification1,...,specificationk}. it calculates the closure of
    // specifications implied by specification
    public static Set<String>horizontalClosure(String specification){
        Set<String>impliedSpecificationsBefore=new HashSet<>();
        Set<String>impliedSpecificationsAfter=new HashSet<>();
        if (informationSpaceImplications.containsKey(specification))
            impliedSpecificationsAfter.addAll(informationSpaceImplications.get(specification));
        int sizeBefore = impliedSpecificationsBefore.size();
        int sizeAfter = impliedSpecificationsAfter.size();
        while (sizeBefore<sizeAfter){
            //System.out.println(impliedSpecificationsBefore);
            //System.out.println(impliedSpecificationsAfter);
            impliedSpecificationsBefore.clear();
            impliedSpecificationsBefore.addAll(impliedSpecificationsAfter);
            impliedSpecificationsBefore.forEach(spec->{
                if (informationSpaceImplications.containsKey(spec))
                    impliedSpecificationsAfter.addAll(informationSpaceImplications.get(spec));
            });
            sizeBefore = impliedSpecificationsBefore.size();
            sizeAfter = impliedSpecificationsAfter.size();
        }
        return impliedSpecificationsAfter;
    }

    //Calculates implication closures of the form specification --> {specification1,...,specificationk} for each specification
    public static void horizontalClosures() {
        for(String specification: informationSpaceImplications.keySet()) {
            Set<String>closure=InformationSpaceImplication.horizontalClosure(specification);
            informationSpaceImplicationsHorizontalClosures.put(specification, closure);
        }
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
        strongSetsBefore.putAll(InformationSpaceImplication.informationSpaceImplicationsHorizontalClosures);
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
        if (informationSpaceImplications.values().stream().anyMatch(vs->vs.contains(specification))) {
            informationSpaceImplications.keySet().stream().forEach(k->{
                if (informationSpaceImplications.get(k).contains(specification))
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
                if (informationSpaceImplications.values().stream().anyMatch(vs->vs.contains(spec))) {
                    informationSpaceImplications.keySet().stream().forEach(k -> {
                        if (informationSpaceImplications.get(k).contains(spec))
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
        for(String specification: informationSpaceImplications.keySet()) {
            Set<String>closure=InformationSpaceImplication.verticalClosure(specification);
            informationSpaceImplicationsVerticalClosures.put(specification, closure);
            //System.out.println(specification+" --> "+informationSpaceImplicationsVerticalClosures);
        }
    }

    //Calculation of weak sets for deciding in a efficient way
    // information space implications between two specifications
    public static Map<String,Set<String>>weakSets(){
        Map<String,Set<String>>weakSetsBefore=new HashMap<>();
        Map<String,Set<String>>weakSetsAfter=new HashMap<>();
        weakSetsBefore.putAll(InformationSpaceImplication.informationSpaceImplicationsVerticalClosures);
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
        File s = new File(informationSpaceImplicationsRepository);
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

        FileWriter f = new FileWriter(informationSpaceImplicationsRepository
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
        f = new FileWriter(informationSpaceImplicationsRepository
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
    }

    public static void calculateImplicationsSets() throws OWLOntologyCreationException, IOException, OWLOntologyStorageException {
        InformationSpaceImplication.readImplications();
        InformationSpaceImplication.horizontalClosures();
        InformationSpaceImplication.verticalClosures();
        Map<String,Set<String>>strongSets=InformationSpaceImplication.strongSets();
        Map<String,Set<String>>weakSets=InformationSpaceImplication.weakSets();
        InformationSpaceImplication.makePersistentImplicationsSets(strongSets, weakSets);
    }
}
