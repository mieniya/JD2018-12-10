package by.it.subach.jd01_12;

import java.util.*;

public class TackC1 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        TreeMap<Integer, String> mapTree = new TreeMap<>();
        Random random = new Random();

        while (true) {
            String name = scanner.next();
            if (name.equals("end")) break;
            else {
                name = name.replaceAll("[,]", "");
                mapTree.put(random.nextInt(99), name);
            }
        }

        for (Map.Entry entry : mapTree.entrySet()) {
            System.out.println(entry);
        }

        System.out.println();
        HashMap<String, Integer> mapHash = new HashMap<>();
        for (Map.Entry<Integer, String> entry : mapTree.entrySet()) {
            mapHash.putIfAbsent(entry.getValue(), entry.getKey());
        }

        for (Map.Entry entry : mapHash.entrySet()) {
            System.out.println(entry);
        }

        System.out.println();

        mapTree = new TreeMap<>();
        for (Map.Entry<String, Integer> entry : mapHash.entrySet()) {
            mapTree.put(entry.getValue(), entry.getKey());
        }

        for (Map.Entry<Integer, String> entry : mapTree.entrySet()) {
            System.out.println(entry);
        }

    }
}
