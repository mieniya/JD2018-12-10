package by.it.lyakhova.jd01_07;

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
}
