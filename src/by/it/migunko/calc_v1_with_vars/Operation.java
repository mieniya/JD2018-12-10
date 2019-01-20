package by.it.migunko.calc_v1_with_vars;

interface Operation {
    Var add(Var other);
    Var sub(Var other);
    Var mul(Var other);
    Var div(Var other);
}

