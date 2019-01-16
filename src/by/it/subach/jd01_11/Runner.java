package by.it.subach.jd01_11;

import java.util.ArrayList;
import java.util.List;

public class Runner {

    public static void main(String[] args) {
        List<String> b = new ArrayList<>();
        b.add("one");
        b.add("two");
        b.add("three");

        System.out.println(b);
        b.remove(1);

        System.out.println(b.size());
        b.remove("one");
        System.out.println(b);
        System.out.println("-------------------------------------------------------");

        List<String> a = new ListB<>();
        a.add("one");
        a.add("two");
        a.add("three");

        System.out.println(a);
        a.remove(1);

        System.out.println(a.size());
        a.remove("one");
        System.out.println(a);
        a.add(null);
        a.add("4");
        a.add("5");
        a.add("6");
        System.out.println(a);
        System.out.println(a.size());
        a.add(0, "neshta");
        System.out.println(a);
        System.out.println(a.size());



    }
}
