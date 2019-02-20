package by.it.moroz.jd01.jd01_12;

import java.util.*;

public class TaskB2 {

    public static void main(String[] args) {
        ArrayList<String> peoples1 = new ArrayList<>();
        peoples1.add("1");
        peoples1.add("2");
        peoples1.add("3");
        peoples1.add("4");
        peoples1.add("5");
        peoples1.add("6");
        peoples1.add("7");

        LinkedList<String> peoples2 = new LinkedList<>();
        peoples2.add("1");
        peoples2.add("2");
        peoples2.add("3");
        peoples2.add("4");
        peoples2.add("5");
        peoples2.add("6");

        System.out.println(process(peoples1));
        System.out.println(process(peoples2));
    }

    private static String process(ArrayList<String> peoples1) {
        int someOne = 0;
        while (peoples1.size() > 1) {
            Iterator<String> iterator = peoples1.iterator();
            if (someOne == 0) {
                iterator.next();
            }
            while (iterator.hasNext()) {
                iterator.next();
                iterator.remove();
                if (iterator.hasNext()) {
                    iterator.next();
                    someOne = 1;
                } else someOne = 0;
            }

        }
        return peoples1.get(0);
    }

    private static String process(LinkedList<String> peoples2) {
        int someOne = 0;
        while (peoples2.size() > 1) {
            ListIterator<String> itr = peoples2.listIterator();
            if (someOne == 0) {
                itr.next();
            }
            while (itr.hasNext()){
                itr.next();
                itr.remove();
                if (itr.hasNext()){
                    itr.next();
                    someOne=1;
                }else someOne=0;
            }
        }
        return peoples2.element();
    }
}


