package by.it.subach.jd01_08.jd01_08_withoutInstanseof;

abstract class Var implements Operation {
    private double value;

    @Override
    public Var add(Var other) {
        System.out.println("Сложение " + this + " на " + other + " невозможно");
        return null;
    }

    @Override
    public Var sub(Var other) {
        System.out.println("Вычитание " + this + " на " + other + " невозможно");
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

    //----------------------------------------add2-------------------------------------------//

    public Var add2(Vector other) {
        System.out.println("Сложение " + this + " на " + other + " невозможно");
        return null;
    }

    public Var add2(Scalar other) {
        System.out.println("Сложение " + this + " на " + other + " невозможно");
        return null;
    }

    public Var add2(Matrix other) {
        System.out.println("Сложение " + this + " на " + other + " невозможно");
        return null;
    }

//---------------------------------------sub2-----------------------------------------------//

    public Var sub2(Scalar other) {
        System.out.println("Вычитание " + this + " на " + other + " невозможно");
        return null;
    }

    public Var sub2(Vector other) {
        System.out.println("Вычитание " + this + " на " + other + " невозможно");
        return null;
    }

    public Var sub2(Matrix other) {
        System.out.println("Вычитание " + this + " на " + other + " невозможно");
        return null;
    }

//---------------------------------------mul2----------------------------------------------//

    public Var mul2(Scalar other) {
        System.out.println("Умножение " + this + " на " + other + " невозможно");
        return null;
    }

    public Var mul2(Vector other) {
        System.out.println("Умножение " + this + " на " + other + " невозможно");
        return null;
    }

    public Var mul2(Matrix other) {
        System.out.println("Умножение " + this + " на " + other + " невозможно");
        return null;
    }

//---------------------------------------div2----------------------------------------------//

    public Var div2(Scalar other) {
        System.out.println("Деление " + this + " на " + other + " невозможно");
        return null;
    }

    public Var div2(Vector other) {
        System.out.println("Деление " + this + " на " + other + " невозможно");
        return null;
    }

    public Var div2(Matrix other) {
        System.out.println("Деление " + this + " на " + other + " невозможно");
        return null;
    }


    @Override
    public String toString() {
        return String.valueOf(value);
    }


}
