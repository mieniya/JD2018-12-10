package by.it.moroz.jd01_08;

import java.util.Arrays;

public class Vector extends Var {

    private double[] value;

    Vector(double[] value) {
        this.value = new double[value.length];
        System.arraycopy(value, 0, this.value, 0, value.length);
    }

    Vector(Vector vector) {
        this.value = vector.value;
    }

    Vector(String strVector) {
        String[] d = strVector.replaceAll("\\{","").replaceAll("\\}","").split(",");
        this.value = new double[d.length];
        for (int i = 0; i < d.length; i++) {
            value[i] = Double.parseDouble(d[i]);
        }
    }

    @Override
    public Var add(Var other) {
        if(other instanceof Scalar){
            double[] res = Arrays.copyOf(this.value, this.value.length);
            for (int i = 0; i < res.length; i++) {
                res[i]+=((Scalar)other).getValue();
            }
            return new Vector(res);
        }
        else if(other instanceof Vector){
            if(this.value.length==((Vector)other).value.length){
                double[] res = Arrays.copyOf(this.value, this.value.length);
                for (int i = 0; i < res.length; i++) {
                   // res[i]+=((Vector)other).value;
                }
            }
        }
        return super.add(other);
    }

    protected double[] getValue() {
        return value;
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder("{");
        String delimiter = "";
        for (double v : value) {
            out.append(delimiter).append(v);
            delimiter = ", ";
        }
        out.append("}");
        return out.toString();
    }
}
