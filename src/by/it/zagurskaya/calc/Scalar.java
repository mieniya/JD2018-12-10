package by.it.zagurskaya.calc;

class Scalar extends Var {

//    Scalar(double value1) {
//        value = value1;
//    }

    // static private double valueStatic; - поле принадлещит классу, т.е. ВСЕ объекты класса Scalar имеют ОБЩЕЕ значение поля
    //  private double valueStatic; - поле принадлещит объекту(конкретному) класса, т.е. КАЖДЫЙ объект класса Scalar имеют СОБСТВЕННОЕ значение поля

    private double value;

    public double getValue() {
        return value;
    }

    Scalar(double value) {
        this.value = value;
    }

    Scalar(Scalar otherScalar) {
        value = otherScalar.value;
    }

    Scalar(String strValue) {
        value = Double.parseDouble(strValue);
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar) {
            double res = this.value + ((Scalar) other).value;
            return new Scalar(res);
        }
        return other.add(this);
        // other Vector or Matrix;
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar) {
            double res = this.value - ((Scalar) other).value;
            return new Scalar(res);
        }
        Scalar minus = new Scalar(-1);
        return other.add(this.mul(minus));
        // other Vector or Matrix;
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar) {
            double res = this.value /((Scalar) other).value;
            return new Scalar(res);
        }
        return super.div(other);
        // other Vector or Matrix;
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar) {
            double res = this.value * ((Scalar) other).value;
            return new Scalar(res);
        }
        return other.mul(this);
        // other Vector or Matrix;
    }

    @Override
    public String toString() {
        //return "какой-то скаляр";
        //return Double.toString(value);
        return String.valueOf(value);
    }
}
