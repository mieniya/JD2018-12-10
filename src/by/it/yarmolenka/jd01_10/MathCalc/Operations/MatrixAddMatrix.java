package by.it.yarmolenka.jd01_10.MathCalc.Operations;

import by.it.yarmolenka.jd01_10.MathCalc.Errors.ErrorAddOperation;
import by.it.yarmolenka.jd01_10.MathCalc.Variables.*;

class MatrixAddMatrix {
    static Matrix twoMatrix(Var v1, Var v2) {
        Matrix m1 = new Matrix(v1.toString());
        Matrix m2 = new Matrix(v2.toString());
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
