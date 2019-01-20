package by.it.yarmolenka.jd01_12;

import java.util.*;

public class TaskB2 {
    public static void main(String[] args) {
        int n = 10;
        ArrayList<String> list1 = new ArrayList<>();
        LinkedList<String> list2 = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            list1.add(String.valueOf(i));
            list2.add(String.valueOf(i));
        }
        System.out.println(list1);
        String process = process(list1);
        String process1 = process(list2);
        System.out.println(process);
        System.out.println(process1);
    }

    private static String process(ArrayList<String> peoples) {
        int m = 2;
        Iterator<String> iterator = peoples.iterator();
        while (peoples.size() != 1) {
            for (int i = 0; i < m; i++) {
                if (iterator.hasNext()) iterator.next();
                else return process(peoples, i);
            }
            iterator.remove();
        }
        return peoples.get(0);
    }

    private static String process(ArrayList<String> peoples, int k) {
        int m = 2;
        Iterator<String> iterator = peoples.iterator();
        for (int i = k; i < m; i++)
            if (iterator.hasNext()) iterator.next();
            else return process(peoples, i);
        iterator.remove();
        while (peoples.size() != 1) {
            for (int i = 0; i < m; i++) {
                if (iterator.hasNext()) iterator.next();
                else return process(peoples, i);
            }
            iterator.remove();
        }
        return peoples.get(0);
    }

    private static String process(LinkedList<String> peoples) {
        Iterator<String> iterator = peoples.iterator();
        while (peoples.size() != 1) {
            for (int i = 0; i < 2; i++) {
                if (iterator.hasNext()) iterator.next();
                else return process(peoples, i);
            }
            iterator.remove();
        }
        return peoples.get(0);
    }

    private static String process(LinkedList<String> peoples, int k) {
        Iterator<String> iterator = peoples.iterator();
        for (int i = k; i < 2; i++)
            if (iterator.hasNext()) iterator.next();
            else return process(peoples, i);
        iterator.remove();
        while (peoples.size() != 1) {
            for (int i = 0; i < 2; i++) {
                if (iterator.hasNext()) iterator.next();
                else return process(peoples, i);
            }
            iterator.remove();
        }
        return peoples.get(0);
    }
}
