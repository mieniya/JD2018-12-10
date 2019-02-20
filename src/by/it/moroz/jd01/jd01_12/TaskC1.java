package by.it.moroz.jd01.jd01_12;

import java.util.*;

public class TaskC1 {
    public static void main(String[] args) {
        Map<Integer, String> c1 = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String input = scanner.next();
            if (input.equals("end")) break;
            int random = (int) (Math.random() * Integer.MAX_VALUE);
            while (c1.containsKey(random)) {
                random = (int) (Math.random() * Integer.MAX_VALUE);
            }
            c1.put(random, input);
        }
        System.out.println("Карта до удаления");
        for (Map.Entry<Integer, String> pair : c1.entrySet()) {
            System.out.println(pair.getKey() + " " + pair.getValue());
        }
        System.out.println();
        HashMap<Integer, String> withoutDuplicates = removeDuplicates(c1);
        System.out.println("Карта после удаления");
        for (Map.Entry<Integer, String> pair : withoutDuplicates.entrySet()) {
            System.out.println(pair.getKey() + " " + pair.getValue());
        }

    }

    private static HashMap<Integer, String> removeDuplicates(Map<Integer, String> map) {
        HashMap<Integer, String> withoutDuplicates = new HashMap<>();
        for (Map.Entry<Integer, String> pair : map.entrySet()) {
            String word = pair.getValue();
            if (!withoutDuplicates.containsValue(word))
                withoutDuplicates.put(pair.getKey(), pair.getValue());

        }
        return withoutDuplicates;
    }

}
