package by.it.naron.jd01_08.taskTaksopark;

/**
 * Created by Админ on 27.03.2018.
 */
public class Furi extends GryzovieAvto {

    //поля класса
    private boolean polypritchep;

    //конструкторы класса
    public Furi(int price, double rashodTopliva, String tipTopliva, int kolvoSeats, int countDriver, int vesAvto, int countKoles, boolean polypritchep) {
        super(price, rashodTopliva, tipTopliva, kolvoSeats, countDriver, vesAvto, countKoles);
        this.polypritchep = polypritchep;
    }

    public Furi(){
    }

    //геттеры и сетторы
    public boolean isPolypritchep() {
        return polypritchep;
    }

    public void setPolypritchep(boolean polypritchep) {
        this.polypritchep = polypritchep;
    }
}
