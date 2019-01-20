package by.it.zagurskaya.jd01_12;

import java.util.*;

public class TaskB2 {
    public static void main(String[] args) {
        String resultList;
        String resultArrayList;
        String resultLinkedList;
        Scanner scanner = new Scanner(System.in);
        String nameString = scanner.nextLine();

        System.out.println(scanPeopleArrayList(nameString));
        resultArrayList = process(scanPeopleArrayList(nameString));
        System.out.println("результат ArrayList " + resultArrayList);
        System.out.println();

        System.out.println(scanPeopleLinkedList(nameString));
        resultLinkedList = process(scanPeopleLinkedList(nameString));
        System.out.println("результат LinkedList " + resultLinkedList);

    }

    public static ArrayList<String> scanPeopleArrayList(String nameString) {
        ArrayList<String> nameList = new ArrayList<>();
        String regAllWord = " ";
        nameList.addAll(Arrays.asList(nameString.split(regAllWord)));
        return nameList;
    }

    public static LinkedList<String> scanPeopleLinkedList(String nameString) {
        LinkedList<String> nameList = new LinkedList<>();
        String regAllWord = " ";
        nameList.addAll(Arrays.asList(nameString.split(regAllWord)));
        return nameList;
    }

    static String process(ArrayList<String> peoples) {
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
}
