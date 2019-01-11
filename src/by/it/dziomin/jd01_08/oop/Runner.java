package by.it.dziomin.jd01_08.oop;

public class Runner {
    public static void main(String[] args) {
        Mobile m1 = new Model(false, "111");
        m1.turnOn();
        m1.call();
        m1.sendSms();
        m1.turnOff();

        Mobile m2 = new Model(true, "222");
        m2.turnOn();
        m2.call();
        m2.sendSms();
        m2.turnOff();
    }
}
