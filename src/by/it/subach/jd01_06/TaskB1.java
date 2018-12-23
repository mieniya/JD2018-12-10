package by.it.subach.jd01_06;

public class TaskB1 {

    public static void main(String[] args) {
        vowelFind(Poem.text);
    }

    private static void vowelFind(String str) {
        char[] vowels = {'а', 'у', 'о', 'ы', 'и', 'э', 'я', 'ю', 'ё', 'е'};
        String [] consonant = {"б", "в", "г", "д", "ж", "з", "й", "к", "л", "м", "н", "п", "р", "с", "т", "ф", "х",
                "ц", "ч", "ш", "щ", "ь", "Ъ"};
        String[] words = str.split("\\s|\\p{Punct}");

        for (String word : words) {
            if(word.length() > 1){
                for (String cons : consonant) {
                    if(word.substring(0,1).equalsIgnoreCase(cons)){
                        for (char vowel : vowels) {
                            if(word.charAt(word.length()-1) == vowel){
                                System.out.println(word);
                                break;
                            }
                        }
                        break;
                    }
                }
            }
        }
    }
}
