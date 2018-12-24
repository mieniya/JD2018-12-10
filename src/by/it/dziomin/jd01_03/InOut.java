package by.it.dziomin.jd01_03;

import java.util.Scanner;

public class InOut {

    //возвращает массив чисел из введенной строки
    static double[] getArray(String line) {
        line = line.trim();
        String[] str = line.split("( )+");

        double[] mas = new double[str.length];
        for (int i = 0; i < mas.length; i++) {
            mas[i] = Double.parseDouble(str[i]);
        }
        return mas;
    }

    static double[] getArray(String line, int length) {
        double[] mas = new double[length];
        double[] masTemp = getArray(line);
        int raznDlinn = length - masTemp.length;
        if (raznDlinn < 0) {
            System.out.println("Внимание! В вектор не поместилось " + -raznDlinn + " элементов");
        } else if (raznDlinn > 0) {
            System.out.println("Внимание! В векторе не хватает " + raznDlinn + " элементов. Они будут заполнены нулями");
        }
        for (int i = 0; i < length; i++) {
            if (i < masTemp.length) {
                mas[i] = masTemp[i];
            } else {
                mas[i] = 0;
            }
        }

        return mas;
    }

    static double[][] getMatrixFromArray(double[] array) {
        System.out.println("Enter number of column");
        Scanner sc = new Scanner(System.in);
        int numberColumn = sc.nextInt();
        int numberRows = (array.length - array.length % numberColumn) / numberColumn;
        if (numberColumn * numberRows != array.length) {
            int razn = array.length - numberColumn * numberRows;
            System.out.println("Внимание! В матрицу не поместилось " + razn + " элементов");
        }
        double[][] matrix = new double[numberRows][numberColumn];
        int k = 0;
        for (int i = 0; i < numberRows; i++) {
            for (int j = 0; j < numberColumn; j++) {
                matrix[i][j] = array[k];
                k++;
            }
        }

        return matrix;
    }

    static void printArray(double[] arr) {
        for (double v : arr) {
            System.out.printf("% -9.2f", v);
        }
    }

    static void printArray(double[] arr, String name, int columnCount) {
        for (int i = 0; i < arr.length; i++) {
            if (i % columnCount == 0 && i != 0)
                System.out.printf("\n");
            System.out.printf("%3s[%d]=% -5.2f", name, i, arr[i]);
        }
    }

    static void printVector(double[] arr) {
        for (double v : arr) {
            System.out.printf("% -9.2f", v);
        }
        System.out.println();
    }

    static void printMatrix(double[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.printf("% -9.2f", arr[i][j]);
            }
            System.out.println();
        }
    }

    // метод задает размер массива
    static int length() {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        return length;
    }

    //метод вовращает вектор
    static double[] getVector(int numElements) {
        Scanner sc = new Scanner(System.in);
        double[] vector = new double[numElements];
        System.out.println("Enter elements of vector");
        for (int i = 0; i < vector.length; i++) {
            System.out.println("Enter [" + i + "] element");
            vector[i] = sc.nextDouble();
        }
        return vector;
    }

    //метод вовращает матрицу
    static double[][] getMatrix(int numRows, int nubColumns) {
        Scanner sc = new Scanner(System.in);
        double[][] matrix = new double[numRows][nubColumns];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.println("Enter [" + i + "][" + j + "] element");
                matrix[i][j] = sc.nextDouble();
            }
        }
        return matrix;
    }


}
