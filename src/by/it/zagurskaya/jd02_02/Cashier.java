package by.it.zagurskaya.jd02_02;

public class Cashier  implements Runnable{
    private String name;
    public Cashier (int number) {
        name = "Casher №" + number;
    }
    @Override
    public void run() {

    }

    @Override
    public String toString() {
        return name;
    }
}
