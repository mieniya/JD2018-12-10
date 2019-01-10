package by.it.naron.jd01_08.taskTaksopark;

/**
 * Created by Админ on 27.03.2018.
 */
public class Samosval extends GryzovieAvto{

    //поля класса
    private boolean bolshoiKyzov;

    //конструкторы класс
    public Samosval(int price, double rashodTopliva, String tipTopliva, int kolvoSeats, int countDriver, int vesAvto, int countKoles, boolean bolshoiKyzov) {
        super(price, rashodTopliva, tipTopliva, kolvoSeats, countDriver, vesAvto, countKoles);
        this.bolshoiKyzov = bolshoiKyzov;
    }

    public Samosval(){
    }

    //Гетторы и сетторы
    public boolean isBolshoiKyzov() {
        return bolshoiKyzov;
    }

    public void setBolshoiKyzov(boolean bolshoiKyzov) {
        this.bolshoiKyzov = bolshoiKyzov;
    }
}
