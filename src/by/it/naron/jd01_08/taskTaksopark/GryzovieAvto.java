package by.it.naron.jd01_08.taskTaksopark;

/**
 * Created by Админ on 27.03.2018.
 */
public class GryzovieAvto extends Avto{

    //поля класса
    private int countDriver;        //колличество водителей
    private int vesAvto;
    private int countKoles;

    //конструктор с параметрами


    public GryzovieAvto(int countDriver, int vesAvto, int countKoles) {
        this.countDriver = countDriver;
        this.vesAvto = vesAvto;
        this.countKoles = countKoles;
    }

    public GryzovieAvto(int price, double rashodTopliva, String tipTopliva, int kolvoSeats, int countDriver, int vesAvto, int countKoles) {
        super(price, rashodTopliva, tipTopliva, kolvoSeats);
        this.countDriver = countDriver;
        this.vesAvto = vesAvto;
        this.countKoles = countKoles;
    }

    //конструктор без параметров
    public GryzovieAvto(){
    }

    //геттеры и сетторы
    public int getCountDriver() {
        return countDriver;
    }

    public void setCountDriver(int countDriver) {
        this.countDriver = countDriver;
    }

    public int getVesAvto() {
        return vesAvto;
    }

    public void setVesAvto(int vesAvto) {
        this.vesAvto = vesAvto;
    }

    public int getCountKoles() {
        return countKoles;
    }

    public void setCountKoles(int countKoles) {
        this.countKoles = countKoles;
    }
}
