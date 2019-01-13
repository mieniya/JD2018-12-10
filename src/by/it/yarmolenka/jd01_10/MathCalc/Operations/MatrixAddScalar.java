package by.it.yarmolenka.jd01_10.MathCalc.Operations;

import by.it.yarmolenka.jd01_10.MathCalc.Patterns;
import by.it.yarmolenka.jd01_10.MathCalc.Variables.*;

import java.util.Arrays;

class MatrixAddScalar {
    static Matrix matrixScalar(Var v1, Var v2) {
        Matrix m = new Matrix(v1.toString().matches(Patterns.MATRIX) ? v1.toString() : v2.toString());
        Scalar sc = new Scalar(v1.toString().matches(Patterns.SCALAR) ? v1.toString() : v2.toString());
        double[][] res = new double[m.value.length][m.value[0].length];
        for (int i = 0; i < res.length; i++) res[i] = Arrays.copyOf(m.value[i], m.value[i].length);

        for (int i = 0; i < res.length; i++)
            for (int j = 0; j < res[0].length; j++)
                res[i][j] += sc.value;
        return new Matrix(res);
    }
}
