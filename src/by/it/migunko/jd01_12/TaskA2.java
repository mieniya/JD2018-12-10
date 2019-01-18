package by.it.migunko.jd01_12;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class TaskA2 {
    public static void main(String[] args) {
        Integer[] arr1 = {0, 8, 1, 1, 1, 2, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7};
        Integer[] arr2 = {9, 9, 9, 8, 8, 8, 7, 7, 7, 6, 6, 6, 5, 4, 4, 4};

        Set<Integer> set1 = new HashSet<>(Arrays.asList(arr1));
        Set<Integer> set2 = new TreeSet<>(Arrays.asList(arr2));
        System.out.println(set1);
        System.out.println(set2);

        Set<Integer> union = getUnion(set1, set2);
        System.out.println(union);
        Set<Integer> cross = getCross(set1, set2);
        System.out.println(cross);
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
