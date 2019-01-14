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

        List<String> a = new ListA<>();
        a.add("one");
        a.add("two");
        a.add("three");

        System.out.println(a);
        a.remove(1);

        System.out.println(a.size());
        a.remove("one");
        System.out.println(a);


    }
}
