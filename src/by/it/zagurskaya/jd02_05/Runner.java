package by.it.zagurskaya.jd02_05;

import by.it.zagurskaya.jd02_05.strings.Message;
import by.it.zagurskaya.jd02_05.strings.User;


public class Runner {

    public static void main(String[] args) {
        if (args.length == 0) {
            args = new String[]{"", ""};
        }
//        args = new String[]{"ru", "RU"};
//        args = new String[]{"", ""};

        ResMan resMan = ResMan.INSTANCE;
        if (args.length == 2) {
            resMan.setLocale(args[0], args[1]);
        }
        System.out.println(resMan.get(Message.WELCOME));
        System.out.println(resMan.get(Message.QUESTION));
        System.out.println(resMan.get(User.NAME));
    }

}
