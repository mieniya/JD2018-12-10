package by.it.dziomin.jd01_07;

public class Runner {
    public static void main(String[] args) {

        //step1
        Scalar var1 = new Scalar(5);
        Scalar var2 = new Scalar(var1);
        Scalar var3 = new Scalar("4");
        System.out.println(var1);
        System.out.println(var2);
        System.out.println(var3);

        //step2
        double[] doub = {1, 3, 4.0};
        String str = "{5., 3}";
        Vector vector1 = new Vector(doub);
        Vector vector2 = new Vector(vector1);
        Vector vector3 = new Vector(str);
        System.out.println(vector1);
        System.out.println(vector2);
        System.out.println(vector3);

        //step3
        double[][] doubleMatrix = {{1.0, 2.0}, {3.0, 4.0}};
        String strMatrix = "{{5., 3},{4, 77}}";
        Matrix matrix1 = new Matrix(doubleMatrix);
        Matrix matrix2 = new Matrix(matrix1);
        Matrix matrix3 = new Matrix(strMatrix);
        System.out.println(matrix1);
        System.out.println(matrix2);
        System.out.println(matrix3);
    }


}
