package by.it.titkovskaya.Calculator.Interfaces;

import by.it.titkovskaya.Calculator.Var;

public interface Operation {
    Var add(Var other);
    Var sub(Var other);
    Var mul(Var other);
    Var div(Var other);
}