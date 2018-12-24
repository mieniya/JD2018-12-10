package by.it.titkovskaya.jd01_06;

/*
Сформировать и вернуть в методе String slow (String text) из случайных слов
исходного текста строку String минимум в сто тысяч символов путем конкатенации. Слова
должны быть «склеены» через один пробел. Затем:
• В методе main: определить время работы метода slow (удобно использовать
System.nanoTime() или аналог); вывести полученный текст и время работы метода slow в
милисекундах на консоль.
• Ускорить процесс с StringBuilder (сделать новый метод String fast (String text),
ВАЖНО: его итог должен быть таким как в slow до буквы). В main повторить вывод.
 */

import java.util.regex.Pattern;

public class TaskC2 {
    public static void main(String[] args) {
        String text = Poem.text.replaceAll("[\\s\\n\\p{Punct}]+", " ");
        while (text.length() < 150000) {
            text += text;
        }
        Pattern pattern = Pattern.compile(" ");
        pattern.split(text);

        long t = System.nanoTime();
        System.out.println(slow(text));
        long dtSlow = (System.nanoTime() - t) / 1000;

        t = System.nanoTime();
        System.out.println(fast(text));
        long dtFast = (System.nanoTime() - t) / 1000;

        System.out.println("slow dt=" + dtSlow);
        System.out.println("fast dt=" + dtFast);
    }

    private static String slow(String text) {
        String result = new String();
        result = result + " ";
        result = result + text;
        return result;
    }

    private static String fast(String text) {
        StringBuilder sb = new StringBuilder();
        String result = sb.append(" ").append(text).toString();
        return result;
    }
}

/*
        System.out.println(words.length);

        String slowText = slow(text);
        System.out.println(slowText);

 */