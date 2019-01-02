package by.it.subach.jd01_08;

import by.it.subach.jd01_08.Var;

import java.util.Arrays;

public class Vector extends Var{

    public double[] getValue() {
        return value;
    }

    private double [] value;


    public Vector (double [] value){
        this.value = new double[value.length];
        System.arraycopy(value, 0, this.value, 0, value.length);
    }

    Vector (Vector vector){
        value = vector.value;
    }

    Vector(String strVector){
        strVector = strVector.replace('{', ' ').replace('}', ' ').trim();
        String [] str = strVector.split(",");
        this.value = new double[str.length];
        for (int i = 0; i < value.length; i++) {
            value[i] = Double.parseDouble(str[i]);
        }
    }

    @Override
    public Var add(Var other) {
        if(other instanceof Scalar){
            double []res = Arrays.copyOf(this.value, this.value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] += ((Scalar) other).getValue();
            }
            return new Vector(res);
        }
        else if(other instanceof Vector){
            if(this.value.length == ((Vector)other).value.length){
                double[]res = Arrays.copyOf(this.value, this.value.length);
                for (int i = 0; i < res.length; i++) {
                    res[i] += ((Vector)other).value[i];
                }
                return new Vector(res);
            }
        }
        return other.add(this);
    }

//    @Override
//    public Var sub(Var other){
//        if(other instanceof Scalar){
//            double [] res = Arrays.copyOf(this.value, this.value.length);
//            for (int i = 0; i < res.length; i++) {
//                res[i] += ((Scalar) other).getValue();
//            }
//            return new Vector(res);
//        }
//
//    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder("{");
        String delimiter = "";
        for (double v : value) {
            out.append(delimiter).append(v);
            delimiter = ", ";
        }

        out.append('}');
        return out.toString();
    }




}
