package by.it.migunko.calc_tests;

class Printer {
    public void print(Var var) {
        if (var != null)
            System.out.println(var);
    }

    public void print(Var var, String string) {
        if (var != null)
            System.out.println(string + "=" + var);
    }
}
