package by.it.subach.jd01_08;


import by.it.subach.jd01_08.Var;

class Matrix extends Var {
    private double [][] value;

    Matrix(double [][] value){
        this.value = value;
    }

    Matrix(Matrix matrix){
        value = matrix.value;
    }

    Matrix(String strMatrix){
        String [] lines = strMatrix.split("},");
        for (int i = 0; i < lines.length; i++) {
            lines[i] = lines[i].replace('}', ' ').replace('{', ' ').trim();
        }
        value = new double[lines.length][];
        for (int i = 0; i < value.length; i++) {
            String [] col = lines[i].split(",");
            value[i] = new double[col.length];
            for (int j = 0; j < value[i].length; j++) {
                value[i][j] = Double.parseDouble(col[j]);
            }
        }

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
            if(i == value.length-1){
                out.append("}");
            }
            else {
                out.append("}, ");
                delimiter = "";
            }
        }
        out.append("}");
        return out.toString();
    }
}
