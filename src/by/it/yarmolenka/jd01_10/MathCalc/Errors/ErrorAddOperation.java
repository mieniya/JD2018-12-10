package by.it.yarmolenka.jd01_10.MathCalc.Errors;

public class ErrorAddOperation {

    public static void errorOperation(){
        System.out.println("Операция сложения невозможна");
    }

    public static void sumVecMat(){
        System.out.println("Сложение вектора с матрицей невозможно");
    }

    public static void sumVecVec(){
        System.out.println("Для сложения/вычитания векторов необходимо чтобы они были одного размиера");
    }

    public static void sumMatMat(){
        System.out.println("Для сложения/вычитания матриц необходимо чтобы они были одного размера");
    }
}
