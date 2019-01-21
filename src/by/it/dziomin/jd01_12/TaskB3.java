package by.it.dziomin.jd01_12;


import java.util.*;

public class TaskB3 extends TaskB2 {
    private final static int COUNT_TO_REMOVE = 2;

    public static void main(String[] args) {

        String[] peoples = new String[4096];
        for (int i = 0; i < 4096; i++) {
            peoples[i] = "people" + i;
        }
        ArrayList<String> arrayPeoples = new ArrayList<>(Arrays.asList(peoples));
        LinkedList<String> linkedPeoples = new LinkedList<>(Arrays.asList(peoples));
        long start = System.nanoTime();
        TaskB3.process(arrayPeoples);
        long end = System.nanoTime();
        System.out.println("time of ArrayList: " + (end - start));
        start = System.nanoTime();
        TaskB3.process(linkedPeoples);
        end = System.nanoTime();
        System.out.println("time of LinkedList: " + (end - start));
    }

    static String process(ArrayList<String> peoples) {
        return getLastAfterRemove(peoples);
    }


    static String process(LinkedList<String> peoples) {
        return getLastAfterRemove(peoples);
    }

    private static String getLastAfterRemove(List<String> peoples) {
        int index = 0;
        while (peoples.size() != 1) {
            Iterator<String> iterator = peoples.iterator();
            while (iterator.hasNext() && peoples.size() != 1) {
                iterator.next();
                if (++index % COUNT_TO_REMOVE == 0) {
                    iterator.remove();
                }
            }
        }
        return peoples.get(0);
    }
}
