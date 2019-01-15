package by.it.subach.jd01_11;

import java.util.*;

public class Runner {

    public static void main(String[] args) {
//        List<String> b = new ArrayList<>();
//        b.add("one");
//        b.add("two");
//        b.add("three");
//
//        System.out.println(b);
//        b.remove(1);
//
//        System.out.println(b.size());
//        b.remove("one");
//        System.out.println(b);
//        System.out.println("-------------------------------------------------------");
//
//        List<String> a = new ListB<>();
//        a.add("one");
//        a.add("two");
//        a.add("three");
//
//        System.out.println(a);
//        a.remove(1);
//
//        System.out.println(a.size());
//        a.remove("one");
//        System.out.println(a);
//        a.add(null);
//        a.add("4");
//        a.add("5");
//        a.add("6");
//        System.out.println(a);
//        System.out.println(a.size());
//        a.add(0, "neshta");
//        System.out.println(a);
//        System.out.println(a.size());

        HashSet<String> hash = new HashSet();
        hash.add("one");
        hash.add("two");
        hash.add("three");
        System.out.println(hash.size());
        System.out.println(hash.toString());

        SetC<String> test = new SetC<>();
        test.add("one");
        test.add("two");
        test.add("three");
        test.add("three");
        test.add("four");
        test.add("five");

        SetC<Integer> test2 = new SetC<>();
        test2.add(2);
        test2.add(3);
        test2.add(4);
        test2.add(2);

        System.out.println(test.toString());
        System.out.println(test.size());

        System.out.println(test2.toString());
    }
}
