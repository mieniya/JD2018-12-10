package by.it.yarmolenka.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC1 {
    public static void main(String[] args) {
        String[] array = Poem.text.split("\n");

        //Находим длину самой длинной строки
        int max = array[0].length();
        for (int i = 1; i < array.length; i++)
            if (array[i].length() > max) max = array[i].length();

            //Добавляем пробелы если строка короче самой длинной пока длины не уравняются
        for (int i = 0; i < array.length; i++) {
            StringBuilder sb = new StringBuilder(array[i]);
            while (sb.length() < max) {
                Pattern p1 = Pattern.compile("[А-Яа-яЁё:,!?.-][ ][А-Яа-яЁё:,!?.-]");
                Matcher m1 = p1.matcher(sb);
                if (m1.find()) {
                    int pos = m1.start() + 1;
                    sb.insert(pos, ' ');
                    continue;
                }
                Pattern p2 = Pattern.compile("[А-Яа-яЁё:,!?.-][ ]{2}[А-Яа-яЁё:,!?.-]");
                Matcher m2 = p2.matcher(sb);
                if (m2.find()) {
                    int pos = m2.start() + 1;
                    sb.insert(pos, ' ');
                    continue;
                }
                Pattern p3 = Pattern.compile("[А-Яа-яЁё:,!?.-][ ]{3}[А-Яа-яЁё:,!?.-]");
                Matcher m3 = p3.matcher(sb);
                if (m3.find()) {
                    int pos = m3.start() + 1;
                    sb.insert(pos, ' ');
                    continue;
                }
                Pattern p4 = Pattern.compile("[А-Яа-яЁё:,!?.-][ ]{4}[А-Яа-яЁё:,!?.-]");
                Matcher m4 = p4.matcher(sb);
                if (m4.find()) {
                    int pos = m4.start() + 1;
                    sb.insert(pos, ' ');
                    continue;
                }
                Pattern p5 = Pattern.compile("[А-Яа-яЁё:,!?.-][ ]{5}[А-Яа-яЁё:,!?.-]");
                Matcher m5 = p5.matcher(sb);
                if (m5.find()) {
                    int pos = m5.start() + 1;
                    sb.insert(pos, ' ');
                    continue;
                }
                Pattern p6 = Pattern.compile("[А-Яа-яЁё:,!?.-][ ]{6}[А-Яа-яЁё:,!?.-]");
                Matcher m6 = p6.matcher(sb);
                if (m6.find()) {
                    int pos = m6.start() + 1;
                    sb.insert(pos, ' ');
                    continue;
                }
                Pattern p7 = Pattern.compile("[А-Яа-яЁё:,!?.-][ ]{7}[А-Яа-яЁё:,!?.-]");
                Matcher m7 = p7.matcher(sb);
                if (m7.find()) {
                    int pos = m7.start() + 1;
                    sb.insert(pos, ' ');
                }
            }
            array[i] = sb.toString();
        }
        for (String s : array) System.out.println(s);

    }
}
