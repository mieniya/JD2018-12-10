package by.it.moroz.jd01.jd01_12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class TaskA3 {

    public static void main(String[] args) throws IOException {
        List<Integer> numbers = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int pos =0;
        while (true){
            String s = reader.readLine();
            if(s.equals("end")) break;
            Integer number = Integer.parseInt(s);
            if(number<0) numbers.add(number);
            else if(number==0) numbers.add(pos, number);
            else numbers.add(pos++, number);

        }
        System.out.println(numbers);
    }
}
