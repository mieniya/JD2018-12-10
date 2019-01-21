package by.it.yarmolenka.MyCalcUsingSwing_v1_simpleOperations_oneOperation;

public class Scalar {
    private double value;

    public Scalar(double value) {
        this.value = value;
    }

    public Scalar() {
        this.value = 0.0;
    }

    public Scalar(String s) {
        s = s.replace(',', '.');
        this.value = Double.parseDouble(s);
    }

    @Override
    public String toString() {
        String res = String.valueOf(this.value);
        res = res.replace('.', ',');
        if (this.getValue() % 1.0 == 0) res = res.substring(0, res.length() - 2);
        return res;
    }

    public static Scalar operation(char operation, Scalar sc1, Scalar sc2) throws CalcException {
        switch (operation) {
            case '+':
                return add(sc1, sc2);
            case '-':
                return sub(sc1, sc2);
            case '*':
                return mul(sc1, sc2);
            case '/':
                return div(sc1, sc2);
            default:
                return null;
        }
    }

    public double getValue() {
        return value;
    }

    private static Scalar add(Scalar sc1, Scalar sc2) {
        return new Scalar(sc1.getValue() + sc2.getValue());
    }

    private static Scalar mul(Scalar sc1, Scalar sc2) {
        return new Scalar(sc1.getValue() * sc2.getValue());
    }

    private static Scalar sub(Scalar sc1, Scalar sc2) {
        return new Scalar(sc1.getValue() - sc2.getValue());
    }

    private static Scalar div(Scalar sc1, Scalar sc2) throws CalcException {
        if (sc2.getValue() == 0) throw new CalcException("деление на ноль невозможно");
        return new Scalar(sc1.getValue() / sc2.getValue());
    }
}
