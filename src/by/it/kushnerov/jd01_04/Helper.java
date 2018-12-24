package by.it.kushnerov.jd01_04;

public class Helper {

    static double findMin(double[] arr){
        double arrMin = 0;
        for (int i = 0; i < arr.length; i++){
            if (arr[i] < arrMin){
                arrMin = arr[i];
            }
        }
        System.out.println(arrMin);
        return arrMin;
    }

    static double findMax(double[] arr){
        double arrMax = 0;
        for (int i = 0; i < arr.length; i++){
            if (arr[i] > arrMax){
                arrMax = arr[i];
            }
        }
        System.out.println(arrMax);
        return arrMax;
    }

    static void sort(double[] arr){
        boolean swap;
        int last = arr.length - 1;
        do {
            swap = false;
            for (int i = 0; i < last; i++) {
                if (arr[i] > arr[i + 1]) {
                    double temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    swap = true;
                }
            }
            last--;
        } while (swap);
    }

    static double[] mul(double[][] matrix, double[] vector){
        double [] z = new double[matrix.length];
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < vector.length; j++)
                z[i] = z[i] + matrix[i][j] * vector[j];
        return z;
    }

    static double[][] mul(double[][] matrixLeft, double[][] matrixRight){
        double[][] z = new double[matrixLeft.length][matrixRight[0].length];
        for (int i = 0; i < matrixLeft.length; i++) {
            for (int j = 0; j < matrixRight[0].length; j++) {
                for (int k = 0; k < matrixRight.length; k++) {
                    z[i][j] = z[i][j] + matrixLeft[i][k] * matrixRight[k][j];
                }
            }
        }
        return z;
    }
}
