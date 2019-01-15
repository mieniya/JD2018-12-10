package by.it.kushnerov.jd01_11;

import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        List<String> a = new ArrayList<>();
        a.add("One");
        a.add("two");
        a.add("3");
        a.add("4");
        a.add("5");
        a.add("6");
        a.add("7");
        System.out.println(a);
        a.remove("5");
        a.remove(5);
        System.out.println(a);

        List<String> b = new ListA<>();
        b.add("One");
        b.add("two");
        b.add("3");
        b.add("4");
        b.add("5");
        b.add("6");
        b.add("7");
        System.out.println(b);
        b.remove("5");
        b.remove(5);
        System.out.println(b);
    }
}
