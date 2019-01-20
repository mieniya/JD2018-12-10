package by.it.naron.jd01_13.calc_j_13;

interface Operation {
    Var add(Var other) throws CalcException;
    Var sub(Var other)throws CalcException;
    Var mul(Var other)throws CalcException;
    Var div(Var other)throws CalcException;

}
