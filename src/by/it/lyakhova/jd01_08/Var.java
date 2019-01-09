package by.it.lyakhova.jd01_08;

abstract class Var implements Operation {
    @Override
    public String toString() {
        return "Какая-то непонятная переменная";
    }

    @Override
    public Var add(Var other) {
        System.out.println("Сложение "+this+" и " +other + "невозможною");
        return null;
    }

    @Override
    public Var sub(Var other) {
        System.out.println("Вычитание "+this+" и " +other + "невозможною");
        return null;
    }

    @Override
    public Var mul(Var other) {
        System.out.println("Умножение "+this+" и " +other + "невозможною");
        return null;
    }

    @Override
    public Var div(Var other) {
        System.out.println("Деление "+this+" и " +other + "невозможною");
        return null;
    }
}
