package by.it.zagurskaya.jd01_07;


public class Vector extends Var {
    private double[] value;

    public Vector(double[] value) {
        this.value = new double[value.length];
        System.arraycopy(value, 0, this.value, 0, value.length);
    }

    public Vector(Vector otherVector) {
        this.value = new double[otherVector.value.length];
        System.arraycopy(otherVector.value, 0, value, 0, value.length);
    }


    public Vector(String strVector) {
        String[] strings = strVector.replace("{", "").replace("}", "").split(",");
        this.value = new double[strings.length];
        for (int i = 0; i < value.length; i++) {
            this.value[i] = Double.parseDouble(strings[i]);
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
        out.append('}');
        return out.toString();
    }
}
