package by.it.naron.jd01_08.taskTaksopark;

/**
 * Created by ����� on 27.03.2018.
 */
public abstract class Avto implements Comparable<Avto>{

    //


    public int compareTo(Avto o) {
        return new Double(rashodTopliva).compareTo(o.rashodTopliva);
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public double getRashodTopliva() {
        return rashodTopliva;
    }

    public void setRashodTopliva(double rashodTopliva) {
        this.rashodTopliva = rashodTopliva;
    }

    public String getTipTopliva() {
        return tipTopliva;
    }

    public void setTipTopliva(String tipTopliva) {
        this.tipTopliva = tipTopliva;
    }

    public int getKolvoSeats() {
        return kolvoSeats;
    }

    public void setKolvoSeats(int kolvoSeats) {
        this.kolvoSeats = kolvoSeats;
    }

    private int price;                  //поля класса
    private double rashodTopliva;
    private String tipTopliva;
    private int kolvoSeats;



    public Avto(){              // пустой конструктор
    }

    // конструктор с параметрами
    public Avto(int price, double rashodTopliva, String tipTopliva, int kolvoSeats){
        this.price = price;
        this.rashodTopliva = rashodTopliva;
        this.tipTopliva = tipTopliva;
        this.kolvoSeats = kolvoSeats;
    }


    //переопределяю метод toString


    @Override
    public String toString() {
        return "Avto{" +
                "price=" + price +
                ", rashodTopliva=" + rashodTopliva +
                ", tipTopliva='" + tipTopliva + '\'' +
                ", kolvoSeats=" + kolvoSeats +
                '}';
    }
}
