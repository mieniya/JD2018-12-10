package by.it.yarmolenka.jd01_11;

import java.util.*;

public class Runner {
    public static void main(String[] args) {
        Set<String> s = new HashSet<>();
        s.add("1");
        s.add("2");
        s.add("3");
        s.add("4");
        s.add("5");
        s.add("6");
        s.add("7");
        s.add("8");
        System.out.println(s);
        Set<String> ss = new SetC<>();
        ss.add("1");
        ss.add("23");
        ss.add("4");
        System.out.println(ss);
        ss.addAll(s);
        System.out.println(ss);
    }
}
