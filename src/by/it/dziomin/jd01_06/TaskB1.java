package by.it.dziomin.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {
    public static void main(String[] args) {

        String reg = "[А-Яа-яёЁ]+";
        Pattern pattern = Pattern.compile(reg);
        StringBuilder sb = new StringBuilder(Poem.text);
        Matcher matcher = pattern.matcher(sb);

        while (matcher.find()) {
            String word = matcher.group();
            if (isWordTrue(word.toCharArray())){
                System.out.println(word);
            }
        }

    }

    private static boolean isWordTrue(char[] letters) {
        if (letters.length > 1) {
            return !isGlasn(letters[0]) && isGlasn(letters[letters.length - 1]);
        } else {
            return false;
        }
    }

    private static boolean isGlasn(char letter) {
        String glasn = "уеёэоаыяиюУЕЭОАЫЯИЮЁ";
        return glasn.indexOf(letter) >= 0;
    }


}
