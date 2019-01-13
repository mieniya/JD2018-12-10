package by.it.yarmolenka.jd01_10.MathCalc.Operations.Adds;

import by.it.yarmolenka.jd01_10.MathCalc.Errors.ErrorAddOperation;
import by.it.yarmolenka.jd01_10.MathCalc.Variables.*;

public class MatrixAddMatrix {
    public static Matrix matrixMatrix(Matrix m1, Matrix m2) {
        if (m1.value.length == m2.value.length && m1.value[0].length == m2.value[0].length){
            double[][] res = new double[m1.value.length][m1.value[0].length];
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[0].length; j++) {
                    res[i][j] = m1.value[i][j] + m2.value[i][j];
                }
            }
            return new Matrix(res);
        } else ErrorAddOperation.sumMatMat(); return null;
    }
}
