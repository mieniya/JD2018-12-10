package by.it.skosirskiy.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB2 {
    public static void main(String[] args) {

        String str=Poem.text;

        str = str.replaceAll("\\p{Punct}", " ");
        str = str.trim();
        int count=0;


        Pattern pattern = Pattern.compile("[а-яА-яёЁ]{4,}");
        Matcher matcher = pattern.matcher(str);





        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i)=='\n'){
                count++;
            }
        }
        System.out.println(count);

    }
}
