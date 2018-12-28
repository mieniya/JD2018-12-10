package by.it.subach.jd01_06;

import java.util.Random;

public class TaskC2 {
    static String[] words;

    public static void main(String[] args) {
        String str = Poem.text;
        long startSlow = System.nanoTime();
        slow(str);
        long estimatedTimeSlow = System.nanoTime() - startSlow;
        System.out.println("время выполнения slow: " + estimatedTimeSlow);

        long startFast = System.nanoTime();
        fast(str);
        long estimatedTimeFast = System.nanoTime() - startFast;
        System.out.println("время выполнения fast:" + estimatedTimeFast);


//        wordsToArray(str);
    }

    private static String [] wordsToArray(String str){
        str = str.replaceAll("\\n+|\\p{Punct}", " ").trim();
        words = str.split("[\\w\\s]+");
        return words;
    }

    private static String slow(String str){
        words = wordsToArray(str);
        int length = words.length;
        Random random = new Random(1234567);
        String resStr = "";
        while(resStr.length() <= 100000) {
            int n = random.nextInt(length - 1);
            resStr += words[n] + " ";
        }
        System.out.println(resStr);
        return resStr;
    }

    private static String fast(String str){
        words = wordsToArray(str);
        Random random = new Random(1234567);
        StringBuilder sb = new StringBuilder();
        while(sb.length() < 100000){
            sb = sb.append(words[random.nextInt(words.length-1)]);
            sb.append(" ");
        }
        System.out.println(sb);
        return sb.toString();
    }
}