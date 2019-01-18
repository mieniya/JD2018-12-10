package by.it.yarmolenka.jd01_10.MathCalc.Operations.Muls;

import by.it.yarmolenka.jd01_10.MathCalc.Errors.ErrorMulOperation;
import by.it.yarmolenka.jd01_10.MathCalc.Variables.*;

public class MatrixMulVector {
    public static Vector matrixVector(Matrix m, Vector v) {
        if (m.value[0].length == v.value.length){
            double[] res = new double[m.value.length];
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j<m.value[0].length;j++){
                    res[i]+=m.value[i][j]*v.value[j];
                }
            }
            return new Vector(res);
        } else {
            ErrorMulOperation.mulMatVec();
            return null;
        }
    }
}
