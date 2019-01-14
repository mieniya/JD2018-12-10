package by.it.lyakhova.jd01_08oop;

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
//--------------------------------------------------------------------------------------------------------------------
    //Sum
    @Override
    public Var addCross(Scalar scalar) { return this.add(scalar); }
    @Override
    public Var addCross(Vector vector) { return this.add(vector); }
    @Override
    public Var addCross(Matrix matrix) { return this.add(matrix); }


    @Override
    public Var add(Var other) { return other.addCross(this); }

    //Matrix + Scalar
    public Var add (Scalar other){
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

    //Matrix + Matrix
    public Var add (Matrix other){
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
        return super.add(other);
    }

//------------------------------------------------------------------------------------------------------------------
    //Minus
    @Override
    public Var subCross(Scalar scalar) {
        Scalar minus = new Scalar(-1);
        return this.add(scalar.mul(minus));
    }
    @Override
    public Var subCross(Vector vector) { return super.sub(vector); }
    @Override
    public Var subCross(Matrix matrix) { return matrix.sub(this); }

    @Override
    public Var sub(Var other) { return other.subCross(this); }

    //Matrix - Scalar
    public Var sub (Scalar other){
        double[][] res = new double[this.value.length][this.value[0].length];
        for (int i = 0; i < this.value.length; i++) {
            System.arraycopy(this.value[i], 0, res[i], 0, this.value[i].length);
        }
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[i].length; j++) {
                res[i][j]-=other.getValue();
            }
        }
        return new Matrix(res);
    }

    //Matrix - Matrix
    public Var sub (Matrix other){
        if (this.value.length == ((Matrix) other).value.length && this.value[0].length == ((Matrix) other).value[0].length) {
            double[][] res = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < this.value.length; i++) {
                System.arraycopy(this.value[i], 0, res[i], 0, this.value[i].length);
            }
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[i].length; j++) {
                    res[i][j] -= ((Matrix) other).value[i][j];
                }
            }
            return new Matrix(res);
        }

        return super.sub(other);
    }

//--------------------------------------------------------------------------------------------------------------------
    //Multiplication
    @Override
    public Var mulCross(Scalar scalar) { return this.mul(scalar); }
    @Override
    public Var mulCross(Vector vector) { return super.mul(vector); }
    @Override
    public Var mulCross(Matrix matrix) { return matrix.mul(this); }

    @Override
    public Var mul(Var other) {
        return other.mulCross(this);
    }

    //Matrix * Scalar
    public Var mul (Scalar other){
        double[][] res = new double[this.value.length][this.value[0].length];
        for (int i = 0; i < this.value.length; i++) {
            System.arraycopy(this.value[i], 0, res[i], 0, this.value[i].length);
        }
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[i].length; j++) {
                res[i][j]*= other.getValue();
            }
        }
        return new Matrix(res);
    }

    //Matrix * Vector
    public Var mul (Vector other){
        if (this.value[0].length == ((Vector) other).getVectorSize()){
            double[] res = new double[this.value.length];
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < this.value[0].length; j++) {
                    res[i]+=this.value[i][j]* other.getVectorElement(j);
                }
            }
            return new Vector(res);
        }
        return super.mul(other);
    }

    //Matrix * Matrix
    public Var mul (Matrix other){
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
        return super.mul(other);
    }

//-------------------------------------------------------------------------------------------------------------------
    //Division
    @Override
    public Var divCross(Scalar scalar) { return this.div(scalar); }
    @Override
    public Var divCross(Vector vector) { return super.div(vector); }
    @Override
    public Var divCross(Matrix matrix) { return super.div(matrix); }

    @Override
    public Var div(Var other) { return other.divCross(this); }

    //Matrix / Scalar
    public Var div (Scalar other){
        double[][] res = new double[this.value.length][this.value[0].length];
        for (int i = 0; i < this.value.length; i++) {
            System.arraycopy(this.value[i], 0, res[i], 0, this.value[i].length);
        }
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[i].length; j++) {
                res[i][j]/=other.getValue();
            }
        }
        return new Matrix(res);
    }
}
