package by.it.yarmolenka.jd01_06;


public class TaskB2 {
    public static void main(String[] args) {
        String poem = Poem.text;
        poem = poem.replace("...", " ");
        poem = poem.replace("\n"," ");
        poem = poem.replace(", ", " ");
        poem = poem.replace(" - ", " ");
        poem = poem.replace(": ", " ");
        poem = poem.replace("! ", " ");
        String[] array = poem.split("\\.");
        for (int i = 0; i < array.length; i++) array[i] = array[i].trim();
        sort(array);
        for (String s : array) {
            System.out.println(s);
        }
    }

    private static void sort(String[] arr) {
        boolean swap;
        int list = arr.length - 1;
        String temp;
        do {
            swap = false;
            for (int i = 0; i < list; i++) {
                if (arr[i].length() > arr[i + 1].length()) {
                    temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    swap = true;
                }
            }
            list--;
        }
        while (swap);

    }

}
