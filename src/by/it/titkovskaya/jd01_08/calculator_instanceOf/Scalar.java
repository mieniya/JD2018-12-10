package by.it.titkovskaya.jd01_08.calculator_instanceOf;

public class Scalar extends Var {

    public double getValue() {
        return value;
    }

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
    public Var add(Var other) {
        return other.addCross(this);
    }

    @Override
    public Var addCross(Scalar other) {
        double result = this.value + other.value;
        return new Scalar(result);
    }

    @Override
    public Var addCross(Vector other) {
        return other.add(this);
    }

    @Override
    public Var addCross(Matrix other) {
        return other.add(this);
    }


    @Override
    public Var sub(Var other) {
        return other.subCross(this);
    }

    @Override
    public Var subCross(Scalar other) {
        double result = this.value - other.value;
        return new Scalar(result);
    }

    @Override
    public Var subCross(Vector other) {
        Scalar minus = new Scalar(-1);
        return other.add(this.mul(minus));
    }

    @Override
    public Var subCross(Matrix other) {
        Scalar minus = new Scalar(-1);
        return other.add(this.mul(minus));
    }


    @Override
    public Var mul(Var other) {
        return other.mulCross(this);
    }

    @Override
    public Var mulCross(Scalar other) {
        double result = this.value * other.value;
        return new Scalar(result);
    }

    @Override
    public Var mulCross(Vector other) {
        return other.mul(this);
    }

    @Override
    public Var mulCross(Matrix other) {
        return other.mul(this);
    }


    @Override
    public Var div(Var other) {
        return other.divCross(this);
    }

    @Override
    public Var divCross(Scalar other) {
        double result = this.value / other.value;
        return new Scalar(result);
    }

    @Override
    public Var divCross(Vector other) {
        return super.div(other);
    }

    @Override
    public Var divCross(Matrix other) {
        return super.div(other);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}