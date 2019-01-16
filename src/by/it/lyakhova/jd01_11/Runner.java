package by.it.lyakhova.jd01_11;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Runner {
    public static <bolean> void main(String[] args) {
        List<String> a = new ArrayList<>();
        a.add("1");
        a.add("2");
        a.add("3");
        a.add("4");
        a.add("5Object");
        a.add("6");
        a.add("7");
        a.add("8");
        System.out.println(a);

        a.remove("5Object");
        a.remove(5);

        System.out.println(a);

        System.out.println("=====================================");


        List<String> b = new ListA<>();
        b.add("1");
        b.add("2");
        b.add("3");
        b.add("4");
        b.add("5Object");
        b.add("6");
        b.add("7");
        b.add("8");
        System.out.println(b);

        b.remove("5Object");
        b.remove(5);

        System.out.println(b);


        List<String> c = new ListB<>();
        c.add("1");
        c.add("2");
        c.add("3");
        c.add("4");
        c.add("5Object");
        c.add("6");
        c.add("7");
        c.add("8");
        System.out.println(c);

        c.remove("5Object");
        c.remove(5);
        c.add(0,"null");
        boolean k = c.contains("null");


        System.out.println(c);
        System.out.println(k);


        HashSet hs = new HashSet();
        hs.add(1);
        hs.add(2);
        hs.add("object");
        System.out.println(hs);

        hs.remove(1);
        System.out.println(hs);

        Set<Short> h = new SetC<>();
        for (int i = 0; i < 10; i++) {
            h.add((short) (i*2));

        }
        System.out.println(h);

        h.remove(0);
        h.remove(4);
        h.remove(8);

        System.out.println(h);

        List<Short> added = new ArrayList<>();
        added.add(null);
        added.add(null);
        added.add((short) 1000);
        added.add((short) 1000);
        added.add((short) 1001);
        added.add((short) 1002);

        h.addAll(added);
        System.out.println(h);
        System.out.println(h.size());









    }
}
