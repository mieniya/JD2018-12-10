package by.it.lyakhova.jd01_01;

public class Main {

    public static void main(String[] args) {

        System.out.println("Hello World!");

        Hello hello = new Hello();
        hello.printSlogan();

        hello.setSlogan("Привет мир!");
        hello.printSlogan();

        Args argObject = new Args(args);
        argObject.printArgs();

	// write your code here
    }
}
