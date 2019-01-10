package by.it.yarmolenka.jd01_09;

public class Runner {
    private static void print(Var var) {
        System.out.println(var);
    }

    public static void main(String[] args) {
        Scalar s1 = new Scalar(3.0);
        Var s2 = new Scalar("6");
        Scalar s3 = new Scalar(s1);
        Vector v1 = new Vector(new double[]{1, 2, 3});
        Var v2 = new Vector("{8, 4, 1}");
        Var v3 = new Vector("{5, 6}");
        Vector v4 = new Vector(v1);
        Matrix m1 = new Matrix("{{1,2,3},{4,5,6},{7,8,9}}");
        Var m2 = new Matrix(new double[][] {{4,7,2},{7,1,2},{5,2,1}});
        Var m3 = new Matrix("{{1, 2}, {3, 4}}");
        Matrix m4 = new Matrix(m1);
        //A
        print(s1.add(s2));
        print(s3.sub(s2));
        print(s1.mul(s2));
        print(s1.div(s2));
        //B
        print(v2.add(v1));
        print(v2.sub(v4));
        print(v2.mul(v1));
        print(v2.div(v1));
        //C
        print(m1.add(m2));
        print(m4.sub(m2));
        print(m1.mul(m2));
        print(m1.div(v1));
        print(m3.mul(v3));
    }
}
