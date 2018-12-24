package by.it.agadzhanov.jd01_01;

class Hello {

    private String slogan="Hello World!" ;//поле класса, переменная slogan, тип String

    void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    void printSlogan(){
        System.out.println(slogan);
    }
}
