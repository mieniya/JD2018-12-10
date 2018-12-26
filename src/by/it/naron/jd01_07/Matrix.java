package by.it.naron.jd01_07;

 class Matrix extends Var {
     private double [][] value;


     Matrix(double[ ][ ] value){
         this.value = value;
     };

     Matrix(Matrix matrix){};

     Matrix(String strMatrix){};




     //    { { 1.0, 2.0 }, { 3.0, 4.0 } }

     @Override
     public String toString() {
         StringBuilder sb  =new StringBuilder("{{");
         String delimeter = "";
         for (double [] row : value){
             for (int i = 0; i <row.length ; i++) {
                 sb.append(delimeter).append(row [i]);
                 delimeter = ", ";
             }
             sb.append("}");
             delimeter = ",{";
         }
         sb.append("}");
         return sb.toString();
     }
 }
