package by.it.subach.jd01_07;

public class Runner {
    public static void main(String[] args) {
        double  [] test = {1, 2 , 3, 4, 5, 6, 7, 8};
        Var vector = new Vector(test);
        System.out.println(vector);

        String str = "{1.0, 2.0, 4.0}";
        Vector vector1 = new Vector(str);
        vector1.toString();


        double [][] matrix = {{1, 2, 3}, {4, 5, 6}};
        Matrix m = new Matrix(matrix);
        m.toString();
    }
}
