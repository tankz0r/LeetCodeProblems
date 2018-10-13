package org.stepic.java.generics;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class symDifference {

    public static <T> Set<T> symmetricDifference(Set<? extends T> set1, Set<? extends T> set2) {
        HashSet <T> diff = new HashSet<>();
//        if (set1.size() > set2.size()){
//            Set <? extends T> temp = null;
//            temp = set1;
//            set1 = set2;
//            set2 = set1;
//        }
        set2.forEach(item -> {
            if (!(set1.contains(item)))
                diff.add(item);
        });
        return diff;
    }

    public static void main(String[] args) {
        HashSet <Integer> s1 = new HashSet<>();
        HashSet <Integer> s2 = new HashSet<>();
        Integer [] m1 = {1,2,3,4};
        Integer [] m2 = {1,2,3};
        Collections.addAll(s1, m1);
        Collections.addAll(s2, m2);
        System.out.print(symmetricDifference(s1,s2 ));
    }
}
