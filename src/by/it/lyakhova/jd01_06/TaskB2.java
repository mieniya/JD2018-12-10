package by.it.lyakhova.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB2 {


    public static void main(String[] args) {

        String text = Poem.text.replaceAll("\n+", " ");
        text = text.replaceAll("[.]{2,}", " ");
        System.out.println(text);

        Pattern sentence = Pattern.compile("[А-ЯЁ][^.?!]+[.!?]");
        //Pattern symbols = Pattern.compile("[^а-яА-ЯёЁ]");
        Matcher matcher = sentence.matcher(text);

        int count = 0; // how many are sentences in the poem
        while (matcher.find()) count++;

        System.out.println(count);

        String[] arrSentence = new String[count];

        matcher.reset();

        int i = 0;

        while (matcher.find()){
            arrSentence[i] = matcher.group().replaceAll("[^а-яА-ЯёЁ]+", " ").trim();
            i++;
        }
        for (String el :
                arrSentence) {
            System.out.println(el);
        }

        sort(arrSentence);

        for (String el :
                arrSentence) {
            System.out.println(el);
        }

    }

    private static void sort(String[] arr){
        int last = arr.length-1;
        boolean move;
        do {
            move=false;
            for (int i = 0; i < last; i++) {
                if (arr[i].length()>arr[i+1].length()){
                    String tempBuf=arr[i];
                    arr[i]=arr[i+1];
                    arr[i+1]=tempBuf;
                    move=true;
                }
            }
            last--;
        }while (move);
    }
}

