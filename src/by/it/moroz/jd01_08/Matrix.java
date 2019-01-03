package by.it.moroz.jd01_08;

public class Matrix extends Var {

    private double[][] value;

    public Matrix(double[][] value) {
        //this.value = new double[value.length][value.length];
        /*for (int i = 0; i < value.length; i++) {
            for (int j = 0; j < value.length; j++) {
                System.arraycopy(value[i][j], 0, this.value[i][j], 0, value[i].length);
            }
        }*/
        this.value = value.clone();
    }

    public Matrix(Matrix matrix) {
        this.value = matrix.value;
    }

    public Matrix(String strMatrix) {
        strMatrix = strMatrix.replaceAll("\\{", "");
        strMatrix = strMatrix.substring(0, strMatrix.length() - 2);
        String[] row = strMatrix.split("},");
        String[][] str1 = new String[row.length][row.length];
        for (int i = 0; i < row.length; i++) {
            row[i] = row[i].trim();
            String single_int[] = row[i].split(",");
            for (int j = 0; j < single_int.length; j++) {
                str1[i][j] = single_int[j];
            }
        }
        this.value = new double[str1.length][str1[0].length];
        for (int i = 0; i < str1.length; i++) {
            for (int j = 0; j < str1[0].length; j++) {
                value[i][j] = Double.parseDouble(str1[i][j]);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder("{{");
        String delimiter = "";
        for (int i = 0; i < value.length; i++) {
            for (int j = 0; j < value[0].length; j++) {
                out.append(delimiter).append(value[i][j]);
                delimiter = ", ";
            }
            delimiter="}, {";
        }
        out.append("}}");
        return out.toString();
    }
}
