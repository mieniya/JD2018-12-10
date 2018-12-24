package by.it.zagurskaya.jd01_04;
public class Helper {
    /**
     * Find  min-s array
     * @param arr one-dimensional array
     * @return min-s array
     */
    static double findMin(double[ ] arr) {
        double minElement;
        minElement=arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (minElement > arr[i]) minElement = arr[i];
        }
        System.out.println(minElement);
        return minElement;
    }
    /**
     * Find  max-s array
     * @param arr one-dimensional array
     * @return max-s array
     */
    static double findMax(double[ ] arr){
        double maxElement;
        maxElement=arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (maxElement < arr[i]) maxElement = arr[i];
        }
        System.out.println(maxElement);
        return maxElement;
    }

    /**
     * Sorting one-dimensional array
     * @param arr one-dimensional array
     */
    static void sort(double[ ] arr){
        boolean swap=true;
        int last=arr.length;
        double buffer;
        do {
            swap=false;
            for (int i = 0; i <last-1 ; i++) {
                if (arr[i]>arr[i+1]) {
                    buffer=arr[i];
                    arr[i]=arr[i+1];
                    arr[i+1]=buffer;
                    swap=true;
                }
            }
            last--;
        } while (swap);

    }

    /**
     * Multiplication two-dimensional array and one-dimensional array
     * @param matrix two-dimensional array
     * @param vector one-dimensional array
     * @return vector
     */
    static double[ ] mul(double[ ][ ] matrix, double[ ] vector) {
        double[] rezMultMatrixVector = new double[matrix.length];
        for (int i = 0; i <matrix.length ; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                rezMultMatrixVector[i] = rezMultMatrixVector[i] + matrix[i][j] * vector[j];
            }
        }
        return rezMultMatrixVector;
    }
    /**
     * Multiplication two-dimensional array and two-dimensional array
     * @param matrixLeft two-dimensional array
     * @param matrixRight two-dimensional array
     * @return two-dimensional array
     */
    static double[ ][ ] mul(double[ ][ ] matrixLeft, double[ ][ ] matrixRight){
        double[][] rezMultMatrixMatrix = new double[matrixLeft.length] [matrixRight[0].length];
        for (int i = 0; i <matrixLeft.length ; i++) {
            for (int j = 0; j <matrixRight[0].length; j++) {
                for (int k = 0; k < matrixRight.length; k++) {
                    rezMultMatrixMatrix[i][j]=rezMultMatrixMatrix[i][j]+matrixLeft[i][k]*matrixRight[k][j];
                }
            }

        }
        return rezMultMatrixMatrix;
    }
}
