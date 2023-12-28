package common;

import file.RepositoryHandler;
import org.antlr.v4.runtime.misc.Pair;
import org.semanticweb.HermiT.Reasoner;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.*;
import org.semanticweb.owlapi.reasoner.OWLReasoner;
import org.semanticweb.owlapi.reasoner.OWLReasonerFactory;
import repositories.Repositories;
import specifications.InformationSpaceImplication;
import specifications.StateSpaceImplication;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static repositories.Repositories.repositoryStatistics;

public class RandGenerator {
    private static java.util.Random numberRandomGenerator = new Random();
    private static String specificationsRepository = "C://xampp//htdocs//specifications//";
    //A table for storing direct information space implications between a pair of specifications
    //spec1 --> {spec1,1,...,spec1,k}
    private static final String repositoriesPath="http://127.0.0.1/repositories/";
    private static String repositoriesRepository="c:/xampp/htdocs/repositories/";
    private static String informationSpaceRepositories = repositoriesRepository+
            "informationSpaceImplications/";
    private static String stateSpaceRepositories = repositoriesRepository+
            "stateSpaceImplications/";
    private static final String
            implicationRepository = "C://xampp//htdocs//implications//";
    private static final String modulesPath="http://127.0.0.1/modules/";
    private static OWLReasonerFactory reasonerFactory = new Reasoner.ReasonerFactory();
    private static Map<String, Set<String>>informationSpaceImplications = new HashMap<>();
    //For each implication speci --> {speci,1,...,speci,k}. it calculates the closure of specifications implied by
    //speci
    private static Map<String, Set<String>>informationSpaceImplicationsHorizontalClosures = new HashMap<>();
    //For each implication  {speci,1,...,speci,k} --> speci meaning that speci,1 --> speci, ..., speci,k --> speci,
    // it calculates the closure of specifications which implies each specification in {speci,1,...,speci,k}
    private static Map<String, Set<String>>informationSpaceImplicationsVerticalClosures = new HashMap<>();

    //A table for storing direct information space implications between a pair of specifications
    //spec1 --> {spec1,1,...,spec1,k}
    private static Map<String, Set<String>> stateSpaceImplications = new HashMap<>();
    //For each implication speci --> {speci,1,...,speci,k}. it calculates the closure of specifications implied by
    //speci
    private static Map<String, Set<String>>stateSpaceImplicationsHorizontalClosures = new HashMap<>();
    //For each implication  {speci,1,...,speci,k} --> speci meaning that speci,1 --> speci, ..., speci,k --> speci,
    // it calculates the closure of specifications which implies each specification in {speci,1,...,speci,k}
    private static Map<String, Set<String>>stateSpaceImplicationsVerticalClosures = new HashMap<>();

    //Inferring direct information space implications of the form speci --> {speci,1,...,speci,k} from the directories
    //called substitutions which have been previously calculated and then stored in a persistent way in the server

    private static Map<String,Set<String>> readImplicationSet(Path implicationSetPath,
                                                              Set<String>specificationSubset) throws IOException {
        Map<String,Set<String>>implications = new HashMap<>();

        Stream<String> lines=Files.lines(implicationSetPath);
        lines.forEach(line->{
            String[]elements=line.split(":");
            String antecedent=elements[0].trim();
            if (specificationSubset.contains(antecedent)) {
                implications.put(antecedent, new HashSet<>());
                String consequent = elements[1].trim();
                if (consequent.contains(",")) {
                    String[] consequentElements = consequent.split(",");
                    for (String elem : consequentElements) {
                        if (specificationSubset.contains(elem.trim()))
                            implications.get(antecedent).add(elem.trim());
                    }
                }
                else
                    if (!consequent.isEmpty() && specificationSubset.contains(consequent))
                        implications.get(antecedent).add(consequent);
            }
        });
        return implications;
    }


    //For each implication specification --> {specification1,...,specificationk}. it calculates the closure of
    // specifications implied by specification
    public static Set<String>informationSpaceHorizontalClosure(String specification){
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
    public static void informationSpaceHorizontalClosures() {
        for(String specification: informationSpaceImplications.keySet()) {
            Set<String>closure=informationSpaceHorizontalClosure(specification);
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
    public static Map<String,Set<String>>informationSpaceStrongSets(){
        Map<String,Set<String>>strongSetsBefore=new HashMap<>();
        Map<String,Set<String>>strongSetsAfter=new HashMap<>();
        strongSetsBefore.putAll(informationSpaceImplicationsHorizontalClosures);
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
    public static Set<String>informationSpaceVerticalClosure(String specification){
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
    public static void informationSpaceVerticalClosures() {
        for(String specification: informationSpaceImplications.keySet()) {
            Set<String>closure=informationSpaceVerticalClosure(specification);
            informationSpaceImplicationsVerticalClosures.put(specification, closure);
            //System.out.println(specification+" --> "+informationSpaceImplicationsVerticalClosures);
        }
    }

    //Calculation of weak sets for deciding in a efficient way
    // information space implications between two specifications
    public static Map<String,Set<String>>informationSpaceWeakSets(){
        Map<String,Set<String>>weakSetsBefore=new HashMap<>();
        Map<String,Set<String>>weakSetsAfter=new HashMap<>();
        weakSetsBefore.putAll(RandGenerator.informationSpaceImplicationsVerticalClosures);
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

    public static Set<String>stateSpaceHorizontalClosure(String specification){
        Set<String>impliedSpecificationsBefore=new HashSet<>();
        Set<String>impliedSpecificationsAfter=new HashSet<>();
        if (stateSpaceImplications.containsKey(specification))
            impliedSpecificationsAfter.addAll(RandGenerator.stateSpaceImplications.get(specification));
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
    public static void stateSpaceHorizontalClosures() {
        for(String specification: stateSpaceImplications.keySet())
            stateSpaceImplicationsHorizontalClosures.
                    put(specification, RandGenerator.stateSpaceHorizontalClosure(specification));
    }

    //Calculates whether a specification speci with closure speci --> {speci,1,...,speci,k} is subsumed by another
    // specification specj with closure specj --> {specj,1,...,specj,m} in the following sense:
    // (1) speci belongs to {specj,1,...,specj,m} and
    // (2) {speci,1,...,speci,k} is contained in {specj,1,...,specj,m}




    //Calculation of strong sets for deciding in a efficient way
    // information space implications between two specifications
    public static Map<String,Set<String>>stateSpaceStrongSets(){
        Map<String,Set<String>>strongSetsBefore=new HashMap<>();
        Map<String,Set<String>>strongSetsAfter=new HashMap<>();
        strongSetsBefore.putAll(stateSpaceImplicationsHorizontalClosures);
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
    public static Set<String>stateSpaceVerticalClosure(String specification){
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
    public static void stateSpaceVerticalClosures() {
        for(String specification: stateSpaceImplications.keySet()) {
            stateSpaceImplicationsVerticalClosures.
                    put(specification, RandGenerator.stateSpaceVerticalClosure(specification));
            //System.out.println(specification+" --> "+informationSpaceImplicationsVerticalClosures);
        }
    }

    //Calculation of weak sets for deciding in a efficient way
    // information space implications between two specifications
    public static Map<String,Set<String>>stateSpaceWeakSets(){
        Map<String,Set<String>>weakSetsBefore=new HashMap<>();
        Map<String,Set<String>>weakSetsAfter=new HashMap<>();
        weakSetsBefore.putAll(stateSpaceImplicationsVerticalClosures);
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


    public static void makePersistentImplications(
            Map<String,Set<String>>implicationSets,
            Map<String,Set<String>>strongSets,
            Map<String,Set<String>>weakSets,
            String implicationRepositories) throws IOException {

        File r = new File(repositoriesRepository);
        if (!r.exists())  r.mkdir();

        File s = new File(implicationRepositories);
        if (!s.exists())  s.mkdir();

        RepositoryHandler rh = new RepositoryHandler(implicationRepositories);
        Set<String>repositories=rh.get_directories().stream().
                map(file->file.getName()).collect(Collectors.toSet());
        Stream<Integer>repositoriesNumbers=repositories.stream().map(n->Integer.valueOf(n));
        Integer index;
        if (repositories.isEmpty()) index=0;
        else {
            Comparator<Integer>cmp=(i1,i2)->i1.compareTo(i2);
            index=repositoriesNumbers.max(cmp).get()+1;
        }
        File t = new File(implicationRepositories+index+"/");
        if (!t.exists())  t.mkdir();

        //Remove non-producive strong and weak sets (implication sets which do imply nothing)
        Set<String>aux=new HashSet();
        aux.addAll(strongSets.keySet().stream().
                filter(k->strongSets.get(k).isEmpty()).collect(Collectors.toSet()));
        aux.forEach(k->strongSets.remove(k));
        aux=new HashSet();
        aux.addAll(weakSets.keySet().stream().
                filter(k->weakSets.get(k).isEmpty()).collect(Collectors.toSet()));
        aux.forEach(k->weakSets.remove(k));

        //Persistence
        FileWriter f = new FileWriter(implicationRepositories+index+"/"+
                "strongSets.txt");
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
        f = new FileWriter(implicationRepositories+index+"/"+
                "weakSets.txt");
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
        f = new FileWriter(implicationRepositories+index+"/"+
                "implicationSets.txt");
        for(String k:implicationSets.keySet()) {
            f.write(k+": ");
            int count = implicationSets.get(k).size();
            for(String l:implicationSets.get(k)){
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

    private static Set<String> readSpecifications(){
        RepositoryHandler rh = new RepositoryHandler(specificationsRepository);
        Set<String>specifications=rh.get_directories().stream().
                map(file->file.getName()).collect(Collectors.toSet());
        return specifications;
    }

    //Ramdon generation of a repository with n specifications from
    //a base repository containing the whole set of specifications
    public static Set<String>generateSpecificationSubset(int n){
        Set<String>specificationSubset=new HashSet<>();
        Set<Integer>randomNumbers=new HashSet<>();
        List<String>specifications=readSpecifications().stream().toList();
        Integer bound = specifications.size();
        while(randomNumbers.size()<n) {
            Integer number = numberRandomGenerator.nextInt(bound);
            randomNumbers.add(number);
            //System.out.println("Num elems: "+k+"Iteration: "+i+"  random number: "+number);
        }
        randomNumbers.forEach(number->specificationSubset.add(specifications.get(number)));
        return specificationSubset;
    }


    //Calculation of implication sets for a repository of a given number of
    // specifications generated randomly.
    //The implication sets are persistent
    public static void calculateImplicationsSets(int repositorySize) throws OWLOntologyCreationException, IOException, OWLOntologyStorageException {
        Set<String>specifications=generateSpecificationSubset(repositorySize);
        //Information space
        Path informationSpaceImplicationSetsPath = Path.of(implicationRepository+
                "informationSpaceImplications//implicationSets.txt");
        informationSpaceImplications.clear();
        informationSpaceImplicationsHorizontalClosures.clear();
        informationSpaceImplicationsVerticalClosures.clear();

        informationSpaceImplications.putAll(readImplicationSet(informationSpaceImplicationSetsPath,specifications));
        informationSpaceHorizontalClosures();
        informationSpaceVerticalClosures();
        Map<String,Set<String>>informationSpaceStrongSets=informationSpaceStrongSets();
        Map<String,Set<String>>informationSpaceWeakSets=informationSpaceWeakSets();
        makePersistentImplications(informationSpaceImplications,
                informationSpaceStrongSets,informationSpaceWeakSets,informationSpaceRepositories);

        //State space
        Path stateSpaceImplicationSetsPath = Path.of(implicationRepository+
                "stateSpaceImplications//implicationSets.txt");
        stateSpaceImplications.clear();
        stateSpaceImplicationsHorizontalClosures.clear();
        stateSpaceImplicationsVerticalClosures.clear();

        stateSpaceImplications.putAll(readImplicationSet(stateSpaceImplicationSetsPath,specifications));
        stateSpaceHorizontalClosures();
        stateSpaceVerticalClosures();
        Map<String,Set<String>>stateSpaceStrongSets=stateSpaceStrongSets();
        Map<String,Set<String>>stateSpaceWeakSets=stateSpaceWeakSets();
        makePersistentImplications(stateSpaceImplications,
                stateSpaceStrongSets,stateSpaceWeakSets,stateSpaceRepositories);
    }

    //Calculation of implication sets for a repository of specifications generated randomly
    //The implication sets are not persistent
    public static Pair<List<Map<String, Set<String>>>,
                           List<Map<String, Set<String>>>> calculateNonPersistentImplicationsSets(int repositorySize) throws IOException {
        //random generation of a repository of specifications with a particular size
        Set<String> specifications = generateSpecificationSubset(repositorySize);
        //Information space
        Path informationSpaceImplicationSetsPath = Path.of(implicationRepository +
                "informationSpaceImplications//implicationSets.txt");
        informationSpaceImplications.clear();
        informationSpaceImplicationsHorizontalClosures.clear();
        informationSpaceImplicationsVerticalClosures.clear();

        informationSpaceImplications.putAll(
                readImplicationSet(informationSpaceImplicationSetsPath,specifications));
        Map<String, Set<String>> informationSpaceImplicationSets = new HashMap<>();
        informationSpaceImplicationSets.putAll(informationSpaceImplications);
        informationSpaceHorizontalClosures();
        informationSpaceVerticalClosures();
        Map<String, Set<String>> informationSpaceStrongSets = informationSpaceStrongSets();
        Map<String, Set<String>> informationSpaceWeakSets = informationSpaceWeakSets();

        Set<String>aux=new HashSet();
        aux.addAll(informationSpaceStrongSets.keySet().stream().
                filter(k->informationSpaceStrongSets.get(k).isEmpty()).collect(Collectors.toSet()));
        aux.forEach(k->informationSpaceStrongSets.remove(k));
        aux=new HashSet();
        aux.addAll(informationSpaceWeakSets.keySet().stream().
                filter(k->informationSpaceWeakSets.get(k).isEmpty()).collect(Collectors.toSet()));
        aux.forEach(k->informationSpaceWeakSets.remove(k));

        List<Map<String, Set<String>>>informationSpaceList = new LinkedList<>();
        informationSpaceList.add(informationSpaceImplicationSets);
        informationSpaceList.add(informationSpaceStrongSets);
        informationSpaceList.add(informationSpaceWeakSets);

        //State space
        Path stateSpaceImplicationSetsPath = Path.of(implicationRepository+
                "stateSpaceImplications//implicationSets.txt");
        stateSpaceImplications.clear();
        stateSpaceImplicationsHorizontalClosures.clear();
        stateSpaceImplicationsVerticalClosures.clear();

        stateSpaceImplications.putAll(readImplicationSet(stateSpaceImplicationSetsPath,specifications));
        Map<String, Set<String>> stateSpaceImplicationSets = new HashMap<>();
        stateSpaceImplicationSets.putAll(stateSpaceImplications);
        stateSpaceHorizontalClosures();
        stateSpaceVerticalClosures();
        Map<String,Set<String>>stateSpaceStrongSets=stateSpaceStrongSets();
        Map<String,Set<String>>stateSpaceWeakSets=stateSpaceWeakSets();

        aux=new HashSet();
        aux.addAll(stateSpaceStrongSets.keySet().stream().
                filter(k->stateSpaceStrongSets.get(k).isEmpty()).collect(Collectors.toSet()));
        aux.forEach(k->stateSpaceStrongSets.remove(k));
        aux=new HashSet();
        aux.addAll(stateSpaceWeakSets.keySet().stream().
                filter(k->stateSpaceWeakSets.get(k).isEmpty()).collect(Collectors.toSet()));
        aux.forEach(k->stateSpaceWeakSets.remove(k));

        List<Map<String, Set<String>>>stateSpaceList = new LinkedList<>();
        stateSpaceList.add(stateSpaceImplicationSets);
        stateSpaceList.add(stateSpaceStrongSets);
        stateSpaceList.add(stateSpaceWeakSets);

        return new Pair<>(informationSpaceList,stateSpaceList);
    }
}
