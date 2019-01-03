package by.it.naron.jd01_08.taskTaksopark;

/**
 * Created by Админ on 27.03.2018.
 */
public class AvariinieAvto extends LegkovieAvto{

    //поля класса
    private boolean bochka;         //бочка  - для пожарной машины
    private boolean avtoak;         //автозак - для милицейской машины
    private boolean katalka;        //каталка - для машины скорой помощи

    //конструкторы класса


    public AvariinieAvto(int price, double rashodTopliva, String tipTopliva, int kolvoSeats, int countPassagir, boolean bochka, boolean avtoak, boolean katalka) {
        super(price, rashodTopliva, tipTopliva, kolvoSeats, countPassagir);
        this.bochka = bochka;
        this.avtoak = avtoak;
        this.katalka = katalka;
    }

    public AvariinieAvto (){
    }

    //геттеры и сеттеры
    public boolean isBochka() {return bochka;}

    public void setBochka(boolean bochka) {
        this.bochka = bochka;
    }

    public boolean isAvtoak() {
        return avtoak;
    }

    public void setAvtoak(boolean avtoak) {
        this.avtoak = avtoak;
    }

    public boolean isKatalka() {
        return katalka;
    }

    public void setKatalka(boolean katalka) {
        this.katalka = katalka;
    }

        //переопреопределить метод toString


    @Override
    public String toString() {
        return "AvariinieAvto{" + super.toString() +
                " bochka= " + bochka +
                " , avtoak= " + avtoak +
                " , katalka= " + katalka +
                '}';
    }
}
