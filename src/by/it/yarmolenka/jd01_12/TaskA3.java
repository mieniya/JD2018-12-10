package by.it.yarmolenka.jd01_12;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskA3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        List<String> st = new ArrayList<>();
        int index = 0;
        String s;
        while (sc.hasNext() && !(s = sc.next()).equals("end")) {
            st.add(s);
            Integer num = Integer.valueOf(s);
            if (num < 0) list.add(num);
            else if (num == 0) list.add(index, num);
            else list.add(index++, num);
        }
        System.out.println(list);
        System.out.println(st);
    }
}
