package by.it.yarmolenka.jd01_10.MathCalc.Operations.Adds;

import by.it.yarmolenka.jd01_10.MathCalc.Variables.*;

import java.util.Arrays;

public class VectorAddScalar {
    public static Vector vectorScalar(Vector vec, Scalar sc) {
        double[] res = Arrays.copyOf(vec.value,vec.value.length);
        for (int i = 0; i < res.length; i++) res[i] += sc.value;
        return new Vector(res);
    }
}
