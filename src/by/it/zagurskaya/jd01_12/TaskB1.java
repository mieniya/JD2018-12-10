package by.it.zagurskaya.jd01_12;

import java.util.HashMap;
import java.util.Scanner;

public class TaskB1 {
    public static void main(String[] args) {

        String expression;
        String regAllWord = " ";
        Scanner scanner = new Scanner(System.in);

        while (!(expression = scanner.nextLine()).equals("end")) {
            expression = expression.replaceAll("[\\n,:.-]", " ");
            expression = expression.replaceAll("  ", " ");
            String[] expressionMass = expression.split(regAllWord);

//            for (String s : expressionMass) {
//                System.out.printf(s+" ");
//            }
            HashMap<String, Integer> wordCount = new HashMap<String, Integer>();
            for (int i = 0; i < expression.length(); i++) {
                System.out.println(expressionMass[i]);
//                Map<String, Integer> varMap = Integer.getVars();
//                for (wordCount.Entry<String, Integer> varEntry : wordCount.entrySet()) {
////                System.out.print(varEntry.getKey() + "=");
//                System.out.println((varEntry.getValue()));
            }
        }
    }
}

