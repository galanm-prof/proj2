package repositories;


import common.RandGenerator;
import common.RepositoryStatistics;
import file.RepositoryHandler;
import org.antlr.v4.gui.TreeViewer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.misc.Pair;
import org.antlr.v4.runtime.tree.ParseTree;

import javax.swing.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//Class for creating and consulting specifications repositories (intended for experimentation)
public class Repositories {
    private static String repositoriesRepository="c:/xampp/htdocs/repositories/";
    private static String informationSpaceRepositories = repositoriesRepository+
            "informationSpaceImplications/";
    private static String stateSpaceRepositories = repositoriesRepository+
            "stateSpaceImplications/";

    //Maximum number of iterations for genering repositories randomly.
    private static final int LIMIT=3000;

    //Read an implication set of a repository
    //Pre: implicationSetPath refers to an existing file containing implications (for instance,
    //     strong sets, weak sets or direct implications)
    private static Map<String, Set<String>> readImplicationSet(Path implicationSetPath) throws IOException {
        Map<String,Set<String>>implications = new HashMap<>();
        Stream<String> lines=Files.lines(implicationSetPath);
        lines.forEach(line->{
            String[]elements=line.split(":");
            String antecedent=elements[0].trim();
            implications.put(antecedent, new HashSet<>());
            String consequent = elements[1].trim();
            if (consequent.contains(",")) {
                String[] consequentElements = consequent.split(",");
                for (String elem : consequentElements) {
                    implications.get(antecedent).add(elem.trim());
                }
            }
            else
                implications.get(antecedent).add(consequent);
        });
        return implications;
    }

    //Number of implication sets in the index-th repository.
    //Pre: the index-th repository exists
    public static double numberOfImplicationSets(Integer index,
                                                 boolean informationSpace,
                                                 boolean strongSets) throws IOException {
        double r=0.0;
        Path path = null;
        if (informationSpace){
            if (strongSets)
                path = Path.of(informationSpaceRepositories+index+"/"+"strongSets.txt");
            else
                path = Path.of(informationSpaceRepositories+index+"/"+"weakSets.txt");
        }
        else{
            if (strongSets)
                path = Path.of(stateSpaceRepositories+index+"/"+"strongSets.txt");
            else
                path = Path.of(stateSpaceRepositories+index+"/"+"weakSets.txt");
        }
        Map<String, Set<String>> implications = readImplicationSet(path);
        r = implications.keySet().size();
        return r;
    }

    //Mean size of implication sets for the index-th repository
    //Pre: the index-th repository exists
    public static double meanSizeOfImplicationSets(Integer index,
                                       boolean informationSpace,
                                       boolean strongSets) throws IOException {
        double r=0.0;
        Path path = null;
        if (informationSpace){
            if (strongSets)
                path = Path.of(informationSpaceRepositories+index+"/"+"strongSets.txt");
            else
                path = Path.of(informationSpaceRepositories+index+"/"+"weakSets.txt");
        }
        else{
            if (strongSets)
                path = Path.of(stateSpaceRepositories+index+"/"+"strongSets.txt");
            else
                path = Path.of(stateSpaceRepositories+index+"/"+"weakSets.txt");
        }
        Map<String, Set<String>> implications = readImplicationSet(path);
        r = implications.entrySet().stream().mapToInt(e->e.getValue().size()).average().orElse(0.0);
        return r;
    }

    //Mean relative size of implication sets for the index-th repository
    //Pre: the index-th repository exists
    public static double meanRelativeSizeOfImplicationSets(Integer index,
                                                   boolean informationSpace,
                                                   boolean strongSets) throws IOException {
        double r=0.0;
        Path path = null;
        if (informationSpace){
            if (strongSets)
                path = Path.of(informationSpaceRepositories+index+"/"+"strongSets.txt");
            else
                path = Path.of(informationSpaceRepositories+index+"/"+"weakSets.txt");
        }
        else{
            if (strongSets)
                path = Path.of(stateSpaceRepositories+index+"/"+"strongSets.txt");
            else
                path = Path.of(stateSpaceRepositories+index+"/"+"weakSets.txt");
        }
        Integer repositorySize =
                readImplicationSet(Path.of(informationSpaceRepositories+
                        index+"/"+"implicationSets.txt")).keySet().size();  //direct implications

        Map<String, Set<String>> implications = readImplicationSet(path);
        r = implications.entrySet().stream().
                mapToDouble(e->e.getValue().size()/(double)repositorySize).average().orElse(0.0);
        return r;
    }

    //Statistics of the index-th repository
    //Pre: index-th repository exists
    public static RepositoryStatistics repositoryStatistics(Integer index) throws IOException {
        Map<String, Set<String>> informationSpaceImplicationSets=
                readImplicationSet(Path.of(informationSpaceRepositories+
                        index+"/"+"implicationSets.txt"));
        Map<String, Set<String>> informationSpaceStrongSets=
                readImplicationSet(Path.of(informationSpaceRepositories+
                        index+"/"+"strongSets.txt"));
        Map<String, Set<String>> informationSpaceWeakSets=
                readImplicationSet(Path.of(informationSpaceRepositories+
                        index+"/"+"weakSets.txt"));
        Map<String, Set<String>> stateSpaceImplicationSets=
                readImplicationSet(Path.of(stateSpaceRepositories+
                        index+"/"+"implicationSets.txt"));
        Map<String, Set<String>> stateSpaceStrongSets=
                readImplicationSet(Path.of(stateSpaceRepositories+
                        index+"/"+"strongSets.txt"));
        Map<String, Set<String>> stateSpaceWeakSets=
                readImplicationSet(Path.of(stateSpaceRepositories+
                        index+"/"+"weakSets.txt"));
        Integer repositorySize=informationSpaceImplicationSets.keySet().size();
        Integer numberInformationSpaceStrongSets=informationSpaceStrongSets.keySet().size();
        Integer numberInformationSpaceWeakSets=informationSpaceWeakSets.keySet().size();
        Integer numberStateSpaceStrongSets=stateSpaceStrongSets.keySet().size();
        Integer numberStateSpaceWeakSets=stateSpaceWeakSets.keySet().size();
        Double meanSizeInformationSpaceStrongSets=meanSizeOfImplicationSets(index,true,true);
        Double meanSizeInformationSpaceWeakSets=meanSizeOfImplicationSets(index,true,false);
        Double meanSizeStateSpaceStrongSets=meanSizeOfImplicationSets(index,false,true);
        Double meanSizeStateSpaceWeakSets=meanSizeOfImplicationSets(index,false,false);
        Double meanRelativeSizeInformationSpaceStrongSets=
                meanRelativeSizeOfImplicationSets(index,true,true);
        Double meanRelativeSizeInformationSpaceWeakSets=
                meanRelativeSizeOfImplicationSets(index,true,false);
        Double meanRelativeSizeStateSpaceStrongSets=
                meanRelativeSizeOfImplicationSets(index,false,true);
        Double meanRelativeSizeStateSpaceWeakSets=
                meanRelativeSizeOfImplicationSets(index,false,false);
        return new RepositoryStatistics(repositorySize,
                numberInformationSpaceStrongSets, numberInformationSpaceWeakSets,
                numberStateSpaceStrongSets,numberStateSpaceWeakSets,
                meanSizeInformationSpaceStrongSets, meanSizeInformationSpaceWeakSets,
                meanSizeStateSpaceStrongSets, meanSizeStateSpaceWeakSets,
                meanRelativeSizeInformationSpaceStrongSets,
                meanRelativeSizeInformationSpaceWeakSets, meanRelativeSizeStateSpaceStrongSets,
                meanRelativeSizeStateSpaceWeakSets);
    }

    //Statistics of a repository given its implication sets.
    public static RepositoryStatistics repositoryStatistics(Map<String, Set<String>> informationSpaceImplicationSets,
                                                            Map<String, Set<String>> informationSpaceStrongSets,
                                                            Map<String, Set<String>> informationSpaceWeakSets,
                                                            Map<String, Set<String>> stateSpaceStrongSets,
                                                            Map<String, Set<String>> stateSpaceWeakSets) {
        Integer repositorySize=informationSpaceImplicationSets.keySet().size();
        Integer numberInformationSpaceStrongSets=informationSpaceStrongSets.keySet().size();
        Integer numberInformationSpaceWeakSets=informationSpaceWeakSets.keySet().size();
        Integer numberStateSpaceStrongSets=stateSpaceStrongSets.keySet().size();
        Integer numberStateSpaceWeakSets=stateSpaceWeakSets.keySet().size();
        Double meanSizeInformationSpaceStrongSets=informationSpaceStrongSets.entrySet().stream().
                mapToDouble(e->e.getValue().size()).average().orElse(0.0);
        Double meanSizeInformationSpaceWeakSets=informationSpaceWeakSets.entrySet().stream().
                mapToDouble(e->e.getValue().size()).average().orElse(0.0);
        Double meanSizeStateSpaceStrongSets=stateSpaceStrongSets.entrySet().stream().
                mapToDouble(e->e.getValue().size()).average().orElse(0.0);
        Double meanSizeStateSpaceWeakSets=stateSpaceWeakSets.entrySet().stream().
                mapToDouble(e->e.getValue().size()).average().orElse(0.0);
        Double meanRelativeSizeInformationSpaceStrongSets=informationSpaceStrongSets.entrySet().stream().
                mapToDouble(e->e.getValue().size()/(double)repositorySize).average().orElse(0.0);
        Double meanRelativeSizeInformationSpaceWeakSets=informationSpaceWeakSets.entrySet().stream().
                mapToDouble(e->e.getValue().size()/(double)repositorySize).average().orElse(0.0);
        Double meanRelativeSizeStateSpaceStrongSets=stateSpaceStrongSets.entrySet().stream().
                mapToDouble(e->e.getValue().size()/(double)repositorySize).average().orElse(0.0);
        Double meanRelativeSizeStateSpaceWeakSets=stateSpaceWeakSets.entrySet().stream().
                mapToDouble(e->e.getValue().size()/(double)repositorySize).average().orElse(0.0);
        return new RepositoryStatistics(repositorySize,
                numberInformationSpaceStrongSets, numberInformationSpaceWeakSets,
                numberStateSpaceStrongSets,numberStateSpaceWeakSets,
                meanSizeInformationSpaceStrongSets, meanSizeInformationSpaceWeakSets,
                meanSizeStateSpaceStrongSets, meanSizeStateSpaceWeakSets,
                meanRelativeSizeInformationSpaceStrongSets,
                meanRelativeSizeInformationSpaceWeakSets, meanRelativeSizeStateSpaceStrongSets,
                meanRelativeSizeStateSpaceWeakSets);
    }

    //Generate-and-test strategy: Randomly generation of n repositories each having a repository size
    // and satisfying a condition over its statistics (RepositoryStatistics).
    public static boolean conditionalGenerationOfRepositories(int n, int repositorySize,
                                   Predicate<RepositoryStatistics> predicate) throws IOException {
        int limit = LIMIT;
        int count = 0;
        List<Pair<List<Map<String, Set<String>>>,
                  List<Map<String, Set<String>>>>>repositories = new LinkedList<>();
        while (limit>0 && count < n){
            //System.out.println("Generating a repository");
            Pair<List<Map<String, Set<String>>>,
                    List<Map<String, Set<String>>>> repository =
                    RandGenerator.calculateNonPersistentImplicationsSets(repositorySize);
            RepositoryStatistics statistics =
                    repositoryStatistics(repository.a.get(0),
                            repository.a.get(1),
                            repository.a.get(2),
                            repository.b.get(1),
                            repository.b.get(2));
            //System.out.println(statistics.toString());
            if (predicate.test(statistics)){
                //System.out.println("OK");
                repositories.add(repository);
                count++;
            }
            limit--;
        }
        if (count==n) {
            //System.out.println("DONE");
            repositories.stream().forEach(repository->
            {
                try {
                    RandGenerator.makePersistentImplications(repository.a.get(0), repository.a.get(1),
                            repository.a.get(2), informationSpaceRepositories);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
            repositories.stream().forEach(repository->
            {
                try {
                    RandGenerator.makePersistentImplications(repository.b.get(0), repository.b.get(1),
                            repository.b.get(2), stateSpaceRepositories);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        }
        return (count==n);
    }

    //Generate-and-test strategy: Randomly generation of n repositories each having a repository size
    // and satisfying a condition over its statistics (RepositoryStatistics).
    public static boolean conditionalGenerationOfRepositories(int n, int repositorySize,
                                                           String pred) throws IOException {
        CharStream f = CharStreams.fromString(pred);
        PredicateLexer analex = new PredicateLexer(f);
        CommonTokenStream ts = new CommonTokenStream(analex);
        PredicateSyntax parser = new PredicateSyntax(ts);
        ParseTree tree = parser.predicate();
        //showParseTree(parser,tree);
        CompilePredicate compiler = new CompilePredicate();
        Predicate<RepositoryStatistics> predicate = compiler.visit(tree).getPredicate();
        int limit = LIMIT;
        int count = 0;
        List<Pair<List<Map<String, Set<String>>>,
                List<Map<String, Set<String>>>>>repositories = new LinkedList<>();
        while (limit>0 && count < n){
            //System.out.println("Generating a repository");
            Pair<List<Map<String, Set<String>>>,
                    List<Map<String, Set<String>>>> repository =
                    RandGenerator.calculateNonPersistentImplicationsSets(repositorySize);
            RepositoryStatistics statistics =
                    repositoryStatistics(repository.a.get(0),
                            repository.a.get(1),
                            repository.a.get(2),
                            repository.b.get(1),
                            repository.b.get(2));
            //System.out.println(statistics.toString());
            if (predicate.test(statistics)){
                //System.out.println("OK");
                repositories.add(repository);
                count++;
            }
            limit--;
        }
        if (count==n) {
            //System.out.println("DONE");
            repositories.stream().forEach(repository->
            {
                try {
                    RandGenerator.makePersistentImplications(repository.a.get(0), repository.a.get(1),
                            repository.a.get(2), informationSpaceRepositories);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
            repositories.stream().forEach(repository->
            {
                try {
                    RandGenerator.makePersistentImplications(repository.b.get(0), repository.b.get(1),
                            repository.b.get(2), stateSpaceRepositories);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        }
        return (count==n);
    }

    //Generate-and-test strategy: Hypothetical generation of n repositories each having a repository size
    // and satisfying a condition over its statistics (RepositoryStatistics).
    public static boolean hypotheticalGenerationOfRepositories(int n, int repositorySize,
                                                           String pred) throws IOException {
        CharStream f = CharStreams.fromString(pred);
        PredicateLexer analex = new PredicateLexer(f);
        CommonTokenStream ts = new CommonTokenStream(analex);
        PredicateSyntax parser = new PredicateSyntax(ts);
        ParseTree tree = parser.predicate();
        //showParseTree(parser,tree);
        CompilePredicate compiler = new CompilePredicate();
        Predicate<RepositoryStatistics> predicate = compiler.visit(tree).getPredicate();
        int limit = LIMIT;
        int count = 0;
        List<Pair<List<Map<String, Set<String>>>,
                  List<Map<String, Set<String>>>>>repositories = new LinkedList<>();
        while (limit>0 && count < n){
            //System.out.println("Generating a repository");
            Pair<List<Map<String, Set<String>>>,
                    List<Map<String, Set<String>>>> repository =
                    RandGenerator.calculateNonPersistentImplicationsSets(repositorySize);
            RepositoryStatistics statistics =
                    repositoryStatistics(repository.a.get(0),
                            repository.a.get(1),
                            repository.a.get(2),
                            repository.b.get(1),
                            repository.b.get(2));
            //System.out.println(statistics.toString());
            if (predicate.test(statistics)){
                //System.out.println("OK");
                repositories.add(repository);
                count++;
            }
            limit--;
        }
        return (count==n);
    }
    private static Set<Integer> readSpecificationIndexes(){

        RepositoryHandler rh = new RepositoryHandler(repositoriesRepository+"informationSpaceImplications/");
        Set<Integer>specifications=rh.get_directories().stream().
                map(file->Integer.valueOf(file.getName())).collect(Collectors.toSet());
        return specifications;
    }

    //Selection of repositories which satisfy a predicate
    public static Set<Integer>selectionOfRepositories(Predicate<RepositoryStatistics> predicate) throws IOException {
        Set<Integer>repositoriesIndexes=new HashSet<>();

        Set<Integer>indexes=readSpecificationIndexes();
        for(Integer index:indexes){
            RepositoryStatistics stat = repositoryStatistics(index);
            //System.out.println(index+" --> "+stat);
            if (predicate.test(stat))
                repositoriesIndexes.add(index);
        }
        return repositoriesIndexes;
    }

    //Selection of repositories which satisfy a predicate
    public static Set<Integer>selectionOfRepositories(String pred) throws IOException {
        CharStream f = CharStreams.fromString(pred);
        PredicateLexer analex = new PredicateLexer(f);
        CommonTokenStream ts = new CommonTokenStream(analex);
        PredicateSyntax parser = new PredicateSyntax(ts);
        ParseTree tree = parser.predicate();
        //showParseTree(parser,tree);
        CompilePredicate compiler = new CompilePredicate();
        Predicate<RepositoryStatistics> predicate = compiler.visit(tree).getPredicate();
        Set<Integer>repositoriesIndexes=new HashSet<>();
        Set<Integer>indexes=readSpecificationIndexes();
        for(Integer index:indexes){
            RepositoryStatistics stat = repositoryStatistics(index);
            //System.out.println(index+" --> "+stat);
            if (predicate.test(stat))
                repositoriesIndexes.add(index);
        }
        return repositoriesIndexes;
    }

    //Selection of repositories with a particular size
    public static Set<Integer>selectionOfRepositories(Integer size) throws IOException {
        Set<Integer>repositoriesIndexes=new HashSet<>();

        Set<Integer>indexes=readSpecificationIndexes();
        for(Integer index:indexes){
            RepositoryStatistics stat = repositoryStatistics(index);

            if (stat.repositorySize().equals(size)) {
                //System.out.println(index+" --> "+stat);
                repositoriesIndexes.add(index);
            }
        }
        return repositoriesIndexes;
    }
}
