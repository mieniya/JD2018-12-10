package by.it.naron.jd01_08.taskTaksopark;

/**
 * Created by Админ on 27.03.2018.
 */
public class Kran extends GryzovieAvto {

    //поля класса
    private boolean kruk;

    //конструкторы класса
    public Kran(int price, double rashodTopliva, String tipTopliva, int kolvoSeats, int countDriver, int vesAvto, int countKoles, boolean kruk) {
        super(price, rashodTopliva, tipTopliva, kolvoSeats, countDriver, vesAvto, countKoles);
        this.kruk = kruk;
    }

    public Kran (){
    }

    //геттеры и сеттеры класса
    public boolean isKruk() {
        return kruk;
    }

    public void setKruk(boolean kruk) {
        this.kruk = kruk;
    }
}
