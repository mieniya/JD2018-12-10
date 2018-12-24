package by.it.yarmolenka.jd01;

public class Main {

    public static void main(String[] args) {
        Hello hello = new Hello();
        hello.printSlogan();
        String slogan = "Привет мир!";
        hello.setSlogan(slogan);
        hello.printSlogan();
        Args argObj = new Args(args);
        argObj.printArgs();
    }
}
