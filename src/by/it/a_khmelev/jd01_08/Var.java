package by.it.a_khmelev.jd01_08;

abstract class Var implements Operation{

    @Override
    public Var add(Var other) {
        System.out.println("Сложение "+this+" и "+other +" невозможно.");
        return null;
    }

    @Override
    public Var sub(Var other) {
        System.out.println("Вычитание "+this+" и "+other +" невозможно.");
        return null;
    }

    @Override
    public Var mul(Var other) {
        System.out.println("Умножение "+this+" и "+other +" невозможно.");
        return null;
    }

    @Override
    public Var div(Var other) {
        System.out.println("Деление "+this+" и "+other +" невозможно.");
        return null;
    }

    @Override
    public String toString() {
        return "Какая-то непонятная переменная";
    }

}
