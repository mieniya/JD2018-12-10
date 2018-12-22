package by.it.agadzhanov.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB2 {

    public static void main(String[] args) {
        String[] sentences=new String[0];
        StringBuilder sb=new StringBuilder("У лукоморья дуб зелёный, Златая цепь на дубе том. И днём и ночью кот учёный " +
                "Всё ходит по цепи кругом. Идёт направо - песнь заводит, Налево - сказку говорит. Там чудеса: там леший" +
                " бродит, Русалка на ветвях сидит. Там на неведомых дорожках Следы невиданных зверей. Избушка там на" +
                " курьих ножках Стоит без окон, без дверей. Там лес и дол видений полны, Там о заре прихлынут волны" +
                " На брег песчаный и пустой, И тридцать витязей прекрасных Чредой из вод выходят ясных, И с ними дядька" +
                " их морской. Там королевич мимоходом Пленяет грозного царя. Там в облаках перед народом Через леса," +
                " через моря Колдун несёт богатыря. В темнице там царевна тужит, А бурый волк ей верно служит. Там ступа" +
                " с Бабою Ягой Идёт, бредёт сама собой. Там царь Кащей над златом чахнет, Там русский дух... там Русью" +
                " пахнет! И там я был, и мёд я пил, У моря видел дуб зелёный, Под ним сидел, и кот учёный Свои мне сказки говорил.");
        Pattern sentence=Pattern.compile("([а-яА-ЯёЁ ,:-]+)(\\.{3})?([а-яА-ЯёЁ ,:-])+([.!?])");
        Matcher matcherSentence=sentence.matcher(sb);

        //forming array of trimmed sentences with symbols excluded
        while (matcherSentence.find()) {
            String oneSentence=matcherSentence.group();
            oneSentence=oneSentence.replaceAll(" ?[,:.!-]+ ?"," ");
            oneSentence=oneSentence.trim();
            int last = sentences.length;
            sentences = Arrays.copyOf(sentences, last + 1);
            sentences[last] = oneSentence;
        }

        //sorting this array
        for (int i = 0; i <= sentences.length-2; i++) {
            for (int j = i+1; j <= sentences.length-1; j++) {
                if (sentences[i].length()>sentences[j].length()) {
                    String buffer=sentences[j];
                    sentences[j]=sentences[i];
                    sentences[i]=buffer;
                }
            }
        }

        //printing this array
        for (int i = 0; i < sentences.length; i++) {
            System.out.printf("%s\n",sentences[i]);
        }
    }
}