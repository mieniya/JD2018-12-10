package by.it.subach.jd01_12;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class TaskC2 {

    public static void main(String[] args) {
        Integer [] arr1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Long [] arr2 = {2L, 4L, 6L, 8L, 10L, 12L};
        Double [] arr3 = {1.0, 2.0, 3.0, 5.0, 15.0};
        Float [] arr4 = {2f, 3f, 5f, 17f};
        Byte [] arr5 = {4, 9, 12, 8};

        Set<Integer> set1 = new HashSet<>(Arrays.asList(arr1));
        Set<Long> set2 = new HashSet<>(Arrays.asList(arr2));
        Set<Double> set3 = new HashSet<>(Arrays.asList(arr3));
        Set<Float> set4 = new HashSet<>(Arrays.asList(arr4));
        Set<Byte> set5 = new HashSet<>(Arrays.asList(arr5));

        System.out.println(set1);
        System.out.println(set2);
        System.out.println(set3);
        System.out.println(set4);
        System.out.println(set5);

        System.out.println();

        System.out.println("getCross result: " + getCross(set1, set2, set5)); //4.0, 8.0
        System.out.println();
        System.out.println("getUnion result: " + getUnion(set1, set2, set3, set5));

    }

    private static Set<?> getCross (Set<?>... sets){
        Set<Double> result = new TreeSet<>(toDouble(sets[0]));

        for(Set<?> set : sets ){
            Set<Double> d = toDouble(set);
            result.retainAll(d);
        }

        return result;
    }

    private static Set<?> getUnion (Set<?>... sets){
        Set<Double>result = new TreeSet<>();

        for(Set<?> set : sets){
            Set<Double> d = toDouble(set);
            result.addAll(d);
        }
        return result;
    }

    private static Set<Double> toDouble (Set<?> set){
        Set<Double> result = new HashSet<>();
        for(Object ob: set){
            result.add(Double.parseDouble(ob.toString()));
        }

        return result;
    }


}
