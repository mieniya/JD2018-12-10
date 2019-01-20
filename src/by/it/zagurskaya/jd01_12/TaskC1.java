package by.it.zagurskaya.jd01_12;

import java.util.*;

public class TaskC1 {
    public static void main(String[] args) {
        String expression;
        Scanner scanner = new Scanner(System.in);
        List<String> wordList = new ArrayList<>();
        Map<String, Integer> varMap = new HashMap<>();

        while (!(expression = scanner.nextLine()).equals("end")) {
            expressionToWorldMap(expression, wordList);
        }
//         mapPrint(countIterationWord(wordList));
    }

    public static void expressionToWorldMap(String exp, List<String> wordList) {
        String regAllWord = " ";
        Scanner scanner = new Scanner(System.in);
        String uniqueID = UUID.randomUUID().toString();
        Map<String, String> varMap = new HashMap<>();

        exp = exp.replaceAll("[\\n,:;.]", " ");
        exp = exp.replaceAll("\\s[\\s]+", " ");

        for (Map.Entry<String, String> entry : varMap.entrySet()) {
            varMap.put(exp.split(regAllWord).toString(), uniqueID);
//            String key = entry.getKey();    // получение ключа
//            Integer value = entry.getValue();    // получение значения
            //wordList.addAll(Arrays.asList(exp.split(regAllWord)));

        }
        mapPrint(varMap);
    }
    public static void mapPrint(Map<String, String> map) {
        for (Map.Entry<String, String> e : map.entrySet()) {
            System.out.println(e.getKey() + "  " + e.getValue());
        }
    }
}
