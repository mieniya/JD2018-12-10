package by.it.migunko.jd01_08;

abstract class Var implements Operation {
     @Override
     public String toString() {
         return "какая-то переменная";
     }

    @Override
    public Var add(Var other) {
        System.out.println("сложение"+this+"на"+other+"невозможно");
        return null;
    }

    @Override
    public Var sub(Var other) {
        System.out.println("вычитание"+this+"на"+other+"невозможно");
        return null;
    }

    @Override
    public Var mul(Var other) {
        System.out.println("умножение"+this+"на"+other+"невозможно");
        return null;
    }

    @Override
    public Var div(Var other) {
        System.out.println("деление"+this+"на"+other+"невозможно");
        return null;
    }
}
