package by.it.yarmolenka.MathCalc_v1_severalCalcuations_singleBrackets_Exceptions.Operations.Muls;

import by.it.yarmolenka.MathCalc_v1_severalCalcuations_singleBrackets_Exceptions.Variables.*;

import java.util.Arrays;

public class MatrixMulScalar {
    public static Matrix matrixScalar(Matrix m, Scalar sc) {
        double[][] res = new double[m.value.length][m.value[0].length];

        for (int i = 0; i < res.length; i++)
            res[i]=Arrays.copyOf(m.value[i], m.value[i].length);

        for (int i = 0; i < res.length; i++)
            for (int j = 0; j < i; j++)
                res[i][j]*=sc.value;

        return new Matrix(res);
    }
}
