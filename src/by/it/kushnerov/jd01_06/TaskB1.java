package by.it.kushnerov.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {

    private static char[] vowels = {'а','о','и','е','ё','э','ы','у','ю','я','А','О','И','Е','Ё','Э','Ы','У','Ю','Я'};

    public static void main(String[] args) {
        String reg = "[а-яА-ЯёЁ]+";
        Pattern pattern = Pattern.compile(reg);
        StringBuilder sb = new StringBuilder(Poem.text);
        Matcher matcher = pattern.matcher(sb);
        while (matcher.find()) {
            if (matcher.group().length()>1){
                if (check(matcher.group())){
                    System.out.println(matcher.group());
                }
            }
        }
    }

    private static boolean check(String str){
        char firstChar = str.charAt(0);
        char lastChar = str.charAt(str.length()-1);
        boolean cond1 = true;
        boolean cond2 = false;
            for (char elem : vowels){
                if (firstChar == elem){
                    cond1 = false;
                }
            }
            for (char elem:vowels){
                if (lastChar == elem )
                cond2 = true;
            }
        return cond1 && cond2;
    }
}
