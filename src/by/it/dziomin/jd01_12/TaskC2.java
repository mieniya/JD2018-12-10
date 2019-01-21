package by.it.dziomin.jd01_12;

import java.util.*;

public class TaskC2 {

    public static void main(String[] args) {

        Number[][] arr = {{(float) 9.4, (float) 9.8, (float) 8, (double) 9, (double) 9, (double) 9, (double) 0, (double) 0},
                {(float) 9.4, (float) 9.8, (float) 6, (float) 9, (float) 7, (float) 7, (float) 8, (float) 0},
                {(int) 9, (long) 9, (double) 4, (short) 9, (short) 9, (double) 0, (byte) 0},
                {(short) 9, (double) 9, (short) 4, (int) 4, (float) 4, (long) 4, (short) 0},
                {(long) 9, (long) 9, (short) 4, (long) 4, (long) 4, (long) 4, (long) 0},
                {(float) 9.4, (double) 9.8, (float) 6, (float) 9, (double) 7, (int) 7, (float) 8, (float) 8, (float) 0, (float) 0}};

        Set[] sets = new HashSet[arr.length];
        for (int i = 0; i < arr.length; i++) {
            sets[i] = new HashSet<>(Arrays.asList(arr[i]));
            System.out.println(sets[i]);
        }

        System.out.println("GetUnion: " + getUnion(sets));
        System.out.println("GetCross: " + getCross(sets));
    }


    private static Set<Double> getUnion(Set<? extends Number>... sets) {
        Set<Double> result = new HashSet<>();
        for (Set<? extends Number> set : sets) {
            for (Number number : set) {
                result.add(number.doubleValue());
            }
        }
        return result;
    }

    private static Set<Double> getCross(Set<? extends Number>... sets) {
        Set<Double> result = new HashSet<>();
        for (Number number : sets[0]) {
            result.add(number.doubleValue());
        }
        for (int i = 1; i < sets.length; i++) {
            Set<Double> temp = new HashSet<>();
            for (Number number : sets[i]) {
                temp.add(number.doubleValue());
            }
            result.retainAll(temp);
        }
        return result;
    }
}
