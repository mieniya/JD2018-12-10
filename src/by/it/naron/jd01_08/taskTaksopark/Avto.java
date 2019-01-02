package by.it.naron.jd01_08.taskTaksopark;

/**
 * Created by ����� on 27.03.2018.
 *
 *              1.Avto(предок)
 *
 * 2.legkovieAvto                          2.GryzovieAvto
 *          (наследуют поля методы и конструктор Avto)
 *
 * 3.1-AvariinieAvto                        3.1-Furi
 * 3.2-GonochnieAvto                        3.2-Kran
 * 3.3-taxi                                 3.3-Samosval
 * (наследуют LegkovieAvto)                 (extends GryzovieAvto)
 *
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
    private double rashodTopliva;       //расход топлива
    private String tipTopliva;          // тип топлива
    private int kolvoSeats;            //колличество сидений



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
