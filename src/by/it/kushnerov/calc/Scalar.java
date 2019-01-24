package by.it.kushnerov.calc;

public class Scalar extends Var {

    private double value;

    Scalar(double value) {
        this.value = value;
    }

    Scalar(Scalar otherScalar) {
        this.value = otherScalar.value;
    }

    Scalar(String strValue) {
        this.value = Double.parseDouble(strValue);
    }

    @Override
    public Var add(Var other) throws CalcExeption {
        if (other instanceof Scalar){
            double res = this.value + ((Scalar) other).value;
            return new Scalar(res);
        }
        return other.add(this);
        //other Vector or Matrix
    }

    @Override
    public Var sub(Var other) throws CalcExeption {
        if (other instanceof Scalar){
            double res = this.value - ((Scalar) other).value;
            return new Scalar(res);
        }
        Scalar minus = new Scalar(-1);
        return other.add(this.mul(minus));
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar){
            double res = this.value * ((Scalar) other).value;
            return new Scalar(res);
        }
        return other.mul(this);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar){
            double res = this.value / ((Scalar) other).value;
            return new Scalar(res);
        }
        return super.div(other);
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }

    public double getValue() {
        return value;
    }
}
