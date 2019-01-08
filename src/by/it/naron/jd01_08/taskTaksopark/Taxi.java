package by.it.naron.jd01_08.taskTaksopark;

/**
 * Created by ����� on 27.03.2018.
 */
public class Taxi extends LegkovieAvto  {

    //поля класса
    private boolean avtoKreslo;

    //конструкторы класса
//    public Taxi(int countPassagir, boolean avtoKreslo) {
//        super(countPassagir);
//        this.avtoKreslo = avtoKreslo;
//    }

    public Taxi(int price, double rashodTopliva, String tipTopliva, int kolvoSeats, int countPassagir, boolean avtoKreslo) {
        super(price, rashodTopliva, tipTopliva, kolvoSeats, countPassagir);
        this.avtoKreslo = avtoKreslo;
    }

    public Taxi(boolean avtoKreslo) {
        this.avtoKreslo = avtoKreslo;
    }
   // public Taxi (){ }

    //сеттеры и геттеры

    public boolean isAvtoKreslo() {
        return avtoKreslo;
    }

    public void setAvtoKreslo(boolean avtoKreslo) {
        this.avtoKreslo = avtoKreslo;
    }

    // переопределяю метод toString


    @Override
    public String toString() {
        return "Taxi{" + super.toString()+
                " avtoKreslo = " + avtoKreslo +
                '}';
    }
}
