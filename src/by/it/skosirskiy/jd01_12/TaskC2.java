package by.it.skosirskiy.jd01_12;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class TaskC2 {
    private static <T extends Number> Set<T> getUnion(Set<T> ...set){
        Set<T> result =new HashSet<>(set[0]);
        for (Set<T> element : set) {
            result.addAll(element);
            }
        return result;
    }

    private static <T extends Number> Set<T> getCross(Set<T> ...set){
        Set<T> result =new HashSet<>(set[0]);
        for (Set<T> element : set) {
            result.retainAll(element);
        }
        return result;
    }
    public static void main(String[] args) {
        TreeSet<Integer> treeSet=new TreeSet<>(Arrays.asList(1,1,2,2,3,3,3,4,4,5,5,6,6));
        HashSet<Integer>hashSet= new HashSet<>(Arrays.asList(4,4,5,5,6,6,7,7,8,8));
        TreeSet<Double> treeSet1=new TreeSet<>(Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0));
        HashSet<Double>hashSet1= new HashSet<>(Arrays.asList(4.0, 5.0, 6.0, 7.0, 8.0));
        TreeSet<Float> treeSet2=new TreeSet<>(Arrays.asList(1.0f, 2.0f, 3.0f, 4.0f, 5.0f));
        HashSet<Float>hashSet2= new HashSet<>(Arrays.asList(4.0f, 5.0f, 6.0f, 7.0f, 8.0f));
        System.out.println(getUnion(treeSet,hashSet ));
        System.out.println(getCross(treeSet,hashSet ));

        System.out.println(getUnion(treeSet1,hashSet1 ));
        System.out.println(getCross(treeSet1,hashSet1 ));

        System.out.println(getUnion(treeSet2,hashSet2 ));
        System.out.println(getCross(treeSet2,hashSet2 ));





    }

}
