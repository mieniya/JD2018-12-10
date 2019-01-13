package by.it.yarmolenka.jd01_10.MathCalc.Errors;

public class ErrorAddOperation {

    public static void errorOperation(){
        System.out.println("Операция невозможна");
    }

    public static void sumVecMat(){
        System.out.println("Сложение Вектора с Матрицей невозможно");
    }

    public static void sumVecVec(){
        System.out.println("Для сложения векторов необходимо чтобы количество членов в них совпадало");
    }

    public static void sumMatMat(){
        System.out.println("Для сложения матриц необходимо чтобы они были одного размера");
    }
}
