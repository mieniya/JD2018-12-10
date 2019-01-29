package by.it.moroz.jd02_02;

public class Printer {

    static synchronized void print (String s){
        System.out.println(s);
    }
}
