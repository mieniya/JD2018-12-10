package by.it.agadzhanov.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("[а-яА-ЯёЁ]+");
        Matcher matcher = pattern.matcher(Poem.text);
        while (matcher.find()) {
            if (wordCheck(matcher.group()) == true)
                System.out.println(matcher.group());
        }
    }

    private static boolean vowelCheck(char a) {
        if (a == 'а' || a == 'о' || a == 'у' || a == 'э' || a == 'ы' || a == 'я' || a == 'ё' || a == 'ю' || a == 'е' || a == 'и'
                || a == 'А' || a == 'О' || a == 'У' || a == 'Э' || a == 'Я' || a == 'Ё' || a == 'Ю' || a == 'Е' || a == 'И')
            return true;
        else return false;
    }

    private static boolean wordCheck(String word) {
        if (vowelCheck(word.charAt(word.length() - 1)) == true && vowelCheck(word.charAt(0)) == false) {
            return true;
        } else return false;
    }
}