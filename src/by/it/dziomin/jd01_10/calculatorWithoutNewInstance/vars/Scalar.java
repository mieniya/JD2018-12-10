package by.it.dziomin.jd01_10.calculatorWithoutNewInstance.vars;

public class Scalar extends Var {

    private double value;

    public Scalar(double value) {
        this.value = value;
    }

    public Scalar(Scalar scalar) {
        this.value = scalar.getValue();
    }

    public Scalar(String strScalar) {
        this.value = Double.parseDouble(strScalar);
    }

    public String toString() {
        return String.valueOf(value);
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public boolean isScalar() {
        return true;
    }

    @Override
    public Var add(Var other) {
        if (other.isScalar()) {
            double result = this.value + ((Scalar) other).value;
            return new Scalar(result);
        }
        return other.add(this);
    }

    @Override
    public Var sub(Var other) {
        if (other.isScalar()) {
            double result = this.value - ((Scalar) other).value;
            return new Scalar(result);
        }
        // other Vector or Matrix
        return other.add(this);
    }

    @Override
    public Var mul(Var other) {
        if (other.isScalar()) {
            double result = this.value * ((Scalar) other).value;
            return new Scalar(result);
        }
        return other.add(this);
    }

    @Override
    public Var div(Var other) {
        if (other.isScalar()) {
            double result = this.value / ((Scalar) other).value;
            return new Scalar(result);
        }
        return other.add(this);

    }
}
