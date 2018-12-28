package by.it.zagurskaya.jd01_08;

public class Matrix extends by.it.zagurskaya.jd01_08.Var {

    private double[][] value;// поле объекта класса Matrix

    public Matrix(double[][] value /* локальная переменная конструктора (метода) */) {
        this.value = value;
    }

    public Matrix(Matrix matrix) {
        value = matrix.value;
    }

    public Matrix(String strMatrix) {
        int k = 0;
        String[] strings /* локальная переменная */ = strMatrix.replace(" ", "")
                .replace("{{", "")
                .replace("}}", "")
                .split("},\\{");

        value = new double[strings.length][];

        for (int i = 0; i < strings.length; i++) {
            String secondLevel = strings[i];
            String[] valueStringArray = secondLevel.split(",");
            double[] doubles = new double[valueStringArray.length];
            for (int j = 0; j < valueStringArray.length; j++) {
                double v = Double.parseDouble(valueStringArray[j]);
                doubles[j] = v;
            }
            value[i] = doubles;
        }
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder("{");
        String delimiteri = "";
        String delimiterj = "";
        for (int i = 0; i < value.length; i++) {
            out.append(delimiteri).append('{');
            delimiterj = "";
            for (int j = 0; j < value[i].length; j++) {
                out.append(delimiterj).append(value[i][j]);
                delimiterj = ", ";
            }
            out.append('}');
            delimiteri = ", ";
        }
        out.append('}');

        return out.toString();
    }
}
