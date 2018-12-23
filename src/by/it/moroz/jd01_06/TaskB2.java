package by.it.moroz.jd01_06;

public class TaskB2 {

    public static void main(String[] args) {

        String text = Poem.text;
        text = text.replaceAll("\\.{3}", " ");
        text = text.replaceAll("\\s+", " ");
        String[] wordArray = text.split("[.!?]+");

        for (int i = 0; i < wordArray.length; i++) {
            wordArray[i] = wordArray[i].replaceAll("[, ]+", " ");
            wordArray[i] = wordArray[i].replaceAll("[ -]+", " ");
            wordArray[i] = wordArray[i].replaceAll("[: ]+", " ");
            wordArray[i]=wordArray[i].trim();
        }
        sort(wordArray);
        for (String s : wordArray) {
            System.out.println(s);
        }
    }

    private static String[] sort(String[] arr) {

        boolean swap;
        int last = arr.length - 1;
        do {
            swap = false;
            for (int j = 0; j < last; j++) {
                if (arr[j].length() > arr[j + 1].length()) {
                    String buffer = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = buffer;
                    swap = true;
                }
            }
            last--;
        }
        while (swap);
        return arr;
    }
}
