package by.it.dziomin.jd01_03;

public class Helper {
    static double findMin(double[] arr) {
        double min = arr[0];
        for (double v : arr) {
            if (v < min)
                min = v;
        }
        return min;
    }

    static double findMax(double[] arr) {
        double max = arr[0];
        for (double v : arr) {
            if (v > max)
                max = v;
        }
        return max;
    }


    //метод печатает в отсортированном виде массив передаваемый ему

    static void sort(double[] arr) {
        if (arr.length <= 0) {
            System.out.println("Массив не введен");
            return;
        }

        for (int i = 0; i < arr.length - 1; i++) {
            int needSort = 0;

            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    double temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                    needSort++;
                }
            }
            if (needSort == 0)
                break;
        }
        InOut.printArray(arr);
    }

    //Метод умножает матрицу на вектор

    static double[] mul(double[][] matrix, double[] vector) {
        double[] newVector = new double[matrix.length];
        if (matrix[0].length != vector.length) {
            System.out.println("матрицу на вектор перемножить невозможно, т.к. их размеры не совпадают");
            return newVector;
        }


        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                newVector[i] = matrix[i][j] * vector[j] + newVector[i];
            }
        }
        return newVector;
    }

// Метод умножает матрицу на матрицу

    static double[][] mul(double[][] matrixLeft, double[][] matrixRight) throws Exception {
        double[][] newMatrix = new double[matrixLeft.length][matrixRight[0].length];
        if (matrixLeft[0].length != matrixRight.length) {
            throw new Exception("матрицу на матрицу перемножить невозможно, т.к. их размеры не совпадают");
        }


        for (int i = 0; i < matrixLeft.length; i++) {
            for (int j = 0; j < matrixRight[0].length; j++) {
                for (int k = 0; k < matrixRight.length; k++) {
                    newMatrix[i][j] = matrixLeft[i][k] * matrixRight[k][j] + newMatrix[i][j];
                }
            }
        }

        return newMatrix;
    }

}
