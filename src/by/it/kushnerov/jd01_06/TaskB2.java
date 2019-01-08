package by.it.kushnerov.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB2 {
    public static void main(String[] args) {
        String reg = "[а-яА-ЯёЁ]+";
        Pattern pattern = Pattern.compile(reg);
        StringBuilder sb = new StringBuilder(Poem.text);
        Matcher matcher = pattern.matcher(sb);
        String[] mas = new String[33];
        mas = Poem.text.split("/n");
        for (String elem : mas){
            String elem1 =  elem.replaceAll("/w","");
            System.out.println(elem1);
        }
    }
}
