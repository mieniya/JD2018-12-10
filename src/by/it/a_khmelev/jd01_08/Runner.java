package by.it.a_khmelev.jd01_08;

public class Runner {
    private static void print(Var var) {
        System.out.println(var);
    }

    public static void main(String[] args) {
        Var v1 = new Vector(new double[]{1, 2, 3}); // закомментируйте вектор и/или
        Var v2 = new Scalar(2); // закомментируйте вектор и/или
        print(v1.add(v2));
    }
}