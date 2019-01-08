package by.it.zagurskaya.jd01_08.oop;

public class Clinic {

    public static void main(String[] args) {
        Sick sick = new Sick(7, "ОРВИ", "температура 38", "аспирин");
        Sicker sicker = new Sicker("Пупкин", sick);

        Neurosurgeon neurosurgeon = new Neurosurgeon();

        neurosurgeon.doSayProfession();
        neurosurgeon.isWorking();

        neurosurgeon.doAsk(sicker);

        neurosurgeon.isWorking();

        neurosurgeon.doCure();

        neurosurgeon.isWorking();
    }

}
