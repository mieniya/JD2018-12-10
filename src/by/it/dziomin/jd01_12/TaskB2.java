package by.it.dziomin.jd01_12;

import java.util.*;

public class TaskB2 {

    private final static int COUNT_TO_REMOVE = 2;


    public static void main(String[] args) {
        String[] peoples = {null, "www", "eee", "eee2", "eee3", "eee4", "eee5", "eee6"};
        ArrayList<String> arrayPeoples = new ArrayList<>(Arrays.asList(peoples));
        LinkedList<String> linkedPeoples = new LinkedList<>(Arrays.asList(peoples));
        System.out.println(arrayPeoples);
        TaskB2.process(arrayPeoples);
        System.out.println(arrayPeoples);
        TaskB2.process(linkedPeoples);
        System.out.println(linkedPeoples);
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

//    static void remove(){
//
//    }

}
