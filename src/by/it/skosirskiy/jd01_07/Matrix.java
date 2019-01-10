package by.it.skosirskiy.jd01_07;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Matrix extends Var {

    private double[][] value;

     Matrix(double[][] value) {
        this.value = value;
    }
    Matrix(Matrix matrix1){

        this.value= matrix1.value;
    }

    Matrix(String str){
        Pattern pattern = Pattern.compile("[{][0-9 ,]*[}]");
        StringBuilder sb = new StringBuilder(str);
        Matcher matcher = pattern.matcher(sb);


        int kolrows = 0; //kolich simvolov
        while (matcher.find()) {
            kolrows++;
        }

        String[] newMatrix = str.replaceAll("[^,0-9]", "").split(",");
        int columns = newMatrix.length / kolrows; // shctchik elment v matrice
        this.value = new double[kolrows][columns];
        for (int k = 0; k < newMatrix.length; k++) {
            for (int i = 0; i < kolrows; i++) {
                for (int j = 0; j < columns; j++) {
                    value[i][j] = Double.parseDouble(newMatrix[k]);
                    k++;
                }
            }
        }

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
