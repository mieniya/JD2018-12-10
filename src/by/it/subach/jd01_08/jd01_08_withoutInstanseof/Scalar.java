package by.it.subach.jd01_08.jd01_08_withoutInstanseof;

import java.util.Arrays;

public class Scalar extends Var {

    public double getValue() {
        return value;
    }

    private double value;
//    Scalar minus = new Scalar(-1);

    Scalar(double value) {
        this.value = value;
    }

    Scalar(Scalar otherScalar) {
        this.value = otherScalar.value;

    }

    Scalar(String strValue) {
        value = Double.parseDouble(strValue);
    }

    @Override
    public Var add(Var other) {
        return other.add2(this);
    }

    @Override
    public Var sub(Var other) {
        return other.sub2(this);
    }

    @Override
    public Var mul(Var other) {
        return other.mul2(this);
    }

    @Override
    public Var div(Var other) {
        return other.div2(this);
    }


    //    -------------------Scalar add2()---------------------------//

//    Scalar + Scalar
    @Override
    public Var add2(Scalar other) {
        return new Scalar(other.getValue() + this.value);
    }

    //    Scalar + Vector
    @Override
    public Var add2(Vector other) {
        double[] res = Arrays.copyOf(other.getValue(), other.getValue().length);
        for (int i = 0; i < res.length; i++) {
            res[i] += this.value;
        }
        return new Vector(res);
    }

    //    Scalar + Matrix
    @Override
    public Var add2(Matrix other) {
        double[][] res = Arrays.copyOf(other.getValue(), other.getValue().length);
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[i].length; j++) {
                res[i][j] += this.getValue();
            }
        }
        return new Matrix(res);
    }


    //    -------------------Scalar sub2()---------------------------//
//    Scalar - Scalar
    @Override
    public Var sub2(Scalar other) {
        double res = other.value - this.value;
        return new Scalar(res);
    }


    //    Vector - Scalar
    @Override
    public Var sub2(Vector other) {
        double[] res = Arrays.copyOf(other.getValue(), other.getValue().length);
        for (int i = 0; i < res.length; i++) {
            res[i] -= this.getValue();
        }
        return new Vector(res);
    }


    //    Matrix - Scalar
    @Override
    public Var sub2(Matrix other) {
        Scalar minus = new Scalar(-1);
        return other.add(this.mul(minus));

    }


//    -------------------Scalar mul2()--------------------------//

    //    Scalar * Scalar
    @Override
    public Var mul2(Scalar other) {
        return new Scalar(other.getValue() * this.value);
    }

    //    Scalar * Vector
    @Override
    public Var mul2(Vector other) {
        double[] res = Arrays.copyOf(other.getValue(), other.getValue().length);
        for (int i = 0; i < res.length; i++) {
            res[i] *= this.value;
        }
        return new Vector(res);
    }

    //    Scalar * Matrix
    @Override
    public Var mul2(Matrix other) {
        double[][] res = Arrays.copyOf(other.getValue(), other.getValue().length);
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[i].length; j++) {
                res[i][j] *= this.value;
            }
        }
        return new Matrix(res);
    }


//    ------------------Scalar div2-----------------------------//

    //      Scalar / Scalar
    @Override
    public Var div2(Scalar other) {
        double res = other.getValue() / this.value;
        return new Scalar(res);

    }

    //    Vector / Scalar
    @Override
    public Var div2(Vector other) {
        double[] res = Arrays.copyOf(other.getValue(), other.getValue().length);
        for (int i = 0; i < res.length; i++) {
            res[i] /= this.getValue();
        }
        return new Vector(res);
    }

    //    Matrix / Scalar
    @Override
    public Var div2(Matrix other) {
        double[][] res = Arrays.copyOf(other.getValue(), other.getValue().length);
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[i].length; j++) {
                res[i][j] /= this.value;
            }
        }
        return new Matrix(res);
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }
}
