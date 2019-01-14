package by.it.lyakhova.jd01_09;

public class Matrix extends Var {
    private double[][] value;

    Matrix(double[ ][ ] value) {
        this.value = new double[value.length][value[0].length];
        for (int i = 0; i < value.length; i++) {
            System.arraycopy(value[i], 0, this.value[i], 0, value[i].length);
        }

    }
    Matrix(Matrix matrix) {
        this.value = new double[matrix.value.length][matrix.value[0].length];
        for (int i = 0; i < matrix.value.length; i++) {
            System.arraycopy(matrix.value[i], 0, this.value[i], 0, matrix.value[i].length);
        }
    }

    Matrix(String strMatrix){

        String[] arr = strMatrix.split("},");

        for (int i = 0; i < arr.length; i++) {
            arr[i]=arr[i].replaceAll("[{|}]", "");
        }
        int numberCol = arr[0].split(",").length;
        String[][] matrix = new String[arr.length][numberCol];

        for (int j = 0; j < arr.length; j++) {
            matrix[j] = arr[j].split(",");
        }

        this.value = new double[arr.length][numberCol];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                this.value[i][j]= Double.parseDouble(matrix[i][j]);
            }
        }
    }


    @Override
    public Var add(Var other) {
        if (other instanceof Scalar){
            double[][] res = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < this.value.length; i++) {
                System.arraycopy(this.value[i], 0, res[i], 0, this.value[i].length);
            }
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[i].length; j++) {
                    res[i][j]+=((Scalar) other).getValue();
                }
            }
            return new Matrix(res);
        }
        else if (other instanceof Matrix){
            if (this.value.length == ((Matrix) other).value.length && this.value[0].length == ((Matrix) other).value[0].length){
                double[][] res = new double[this.value.length][this.value[0].length];
                for (int i = 0; i < this.value.length; i++) {
                    System.arraycopy(this.value[i], 0, res[i], 0, this.value[i].length);
                }
                for (int i = 0; i < res.length; i++) {
                    for (int j = 0; j < res[i].length; j++) {
                        res[i][j]+=((Matrix) other).value[i][j];
                    }
                }
                return new Matrix(res);
            }
        }
        return super.add(other);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar){
            double[][] res = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < this.value.length; i++) {
                System.arraycopy(this.value[i], 0, res[i], 0, this.value[i].length);
            }
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[i].length; j++) {
                    res[i][j]-=((Scalar) other).getValue();
                }
            }
            return new Matrix(res);
        }
        else if (other instanceof Matrix){
            if (this.value.length == ((Matrix) other).value.length && this.value[0].length == ((Matrix) other).value[0].length){
                double[][] res = new double[this.value.length][this.value[0].length];
                for (int i = 0; i < this.value.length; i++) {
                    System.arraycopy(this.value[i], 0, res[i], 0, this.value[i].length);
                }
                for (int i = 0; i < res.length; i++) {
                    for (int j = 0; j < res[i].length; j++) {
                        res[i][j]-=((Matrix) other).value[i][j];
                    }
                }
                return new Matrix(res);
            }
        }
        return super.sub(other);
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar){
            double[][] res = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < this.value.length; i++) {
                System.arraycopy(this.value[i], 0, res[i], 0, this.value[i].length);
            }
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[i].length; j++) {
                    res[i][j]*=((Scalar) other).getValue();
                }
            }
            return new Matrix(res);
        }
        else if (other instanceof Vector){
            if (this.value[0].length == ((Vector) other).getVectorSize()){
                double[] res = new double[this.value.length];
                for (int i = 0; i < res.length; i++) {
                    for (int j = 0; j < this.value[0].length; j++) {
                        res[i]+=this.value[i][j]*((Vector) other).getVectorElement(j);
                    }
                }
                return new Vector(res);
            }
        }
        else if (other instanceof Matrix){
            if (this.value[0].length == ((Matrix) other).value.length){
                double[][] res = new double[this.value.length][((Matrix) other).value[0].length];

                for (int i = 0; i < res.length; i++) {
                    for (int j = 0; j < res[i].length; j++) {
                        for (int k = 0; k < this.value[0].length; k++) {
                          res[i][j]+=this.value[i][k]*((Matrix) other).value[k][j];
                        }
                    }
                }
                return new Matrix(res);
            }
        }

        return super.mul(other);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar){
            double[][] res = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < this.value.length; i++) {
                System.arraycopy(this.value[i], 0, res[i], 0, this.value[i].length);
            }
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[i].length; j++) {
                    res[i][j]/=((Scalar) other).getValue();
                }
            }
            return new Matrix(res);
        }
        return super.div(other);
    }


    public String toString() {
        StringBuilder out = new StringBuilder("{");
        String bracket ="{";
        for (double[] row : value) {
            out.append(bracket);
            String delimiter="";
            for (double v: row) {
                out.append(delimiter).append(v);
                delimiter=", ";
            }
            out.append("}");
            bracket = ", {";

        }
        out.append("}");
        return out.toString();
    }
}
