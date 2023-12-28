package repositories;

import file.RepositoryHandler;
import org.antlr.v4.runtime.misc.Pair;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import search.StateSpaceImplication;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//Class for developing matching experiments
//For matching experiment we mean the matching of a set of requests with a set of
//specification repositories.
//The selection of both requests and specification repositories is a relevant
//part of the experiment.
public class Experiment {
    private static final String
            substitutionRepositoryRequestSpecification =
               "C://xampp//htdocs//substitutions2//";
    private static final String
            substitutionRepositorySpecificationSpecification =
               "C://xampp//htdocs//substitutions//";

    private static final String
            implicationRepositoryRequestSpecification =
               "C://xampp//htdocs//implications2//";
    private static final String
            implicationRepositorySpecificationSpecification =
               "C://xampp//htdocs//implications//";
    private static final String
            specificationsRepository = "C://xampp//htdocs//specifications//";

    private static final String
            repositoriesRepository = "C://xampp//htdocs//repositories//";
    private Set<String> requests;
    private Set<String> specifications;
    private Map<String,Set<String>> informationSpaceStrongSetsSpecificationSpecification;
    private Map<String,Set<String>>informationSpaceWeakSetsSpecificationSpecification;
    private Map<String,Set<String>> stateSpaceStrongSetsSpecificationSpecification;
    private Map<String,Set<String>> stateSpaceWeakSetsSpecificationSpecification;

    public Experiment() throws IOException {
        readSpecifications();
        readImplicationSetsSpecificationSpecification();
    }

    private void readSpecifications(){
        RepositoryHandler rh = new RepositoryHandler(specificationsRepository);
        specifications=rh.get_directories().stream().
                map(file->file.getName()).collect(Collectors.toSet());
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
    private void readImplicationSetsSpecificationSpecification() throws IOException {
        Map<String,Set<String>> implicationSets = new HashMap<>();
        Path informationSpaceStrongSetsPath = Path.of(implicationRepositorySpecificationSpecification+
                "informationSpaceImplications//strongSets.txt");
        Path informationSpaceWeakSetsPath = Path.of(implicationRepositorySpecificationSpecification+
                "informationSpaceImplications//weakSets.txt");
        Path stateSpaceStrongSetsPath = Path.of(implicationRepositorySpecificationSpecification+
                "stateSpaceImplications//strongSets.txt");
        Path stateSpaceStrongWeakSetsPath = Path.of(implicationRepositorySpecificationSpecification+
                "stateSpaceImplications//weakSets.txt");
        informationSpaceStrongSetsSpecificationSpecification =
                readImplicationSet(informationSpaceStrongSetsPath);
        informationSpaceWeakSetsSpecificationSpecification =
                readImplicationSet(informationSpaceWeakSetsPath);
        stateSpaceStrongSetsSpecificationSpecification =
                readImplicationSet(stateSpaceStrongSetsPath);
        stateSpaceWeakSetsSpecificationSpecification =
                readImplicationSet(stateSpaceStrongWeakSetsPath);
    }

    private boolean implies(String specification, String request){
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

    public Pair<Set<String>,Double> inefficientSearchingInformationSpace(String request){
        Set<String>foundSpecifications = new HashSet<>();
        Set<String>visitedSpecifications = new HashSet<>();
        for (String specification:this.specifications){
            visitedSpecifications.add(specification);
            if (implies(specification,request))
                foundSpecifications.add(specification);
        }
        return new Pair<>(foundSpecifications, ((double) visitedSpecifications.size()/this.specifications.size()));
    }

    public Pair<Set<String>,Double> efficientSearchingInformationSpace(String request){
        Set<String>foundSpecifications = new HashSet<>();
        Set<String>visitedSpecifications = new HashSet<>();
        Set<String>discardedSpecifications = new HashSet<>();
        Set<String>potentialSpecifications=new HashSet<>();
        potentialSpecifications.addAll(this.specifications);

       //Prunning
        for (String specification:this.informationSpaceStrongSetsSpecificationSpecification.keySet()) {
            visitedSpecifications.add(specification);
            if (!implies(specification,request)){
                discardedSpecifications.add(specification);
                discardedSpecifications.addAll(this.
                    informationSpaceStrongSetsSpecificationSpecification.get(specification));
            }
        }
        potentialSpecifications.removeAll(discardedSpecifications);
        System.out.println("\nPrunning (Total/Potential/Discarded/Visited) "+
                this.specifications.size()+"/"+potentialSpecifications.size()+"/"+
                discardedSpecifications.size()+"/"+visitedSpecifications.size());

        //Direct discovery
        if (!potentialSpecifications.isEmpty()) {
           Set<String>aux=new HashSet<>();
           aux.addAll(this.informationSpaceWeakSetsSpecificationSpecification.keySet());
           aux.removeAll(discardedSpecifications);
           for(String specification:aux){
               visitedSpecifications.add(specification);
               if (implies(specification,request)){
                   foundSpecifications.add(specification);
                   foundSpecifications.addAll(this.
                           informationSpaceWeakSetsSpecificationSpecification.get(specification));
                   discardedSpecifications.add(specification);
                   discardedSpecifications.addAll(this.
                           informationSpaceWeakSetsSpecificationSpecification.get(specification));
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
            if (implies(specification,request))
                foundSpecifications.add(specification);
        }

        System.out.println("Remaining specification discovery (Total/Potential/Discarded/Visited) "+
                this.specifications.size()+"/"+potentialSpecifications.size()+"/"+
                discardedSpecifications.size()+"/"+visitedSpecifications.size());

        return new Pair<>(foundSpecifications, ((double) visitedSpecifications.size()/this.specifications.size()));
    }

    private boolean implies2(String specification, String request) throws OWLOntologyCreationException {
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
    public Pair<Set<String>,Double> efficientSearchingInformationSpaceStateSpace(String request) throws OWLOntologyCreationException {
        Set<String>foundSpecifications = new HashSet<>();
        Set<String>visitedSpecifications = new HashSet<>();
        Set<String>discardedSpecifications = new HashSet<>();
        Set<String>potentialSpecifications=new HashSet<>();
        potentialSpecifications.addAll(this.specifications);

        //Prunning wrt information space
        for (String specification:this.informationSpaceStrongSetsSpecificationSpecification.keySet()) {
            visitedSpecifications.add(specification);
            if (!implies(specification,request)){
                discardedSpecifications.add(specification);
                discardedSpecifications.addAll(this.
                        informationSpaceStrongSetsSpecificationSpecification.get(specification));
            }
        }
        potentialSpecifications.removeAll(discardedSpecifications);
        System.out.println("\nPrunning wrt information space (Total/Potential/Discarded/Visited) "+
                this.specifications.size()+"/"+potentialSpecifications.size()+"/"+
                discardedSpecifications.size()+"/"+visitedSpecifications.size());

        //Prunning discovery wrt state space
        Set<String>aux=new HashSet<>();
        aux.addAll(this.stateSpaceStrongSetsSpecificationSpecification.keySet());
        aux.removeAll(discardedSpecifications);
        for (String specification:aux) {
            visitedSpecifications.add(specification);
            if (!implies2(specification,request)){
                discardedSpecifications.add(specification);
                discardedSpecifications.addAll(this.
                        stateSpaceStrongSetsSpecificationSpecification.get(specification));
            }
        }
        potentialSpecifications.removeAll(discardedSpecifications);
        System.out.println("\nPrunning wrt state space (Total/Potential/Discarded/Visited) "+
                this.specifications.size()+"/"+potentialSpecifications.size()+"/"+
                discardedSpecifications.size()+"/"+visitedSpecifications.size());

        //Direct discovery
        if (!potentialSpecifications.isEmpty()) {
            aux=new HashSet<>();
            aux.addAll(this.stateSpaceWeakSetsSpecificationSpecification.keySet());
            aux.removeAll(discardedSpecifications);
            for(String specification:aux){
                visitedSpecifications.add(specification);
                if (implies2(specification,request)){
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
            if (implies2(specification,request))
                foundSpecifications.add(specification);
        }

        System.out.println("Remaining specification discovery (Total/Potential/Discarded/Visited) "+
                this.specifications.size()+"/"+potentialSpecifications.size()+"/"+
                discardedSpecifications.size()+"/"+visitedSpecifications.size());

        return new Pair<>(foundSpecifications, ((double) visitedSpecifications.size()/this.specifications.size()));
    }
}
