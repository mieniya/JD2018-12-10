package by.it.yarmolenka.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {
    public static void main(String[] args) {
        Pattern pt = Pattern.compile("[А-Яа-яЁё]+");
        Matcher mc = pt.matcher(Poem.text);
        while (mc.find()) {
            if (firstConsnonatLastVowel(mc.group())) System.out.println(mc.group());
        }
    }

    private static boolean firstConsonantLastVowel(String s) {
        s = s.toLowerCase();
        char first = s.charAt(0);
        char last = s.charAt(s.length() - 1);
        return (isConsonant(first) && isVowel(last));
    }

    private static boolean isConsonant(char x) {
        char[] vow = {'а', 'е', 'ё', 'и', 'о', 'у', 'ы', 'э', 'ю', 'я', 'ъ', 'ь'};
        for (char v : vow) if (x == v) return false;
        return true;
    }

    private static boolean isVowel(char x) {
        char[] vowels = {'а', 'е', 'ё', 'и', 'о', 'у', 'ы', 'э', 'ю', 'я'};
        for (char vowel : vowels) if (x == vowel) return true;
        return false;
    }
}
