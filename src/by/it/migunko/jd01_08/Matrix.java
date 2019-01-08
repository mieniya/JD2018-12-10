package by.it.migunko.jd01_08;

public class Matrix extends Var{
    private double[][] value;

    public Matrix(double[][] value) {
        this.value = value;
    }

    public Matrix(Matrix matrix) {
        this.value = matrix.value;
    }
    public Matrix(String strMatrix){
        String[] strValues = strMatrix
                .replaceAll("\\{\\{|\\}\\}", "")
                .trim()
                .split("\\},\\s?\\{");//?
        String[] strValues1 = strValues[0]
                .trim()
                .split(",\\s?");
        value = new double[strValues.length][strValues.length];
        for (int i = 0; i < strValues.length; i++) {
            String[] matrix = strValues[i]
                    .trim()
                    .split(",\\s?");
            for (int j = 0; j < strValues.length; j++) {
                value[i][j] = Double.parseDouble(matrix[j]);
            }
        }
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Matrix) {
            double[][] matrix = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < this.value.length; i++) {
                for (int j = 0; j < this.value[i].length; j++) {
                    matrix[i][j] = this.value[i][j] + ((Matrix) other).value[i][j];
                }
            }
            return new Matrix(matrix);
        }
        else if (other instanceof Scalar) {
            double[][] matrix = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < this.value.length; i++) {
                for (int j = 0; j < this.value[i].length; j++) {
                    matrix[i][j] = this.value[i][j] + ((Scalar) other).getValue();
                }
            }
            return new Matrix(matrix);
        }
        else
            return super.add(other);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Matrix) {
            double[][] matrix = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < this.value.length; i++) {
                for (int j = 0; j < this.value[i].length; j++) {
                    matrix[i][j] = this.value[i][j] - ((Matrix) other).value[i][j];
                }
            }
            return new Matrix(matrix);
        }
        else if (other instanceof Scalar) {
            double[][] matrix = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < this.value.length; i++) {
                for (int j = 0; j < this.value[i].length; j++) {
                    matrix[i][j] = this.value[i][j] - ((Scalar) other).getValue();
                }
            }
            return new Matrix(matrix);
        }
        else
            return super.sub(other);
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Matrix){
            double[][] newMatrix = new double[this.value.length][((Matrix) other).value[0].length];
            for (int i = 0; i < this.value.length; i++) {
                for (int j = 0; j < ((Matrix) other).value[0].length; j++) {
                    for (int k = 0; k < ((Matrix) other).value.length; k++) {
                        newMatrix[i][j] += this.value[i][k]* ((Matrix) other).value[k][j];
                    }
                }
            }
            return new Matrix(newMatrix);
        }
        else if (other instanceof Scalar) {
            double[][] matrix = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < this.value.length; i++) {
                for (int j = 0; j < this.value[i].length; j++) {
                    matrix[i][j] = this.value[i][j] * ((Scalar) other).getValue();
                }
            }
            return new Matrix(matrix);
        }
        else if (other instanceof Vector) {
            double[] newMatrix = new double[this.value.length];
            for (int i = 0; i < this.value.length; i++ ) {
                for (int j = 0; j < ((Vector) other).getValue().length; j++) {
                    newMatrix[i] += this.value[i][j] * ((Vector) other).getValue()[j];
                }
            }
            return new Vector (newMatrix);
        }
        else
            return super.mul(other);
    }


    @Override
    public Var div(Var other) {
        if (other instanceof Scalar){
            double[][] matrix = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < this.value.length; i++) {
                for (int j = 0; j < this.value[i].length; j++) {
                    matrix[i][j] = this.value[i][j] / ((Scalar) other).getValue();
                }
            }
            return new Matrix(matrix);
        }
        else
            return super.div(other);
    }


}
