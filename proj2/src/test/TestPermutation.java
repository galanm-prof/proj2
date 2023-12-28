package test;

import common.Permutation;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;

public class TestPermutation {
    public static void main(String[] args){
        Set<String> s=new HashSet<>();
        s.add("s1");s.add("s2");s.add("s3");
        //Set<List<String>> r=Permutation.generate(s);
        //r.stream().forEach(l->System.out.println(l));

        Set<List<String>> p=new HashSet<>();
        p.add(new LinkedList<>());
        //Set<List<String>> r=Permutation.generate(s,p);
        //r.stream().forEach(l->System.out.println(l));

        Predicate<List<String>> pred=l->l.size()==4;
        Set<List<String>> r2=Permutation.generateAndTest(s,p,pred);
        if (r2==null) System.out.println(r2);
        else r2.stream().forEach(l->System.out.println(l));
    }
}
