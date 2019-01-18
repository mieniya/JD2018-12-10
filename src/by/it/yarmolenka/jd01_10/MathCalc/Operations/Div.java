package by.it.yarmolenka.jd01_10.MathCalc.Operations;

import by.it.yarmolenka.jd01_10.MathCalc.Errors.ErrorDivOperation;
import by.it.yarmolenka.jd01_10.MathCalc.Operations.Divs.*;
import by.it.yarmolenka.jd01_10.MathCalc.Patterns;
import by.it.yarmolenka.jd01_10.MathCalc.Variables.*;

public class Div {

    public static Var divVarVar(Var var1, Var var2) {

        if (var1.toString().matches(Patterns.SCALAR) && var2.toString().matches(Patterns.SCALAR)) {
            Scalar sc1 = new Scalar(var1.toString());
            Scalar sc2 = new Scalar(var2.toString());
            return ScalarDivScalar.scalarScalar(sc1, sc2);
        }

        if (var1.toString().matches(Patterns.VECTOR) && var2.toString().matches(Patterns.SCALAR)) {
            Vector vec = new Vector(var1.toString());
            Scalar sc = new Scalar(var2.toString());
            return VectorDivScalar.vectorScalar(vec, sc);
        }

        if (var1.toString().matches(Patterns.SCALAR) && var2.toString().matches(Patterns.VECTOR)) {
            ErrorDivOperation.divScaVec();
            return null;
        }

        if (var1.toString().matches(Patterns.MATRIX) && var2.toString().matches(Patterns.SCALAR)) {
            Matrix m = new Matrix(var1.toString());
            Scalar sc = new Scalar(var2.toString());
            return MatrixDivScalar.matrixScalar(m, sc);
        }

        if (var1.toString().matches(Patterns.SCALAR) && var2.toString().matches(Patterns.MATRIX)) {
            ErrorDivOperation.divScaMat();
            return null;
        }

        if (var1.toString().matches(Patterns.VECTOR) && var2.toString().matches(Patterns.MATRIX)) {
            ErrorDivOperation.divVecMat();
            return null;
        }

        if (var1.toString().matches(Patterns.MATRIX) && var2.toString().matches(Patterns.VECTOR)) {
            ErrorDivOperation.divMatVec();
            return null;
        }

        if (var1.toString().matches(Patterns.VECTOR) && var2.toString().matches(Patterns.VECTOR)) {
            ErrorDivOperation.divVecVec();
            return null;
        }

        if (var1.toString().matches(Patterns.MATRIX) && var2.toString().matches(Patterns.MATRIX)) {
            ErrorDivOperation.divMatMat();
            return null;
        }

        ErrorDivOperation.errorOperation();
        return null;
    }
}
