package by.it.lyakhova.jd01_08;

import java.util.Arrays;

public class Vector extends Var {
    private double[] value;

    public int getVectorSize(){return this.value.length;}

    public double getVectorElement(int i){return value[i];}

    Vector(double[] value){
        this.value = new double[value.length];
        System.arraycopy(value, 0, this.value, 0, value.length);
    }

    Vector (String str){
        String[] val = str.replace("{","").replace("}", "").split(",\\s*");
                value = new double[val.length];
        for (int i = 0; i < value.length; i++) {
            value[i]= Double.parseDouble(val[i]);
        }
    }

    Vector(Vector vector){
        this.value = new double[vector.value.length];
       System.arraycopy(vector.value, 0, this.value, 0, vector.value.length);
    }

    /*public Vector (String strVector){
        strVector = strVector.replaceAll("[{|}]", "");
        strVector = strVector.trim();
        String[] strArr = strVector.split(",");
        this.value = new double[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            this.value[i]=Double.parseDouble(strArr[i]);
        }
    }*/

    @Override
    public Var add(Var other) {
        if(other instanceof Scalar){
            double[] res = Arrays.copyOf(this.value, this.value.length);
            for (int i = 0; i < res.length; i++) {
                res[i]+=((Scalar) other).getValue();
            }
            return new Vector(res);
        }
        else if (other instanceof Vector){
            if(this.value.length == ((Vector) other).value.length){
                double[] res = Arrays.copyOf(this.value, this.value.length);
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
        if (other instanceof Scalar){
            double[] res = Arrays.copyOf(this.value, this.value.length);
            for (int i = 0; i < res.length; i++) {
                res[i]-=((Scalar)other).getValue();
            }
            return new Vector(res);
        }
        else if (other instanceof Vector){
            if (this.value.length == ((Vector) other).value.length){
                double[] res = Arrays.copyOf(this.value, this.value.length);
                for (int i = 0; i < res.length; i++) {
                    res[i]-=((Vector) other).value[i];
                }
                return new Vector(res);
            }
        }
        return super.sub(other);
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar){
            double[] res = Arrays.copyOf(this.value, this.value.length);
            for (int i = 0; i < res.length; i++) {
                res[i]*=((Scalar) other).getValue();
            }
            return new Vector(res);
        }
        else if (other instanceof Vector){
            if (this.value.length == ((Vector) other).value.length){
                double[] res = Arrays.copyOf(this.value, this.value.length);
                double sum = 0;
                for (int i = 0; i < res.length; i++) {
                    sum+=res[i]*((Vector) other).value[i];
                }
                return new Scalar(sum);
            }
        }
        return super.mul(other);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar){
            double[] res = Arrays.copyOf(this.value, this.value.length);
            for (int i = 0; i < res.length; i++) {
                res[i]/=((Scalar) other).getValue();
            }
            return new Vector(res);
        }
        return super.div(other);
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder("{");
        String delimiter="";
        for (double v :
                value) {
            out.append(delimiter).append(v);
            delimiter=", ";
        }
        out.append("}");
        return out.toString();
    }
}
