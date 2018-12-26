package by.it.lyakhova.jd01_07;

class Scalar extends Var {
   private double value;

    Scalar (double value){
      this.value=value;
  }

   Scalar (Scalar otherScalar){
       this.value=otherScalar.value;
  }

   Scalar(String strValue){
       value = Double.parseDouble(strValue);
  }

  public String toString() {
       return Double.toString(value);
        //return String.valueOf(value);
   }

}
