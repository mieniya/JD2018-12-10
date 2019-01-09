package by.it.lyakhova.jd01_06;


import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {

    private static String[] words = new String[0];

    public static void main(String[] args) {
        String reg="[а-яА-ЯёЁ]+";
        Pattern pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher(Poem.text);

        while (matcher.find()){
            processOneWord(matcher.group());
        }

        for (String el :
                words) {
            if(find(el)) System.out.println(el);
        }

    }

    private static boolean find(String text){
       boolean find = false;
       String vowel = "аАеЕёЁиИоОуУыЫэЭюЮяЯ";
       int end = text.length()-1;
       char firstLetter = text.charAt(0);
       char lastLetter = text.charAt(end);
       if (vowel.indexOf(firstLetter)==-1){
           if (vowel.indexOf(lastLetter)!=-1) find=true;
       }





        return find;
   }

    private static void processOneWord(String word) {
        for (int i=0; i<words.length;i++) {
            String str = words[i];
            if (str.equals(word)) {
                return;
            }
        }
        //word is new
        words = Arrays.copyOf(words, words.length+1);
        words[words.length-1]=word;
    }
}
