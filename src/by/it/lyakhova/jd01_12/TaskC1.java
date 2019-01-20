package by.it.lyakhova.jd01_12;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class TaskC1 {

    public static void main(String[] args) {

        Map<Integer, String> table = new HashMap<>();

        Scanner scanner = new Scanner(System.in);
        String input;
        while (!"end".equalsIgnoreCase(input = scanner.next())) {
            Integer key = (int) (Math.random() * 1000);
            while (table.containsKey(key)) {
                key = (int) (Math.random() * 1000);
            }
            table.put(key, input);
        }

        System.out.println(table);

        Map<String, Integer> sortTable = new TreeMap<>();
        for (Map.Entry<Integer, String> entry :
                table.entrySet()) {
            sortTable.put(entry.getValue(), entry.getKey());
        }

        System.out.println(sortTable);
    }
}
