package by.it.lyakhova.jd01_07;

public class Runner {
    public static void main(String[] args) {
       // Var var = new Var();
       // var.notify(); //можно посмотреть все, что есть в обжекте

        /*Var var = new Scalar(5);
        System.out.println(var);*/
        Scalar var1 = new Scalar(1);
        Scalar var2 = new Scalar("222");
        Scalar var3 = new Scalar(2.0);

        double[] test = {1,2,3,4,5,6,7,8};
        Var vector = new Vector(test);
        System.out.println(vector);

        Var vector1 = new Vector("{1.0, 2.0, 4.0}");
        System.out.println(vector1);

        double[][] mtr =  {{1.0, 2.0 }, { 3.0, 4.0}};
        Var matrix = new Matrix(mtr);
        System.out.println(matrix);

        Var matrix2 = new Matrix("{{1.0, 2.0 }, { 3.0, 4.0}}");
        System.out.println(matrix2);
    }
}
