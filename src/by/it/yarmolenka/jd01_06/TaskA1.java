package by.it.yarmolenka.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA1 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder(Poem.text);
        Pattern p1 = Pattern.compile("[А-Яа-яЁё]{4,}");
        Matcher m1 = p1.matcher(sb);
        while (m1.find()){
            int position = m1.start()+3;
            sb.setCharAt(position,'#');
            if (m1.end()-m1.start()>=7){
                int pos = m1.start()+6;
                sb.setCharAt(pos,'#');
            }
        }
        System.out.println(sb);
    }
}
