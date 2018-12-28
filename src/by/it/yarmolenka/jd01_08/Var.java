package by.it.yarmolenka.jd01_08;

abstract class Var implements Operation {


    @Override
    public Var add(Var other) {
        System.out.println("Сложение невозможно");
        return null;
    }

    @Override
    public Var sub(Var other) {
        System.out.println("Вычитание невозможно");
        return null;
    }

    @Override
    public Var mul(Var other) {
        System.out.println("Умножение невозможно");
        return null;
    }

    @Override
    public Var div(Var other) {
        System.out.println("Деление невозможно");
        return null;
    }

    @Override
    public String toString() {
        return "Переменная";
    }
}
