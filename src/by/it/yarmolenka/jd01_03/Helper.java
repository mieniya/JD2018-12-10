package by.it.yarmolenka.jd01_03;

class Helper {
    static double findMax(double[] arr) {
        double max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) max = arr[i];
        }
        return max;
    }

    static double findMin(double[] arr) {
        double min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) min = arr[i];
        }
        return min;
    }

    static void sort(double[] arr) {
        boolean swap;
        int list = arr.length - 1;
        double temp;
        do {
            swap = false;
            for (int i = 0; i < list; i++) {
                if (arr[i] > arr[i + 1]) {
                    temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    swap = true;
                }
            }
            list--;
        }
        while (swap);
    }

    static double[] mul(double[][] matrix, double[] vector) {
        double[] res = new double[matrix.length];
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[0].length; j++) {
                res[i] += matrix[i][j] * vector[j];
            }
        return res;
    }

    static double[][] mul(double[][] matrix1, double[][] matrix2) {
        double[][] res = new double[matrix1.length][matrix2[0].length];
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix2[0].length; j++){
                for (int k = 0; k< matrix1[j].length;k++){
                    res[i][j]+=matrix1[i][k]*matrix2[k][j];
                }
            }
        }
        return res;
    }
}
