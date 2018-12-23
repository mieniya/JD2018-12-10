package by.it.lyakhova.jd01_04;

import static by.it.lyakhova.jd01_04.InOut.printArray;

public class Helper {
    /**
     *
     * @param arr incoming array
     * @return minimum value
     */

     static double findMin(double[ ] arr){
        if (0==arr.length){
            return Integer.MIN_VALUE;
        }
        else {
            double min = arr[0];
            for (int i = 1; i < arr.length; i++) {
                if(min>arr[i]) min = arr[i];
            }
            return min;
        }
    }

    /**
     *
     * @param arr incoming array
     * @return minimum value
     */
    static double findMax(double[ ] arr){
        if (0==arr.length){
            return Integer.MAX_VALUE;
        }
        else {
            double max = arr[0];
            for (int i = 1; i < arr.length; i++) {
                if(max<arr[i]) max = arr[i];
            }
            return max;
        }

    }

    /**
     * simple array sorting ascending
     * @param arr incoming array
     */
    static void sort(double[ ] arr){
         int last = arr.length-1;
         boolean move;
        do {
            move=false;
            for (int i = 0; i < last; i++) {
                if (arr[i]>arr[i+1]){
                    double tempBuf=arr[i];
                    arr[i]=arr[i+1];
                    arr[i+1]=tempBuf;
                    move=true;
                }
            }
            last--;
        }while (move);
        printArray(arr);
    }

    /**
     *
     * @param matrix incoming two-dimensional matrix
     * @param vector incoming vector
     * @return vector - the result of multiplying the matrix and the vector
     */
    static double[ ] mul(double[ ][ ] matrix, double[ ] vector){
         double[] mulVector = new double[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < vector.length; j++) {
                mulVector[i]=mulVector[i]+matrix[i][j]*vector[j];
            }
        }
         return mulVector;
    }

    /**
     *
     * @param matrixLeft incoming two-dimensional matrix
     * @param matrixRight incoming two-dimensional matrix
     * @return two-dimensional matrix - the result of multiplying the matrix and the matrix
     */
    static double[ ][ ] mul(double[ ][ ] matrixLeft, double[ ][ ] matrixRight){
         double[][] mulMatrix = new double[matrixLeft.length][matrixRight[0].length];
        for (int i = 0; i < matrixLeft.length; i++) {
            for (int j = 0; j < matrixRight[0].length; j++) {
                for (int k = 0; k < matrixRight.length; k++) {
                    mulMatrix[i][j]=mulMatrix[i][j]+matrixLeft[i][k]*matrixRight[k][j];
                }
            }
        }

         return mulMatrix;
    }
}
