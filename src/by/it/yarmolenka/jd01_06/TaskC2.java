package by.it.yarmolenka.jd01_06;

public class TaskC2 {
    public static void main(String[] args) {
        String text = Poem.text;
        long start = System.nanoTime();
        String slow = slow(text);
        long end = System.nanoTime();
        System.out.println(slow);
        System.out.println(end - start);
        long start2 = System.nanoTime();
        String fast = fast(text);
        long end2 = System.nanoTime();
        System.out.println(fast);
        System.out.println(end2 - start2);

    }

    private static String[] getWords(String text) {
        text = text.replace("\n", " ");
        text = text.replace("? ", " ");
        text = text.replace(", ", " ");
        text = text.replace(" - ", " ");
        text = text.replace(": ", " ");
        text = text.replace("... ", " ");
        text = text.replace(". ", " ");
        text = text.replace("! ", " ");
        text = text.replace(".", "");
        return text.split(" ");
    }

    private static String slow(String text) {
        String line = "";
        String[] words = getWords(text);
        int n = 0;
        while (line.length() < 10000) {
            int m = n % words.length;
            line = line + " " + words[m];
            n++;
        }
        line = line.trim();
        return line;
    }

    private static String fast(String text) {
        String[] words = getWords(text);
        StringBuilder sb = new StringBuilder();
        int n = 0;
        while (sb.length() < 10000) {
            int m = n % words.length;
            String add = " " + words[m];
            sb.insert(sb.length(), add);
            n++;
        }
        String line = sb.toString();
        line = line.trim();
        return line;
    }
}
