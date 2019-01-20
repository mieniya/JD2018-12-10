package by.it.lyakhova.jd01_12;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class TaskC2 <T extends Number> {
    public static void main(String[] args) {
        Integer[] arr1 = {0,1,1,1,1,2,2,2,3,3,3,3,4,4,5,5,5,5,6,6,6,7,7,7,7};
        Integer[] arr2 = {9,9,9,9,8,8,8,8,7,7,7,7,6,6,6,5,5,5,5,4,4,4};

        Set<Integer> set1 = new HashSet<>(Arrays.asList(arr1));
        System.out.println(set1);
        Set<Integer> set2 = new TreeSet<>(Arrays.asList(arr2));
        System.out.println(set2);

        Set<Integer> cross = getCross(set1, set2);
        System.out.println(cross);
        Set<Integer> union = getUnion(set1, set2);
        System.out.println(union);

    }

    private static Set getUnion(Set<? extends Number> ... sets) {
        Set<? extends Number> result = new HashSet<>();
        for (Set set:
             sets) {
            result.addAll(set);

        }
        return result;
    }

    private static Set getCross(Set<? extends Number> ... sets) {
        Set<? extends Number> result = new HashSet<>(16);
        int i = 1;
        for (Set set:
                sets) {
            if (i++==1) result.addAll(set);
            result.retainAll(set);

        }
        return result;
    }
}
