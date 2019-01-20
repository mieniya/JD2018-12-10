package by.it.moroz.calc;


class Printer {

     void print(Var result) {
         if (result!=null)
         System.out.println(result);
    }

    void showError (CalcExeption e){
         System.out.println(e.getMessage());
    }


}
