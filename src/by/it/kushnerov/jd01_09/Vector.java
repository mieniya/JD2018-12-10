package by.it.kushnerov.jd01_09;

import java.util.Arrays;

public class Vector extends Var {

    private double[] value;

    Vector(double[] value) {
        this.value = new double[value.length];
        System.arraycopy(value,0,this.value,0,value.length);
    }

    Vector(Vector otherVector){
        this.value = otherVector.value;
    }

    Vector(String strVector){
        strVector = strVector.replaceAll("[{}]","").trim();
        String[] strMas = strVector.split(",");
        this.value = new double[strMas.length];
        for (int i = 0; i < strMas.length; i++) {
            this.value[i] = Double.parseDouble(strMas[i]);
        }
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar){
            double[] res = Arrays.copyOf(value,value.length);
            for (int i = 0; i < res.length; i++) {
                res[i]+=((Scalar) other).getValue();
            }
            return new Vector(res);
        }
        else if (other instanceof Vector){
            if (this.value.length==((Vector) other).value.length){
                double[] res = Arrays.copyOf(this.value,this.value.length);
                for (int i = 0; i < res.length; i++) {
                    res[i]+=((Vector)other).value[i];
                }
                return new Vector(res);
            }
        }
        return super.add(other);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar){
            double[] res = Arrays.copyOf(value,value.length);
            for (int i = 0; i < res.length; i++) {
                res[i]-=((Scalar) other).getValue();
            }
            return new Vector(res);
        }
        else if (other instanceof Vector){
            if (this.value.length==((Vector) other).value.length){
                double[] res = Arrays.copyOf(this.value,this.value.length);
                for (int i = 0; i < res.length; i++) {
                    res[i]-=((Vector)other).value[i];
                }
                return new Vector(res);
            }
        }
        return super.sub(other);
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar){
            double[] res = Arrays.copyOf(value,value.length);
            for (int i = 0; i < res.length; i++) {
                res[i]*=((Scalar) other).getValue();
            }
            return new Vector(res);
        } else if (other instanceof Vector){
            if (value.length == ((Vector) other).value.length){
                double sum = 0.0;
                double[] res = Arrays.copyOf(value,value.length);
                for (int i = 0; i < res.length; i++) {
                    sum += res[i] * ((Vector)other).value[i];
                }
                return new Scalar(sum);
            }
        }
        return super.mul(other);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar) {
            double[] res = Arrays.copyOf(this.value, this.value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] / ((Scalar) other).getValue();
            }
            return new Vector(res);
        }
        return super.div(other);
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder("{");
        String delimiter = "";
        for (double v : value) {
            out.append(delimiter).append(v);
            delimiter=", ";
        }
        out.append('}');
        return out.toString();
    }

    public double[] getValue(){
        return value;
    }
}
