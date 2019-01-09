package by.it.subach.jd01_09;


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
//        value = Arrays.copyOf(matrix.value, matrix.value.length);
//        this.value = new double[matrix.value.length][];
//        System.arraycopy(matrix.value, 0, this.value, 0, this.value.length);
        this.value = matrix.value;
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
                double[][] res = Arrays.copyOf(((Matrix) other).value, ((Matrix) other).value.length);
                for (int i = 0; i < res.length; i++) {
                    for (int j = 0; j < res.length; j++) {
                        res[i][j] += this.value[i][j];
                    }
                }
                return new Matrix(res);
            }
        } else if (other instanceof Scalar) {
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
    public Var sub(Var other) {
        Scalar minus = new Scalar(-1);
        if (other instanceof Scalar) {
            return this.add(other.mul(minus));
        }
        if (other instanceof Matrix) {
            return this.add(other.mul(minus));
        }
        return super.sub(other);
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar) {
            double[][] res = Arrays.copyOf(this.value, this.value.length);
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[i].length; j++) {
                    res[i][j] *= ((Scalar) other).getValue();
                }
            }
            return new Matrix(res);
        }

        if (other instanceof Vector) {
            int vectorLength = ((Vector) other).getValue().length;
            if (this.value.length == vectorLength) {
                double[] res = new double[vectorLength];
                for (int i = 0; i < value.length; i++) {
                    for (int j = 0; j < value.length; j++) {
                        res[i] += value[i][j] * ((Vector) other).getValue()[j];
                    }
                }
                return new Vector(res);
            }
        }

        if (other instanceof Matrix) {
            if (this.value[0].length == ((Matrix) other).value.length) {
                double[][] res = new double[this.value.length][((Matrix) other).value[0].length];
                for (int i = 0; i < this.value.length; i++) {
                    for (int j = 0; j < ((Matrix) other).value.length; j++) {
                        double sum = 0;
                        for (int k = 0; k < ((Matrix) other).value[j].length; k++) {
                            sum += this.value[i][k] * ((Matrix) other).value[k][j];
                        }
                        res[i][j] = sum;
                    }
                }
                return new Matrix(res);
            }
        }

        return super.mul(other);
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
