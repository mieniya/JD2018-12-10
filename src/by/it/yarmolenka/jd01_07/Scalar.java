package by.it.yarmolenka.jd01_07;

public class Scalar extends Var {
    private double value;

    Scalar(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }
}
