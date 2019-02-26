package by.it.moroz.jd01.jd01_06;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC1 {

    public static void main(String[] args) {

        String text = Poem.text;
        String[] wordArray = text.split("[\n]+");

        for (int i = 0; i < wordArray.length; i++) {
            wordArray[i] = wordArray[i].trim();
        }
        int max = findMax(wordArray);

        for (int i = 0; i < wordArray.length; i++) {
            StringBuilder sb = new StringBuilder(wordArray[i]);
            while (sb.length() != max) {
                Pattern pat1 = Pattern.compile("[\\w]+[ ]");
                Matcher mat1 = pat1.matcher(sb);
                if (mat1.find()){
                    int position = mat1.start()+1;
                    sb.insert(position, ' ');
                    continue;
                }

            }

        }
        for (int i = 0; i < wordArray.length; i++) {
            System.out.println(wordArray[i]);
        }

    }


    static int findMax(String[] arr) {
            int max = arr[0].length();
            for (int i = 1; i < arr.length; i++) {
                if (max < arr[i].length()) max = arr[i].length();
            }
            return max;
    }
}
