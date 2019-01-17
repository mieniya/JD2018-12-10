package by.it.yarmolenka.jd01_12;

import java.util.*;

public class TaskA2 {
    public static void main(String[] args) {
        Integer[] aa = {1,1,1,2,2,2,3,3,4,4,4,4,5,5,5,6,6,6,7,7,7};
        Integer[] bb = {4,4,5,5,5,6,6,6,6,7,7,7,8,8,8,9,9,0,0,0};
        Set<Integer> set1 = new HashSet<>(Arrays.asList(aa));
        Set<Integer> set2 = new TreeSet<>(Arrays.asList(bb));
        Set<Integer> cross = getCross(set1, set2);
        Set<Integer> union = getUnion(set1, set2);
        System.out.println(cross);
        System.out.println(union);
    }

    private static Set<Integer> getUnion(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> res = new HashSet<>(set1);
        res.addAll(set2);
        return res;
    }

    private static Set<Integer> getCross(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> res = new HashSet<>(set1);
        res.retainAll(set2);
        return res;
    }

}
