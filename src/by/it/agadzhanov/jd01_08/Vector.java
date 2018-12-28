package by.it.agadzhanov.jd01_08;

import java.util.Arrays;

class Vector extends Var {

    private double[] value;

    Vector(double[] value) {
        this.value = value;
    }

    Vector(Vector vector) {
        this.value = vector.value;
    }

    Vector(String strVector) {
        strVector = strVector.replaceAll("[{]", " ");
        strVector = strVector.replaceAll("[}]", " ");
        strVector = strVector.replaceAll("[,]", " ");
        strVector = strVector.trim();
        String[] stringMas = strVector.split(" ");
        double[] doubleMas = new double[stringMas.length];
        for (int i = 0; i < doubleMas.length; i++) {
            doubleMas[i] = Double.parseDouble(stringMas[i]);
        }
        this.value = doubleMas;
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar) {
            double[] res= Arrays.copyOf(this.value,this.value.length);
            for (int i = 0; i < res.length; i++) {
                res[i]+=((Scalar) other).getValue();
            }
            return new Vector(res);
        }
        else if (other instanceof Vector) {
            if (this.value.length==((Vector) other).value.length) {
                double[] res= Arrays.copyOf(this.value,this.value.length);
                for (int i = 0; i < res.length; i++) {
                    res[i]+=((Vector) other).value[i];
                }
                return new Vector(res);
            }
        }
        return super.add(other);
    }

    @Override
    public Var sub(Var other) {
        return super.sub(other);
    }

    @Override
    public Var mul(Var other) {
        return super.mul(other);
    }

    @Override
    public Var div(Var other) {
        return super.div(other);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        String delimiter = "";
        for (double element : value) {
            sb.append(delimiter).append(element);
            delimiter = ", ";
        }
        sb.append("}");
        return sb.toString();
    }
}
