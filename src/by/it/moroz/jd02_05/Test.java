package by.it.moroz.jd02_05;

import by.it.moroz.jd02_05.strings.Message;

import java.util.Locale;
import java.util.ResourceBundle;

public class Test {

    public static void main(String[] args) {
        String messages = "by.it.moroz.jd02_05.messages";
        Locale locale = new Locale("ru", "RU");
        ResourceBundle sb = ResourceBundle.getBundle(messages, locale);
        String test = sb.getString(Message.WELCOME);
        System.out.println(test);
    }
}
