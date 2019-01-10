package by.it.naron.jd01_08.taskTaksopark;

/**
 * Created by Админ on 27.03.2018.
 */
public class LegkovieAvto extends Avto{

    //поля класса
    private int countPassagir;          //колличество мест для пассажиров

    //конструкторы класса
    public LegkovieAvto(int countPassagir) {
        this.countPassagir = countPassagir;
    }

    public LegkovieAvto(int price, double rashodTopliva, String tipTopliva, int kolvoSeats, int countPassagir) {
        super(price, rashodTopliva, tipTopliva, kolvoSeats);
        this.countPassagir = countPassagir;
    }

    public LegkovieAvto (){
    }

    //гетторы и сетторы класса
    public int getCountPassagir() {
        return countPassagir;
    }

    public void setCountPassagir(int countPassagir) {
        this.countPassagir = countPassagir;
    }

    //переопределяю метод toString


    @Override
    public String toString() {
        return "LegkovieAvto{" + super.toString()+
                " countPassagir = " + countPassagir +
                '}';
    }
}
