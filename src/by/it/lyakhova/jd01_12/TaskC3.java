package by.it.lyakhova.jd01_12;

import java.util.*;

public class TaskC3 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();

        s.replaceAll("[ˆ(){}\\[\\]]", "");

        Map<Character, Character> map = new HashMap<>();

        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        Deque<Character> tempLine = new LinkedList<>();

        for(char symb: s.toCharArray()){
            if(symb=='('||symb=='{'||symb=='['){
                tempLine.push(symb);
            }
            else if((!tempLine.isEmpty())&&(tempLine.peek().equals(map.get(symb)))) tempLine.poll();
            else System.out.println("There is a mistake with parentheses");
        }

       if (!tempLine.isEmpty()) System.out.println("There is a mistake with parentheses");
       else System.out.println("All is good");
    }
}
