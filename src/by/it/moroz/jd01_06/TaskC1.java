package by.it.moroz.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC1 {

    public static void main(String[] args) {

        String text = Poem.text;
        String[] wordArray = text.split("[\n]+");

        for (int i = 0; i < wordArray.length; i++) {
            wordArray[i]=wordArray[i].trim();
        }
        int max = findMax(wordArray);

        for (int i = 1; i < wordArray.length; i++) {
            while (wordArray[i].length() != max) {

                   // wordArray[i] = wordArray[i].replaceAll("[ ]?", "  ");
            }

        }
        for (int i = 0; i < wordArray.length; i++) {
            System.out.println(wordArray[i]);
        }

    }


    static int findMax(String[ ] arr){
        if (0==arr.length) {
            return arr[0].length();
        } else {
            int max = arr[0].length();
            for (int i = 1; i < arr.length; i++) {
                if (max<arr[i].length()) max=arr[i].length();
            }
            return max;
        }
    }
}
