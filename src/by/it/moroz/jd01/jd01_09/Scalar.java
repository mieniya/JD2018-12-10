package by.it.moroz.jd01.jd01_09;

class Scalar extends Var {

    private double value;

    Scalar(double value) {
        this.value = value;
    }

    Scalar(Scalar scalar) {
        this.value = scalar.value;
    }

    Scalar(String strValue) {
        value = Double.parseDouble(strValue);
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar){
            double res = this.value+((Scalar) other).value;
            return new Scalar(res);
        }
        return other.add(this);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar){
            double res = this.value-((Scalar) other).value;
            return new Scalar(res);
        }
        Scalar minus = new Scalar(value-1);
        return other.add(this.mul(minus));
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar){
            double res = this.value*((Scalar) other).value;
            return new Scalar(res);
        }
        return other.mul(this);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar){
            double res = this.value/((Scalar) other).value;
            return new Scalar(res);
        }
        return other.div(this);
    }

    protected double getValue() {
        return value;
    }

    @Override
    public String toString() {
        return Double.toString(value);
        // return String.valueOf(value);
    }
}
