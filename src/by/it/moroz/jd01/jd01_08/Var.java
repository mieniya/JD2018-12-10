package by.it.moroz.jd01.jd01_08;

public abstract class Var implements Operation {

    @Override
    public Var add(Var other) {
        System.out.println("Сложение "+this+" на "+other+" невозможно.");
        return null;
    }

    @Override
    public Var sub(Var other) {
        System.out.println("Вычитание "+this+" на "+other+" невозможно.");
        return null;
    }

    @Override
    public Var mul(Var other) {
        System.out.println("Умножение "+this+" на "+other+" невозможно.");
        return null;
    }

    @Override
    public Var div(Var other) {
        System.out.println("Деление "+this+" на "+other+" невозможно.");
        return null;
    }

}
