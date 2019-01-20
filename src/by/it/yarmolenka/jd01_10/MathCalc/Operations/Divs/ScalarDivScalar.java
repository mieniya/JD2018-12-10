package by.it.yarmolenka.jd01_10.MathCalc.Operations.Divs;

import by.it.yarmolenka.jd01_10.MathCalc.Variables.Scalar;

public class ScalarDivScalar {
    public static Scalar scalarScalar(Scalar sc1, Scalar sc2) {
        return new Scalar(sc1.value/sc2.value);
    }
}
