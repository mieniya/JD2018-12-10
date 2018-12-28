package by.it.yarmolenka.jd01_07;

public class Runner {
    public static void main(String[] args) {
        Scalar var = new Scalar(5);
        System.out.println(var);
        Scalar va = new Scalar(var);
        System.out.println(va);
        String s = "0.12345";
        Scalar st = new Scalar(s);
        System.out.println(st);
        double[] vector = {1, 5, 8};
        Vector vec = new Vector(vector);
        System.out.println(vec);
        Vector vec2 = new Vector(vec);
        System.out.println(vec2);
        Vector vec3 = new Vector("{1.0, 4, 77.0, 82");
        System.out.println(vec3);
        double[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        Matrix mat = new Matrix(arr);
        System.out.println(mat);
        Matrix mat2 = new Matrix(mat);
        System.out.println(mat2);
        String str = "{{11.0, 22.0, 33.0}, {44.0, 55.0, 66.0}, {77.0, 88.0, 99.0}}";
        Matrix mat3 = new Matrix(str);
        System.out.println(mat3);
    }
}
