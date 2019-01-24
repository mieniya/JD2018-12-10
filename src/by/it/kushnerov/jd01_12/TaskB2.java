package by.it.kushnerov.jd01_12;

import java.lang.reflect.Array;
import java.util.*;

public class TaskB2 {
    public static void main(String[] args) {
    String list = "1,2,3,4,5,6,7,8,9";
    String[] mas = list.split(",");
    ArrayList<String> l1 = new ArrayList<>(Arrays.asList(mas));
    LinkedList<String> l2 = new LinkedList<>(Arrays.asList(mas));
    process(l1);
    process(l2);
    }

    static String process(ArrayList<String> peoples) {
        List<String> killArray = new ArrayList<>(peoples);
        boolean last = true;
        int count = killArray.size();
        while (killArray.size() != 1) {
            Iterator<String> iter = killArray.iterator();
            if (killArray.size() == count || last == false) {
                iter.next();
            }
            while (iter.hasNext()) {
                iter.next();
                iter.remove();
                if (iter.hasNext()) {
                    iter.next();
                    last = true;
                } else last = false;
            }

        }
        return killArray.get(0);

    }

    static String process(LinkedList<String> peoples) {
        List<String> killArray = new LinkedList<>(peoples);
        boolean last = true;
        int count = killArray.size();
        while (killArray.size() != 1) {
            Iterator<String> iter = killArray.iterator();
            if (killArray.size() == count || last == false) {
                iter.next();
            }
            while (iter.hasNext()) {
                iter.next();
                iter.remove();
                if (iter.hasNext()) {
                    iter.next();
                    last = true;
                } else last = false;
            }

        }
        return killArray.get(0);

    }

}
