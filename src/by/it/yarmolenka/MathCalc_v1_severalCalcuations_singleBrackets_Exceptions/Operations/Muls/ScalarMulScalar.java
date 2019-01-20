package by.it.yarmolenka.MathCalc_v1_severalCalcuations_singleBrackets_Exceptions.Operations.Muls;

import by.it.yarmolenka.MathCalc_v1_severalCalcuations_singleBrackets_Exceptions.Variables.*;

public class ScalarMulScalar {
    public static Scalar scalarScalar(Scalar sc1, Scalar sc2) {
        return new Scalar(sc1.value*sc2.value);
    }
}
