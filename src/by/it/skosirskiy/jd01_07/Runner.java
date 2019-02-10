package by.it.skosirskiy.jd01_07;

public class Runner {
    public static void main(String[] args) {
        String str="{1,2,4}";
        Var v1=new Scalar(3.1415);
        Var v2=new Vector(str);
        Var v3=new Scalar((Scalar) v1);


        Var v4=new Vector(str);


        System.out.println(v1);
        System.out.println(v2);
        System.out.println(v3);

        double[][] test2 = {{1, 2, 3},{3, 4, 5},{3, 4, 5},{6,7,8}};

        Matrix matrix1 = new Matrix(test2);
        Matrix matrix2 = new Matrix(matrix1);
        Matrix matrix3 = new Matrix("{{1, 2, 3},{3, 4, 5},{6,7,8}},{3, 4, 5},{6,7,8},{6,7,8}");

        System.out.println(matrix1);
        System.out.println(matrix2);
        System.out.println(matrix3);


    }


}
