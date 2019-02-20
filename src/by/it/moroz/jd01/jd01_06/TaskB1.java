package by.it.moroz.jd01.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {

    public static void main(String[] args) {

        String text = Poem.text;
        String[] wordArray = text.split("[\\s,.:!?]+");
        Pattern pattern = Pattern.compile("^[^АОЭИУЕЁЮЯаоэиуыеёюя].*[аоэиуыеёюя]$");
        for (String word : wordArray) {
            Matcher matcher = pattern.matcher(word);
            if (matcher.find()) {
                System.out.println(word);
            }
        }

    }
}
