package by.it.zagurskaya.jd01_12;

import java.util.*;

public class TaskB1 {
    public static void main(String[] args) {
        String expression;
        String regAllWord = " ";
        Scanner scanner = new Scanner(System.in);

        List<String> wordList = new ArrayList<>();
        while (!(expression = scanner.nextLine()).equals("end")) {
            expression = expression.replaceAll("[\\n,:;.]", " ");
            expression = expression.replaceAll("\\s[\\s]+", " ");
            wordList.addAll(Arrays.asList(expression.split(regAllWord)));
        }

        Map<String, Integer> varMap = new HashMap<>();
        for (String wordString : wordList) {
            if (varMap.containsKey(wordString)) {
                Integer count = varMap.get(wordString) + 1;
                varMap.put(wordString, count);
            } else {
                varMap.put(wordString, 1);
            }
        }
        mapPrint(varMap);
    }

    public static void mapPrint(Map<String, Integer> map) {
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            System.out.println(e.getKey() + "=" + e.getValue());
        }
    }
}

