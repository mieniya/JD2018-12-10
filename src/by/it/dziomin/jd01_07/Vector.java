package by.it.dziomin.jd01_07;


import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Vector extends Var {
    private double[] value;

    public Vector(double[] value) {
        this.value = Arrays.copyOf(value, value.length);
    }

    public Vector(Vector vector) {
        this.value = Arrays.copyOf(vector.getValue(), vector.getValue().length);
    }

    public Vector(String strVector) {
        Pattern pattern = Pattern.compile("[0-9.]{1,}");
        Matcher matcher = pattern.matcher(strVector);

        int count = 0;
        while (matcher.find()) {
            count++;
        }

        this.value = new double[count];
        matcher = pattern.matcher(strVector);

        int i = 0;
        while (matcher.find()) {
            this.value[i] = Double.parseDouble(matcher.group());
            i++;
        }
    }

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

    public double[] getValue() {
        return value;
    }

    public void setValue(double[] value) {
        this.value = value;
    }
}
