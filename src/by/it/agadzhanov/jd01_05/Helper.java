package by.it.agadzhanov.jd01_05;

class Helper {

    /**
     * @param arr Исходный массив из чисел
     * @return Наименьший элемент массива
     */
    static double findMin(double[] arr) {
        double min = arr[0];
        for (double element : arr) {
            if (element < min)
                min = element;
        }
        return min;
    }

    /**
     * @param arr Исходный массив из чисел
     * @return Наибольший элемент масива
     */
    static double findMax(double[] arr) {
        double max = arr[0];
        for (double element : arr) {
            if (element > max)
                max = element;
        }
        return max;
    }

    /**
     * @param arr Исходный массив из чисел
     */
    static void sort(double[] arr) {
        for (int i = 0; i <= arr.length - 2; i++) {
            for (int j = i + 1; j <= arr.length - 1; j++) {
                if (arr[i] > arr[j]) {
                    double buffer = arr[i];
                    arr[i] = arr[j];
                    arr[j] = buffer;
                }
            }
        }
    }

    /**
     * @param matrix Вводная матрица
     * @param vector Вводный вектор
     * @return Вектор-результат умножения
     */
    static double[] mul(double[][] matrix, double[] vector) {
        double[] res=new double[matrix.length];
        for (int i = 0; i <= matrix.length-1; i++) {
            for (int j = 0; j <= vector.length-1; j++) {
                res[i]=res[i]+matrix[i][j]*vector[j];
            }
        }
        return res;
    }

    /**
     * @param matrixLeft Вводная матрица слева
     * @param matrixRight Вводная матрица справа
     * @return Матрица-результат умножения
     */
    static double[ ][ ] mul(double[ ][ ] matrixLeft, double[ ][ ] matrixRight) {
        double[][] res=new double[matrixLeft.length][matrixRight[0].length];
        for (int i = 0; i <= matrixLeft.length-1; i++) {
            for (int j = 0; j <= matrixRight[0].length-1; j++) {
                for (int k = 0; k <= matrixRight.length-1; k++) {
                    res[i][j]=res[i][j]+matrixLeft[i][k]*matrixRight[k][j];
                }
            }
        }
        return res;
    }
}