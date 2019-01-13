package by.it.lyakhova.jd01_08oop;

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


    public abstract Var addCross(Scalar scalar);

    public abstract Var addCross(Vector vector);

    public abstract Var addCross(Matrix matrix);


    public abstract Var subCross(Scalar scalar);

    public abstract Var subCross(Vector vector);

    public abstract Var subCross(Matrix matrix);


    public abstract Var mulCross(Scalar scalar);

    public abstract Var mulCross(Vector vector);

    public abstract Var mulCross(Matrix matrix);


    public abstract Var divCross(Scalar scalar);

    public abstract Var divCross(Vector vector);

    public abstract Var divCross(Matrix matrix);


}
