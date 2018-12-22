package by.it.agadzhanov.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC1 {
    public static void main(String[] args) {
        StringBuilder sb=new StringBuilder(Poem.text);
        Pattern newline=Pattern.compile("\n");
        Matcher matcherNewline=newline.matcher(sb);

        while (matcherNewline.find()) {
            System.out.println(matcherNewline.group());
        }
    }
}
