package by.it.a_khmelev.calc_v2_with_exception;

class Printer {

    void print(Var result) {
        if (result != null)
            System.out.println(result);
    }

    void showError(CalcException e) {
        System.err.println(e.getMessage());
    }
}
