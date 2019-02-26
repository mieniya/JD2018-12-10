package by.it.moroz.jd01.jd01_12;

import java.util.ArrayDeque;
import java.util.Scanner;

public class TaskC3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        System.out.println(validate(text));
    }


    private static boolean validate(String input) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (char c : input.toCharArray()) {
            if("]})".indexOf(c)!=-1 && stack.isEmpty()) {
                return false;
            }
            if ("({[".indexOf(c)!=-1) {
                stack.addFirst(c);
            }
            if ("]})".indexOf(c)!=-1) {
                if(stack.getFirst()=='(' && c==')' || stack.getFirst()=='{' && c=='}' || stack.getFirst()=='[' && c==']'){
                    stack.removeFirst();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
