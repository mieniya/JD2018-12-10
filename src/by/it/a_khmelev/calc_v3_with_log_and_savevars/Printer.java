package by.it.a_khmelev.calc_v3_with_log_and_savevars;

class Printer {

    void print(Var result) {
        if (result != null)
            System.out.println(result);
    }

    void showError(CalcException e) {
        System.err.println(e.getMessage());
        Log.toLog(e.getMessage());
    }
}
