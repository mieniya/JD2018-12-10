package by.it.pkzm.jd01_03;

import java.util.Arrays;

public class Helper {
    static double findMax(double[] arr) {
        if (0 == arr.length) {
            return Double.MAX_VALUE;
        } else {
            double max = arr[0];
            for (double m : arr) {
                if (max < m) max = m;
            }
            return max;
        }
    }

    static double findMin(double[] arr) {
        if (0 == arr.length) {
            return Double.MIN_VALUE;
        } else {
            double min = arr[0];
            for (double m : arr) {
                if (min > m) min = m;
            }
            return min;
        }
    }

    static void sort(double[] arr) {
        double k = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {

                if (arr[i] > arr[j]) {
                    k = arr[i];
//                    System.out.println(k);
                    arr[i] = arr[j];
                    arr[j] = k;
                }
            }
            System.out.print(arr[i] + " ");
        }
        System.out.println();

    }

    static double[] mul(double[][] matrix, double[] vector) {
        double[] z = new double[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < vector.length; j++) {
                z[i] = z[i] + matrix[i][j] * vector[j];

            }

        }
        return z;
    }

    static double[][] mul(double[][] matrixLeft, double[][] matrixRight) {

        double[][] y = new double[matrixLeft.length][matrixRight[0].length];
        for (int i = 0; i < matrixLeft.length; i++) {
            for (int j = 0; j < matrixRight[i].length; j++) {
                for (int k = 0; k < matrixLeft[i].length; k++) {
                    y[i][j] = y[i][j] + matrixLeft[i][k] * matrixRight[k][j];

                }

            }

        }
        return y;
    }


    public static void main(String[] args) {
        double[][] left = {
                {1, 2, 3},
                {4, 5, 6}
        };

        double[][] right = {
                {1, 2},
                {3, 4},
                {5, 6}
        };
        mul(left,right);
    }
}

