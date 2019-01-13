package by.it.yarmolenka.jd01_10.MathCalc.Operations;

import by.it.yarmolenka.jd01_10.MathCalc.Patterns;
import by.it.yarmolenka.jd01_10.MathCalc.Variables.*;

import java.util.Arrays;

class VectorAddScalar {
    static Vector vectorScalar(Var v1, Var v2) {
        Vector v = new Vector(v1.toString().matches(Patterns.VECTOR) ? v1.toString() : v2.toString());
        Scalar sc = new Scalar(v1.toString().matches(Patterns.SCALAR) ? v1.toString() : v2.toString());
        double[] res = Arrays.copyOf(v.value,v.value.length);
        for (int i = 0; i < res.length; i++) res[i] += sc.value;
        return new Vector(res);
    }
}
