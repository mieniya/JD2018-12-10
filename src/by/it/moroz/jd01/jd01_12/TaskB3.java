package by.it.moroz.jd01.jd01_12;

import java.util.*;

public class TaskB3 {

    public static void main(String[] args) {
        Timer timer = new Timer();
        ArrayList<String> elem1 = new ArrayList<>();
        LinkedList<String> elem2 = new LinkedList<>();
        for (int i = 1; i < 4096; i++) {
            elem1.add("n"+i);
            elem2.add("n"+i);
        }
        System.out.println(process(elem1)+" "+timer);
        System.out.println(process(elem2)+" "+timer);
    }

    private static String process(ArrayList<String> elem) {
        int someOne = 0;
        while (elem.size() > 1) {
            Iterator<String> iterator = elem.iterator();
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
        return elem.get(0);
    }

    private static String process(LinkedList<String> elem) {
        int someOne = 0;
        while (elem.size() > 1) {
            ListIterator<String> itr = elem.listIterator();
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
        return elem.element();
    }
}
