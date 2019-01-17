package by.it.yarmolenka.jd01_12;

import java.util.*;

public class TaskC2 {
    public static void main(String[] args) {
        String[] mas1 = {"one", "two", "three", "four", "five"};
        String[] mas2 = {"four", "five", "six", "seven", "eight"};
        String[] mas3 = {"eight", "nine", "ten", "eleven", "twelve", "five"};
        Set<String> arr1 = new TreeSet<>(Arrays.asList(mas1));
        Set<String> arr2 = new TreeSet<>(Arrays.asList(mas2));
        Set<String> arr3 = new TreeSet<>(Arrays.asList(mas3));
        Set union = getUnion(arr1, arr2, arr3);
        Set cross = getCross(arr1, arr2, arr3);
        System.out.println("arr1: " + arr1);
        System.out.println("arr2: " + arr2);
        System.out.println("arr3: " + arr3);
        System.out.println("union: " + union);
        System.out.println("cross: " + cross);
    }

    @SafeVarargs
    private static <E> Set getUnion(Set<E>... arr) {
        Set<E> res = new HashSet<>(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            res.addAll(arr[i]);
        }
        return res;
    }

    @SafeVarargs
    private static <E> Set getCross(Set<E>... set) {
        Set<E> res = new HashSet<>(set[0]);
        for (int i = 1; i < set.length; i++) {
            res.retainAll(set[i]);
        }
        return res;
    }
}
