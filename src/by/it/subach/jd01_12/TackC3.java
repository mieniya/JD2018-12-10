package by.it.subach.jd01_12;

import java.util.*;

public class TackC3 {

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String line = scanner.nextLine();
//
//        System.out.println(checkBracket(line));
        String test1 = "{{[][]()()}()}[]()"; //true
        String test2 = "{{[][]()()}}()}[]()"; //false


        System.out.println(checkBracket(test1));

        System.out.println(checkBracket(test2));
    }

    private static boolean checkBracket(String str){
        str = str.replaceAll("[^(){}\\[\\]]", "");
        char[] arr = str.toCharArray();
        Deque<Character> open = new ArrayDeque<>();
        Deque<Character> close = new ArrayDeque<>();
        for (char c : arr) {
            if(c == '[' || c == '{' || c == '('){
                open.add(c);
            }
            if(c == ']' || c == '}' || c == ')') {
                close.add(c);
            }

            if((open.size() >0 && close.size() > 0) && open.getLast() == '[' && close.getLast() == ']'){
                open.removeLast();
                close.removeLast();
            }

            if((open.size() >0 && close.size() > 0) && open.getLast() == '{' && close.getLast() == '}'){
                open.removeLast();
                close.removeLast();
            }
            if((open.size() >0 && close.size() > 0) && open.getLast() == '(' && close.getLast() == ')'){
                open.removeLast();
                close.removeLast();
            }

        }

        return (open.size() == 0 && close.size()==0);
    }
}
