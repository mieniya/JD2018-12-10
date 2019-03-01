package by.it.moroz.jd01.jd01_11;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Runner {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("One");
        list.add("Two");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");
        list.add("7");
        list.add("8");
        System.out.println(list);
        list.remove("5");
        list.remove(5);
        //list.set(3,"Three");
        System.out.println(list);

        System.out.println("=====================================");

        List<String> list1 = new ListA<>();
        list1.add("One");
        list1.add("Two");
        list1.add("3");
        list1.add("4");
        list1.add("5");
        list1.add("6");
        list1.add("7");
        list1.add("8");
        System.out.println(list1);
        list.remove("5");
        list.remove(5);
        System.out.println(list1);

        System.out.println("=====================================");

        List<String> list2 = new ListB<>();
        list2.add("One");
        list2.add("Two");
        list2.add("3");
        list2.add("4");
        list2.add("5");
        list2.add("6");
        list2.add("7");
        list2.add("8");
        System.out.println(list2);
        //list2.remove(5);
        //System.out.println(list2.get(1));
        list2.set(2, "some");
        //list2.add(1, "1");
        System.out.println(list2);

        System.out.println("=====================================");

        HashSet<String> test = new HashSet<>();
        test.add("1");
        test.add("2");
        test.add("3");
        test.add("4");
        test.add("5");
        test.add("6");
        test.add("7");
        System.out.println(test);

        Set<String> set = new SetC<>();
        test.add("1");
        test.add("2");
        test.add("3");
        test.add("4");
        test.add("5");
        test.add("6");
        test.add("7");
        test.remove("6");

        System.out.println(set);

    }
}
