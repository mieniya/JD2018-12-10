package by.it.dziomin.jd01_11;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Runner {
    public static void main(String[] args) {
        List<String> a = new ArrayList<>();
        a.add("one");
        a.add("2");
        a.add("three");
        System.out.print(a);
        System.out.println("  size: " + a.size());
        a.remove(0);
        System.out.print(a);
        System.out.println(" А size: " + a.size());
        //--------------------------------

        List<String> b = new ListB<>();
        b.add("one");
        b.add("2");
        b.add("3");
        System.out.print(b);
        System.out.println("  size: " + b.size());
        b.remove(0);
        System.out.print(b);
        System.out.println("  size: " + b.size());
        b.set(0,"5");
        System.out.print(b);
        System.out.println("  size: " + b.size());
        b.add(1,null);
        System.out.print(b);
        System.out.println("  size: " + b.size());
        b.addAll(b);
        System.out.print(b);
        System.out.println("  size: " + b.size());


        //----------SET-----------------

        Set<String> c1 = new HashSet<>();
        c1.add("one");
        c1.add("two");
        c1.add("one");
        System.out.println(c1);


        Set<String> c2 = new SetC<>();
        c2.add("one");
        c2.add("two");
        c2.add("one");
        System.out.println(c2);
    }
}
