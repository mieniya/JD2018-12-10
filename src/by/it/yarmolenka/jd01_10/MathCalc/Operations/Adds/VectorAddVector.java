package by.it.yarmolenka.jd01_10.MathCalc.Operations.Adds;

import by.it.yarmolenka.jd01_10.MathCalc.Errors.ErrorAddOperation;
import by.it.yarmolenka.jd01_10.MathCalc.Variables.*;

public class VectorAddVector {
    public static Vector vectorVector(Vector v1, Vector v2) {
        if (v1.value.length == v2.value.length) {
            double[] res = new double[v1.value.length];
            for (int i = 0; i < res.length; i++)
                res[i] += v1.value[i] + v2.value[i];
            return new Vector(res);
        } else ErrorAddOperation.sumVecVec();
        return null;
    }
}
