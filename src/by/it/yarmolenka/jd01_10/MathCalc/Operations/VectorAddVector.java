package by.it.yarmolenka.jd01_10.MathCalc.Operations;

import by.it.yarmolenka.jd01_10.MathCalc.Errors.ErrorAddOperation;
import by.it.yarmolenka.jd01_10.MathCalc.Variables.*;

class VectorAddVector {
    static Vector twoVector(Var var1, Var var2) {
        Vector v1 = new Vector(var1.toString());
        Vector v2 = new Vector(var2.toString());
        if (v1.value.length == v2.value.length) {
            double[] res = new double[v1.value.length];
            for (int i = 0; i < res.length; i++)
                res[i] += v1.value[i] + v2.value[i];
            return new Vector(res);
        } else ErrorAddOperation.sumVecVec();
        return null;
    }
}
