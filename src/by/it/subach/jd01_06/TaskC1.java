package by.it.subach.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC1 {
    static String [] textArray;

    public static void main(String[] args) {
        String str = Poem.text;
        poemToArray(str);
        lineJustify(textArray, maxLineLength(textArray));

    }

    private static String [] poemToArray(String str){
        textArray = str.split("[\\n]+");
        return textArray;
    }

    private static int maxLineLength(String [] arr){
        int max = 0;
        for (String s : arr) {
            if(s.length() > max){
                max = s.length();
            }
        }
        return max;
    }

    private static void lineJustify(String [] arr, int maxLineLength){
        Pattern pattern = Pattern.compile("[\\w\\s]+");
        for (int i = 0; i < arr.length; i++) {
            StringBuilder sb = new StringBuilder(arr[i]);
            Matcher matcher = pattern.matcher(sb);
            int start = 0;
            while(sb.length() < maxLineLength){
                if(matcher.find(start)) {
                    int find = matcher.end();
                    sb.insert(find, " ");
                    start = find + 1;
                }
                else{
                    start = 0;
                }
            }
            arr[i] = sb.toString();
            System.out.println(sb);

        }
    }




}
