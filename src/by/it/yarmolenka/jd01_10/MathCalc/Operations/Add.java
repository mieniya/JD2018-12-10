package by.it.yarmolenka.jd01_10.MathCalc.Operations;

import by.it.yarmolenka.jd01_10.MathCalc.Errors.ErrorAddOperation;
import by.it.yarmolenka.jd01_10.MathCalc.Patterns;
import by.it.yarmolenka.jd01_10.MathCalc.Variables.*;

public class Add {
    public static Var addVarVar(Var var1, Var var2) {

        if (var1.toString().matches(Patterns.SCALAR) && var2.toString().matches(Patterns.SCALAR)) {
            return ScalarAddScalar.scalarScalar(var1, var2);
        }

        if ((var1.toString().matches(Patterns.VECTOR) && var2.toString().matches(Patterns.SCALAR)) ||
                (var1.toString().matches(Patterns.SCALAR) && var2.toString().matches(Patterns.VECTOR))) {
            return VectorAddScalar.vectorScalar(var1, var2);
        }

        if ((var1.toString().matches(Patterns.MATRIX) && var2.toString().matches(Patterns.SCALAR)) ||
                (var1.toString().matches(Patterns.SCALAR) && var2.toString().matches(Patterns.MATRIX))) {
            return MatrixAddScalar.matrixScalar(var1, var2);
        }
        if ((var1.toString().matches(Patterns.VECTOR) && var2.toString().matches(Patterns.MATRIX)) ||
                (var1.toString().matches(Patterns.MATRIX) && var2.toString().matches(Patterns.VECTOR))) {
            ErrorAddOperation.sumVecMat();
            return null;
        }
        if (var1.toString().matches(Patterns.VECTOR) && var2.toString().matches(Patterns.VECTOR)) {
            return VectorAddVector.twoVector(var1, var2);
        }
        if (var1.toString().matches(Patterns.MATRIX) && var2.toString().matches(Patterns.MATRIX)) {
            return MatrixAddMatrix.twoMatrix(var1, var2);
        }
        ErrorAddOperation.errorOperation();
        return null;
    }

}
