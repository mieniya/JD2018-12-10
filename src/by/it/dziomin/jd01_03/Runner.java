package by.it.dziomin.jd01_03;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter String of numbers");
        String str = sc.nextLine();
        double[] mas = InOut.getArray(str);
        InOut.printArray(mas);

        System.out.println("\nEnter name of element");
        String el = sc.nextLine();
        System.out.println("Enter number of columns");
        int num = sc.nextInt();

        InOut.printArray(mas, el, num);

        System.out.println("\nmax is:" + Helper.findMax(mas));

        System.out.println("min is:" + Helper.findMin(mas));

        System.out.println("Sorted array:");
        Helper.sort(mas);
        System.out.println("\n**************************************************");
        System.out.println("Multiplication matrix-vector");
        System.out.println("Введите элементы матрицы");
        str = sc.nextLine();
        double[] arrayFromString = InOut.getArray(str);
        double[][] matrixFromArray =InOut.getMatrixFromArray(arrayFromString);
        InOut.printMatrix(matrixFromArray);
        System.out.println("Введите вектор длинны: "+matrixFromArray[0].length);
        str = sc.nextLine();
        double[] vectorFromString = InOut.getArray(str,matrixFromArray[0].length);
        InOut.printVector(vectorFromString);
        System.out.println("Matrix * vector equals:");
        InOut.printVector(Helper.mul(matrixFromArray, vectorFromString));

        System.out.println("\n**************************************************");
        System.out.println("Multiplication matrix-matrix:");
        System.out.println("Введите элементы первой матрицы");
        str = sc.nextLine();
        arrayFromString = InOut.getArray(str);
        matrixFromArray =InOut.getMatrixFromArray(arrayFromString);
        InOut.printMatrix(matrixFromArray);
        System.out.println("Введите элементы второй матрицы");
        str = sc.nextLine();
        arrayFromString = InOut.getArray(str);
        double[][] matrixFromArrayB=InOut.getMatrixFromArray(arrayFromString);

        try {
            InOut.printMatrix(Helper.mul(matrixFromArray, matrixFromArrayB));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    //size of matrix or vector
    static int[] sizeMatrix() {

        Scanner sc = new Scanner(System.in);
        int r[] = new int[2];
        int nRows, nColumns;
        System.out.println("Enter number of rows");
        nRows = sc.nextInt();
        System.out.println("Enter number of columns");
        nColumns = sc.nextInt();
        r[0] = nRows;
        r[1] = nColumns;
        return r;
    }

    static int sizeVector() {
        Scanner sc = new Scanner(System.in);
        int lenVector;
        System.out.println("Enter length of vector");
        lenVector = sc.nextInt();
        return lenVector;
    }

}
