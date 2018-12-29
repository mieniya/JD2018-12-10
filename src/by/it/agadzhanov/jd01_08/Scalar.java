package by.it.agadzhanov.jd01_08;

class Scalar extends Var {

    private double value;

    public double getValue() {
        return value;
    }

    Scalar(double value) {
        this.value = value;
    }

    Scalar(String str) {
        this.value = Double.parseDouble(str);
    }

    Scalar(Scalar scalar) {
        this.value = scalar.value;
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar) {
            double res=this.value+((Scalar) other).value;
            return new Scalar(res);
        }
        return other.add(this);
        //other Vector or Matrix
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar) {
            double res=this.value-((Scalar) other).value;
            return new Scalar(res);
        }
        Scalar minus=new Scalar(-1);
        return other.add(this.mul((minus)));
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar) {
            double res=this.value*((Scalar) other).value;
            return new Scalar(res);
        }
        return other.mul(this);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar) {
            double res=this.value/((Scalar) other).value;
            return new Scalar(res);
        }
        return super.div(other);
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }
}
