package by.it.skosirskiy.jd01;

public class Main {

    public static void main(String[] args) {
	    MyFirstClass myFirstClass=new MyFirstClass();
	    myFirstClass.setSlogan("hello world!!!!");
	    myFirstClass.printSlogan();
	    myFirstClass.setSlogan("Привет мир!");
        myFirstClass.printSlogan();

        Args argObj=new Args(args);
        argObj.printArgs();
    }
}
