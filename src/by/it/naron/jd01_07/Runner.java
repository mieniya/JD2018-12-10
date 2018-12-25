package by.it.naron.jd01_07;

public class Runner {
    public static void main(String[] args) {
        System.out.println("This is from class Scalar:");
        Var a1 = new Scalar(3.14);
        System.out.println(a1);
        Var a2 = new Scalar("3.14");
        System.out.println(a2);
        Scalar scalar = new Scalar(3.14);
        Var a3 = new Scalar(scalar);
        System.out.println(a3);

        System.out.println("This is from class Vector");
        Var b1 = new Vector(new double[]{1,2,4});
        System.out.println(b1);
        Vector vector = new Vector(new double[]{1,2,4});
        Var b2 = new Vector(vector);
        System.out.println(b2);
        Var b3 = new Vector("1,2,4");
        System.out.println(b3);







        }
}
