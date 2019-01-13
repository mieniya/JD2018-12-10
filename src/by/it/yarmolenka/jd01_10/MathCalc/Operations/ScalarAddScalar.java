package by.it.yarmolenka.jd01_10.MathCalc.Operations;

import by.it.yarmolenka.jd01_10.MathCalc.Variables.*;

class ScalarAddScalar {
    static Scalar scalarScalar(Var v1, Var v2){
        Scalar sc1 = new Scalar(v1.toString());
        Scalar sc2 = new Scalar(v2.toString());
        return new Scalar(sc1.value+sc2.value);
    }
}
