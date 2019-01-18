package by.it.yarmolenka.jd01_12;

import java.util.*;

public class TaskC3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        if (checkChar(line)) System.out.println("Введённое выражение корректно");
        else System.out.println("Введённое выражение НЕ корректно");
    }

    private static boolean checkChar(String s){
        char[] chars = s.toCharArray();
        LinkedList<Character> list = new LinkedList<>();
        for (char aChar : chars) {
            switch (aChar) {
                case '(': list.offerFirst(aChar); continue;
                case '{': list.offerFirst(aChar); continue;
                case '[': list.offerFirst(aChar); continue;
                case ')': if (list.isEmpty()) return false;
                else {
                    Character t = list.pollFirst();
                    if (t == null) return false;
                    if (!t.equals('(')) return false;
                } continue;
                case '}': if (list.isEmpty()) return false;
                else {
                    Character t = list.pollFirst();
                    if (t == null) return false;
                    if (!t.equals('{')) return false;
                } continue;
                case ']': if (list.isEmpty()) return false;
                else {
                    Character t = list.pollFirst();
                    if (t == null) return false;
                    if (!t.equals('[')) return false;
                }
            }
        }
        return true;
    }
}
