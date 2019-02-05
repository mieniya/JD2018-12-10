package by.it.subach.jd02_05;

import java.util.ResourceBundle;

public class Test {

    public static void main(String[] args) {
        String messages = "/home/owner/git/JD2018-12-10/src/by/it/subach/jd02_05/messages";
        ResourceBundle rb = ResourceBundle.getBundle(messages);

        String test = rb.getString("message.welcome");
        System.out.println(test);

    }
}
