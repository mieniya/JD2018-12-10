package by.it.naron.jd01_08.taskTaksopark;

/**
 * Created by Админ on 27.03.2018.
 */
public class GonochnieAvto extends LegkovieAvto {

    //поля класса
    private boolean spiler;     //спойлер

    //конструкторы класса



    public GonochnieAvto(int price, double rashodTopliva, String tipTopliva, int kolvoSeats, int countPassagir, boolean spiler) {
        super(price, rashodTopliva, tipTopliva, kolvoSeats, countPassagir);
        this.spiler = spiler;
    }

    public GonochnieAvto() {
    }

    //геттеры и сетторы класса
    public boolean isSpiler() {
        return spiler;
    }

    public void setSpiler(boolean spiler) {
        this.spiler = spiler;
    }
}
