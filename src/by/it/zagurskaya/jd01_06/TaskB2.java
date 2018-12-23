package by.it.zagurskaya.jd01_06;

public class TaskB2 {
    public static void main(String[] args) {
        String regSentence = "[!\\.]+";
        StringBuilder sb = new StringBuilder(Poem.text);

        String poemString = sb.toString();
        poemString = poemString.replaceAll("[\\n,:-]", " ");
        poemString = poemString.replaceAll("[\\s]+", " ");
        String[] split = poemString.split(regSentence);

        for (int i = 0; i < split.length; i++) {
            split[i] = split[i].trim();
        }

        bubbleSortStrings(split);

        for (String s : split) {
            System.out.println(s);
        }

    }

    static void bubbleSortStrings(String[] array) {
        boolean swap;
        int end = array.length - 1;
        do {
            swap = false;
            for (int i = 0; i < end; i++)
                if (array[i].length() > array[i + 1].length()) {
                    String temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    swap = true;
                }
            end--;
        }
        while (swap);
    }
}
