package by.it.moroz.jd01.jd01_12;

import java.util.*;

public class TaskC2 {

    public static <E> void main(String[] args) {

        Integer[] arr1 = {1, 2, 3, 4, 5, 6, 6, 7, 7, 8, 9};
        Double[] arr2 = {5.0, 5.0, 5.2, 6.3, 10.7, 8.4, 9.8, 12.0, 9.12, 10.7, 11.5, 9.0, 7.6};
        Integer[] arr3 = {1, 2,55, 4, 5, 6, 6, 7, 7, 8, 9};
        Integer[] arr4 = {1, 2, 3, 4, 44, 6, 6, 7, 7, 8, 9};
        Integer[] arr5 = {1, 2, 3, 66, 5, 6, 6, 7, 7, 8, 9};
        Integer[] arr6 = {1, 2, 33, 4, 5, 6, 6, 7, 7777, 8, 9};

        Set<Integer> set1 = new HashSet<>( Arrays.asList(arr1));
        System.out.println(set1);

        Set<Double> set2 = new TreeSet<>(Arrays.asList(arr2));
        System.out.println(set2);
        Set<Integer> set3 = new HashSet<>(Arrays.asList(arr3));
        Set<Integer> set4 = new HashSet<>(Arrays.asList(arr4));
        Set<Integer> set5 = new HashSet<>(Arrays.asList(arr5));
        Set<Integer> set6 = new HashSet<>(Arrays.asList(arr6));


        Set <E> union =  getUnion(set1, set3, set4, set5, set6);
        System.out.println(union);
        Set<E> cross = getCross(set1, set3);
        System.out.println(cross);
    }


    private static <E> Set getUnion(Set<E>... set) {
       HashSet <E> result = new HashSet<>();
        for (Set<E> es : set) {
            result.addAll(es);
        }
        return result;
    }

    private static <E> Set getCross(Set<E>... set) {

        Set<E> result = new HashSet<>(set[0]);
        for (Set<E> es : set) {
            result.retainAll(es);
        }
        return result;
    }
}
