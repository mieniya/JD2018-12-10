package by.it.dziomin.jd01_08;

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
    public Var add(Var other) {
        if (other instanceof Scalar) {
            double result = this.value + ((Scalar) other).value;
            return new Scalar(result);
        }
        return other.add(this);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar) {
            double result = this.value - ((Scalar) other).value;
            return new Scalar(result);
        }
        // other Vector or Matrix
        Scalar minus = new Scalar(-1);
        return other.add(this);
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar) {
            double result = this.value * ((Scalar) other).value;
            return new Scalar(result);
        }
        Scalar minus = new Scalar(-1);
        return other.add(this);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar) {
            double result = this.value / ((Scalar) other).value;
            return new Scalar(result);
        }
        Scalar minus = new Scalar(-1);
        return other.add(this);

    }
}
