package by.it.kushnerov.calc;

public class Matrix extends Var {
    private double[][] value;

    Matrix(double[][] value){
        this.value = new double[value.length][value[0].length];
        for (int i = 0; i < value.length; i++) {
               System.arraycopy(value[i],0,this.value[i],0,value[i].length);
        }
    }

    Matrix(Matrix otherMatrix){
        this.value = otherMatrix.value;
    }

    Matrix(String strMatrix){
        String[] strMas1 = strMatrix.split("},");
        for (int i = 0; i < strMas1.length; i++) {
            strMas1[i] = strMas1[i].replaceAll("[{}]","").trim();
        }
        this.value = new double[strMas1.length][];
        String[] strMas2;
        for (int i = 0; i < value.length; i++) {
            strMas2 = strMas1[i].split(",");
            value[i] = new double[strMas2.length];
            for (int j = 0; j < value[i].length; j++) {
                this.value[i][j] = Double.parseDouble(strMas2[j]);
            }
        }
    }

    @Override
    public String toString(){
        StringBuilder out = new StringBuilder("{{");
        String delimiter = "";
        for (int i = 0; i < value.length; i++) {
            for (int j = 0; j < value[i].length; j++) {
                out.append(delimiter).append(value[i][j]);
                delimiter=", ";
            }
            delimiter ="}, {";
        }
        out.append("}}");
        return out.toString();
    }

    @Override
    public Var add(Var other) throws CalcExeption {
        if (other instanceof Scalar) {
            double[][] res = new double[value.length][value[0].length];
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[0].length; j++) {
                    res[i][j] = value[i][j] + ((Scalar) other).getValue();
                }
            }
            return new Matrix(res);
        } else if (other instanceof Matrix) {
            if (value.length == ((Matrix) other).value.length || value[0].length == ((Matrix) other).value[0].length) {
                double[][] res = new double[value.length][value[0].length];
                for (int i = 0; i < res.length; i++) {
                    for (int j = 0; j < res[0].length; j++) {
                        res[i][j] = value[i][j] + ((Matrix) other).value[i][j];
                    }
                }
                return new Matrix(res);
            }
        }
        return super.add(other);
    }

    @Override
    public Var sub(Var other) throws CalcExeption {
        if (other instanceof Scalar) {
            Scalar minus = new Scalar(-1);
            return this.add(other.mul(minus));
        } else if (other instanceof Matrix) {
            if (value.length == ((Matrix) other).value.length || value[0].length == ((Matrix) other).value[0].length) {
                double[][] res = new double[value.length][value[0].length];
                for (int i = 0; i < res.length; i++) {
                    for (int j = 0; j < res.length; j++) {
                        res[i][j] = value[i][j] - ((Matrix) other).value[i][j];
                    }
                }
                return new Matrix(res);
            }
        }
        return super.sub(other);
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar) {
            double[][] res = new double[value.length][value[0].length];
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[0].length; j++) {
                    res[i][j] = value[i][j] * ((Scalar) other).getValue();
                }
            }
            return new Matrix(res);
        } else if (other instanceof Vector) {
            if (value.length == ((Vector) other).getValue().length) {
                double[] res = new double[value.length];
                for (int i = 0; i < value.length; i++) {
                    for (int j = 0; j < ((Vector) other).getValue().length; j++) {
                        res[i]+=value[i][j]*((Vector) other).getValue()[j];
                    }
                }
                return new Vector(res);
            }
        } else if(other instanceof Matrix){
            if(value.length == ((Matrix) other).value.length || value[0].length == ((Matrix) other).value[0].length){
                double[][]res = new double[value.length][value[0].length];
                for (int i = 0; i < value.length; i++) {
                    for (int j = 0; j < ((Matrix) other).value[0].length; j++) {
                        for (int k = 0; k < ((Matrix) other).value.length; k++) {
                            res[i][j]+=value[i][k]*((Matrix) other).value[k][j];
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
        if (other instanceof Scalar) {
            double[][] res = new double[value.length][value[0].length];
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[0].length; j++) {
                    res[i][j] = value[i][j] / ((Scalar) other).getValue();
                }
            }
            return new Matrix(res);
        }
        return super.div(other);
    }
}
