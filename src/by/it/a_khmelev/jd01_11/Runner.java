package by.it.a_khmelev.jd01_11;

import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        List<String> a=new ArrayList<>();
        a.add("One"); //0
        a.add("Two"); //1
        a.add("3"); //2
        a.add("4"); //3
        a.add("5Object"); //4
        a.add("6"); //5
        a.add("7");
        a.add("8");
        System.out.println(a);
        a.remove("5Object");
        a.remove(5);
        System.out.println(a);
        System.out.println("===================================");
        List<String> b=new ListA<>();
        b.add("One"); //0
        b.add("Two"); //1
        b.add("3"); //2
        b.add("4"); //3
        b.add("5Object"); //4
        b.add("6"); //5
        b.add("7");
        b.add("8");
        System.out.println(b);
        b.remove("5Object");
        b.remove(5);
        System.out.println(b);
    }
}
