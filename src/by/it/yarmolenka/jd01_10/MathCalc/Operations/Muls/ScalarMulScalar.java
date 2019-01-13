package by.it.yarmolenka.jd01_10.MathCalc.Operations.Muls;

import by.it.yarmolenka.jd01_10.MathCalc.Variables.*;

public class ScalarMulScalar {
    public static Scalar scalarScalar(Scalar sc1, Scalar sc2) {
        return new Scalar(sc1.value*sc2.value);
    }
}
