package by.it.zagurskaya.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {

    public static void main(String[] args) {
        String regAllWord = "[а-яА-ЯёЁ]{2,}+";// все слова длиной больше 2-х
        Pattern patternAllWord = Pattern.compile(regAllWord);

        Matcher matcher = patternAllWord.matcher(Poem.text);
        while (matcher.find()) {

            if (processTwoWords(matcher.group())) {
                System.out.println(matcher.group());
            }
        }
    }

    private static boolean processTwoWords(String word) {
        String stressLaterString = "аеёиоуыэюяАЕЁИОУЫЭЮЯ"; // гласные
        String firstLater = word.substring(0, 1);
        String lastLater = word.substring(word.length() - 1);

        if (!stressLaterString.contains(firstLater) && stressLaterString.contains(lastLater)) {
            return true;
        }
        return false;
    }

}
