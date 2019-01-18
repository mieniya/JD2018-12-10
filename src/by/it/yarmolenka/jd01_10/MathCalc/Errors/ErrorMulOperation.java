package by.it.yarmolenka.jd01_10.MathCalc.Errors;

public class ErrorMulOperation {

    public static void errorOperation(){
        System.out.println("Операция умножения невозможна");
    }

    public static void mulVecMat(){
        System.out.println("умножение вектора на матрицей невозможно");
    }

    public static void mulMatVec(){
        System.out.println("умножение матрицы на вектор возможно только в случае\n если число столбцов в матрице совпадает с размеров вектора");
    }

    public static void mulVecVec(){
        System.out.println("Для умножения векторов необходимо чтобы они были одного размиера");
    }

    public static void mulMatMat(){
        System.out.println("Для умножения матриц необходимо чтобы количество столбцов первой матрицы совпадало с количеством строк второй матрицы");
    }
}
