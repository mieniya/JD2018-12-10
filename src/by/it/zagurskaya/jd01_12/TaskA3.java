package by.it.zagurskaya.jd01_12;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskA3 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Scanner scanner=new Scanner(System.in);
        while (true){
            String input =scanner.next();
            if (input.equals("end"))break;
            Integer value = Integer.valueOf(input);
            int pos=0;
            if (value<0)
                list.add(value);
            else if (value==0)
                list.add(pos, value);
            else list.add(pos++, value);
        }
    }
}
