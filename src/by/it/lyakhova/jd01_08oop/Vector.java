package by.it.lyakhova.jd01_08oop;

import java.util.Arrays;

public class Vector extends Var {
    private double[] value;

    public int getVectorSize(){return this.value.length;}

    public double getVectorElement(int i){return value[i];}

    Vector(double[] value){
        this.value = new double[value.length];
        System.arraycopy(value, 0, this.value, 0, value.length);
    }

    Vector(Vector vector){
        this.value = new double[vector.value.length];
       System.arraycopy(vector.value, 0, this.value, 0, vector.value.length);
    }

    Vector (String str){
        String[] val = str.replace("{","").replace("}", "").split(",\\s*");
        value = new double[val.length];
        for (int i = 0; i < value.length; i++) {
            value[i]= Double.parseDouble(val[i]);
        }
    }

    //panel output
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

//-------------------------------------------------------------------------------
    //Sum
    @Override
    public Var addCross(Scalar scalar) { return this.add(scalar); }
    @Override
    public Var addCross(Vector vector) { return this.add(vector); }
    @Override
    public Var addCross(Matrix matrix) { return super.add(matrix); }


    @Override
    public Var add(Var other){
        return other.addCross(this);
    }

    //vector + scalar
    public Var add(Scalar other) {
        double[] res = Arrays.copyOf(this.value, this.value.length);
        for (int i = 0; i < res.length; i++) {
            res[i]+=other.getValue();
        }
        return new Vector(res);
    }

    //vector + vector
    public Var add(Vector vector) {
        if (this.value.length == vector.value.length){
            double[] res = Arrays.copyOf(this.value, this.value.length);
            for (int i = 0; i < res.length; i++) {
                res[i]+= vector.value[i];
            }
            return new Vector(res);
        }
        return super.add(vector);
    }

//-------------------------------------------------------------------------------
    //Minus
    @Override
    public Var subCross(Scalar scalar) {
        Scalar minus = new Scalar(-1);
        return this.add(scalar.mul(minus));
    }
    @Override
    public Var subCross(Vector vector) { return vector.sub(this); }
    @Override
    public Var subCross(Matrix matrix) { return super.sub(matrix); }


    @Override
    public Var sub(Var other) { return other.subCross(this); }

    //Vector - Scalar
    public Var sub (Scalar other){
        double[] res = Arrays.copyOf(this.value, this.value.length);
        for (int i = 0; i < res.length; i++) {
            res[i]-=other.getValue();
        }
        return new Vector(res);
    }

    //Vector - Vector
    public Var sub (Vector other){
        if (this.value.length == ((Vector) other).value.length){
            double[] res = Arrays.copyOf(this.value, this.value.length);
            for (int i = 0; i < res.length; i++) {
                res[i]-= other.value[i];
            }
            return new Vector(res);
        }
        return super.sub(other);
    }

//---------------------------------------------------------------------------------
    //Multiplication
    @Override
    public Var mulCross(Scalar scalar) { return this.mul(scalar); }
    @Override
    public Var mulCross(Vector vector) { return vector.mul(this); }
    @Override
    public Var mulCross(Matrix matrix) { return matrix.mul(this); }

    @Override
    public Var mul(Var other) {
        return other.mulCross(this);
    }

    //Vector * Scalar
    public Var mul (Scalar other){
        double[] res = Arrays.copyOf(this.value, this.value.length);
        for (int i = 0; i < res.length; i++) {
            res[i]*=((Scalar) other).getValue();
        }
        return new Vector(res);
    }

    //Vector * Vector
    public Var mul (Vector other){
        if (this.value.length == ((Vector) other).value.length){
            double[] res = Arrays.copyOf(this.value, this.value.length);
            double sum = 0;
            for (int i = 0; i < res.length; i++) {
                sum+=res[i]*((Vector) other).value[i];
            }
            return new Scalar(sum);
        }
        return super.mul(other);
    }

//--------------------------------------------------------------------------------
    //Division
    @Override
    public Var divCross(Scalar scalar) { return this.div(scalar); }
    @Override
    public Var divCross(Vector vector) { return super.div(vector); }
    @Override
    public Var divCross(Matrix matrix) { return super.div(matrix); }

    @Override
    public Var div(Var other) {
        return other.divCross(this);
    }

    //Vector / Scalar
    public Var div (Scalar other){
        double[] res = Arrays.copyOf(this.value, this.value.length);
        for (int i = 0; i < res.length; i++) {
            res[i]/=other.getValue();
        }
        return new Vector(res);
    }

}
