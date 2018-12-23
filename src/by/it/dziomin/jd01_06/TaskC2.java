package by.it.dziomin.jd01_06;


import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC2 {

    private static LinkedHashSet<Integer> indexes = null;

    public static void main(String[] args) {
        long timeBegin = System.currentTimeMillis();
        String slow = slow(Poem.text);
        long timeEnd = System.currentTimeMillis();

//        System.out.println(slow);
        System.out.println("slow/miliseconds: " + (timeEnd-timeBegin));
        timeBegin = System.currentTimeMillis();
        String fast = fast(Poem.text);
        timeEnd = System.currentTimeMillis();

//        System.out.println(fast);
        System.out.println("fast/miliseconds: " + (timeEnd-timeBegin));



    }

    private static String slow(String text) {

        String[] array = getArrayWords(text);
        array = randomShuffleWordsArray(array);
        String newText = "";
        while (newText.length() <= 100000) {
            for (String word : array) {
                newText = newText + " " + word;
            }
        }
        return newText;
    }

    private static String fast(String text) {
        String[] array = getArrayWords(text);
        array = randomShuffleWordsArray(array);
        StringBuilder newText = new StringBuilder();
        while (newText.length() <= 100000) {
            for (String word : array) {
                newText = newText.append(" ").append(word);
            }
        }

        return newText.toString();
    }

    private static String[] getArrayWords(String text) {
        String regex = "[А-Яа-яёЁ]{1,}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        String[] arrayWords = new String[0];
        int i = 0;
        while (matcher.find()) {
            arrayWords = Arrays.copyOf(arrayWords, arrayWords.length + 1);
            arrayWords[i] = matcher.group();
            i++;
        }
        return arrayWords;
    }

    private static String[] randomShuffleWordsArray(String[] arrayWords) {
        int size = arrayWords.length;
        String[] shuffleArray = new String[size];

        if (indexes == null) {
            indexes = new LinkedHashSet<>();
            Random random = new Random();
            while (indexes.size() != size) {
                indexes.add(random.nextInt(size));
            }
        }

        int i = 0;
        for (Integer integer : indexes) {
            shuffleArray[i] = arrayWords[integer];
            i++;
        }

        return shuffleArray;
    }

}
