package by.it.yarmolenka.jd01_10.MathCalc.Operations.Muls;

import by.it.yarmolenka.jd01_10.MathCalc.Errors.ErrorMulOperation;
import by.it.yarmolenka.jd01_10.MathCalc.Variables.*;

public class VectorMulVector {
    public static Scalar vectorVector(Vector vec1, Vector vec2) {
        if (vec1.value.length == vec2.value.length) {
            double res = 0;
            for (int i = 0; i < vec1.value.length; i++) {
                res += vec1.value[i] * vec2.value[i];
            }
            return new Scalar(res);
        } else{
            ErrorMulOperation.mulVecVec();
            return null;
        }
    }
}
