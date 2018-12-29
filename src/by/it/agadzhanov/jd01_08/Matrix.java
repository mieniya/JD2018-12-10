package by.it.agadzhanov.jd01_08;

import java.util.Arrays;

class Matrix extends Var {

    private double[][] value;

    Matrix(double[][] value) {
        this.value = value;
    }

    Matrix(Matrix matrix) {
        this.value = matrix.value;
    }

    Matrix(String strMatrix) {
        strMatrix = strMatrix.replaceAll("[{]", " ");
        strMatrix = strMatrix.replaceAll("[}]", " ");
        strMatrix = strMatrix.trim();
        String[] strMatrixRows = strMatrix.split(" , ");

        //finding number of columns
        String[] exampleRow = strMatrixRows[0].split(",");
        int columnNumber = exampleRow.length;

        //filling the matrix with elements of double type
        double[][] matrixElements = new double[strMatrixRows.length][columnNumber];
        for (int i = 0; i < strMatrixRows.length; i++) {
            String[] rowMas = strMatrixRows[i].split(",");
            for (int j = 0; j < columnNumber; j++) {
                double[] doubleMas = new double[columnNumber];
                doubleMas[j] = Double.parseDouble(rowMas[j]);
                matrixElements[i][j] = doubleMas[j];
            }
        }
        this.value = matrixElements;
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar) {
            double[][] sum=new double[this.value.length][this.value[0].length];
            for (int i = 0; i < this.value.length; i++) {
                for (int j = 0; j < this.value[0].length; j++) {
                    sum[i][j]=this.value[i][j];
                }
            }
            for (int i = 0; i < this.value.length; i++) {
                for (int j = 0; j < this.value[0].length; j++) {
                    sum[i][j]=sum[i][j]+((Scalar) other).getValue();
                }
            }
            return new Matrix(sum);
        }
        else if (other instanceof Matrix) {
            if (this.value.length==((Matrix) other).value.length && this.value[0].length==((Matrix) other).value[0].length) {
                double[][] sum=new double[this.value.length][this.value[0].length];
                for (int i = 0; i < this.value.length; i++) {
                    for (int j = 0; j < this.value[0].length; j++) {
                        sum[i][j]=this.value[i][j];
                    }
                }
                for (int i = 0; i < this.value.length; i++) {
                    for (int j = 0; j < this.value[0].length; j++) {
                        sum[i][j]=sum[i][j]+((Matrix) other).value[i][j];
                    }
                }
                return new Matrix(sum);
            }
        }
        return super.add(other);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar) {
            double[][] sub=new double[this.value.length][this.value[0].length];
            for (int i = 0; i < this.value.length; i++) {
                for (int j = 0; j < this.value[0].length; j++) {
                    sub[i][j]=this.value[i][j];
                }
            }
            for (int i = 0; i < this.value.length; i++) {
                for (int j = 0; j < this.value[0].length; j++) {
                    sub[i][j]=sub[i][j]-((Scalar) other).getValue();
                }
            }
            return new Matrix(sub);
        }
        else if (other instanceof Matrix) {
            if (this.value.length==((Matrix) other).value.length && this.value[0].length==((Matrix) other).value[0].length) {
                double[][] sub=new double[this.value.length][this.value[0].length];
                for (int i = 0; i < this.value.length; i++) {
                    for (int j = 0; j < this.value[0].length; j++) {
                        sub[i][j]=this.value[i][j];
                    }
                }
                for (int i = 0; i < this.value.length; i++) {
                    for (int j = 0; j < this.value[0].length; j++) {
                        sub[i][j]=sub[i][j]-((Matrix) other).value[i][j];
                    }
                }
                return new Matrix(sub);
            }
        }
        return super.sub(other);
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar) {
            double[][] product=new double[this.value.length][this.value[0].length];
            for (int i = 0; i < this.value.length; i++) {
                for (int j = 0; j < this.value[0].length; j++) {
                    product[i][j]=this.value[i][j];
                }
            }
            for (int i = 0; i < this.value.length; i++) {
                for (int j = 0; j < this.value[0].length; j++) {
                    product[i][j]=product[i][j]*((Scalar) other).getValue();
                }
            }
            return new Matrix(product);
        }
        else if (other instanceof Vector) {
            if (this.value[0].length==((Vector) other).getValue().length) {
                double[] product=new double[this.value.length];
                for (int i = 0; i < this.value.length; i++) {
                    for (int j = 0; j < this.value[0].length; j++) {
                        product[i]=product[i]+this.value[i][j]*((Vector) other).getValue()[j];
                    }
                }
                return new Vector(product);
            }
        }
        else if (other instanceof Matrix) {
            if (this.value[0].length==((Matrix) other).value.length) {
                double[][] product=new double[this.value.length][((Matrix) other).value[0].length];
                for (int i = 0; i < this.value.length; i++) {
                    for (int j = 0; j < ((Matrix) other).value[0].length; j++) {
                        for (int k = 0; k < this.value[0].length; k++) {
                            product[i][j]=product[i][j]+this.value[i][k]*((Matrix) other).value[k][j];
                        }
                    }
                }
                return new Matrix(product);
            }
        }
        return super.mul(other);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar) {
            double[][] div=new double[this.value.length][this.value[0].length];
            for (int i = 0; i < this.value.length; i++) {
                for (int j = 0; j < this.value[0].length; j++) {
                    div[i][j]=this.value[i][j];
                }
            }
            for (int i = 0; i < this.value.length; i++) {
                for (int j = 0; j < this.value[0].length; j++) {
                    div[i][j]=div[i][j]/((Scalar) other).getValue();
                }
            }
            return new Matrix(div);
        }
        return super.div(other);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{{");
        String delimiter = "";
        for (int i = 0; i < value.length; i++) {
            for (int j = 0; j < value[0].length; j++) {
                if (j == 0)
                    delimiter = "";
                sb.append(delimiter).append(value[i][j]);
                delimiter = ", ";
            }
            if (i <= value.length - 2) {
                sb.append("}, {");
            }
        }
        sb.append("}}");
        return sb.toString();
    }
}