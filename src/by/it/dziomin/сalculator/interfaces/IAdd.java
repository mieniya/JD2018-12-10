package by.it.dziomin.сalculator.interfaces;

import by.it.dziomin.сalculator.CalcException;
import by.it.dziomin.сalculator.vars.Var;

public interface IAdd {
    Var add(Var other)throws CalcException;
}
