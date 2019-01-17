package by.it.naron.jd01_12;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class TaskA2 {
    public static void main(String[] args) {
        Integer masA[] = {1, 2, 3, 4, 5, 6};
        Integer masB[] = { 4, 5, 6,7,8,9};
        Set<Integer> a = new HashSet<>(Arrays.asList(masA));
        Set <Integer> b = new TreeSet<>(Arrays.asList(masB));
        System.out.println("Set - a:"+a);
        System.out.println("Set - b:"+b);
//        System.out.println("Cross Set-a and Set-b:"+getCross(a,b));
//        System.out.println("Union Set-a and Set-b:"+getUnion(a,b));
        Set<Integer> union = getUnion(a,b);
        System.out.println(union);
        Set<Integer> cross = getCross(a,b);
        System.out.println(cross);
    }
    private static Set<Integer> getUnion(Set<Integer> firstA, Set<Integer> secondB){
        Set <Integer> res = new HashSet<>(firstA);
        res.addAll(secondB);
        return res;
    }
    private static Set<Integer> getCross(Set<Integer>a, Set<Integer>b){
        Set <Integer> res = new HashSet<>(a);
        res.retainAll(b);
        return res;
    }


}
