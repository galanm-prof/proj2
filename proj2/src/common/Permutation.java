package common;

import file.RepositoryHandler;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Permutation {

    //Iterative version.
    public static Set<List<String>>generate(Set<String>specifications){
        Set<List<String>>permutations=new HashSet<>();
        if (specifications.isEmpty()) {
            permutations.add(new LinkedList<>());
            return permutations;
        }
        else {
            for(String spec:specifications){
                Set<String>specs=new HashSet<>();
                specs.addAll(specifications);
                specs.remove(spec);
                Set<List<String>>aux=generate(specs);
                for(List<String>l:aux){
                    l.add(0,spec);
                    permutations.add(l);
                }
            }
        }
        return permutations;
    }

    //Final recursive version. Permutation parameter takes the initial value: {[]}
    public static Set<List<String>> generate(Set<String>specifications,
                                            Set<List<String>>permutations){
        //System.out.println(specifications+"  "+permutations);
        Set<List<String>>r=null;
        if (!specifications.isEmpty()) {
            Set<String>aux_specs=new HashSet<>(specifications);
            String spec=aux_specs.stream().findAny().get();
            aux_specs.remove(spec);
            Set<List<String>>aux_perms=new HashSet<>();
            for(List<String>p:permutations){
                if (p.isEmpty()){
                    List<String>aux_p=new LinkedList<>();
                    aux_p.add(0,spec);
                    aux_perms.add(aux_p);
                }
                else{
                    for(int i=0;i<=p.size();i++){
                        List<String>aux_p=new LinkedList<>(p);
                        aux_p.add(i,spec);
                        aux_perms.add(aux_p);
                    }
                }
            }
            r=generate(aux_specs,aux_perms);
        }
        else r=permutations;
        return r;
    }
    //Final recursive version. Permutation parameter takes the initial value: {[]}
    //Recursion termination depends on a predicate. Permutations are generated in an incremental way and
    //this generation process terminates if some generated permutation satifies the given predicate.
    public static Set<List<String>> generateAndTest(Set<String>specifications,
                                                    Set<List<String>>permutations,
                                                    Predicate<List<String>>predicate){
        //System.out.println(specifications+"  "+permutations+"  predicate: "+
          //      permutations.stream().anyMatch(l->predicate.test(l)));
        Set<List<String>>r=null;
        if (!permutations.stream().anyMatch(l->predicate.test(l))) {
            if (!specifications.isEmpty()){
                Set<String> aux_specs = new HashSet<>(specifications);
                String spec = aux_specs.stream().findAny().get();
                aux_specs.remove(spec);
                Set<List<String>> aux_perms = new HashSet<>();
                for (List<String> p : permutations) {
                    if (p.isEmpty()) {
                        List<String> aux_p = new LinkedList<>();
                        aux_p.add(0, spec);
                        aux_perms.add(aux_p);
                    } else {
                        for (int i = 0; i <= p.size(); i++) {
                            List<String> aux_p = new LinkedList<>(p);
                            aux_p.add(i, spec);
                            aux_perms.add(aux_p);
                        }
                    }
                }
                r = generateAndTest(aux_specs, aux_perms,predicate);
            }
            else return null;
        }
        else r=permutations;
        return r;
    }
}
