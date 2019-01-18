package by.it.yarmolenka.jd01_10.MathCalc.Operations.Muls;

import by.it.yarmolenka.jd01_10.MathCalc.Errors.ErrorMulOperation;
import by.it.yarmolenka.jd01_10.MathCalc.Variables.Matrix;

public class MatrixMulMatrix {
    public static Matrix matrixMatrix(Matrix mat1, Matrix mat2) {
        if (mat1.value[0].length == mat2.value.length) {
            double[][] res = new double[mat1.value.length][mat2.value[0].length];
            for (int i = 0; i < res.length; i++)
                for (int j = 0; j < res[i].length; j++)
                    for (int k = 0; k < mat1.value[0].length; k++)
                        res[i][j] += mat1.value[i][k] * mat2.value[k][j];
            return new Matrix(res);
        } else {
            ErrorMulOperation.mulMatMat();
            return null;
        }
    }
}
