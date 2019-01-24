package by.it.skosirskiy.Calc;

public class Printer {

    void print(Var var){

        if (var!=null)
            System.out.println(var);

    }
    void showError(CalcException e) {
        System.err.println(e.getMessage());
        Log.toLog(e.getMessage()+"\n");
    }


}
