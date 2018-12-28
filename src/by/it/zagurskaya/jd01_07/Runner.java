package by.it.zagurskaya.jd01_07;

public class Runner {
    public static void main(String[] args) {
        //Object var=new Var();
        // Object var=new Scalar();
        Scalar var1 = new Scalar(1);
        Scalar var2 = new Scalar(222);
        Scalar var3 = new Scalar(var1);
        System.out.println(var3);

        double[] vec1 = {1,2,4};
        Vector vect1 = new Vector(vec1);
        System.out.println(vect1);

        double[][] mat1 = {{1,3,4},{1,2,4}};
        Matrix matr1 = new Matrix(mat1);
        System.out.println(matr1);

        String strMatrix = "{{1,3,4},{1,2,4}}";
        Matrix matrixString = new Matrix(strMatrix);


    }

}
