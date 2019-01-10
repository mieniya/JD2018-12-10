package by.it.yarmolenka.jd01_09;

abstract class Var implements Operation {


    static Var createVar(String s) {
        s = s.trim();
        if (s.matches(Patterns.SCALAR)) return new Scalar(s);
        if (s.matches(Patterns.VECTOR)) return new Vector(s);
        if (s.matches(Patterns.MATRIX)) return new Matrix(s);
        System.out.println("Переменная " + s + " не определена");
        return null;
    }

    @Override
    public Var add(Var other) {
        System.out.println("Сложение " + this + " и " + other + " невозможно");
        return null;
    }

    @Override
    public Var sub(Var other) {
        System.out.println("Вычитание " + other + " из " + this + " невозможно");
        return null;
    }

    @Override
    public Var mul(Var other) {
        System.out.println("Умножение " + this + " на " + other + " невозможно");
        return null;
    }

    @Override
    public Var div(Var other) {
        System.out.println("Деление " + this + " на " + other + " невозможно");
        return null;
    }

    @Override
    public String toString() {
        return "Переменная";
    }
}
