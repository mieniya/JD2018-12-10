package by.it.lyakhova.jd01_07;

public class Vector extends Var {
    private double[] value;

    public Vector(double[] value){
        this.value = new double[value.length];
        System.arraycopy(value, 0, this.value, 0, value.length);
    }


    public Vector(Vector vector){
        this.value = new double[vector.value.length];
       System.arraycopy(vector.value, 0, this.value, 0, vector.value.length);
    }

    public Vector (String strVector){
        strVector = strVector.replaceAll("[{|}]", "");
        strVector = strVector.trim();
        String[] strArr = strVector.split(",");
        this.value = new double[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            this.value[i]=Double.parseDouble(strArr[i]);
        }


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
