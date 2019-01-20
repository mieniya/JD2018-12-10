package by.it.zagurskaya.jd01_12;

import java.util.*;

public class TaskC1 {
    public static void main(String[] args) {
        String expression;
        Scanner scanner = new Scanner(System.in);
        TreeMap<String, String> varMap = new TreeMap<>();

        while (!(expression = scanner.nextLine()).equals("end")) {
            varMap.putAll(expressionToWorldMap(expression));
        }
        mapPrint(varMap);

        System.out.println("=================");

        Map<String, String> compressed = getCompressedMap(varMap);
        mapPrint(compressed);
    }

    private static Map<String, String> getCompressedMap(TreeMap<String, String> varMap) {
        Map<String, String> unique = new HashMap<>();
        for (Map.Entry<String, String> e : varMap.descendingMap().entrySet()) {
            unique.put(e.getValue(), e.getKey());
        }
        Map<String, String> result = new HashMap<>();
        for (Map.Entry<String, String> e : unique.entrySet()) {
            result.put(e.getValue(), e.getKey());
        }
        return result;
    }

    public static Map<String, String> expressionToWorldMap(String exp) {
        String uniqueID = UUID.randomUUID().toString();
        Map<String, String> varMap = new HashMap<>();
        varMap.put(uniqueID, exp);
        return varMap;
    }

    public static void mapPrint(Map<String, String> map) {
        for (Map.Entry<String, String> e : map.entrySet()) {
            System.out.println(e.getValue() + "  " + e.getKey());
        }
    }
}
