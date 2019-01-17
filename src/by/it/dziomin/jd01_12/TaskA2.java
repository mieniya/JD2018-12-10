package by.it.dziomin.jd01_12;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class TaskA2 {

    public static void main(String[] args) {
        Integer ar1[] = {1, 1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 4, 5, 5, 5, 5, 6, 6, 6, 7, 7, 7, 100, -1000};
        Integer ar2[] = {9, 9, 4, 4, 4, 4, 4, 5, 5, 5, 5, 6, 6, 6, 7, 7, 7, 8, 8, 9, 9, 9, 0, 0};
        Set<Integer> set1 = new HashSet<>(Arrays.asList(ar1));
        Set<Integer> set2 = new TreeSet<>(Arrays.asList(ar2));
        System.out.println(set1);
        System.out.println(set2);
        System.out.println("GetUnion: " + getUnion(set1, set2));
        System.out.println("GetCross: " + getCross(set1, set2));
    }

    private static Set<Integer> getUnion(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> result = new HashSet<>(set1);
        result.addAll(set2);
        return result;
    }

    private static Set<Integer> getCross(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> result = new HashSet<>(set1);
        result.retainAll(set2);
        return result;
    }

}
