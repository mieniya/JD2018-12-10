package by.it.zagurskaya.jd01_12;

import java.util.*;

public class TaskB3 {
    public static void main(String[] args) {
        String resultArrayList;
        String resultLinkedList;
        String resultQueque;

//        System.out.println(scanPeopleLinkedList());
//        System.out.println();
        Timer t = new Timer();
        System.out.println(scanPeopleArrayList());
        System.out.println("Удаление элементов из ArrayList." + t);
        resultArrayList = process(scanPeopleArrayList());
        System.out.println();
        System.out.println(scanPeopleLinkedList());
        System.out.println("Удаление элементов из LinkedList." + t);
        resultLinkedList = process(scanPeopleLinkedList());
//        System.out.println();
//        System.out.println(scanPeopleQueque());
//        System.out.println("Удаление элементов из Queque." + t);
//        resultQueque = process(scanPeopleQueque());
//        System.out.println();

        System.out.println("результат ArrayList " + resultArrayList);
        System.out.println();

        System.out.println("результат LinkedList " + resultLinkedList);
        System.out.println();

//        System.out.println("результат Queque " + resultQueque);
        System.out.println();
    }

    public static ArrayList<String> scanPeopleArrayList() {
        ArrayList<String> numberList = new ArrayList<>();
        Integer number;
        for (int i = 0; i < 4096; i++) {
            number = i;
            numberList.add(number.toString());
        }
        return numberList;
    }

    public static LinkedList<String> scanPeopleLinkedList() {
        LinkedList<String> numberList = new LinkedList<>();
        Integer number;
        for (int i = 0; i < 4096; i++) {
            number = i;
            numberList.add(number.toString());
        }
        return numberList;
    }

    public static Queue<String> scanPeopleQueque() {
        Deque<String> numberList = new LinkedList<>();
        Integer number;
        for (int i = 0; i < 4096; i++) {
            number = i;
            numberList.offer(number.toString());
        }
        return numberList;
    }

    static String processOld(ArrayList<String> peoples) {
        int i = 0;
        boolean removePeople = false;
        while (peoples.size() != 1) {
            if (removePeople == true) {
                peoples.remove(i);
            } else {
                i++;
            }
            removePeople = !removePeople;
            if (i == peoples.size()) i = 0;
        }
        return peoples.get(0);
    }

    static String process(ArrayList<String> peoples) {
        boolean removePeople = false;
        Iterator<String> stringIterator = peoples.iterator();
        while (peoples.size() != 1) {
            if (removePeople) {
                stringIterator.next();
                stringIterator.remove();
            } else {
                stringIterator.next();
            }
            removePeople = !removePeople;
            if (!stringIterator.hasNext()) {
                stringIterator = peoples.iterator();
            }
        }
        return peoples.get(0);
    }

    static String processOld(LinkedList<String> peoples) {
        int i = 0;
        boolean removePeople = false;
        while (peoples.size() != 1) {
            if (removePeople == true) {
                peoples.remove(i);
            } else {
                i++;
            }
            removePeople = !removePeople;
            if (i == peoples.size()) i = 0;
        }
        return peoples.get(0);
    }

    static String process(LinkedList<String> peoples) {
        boolean removePeople = false;
        Iterator<String> stringIterator = peoples.iterator();
        while (peoples.size() != 1) {
            if (removePeople) {
                stringIterator.next();
                stringIterator.remove();
            } else {
                stringIterator.next();
            }
            removePeople = !removePeople;
            if (!stringIterator.hasNext()) {
                stringIterator = peoples.iterator();
            }
        }
        return peoples.get(0);
    }

    static String process(Queue<String> peoples) {
        int i = 0;
        boolean removePeople = false;
        while (peoples.size() != 1) {
            if (removePeople == true) {
                peoples.poll();
            } else {
                i++;
            }
            removePeople = !removePeople;
            //if (i == peoples.size()) i = 0;
        }
        return peoples.toString();
    }

    public static class Timer {
        private long iniTime;
        private Double delta;

        public Timer() {
            iniTime = System.nanoTime();
        }

        public String toString() {
            delta = (double) (System.nanoTime() - iniTime) / 1000;
            iniTime = System.nanoTime();
            return "Прошло " + delta.toString() + " микросекунд";
        }
    }
}
