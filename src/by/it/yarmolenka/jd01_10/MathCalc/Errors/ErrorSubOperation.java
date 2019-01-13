package by.it.yarmolenka.jd01_10.MathCalc.Errors;

public class ErrorSubOperation {

    public static void errorOperation(){
        System.out.println("Операция вычитания невозможна");
    }

    public static void subVecMat(){
        System.out.println("Вычитание вектора из матрицы невозможно");
    }

    public static void subMatVec(){
        System.out.println("Вычитание матрицы из вектора невозможно");
    }
}
