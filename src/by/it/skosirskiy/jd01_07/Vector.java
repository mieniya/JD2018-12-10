package by.it.skosirskiy.jd01_07;

import java.util.Arrays;

class Vector extends Var {

    private double[] value;


    Vector(double[] value) {
        this.value = new double[value.length];
        System.arraycopy(value, 0, this.value, 0, value.length);
    }

     Vector(Vector vector) {
        this.value = vector.value;
    }



    Vector(String strVector){
        strVector=strVector.replaceAll("\\{","");
        strVector=strVector.replaceAll("\\}","");
        String[] buf=strVector.split(",");

        this.value= new double[buf.length] ;
        for (int i = 0; i < buf.length; i++) {
            value[i]=Double.parseDouble(buf[i]);
        }
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
