package by.it.kushnerov.jd01_08;

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
            double[] res = this.value;
            for (int i = 0; i < res.length; i++) {
//                res[i]+=((Scalar) other).getValue();
            }
            return new Vector(res);
        }
        else if (other instanceof Vector){
            if (this.value.length==((Vector) other).value.length){
                double[] res = Arrays.copyOf(this.value,this.value.length);
                for (int i = 0; i < res.length; i++) {
                    res[i]+=((Vector)other).value[i];
                }
            }
        }
        return other;
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
        StringBuilder out = new StringBuilder("{");
        String delimiter = "";
        for (double v : value) {
            out.append(delimiter).append(v);
            delimiter=", ";
        }
        out.append('}');
        return out.toString();
    }
}
