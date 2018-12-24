package by.it.subach.jd01_03;

public class Helper {

    static double findMin(double[] arr) {
        double min = Double.MAX_VALUE;

        for (double element : arr) {
            if (element < min)
                min = element;
        }
        return min;
    }

    static double findMax(double[] arr) {
        double max = Double.MIN_VALUE;

        for (double element : arr) {
            if (element > max)
                max = element;
        }
        return max;

    }

    static void sort(double[] arr) {
        boolean change;
        int counter = arr.length - 1;
        do {
            change = false;
            for (int i = 0; i < counter; i++) {
                if (arr[i] > arr[i + 1]) {
                    double temp = arr[i + 1];
                    arr[i + 1] = arr[i];
                    arr[i] = temp;
                    change = true;
                }
            }
            counter--;
        }while (change == true);
    }

    static double [] mul(double [][] matrix, double [] vector){
        double [] result = new double[matrix.length];

        for(int i = 0; i < matrix.length; i++){
            double sum = 0;
            for (int j = 0; j < matrix[i].length; j++) {
                sum += matrix[i][j] * vector[j];
            }
            result[i] = sum;
        }
        return result;
    }

    static double [][] mul(double[][] matrixLeft, double[][] matrixRight){
        double [][] result = new double[matrixLeft.length][matrixRight[0].length];

        for(int i = 0; i < matrixLeft.length; i++){
            for (int j = 0; j < matrixRight[i].length; j++) {
                double sum = 0;
                for (int k = 0; k < matrixRight.length; k++) {
                    sum += matrixLeft[i][k] * matrixRight[k][j];
                }
                result[i][j] = sum;
            }
        }

        return result;
    }
}
