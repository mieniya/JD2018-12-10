package by.it.yarmolenka.MathCalc_v1_severalCalcuations_singleBrackets_Exceptions.Operations.Divs;

import by.it.yarmolenka.MathCalc_v1_severalCalcuations_singleBrackets_Exceptions.CalcException;
import by.it.yarmolenka.MathCalc_v1_severalCalcuations_singleBrackets_Exceptions.Variables.Scalar;

public class ScalarDivScalar {
    public static Scalar scalarScalar(Scalar sc1, Scalar sc2) throws CalcException {
        if (sc2.value == 0) throw new CalcException("Деление на ноль невозможно");
        else return new Scalar(sc1.value / sc2.value);
    }
}
