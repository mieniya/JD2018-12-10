package by.it.dziomin.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC1 {
    public static void main(String[] args) {
        String[] str = getArrayRowsFromText(Poem.text);
        int size = findMaxSizeOfRows(str);

        str = setRowsToNeedSize(str, size);
        for (String s : str) {
            System.out.println(s);
        }

    }


    private static String[] getArrayRowsFromText(String text) {

        String reg = "[^\\n]{1,}";
        Pattern pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher(text);
        String[] arrayRows = new String[0];
        int i = 0;
        while (matcher.find()) {
            arrayRows = Arrays.copyOf(arrayRows, arrayRows.length + 1);
            arrayRows[i] = matcher.group();
            i++;
        }
        return arrayRows;


    }


    private static int findMaxSizeOfRows(String[] arrayRows) {
        int maxSize = 0;
        for (String i : arrayRows) {
            if (maxSize < i.length()) {
                maxSize = i.length();
            }
        }
        return maxSize;
    }

    private static String[] setRowsToNeedSize(String[] arrayRows, int size) {
        String[] needRows = new String[arrayRows.length];
        Pattern pattern = Pattern.compile("( +)");

        for (int i = 0; i < arrayRows.length; i++) {
            StringBuilder sb = new StringBuilder(arrayRows[i]);
            Matcher matcher = pattern.matcher(sb);
            int diffSize = size - arrayRows[i].length();
            int groupCount = 0;
            while (matcher.find()) {
                groupCount++;
            }

            if (diffSize == 0) {
                needRows[i] = new String(sb);
                continue;
            }

            int[] indexSpace = new int[groupCount];
            int temp = 0;
            matcher = pattern.matcher(sb);
            while (matcher.find()) {
                indexSpace[temp] = matcher.start();
                temp++;
            }


            int curIndex = 0;
            while (sb.length() < size) {

                indexSpace[curIndex] = indexSpace[curIndex] + curIndex;
                sb = sb.insert(indexSpace[curIndex], " ");

                curIndex++;
                if (curIndex >= indexSpace.length) {
                    curIndex = 0;
                }
            }
            needRows[i] = sb.toString();
        }
        return needRows;
    }

}

