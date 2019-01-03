package by.it.subach.jd01_08;


import by.it.subach.jd01_08.Var;

import java.util.Arrays;

class Matrix extends Var {
    private double[][] value;

    Matrix(double[][] value) {
        this.value = new double[value.length][value[0].length];
        for (int i = 0; i < value.length; i++) {
            System.arraycopy(value[i], 0, this.value[i], 0, value[i].length);
        }

//        this.value = Arrays.copyOf(value, value.length);
//        this.value = value;
    }

    Matrix(Matrix matrix) {
        value = Arrays.copyOf(matrix.value, matrix.value.length);
//        this.value = new double[matrix.value.length][];
//        System.arraycopy(matrix.value, 0, this.value, 0, this.value.length);
    }

    Matrix(String strMatrix) {
        String[] lines = strMatrix.split("},");
        for (int i = 0; i < lines.length; i++) {
            lines[i] = lines[i].replace('}', ' ').replace('{', ' ').trim();
        }
        this.value = new double[lines.length][];
        for (int i = 0; i < value.length; i++) {
            String[] col = lines[i].split(",");
            this.value[i] = new double[col.length];
            for (int j = 0; j < value[i].length; j++) {
                value[i][j] = Double.parseDouble(col[j]);
            }
        }

    }

    @Override
    public Var add(Var other) {

        if (other instanceof Matrix) {
            if (this.value.length == ((Matrix) other).value.length &&
                    this.value[0].length == ((Matrix) other).value[0].length) {
                double[][] res = Arrays.copyOf(this.value, this.value.length);
                for (int i = 0; i < res.length; i++) {
                    for (int j = 0; j < res.length; j++) {
                        res[i][j] += ((Matrix) other).value[i][j];
                    }
                }
                return new Matrix(res);
            }
        }
        if (other instanceof Scalar) {
            double res[][] = Arrays.copyOf(this.value, this.value.length);
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res.length; j++) {
                    res[i][j] += ((Scalar) other).getValue();
                }
            }
            return new Matrix(res);
        }


        return super.add(other);
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder("{");
        String delimiter = "";
        for (int i = 0; i < value.length; i++) {
            out.append("{");
            for (int j = 0; j < value[i].length; j++) {
                out.append(delimiter).append(value[i][j]);
                delimiter = ", ";
            }
            if (i == value.length - 1) {
                out.append("}");
            } else {
                out.append("}, ");
                delimiter = "";
            }
        }
        out.append("}");
        return out.toString();
    }
}
