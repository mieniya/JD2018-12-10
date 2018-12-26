package by.it.moroz.jd01_07;

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
