package by.it.titkovskaya.jd01_08.calculator_instanceOf;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Matrix extends Var {

    private double[][] value;

    Matrix(double[][] value) {
        this.value = value;
    }

    Matrix(Matrix otherMatrix) {
        this.value = otherMatrix.value;
    }

    public Matrix(String strMatrix) {
        Pattern pattern = Pattern.compile("[{][0-9., ]+[}]");
        StringBuilder sb = new StringBuilder(strMatrix);
        Matcher matcher = pattern.matcher(sb);
        int rowsQuantity = 0;
        while (matcher.find()) {
            rowsQuantity++;
        }
        String[] newMatrix = strMatrix.replaceAll("[^.,0-9]", "").split(",");
        int columnsQuantity = newMatrix.length / rowsQuantity;
        this.value = new double[rowsQuantity][columnsQuantity];
        for (int k = 0; k < newMatrix.length; k++) {
            for (int i = 0; i < rowsQuantity; i++) {
                for (int j = 0; j < columnsQuantity; j++) {
                    value[i][j] = Double.parseDouble(newMatrix[k]);
                    k++;
                }
            }
        }
    }

    @Override
    public Var add(Var other) {
        return other.addCross(this);
    }

    @Override
    public Var addCross(Scalar other) {
        double[][] res = new double[this.value.length][this.value[0].length];
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                res[i][j] = this.value[i][j] + other.getValue();
            }
        }
        return new Matrix(res);
    }

    @Override
    public Var addCross(Vector other) {
        return super.addCross(other);
    }

    @Override
    public Var addCross(Matrix other) {
        if (this.value.length == other.value.length && this.value[0].length == other.value[0].length) {
            double[][] res = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[0].length; j++) {
                    res[i][j] = this.value[i][j] + other.value[i][j];
                }
            }
            return new Matrix(res);
        }
        return super.add(other);
    }

    @Override
    public Var sub(Var other) {
        return other.subCross(this);
    }

    @Override
    public Var subCross(Scalar other) {
        double[][] res = new double[this.value.length][this.value[0].length];
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                res[i][j] = this.value[i][j] - other.getValue();
            }
        }
        return new Matrix(res);
    }

    @Override
    public Var subCross(Vector other) {
        return super.subCross(other);
    }

    @Override
    public Var subCross(Matrix other) {
        if (this.value.length == other.value.length && this.value[0].length == other.value[0].length) {
            double[][] res = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[0].length; j++) {
                    res[i][j] = this.value[i][j] - other.value[i][j];
                }
            }
            return new Matrix(res);
        }
        return super.sub(other);
    }


    @Override
    public Var mul(Var other) {
        return other.divCross(this);
    }

    @Override
    public Var mulCross(Scalar other) {
        double[][] res = new double[this.value.length][this.value[0].length];
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                res[i][j] = this.value[i][j] * other.getValue();
            }
        }
        return new Matrix(res);
    }

    @Override
    public Var mulCross(Vector other) {
        if (this.value[0].length == other.getValue().length) {
            double[] res = new double[other.getValue().length];
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < other.getValue().length; j++) {
                    res[i] = res[i] + this.value[i][j] * other.getValue()[j];
                }
            }
            return new Vector(res);
        }
        return super.mul(other);
    }

    @Override
    public Var mulCross(Matrix other) {
        if (this.value.length == other.value.length && this.value[0].length == other.value[0].length) {
            double[][] res = new double[value.length][other.value[0].length];
            for (int i = 0; i < value.length; i++) {
                for (int j = 0; j < other.value[0].length; j++) {
                    for (int k = 0; k < other.value.length; k++) {
                        res[i][j] = res[i][j] + this.value[i][k] * other.value[k][j];
                    }
                }
            }
            return new Matrix(res);
        }
        return super.mulCross(other);
    }

    @Override
    public Var div(Var other) {
        return super.div(other);
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder("{{");
        String delimiter = "";
        for (double[] doubles : value) {
            for (double v : doubles) {
                out.append(delimiter).append(v);
                delimiter = ", ";
            }
            delimiter = "}, {";
        }
        out.append("}}");
        return out.toString();
    }
}
