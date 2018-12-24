package by.it.lyakhova.jd01_05;

import static by.it.lyakhova.jd01_05.InOut.printArray;

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

    static void sort(int[ ] arr){
        int last = arr.length-1;
        boolean move;
        do {
            move=false;
            for (int i = 0; i < last; i++) {
                if (arr[i]>arr[i+1]){
                    int tempBuf=arr[i];
                    arr[i]=arr[i+1];
                    arr[i+1]=tempBuf;
                    move=true;
                }
            }
            last--;
        }while (move);

    }

    static void mergeSort(double[] array){
        int left = 0;
        int right = array.length-1;
        double[] arr = mergeSort(array, left, right);
        for (int i = 0; i < arr.length; i++) {
            array[i]=arr[i];
        }
    }

    private static double[] mergeSort(double[] array, int left, int right){

        if (left==right) return array;
        else {
            int middle=(left+right)/2;
            double[] part1 = new double[middle-left+1];
            for (int i = 0; i < part1.length; i++) {
                part1[i]=array[i];
            }
            part1 = mergeSort(part1, 0, part1.length-1);

            double[] part2 = new double[array.length-part1.length];
            for (int i = 0; i < part2.length; i++) {
                part2[i]=array[middle+1+i];
            }
            part2 = mergeSort(part2, 0, part2.length-1);

            array = merge(part1, part2);

        }
        return array;
    }

    private static double[] merge(double[] part1, double[] part2){
        int i=0;
        int j=0;
        double[] arraySort = new double[part1.length+part2.length];
        int lengthLeft = part1.length;
        int lengthRight = part2.length;
        for (int k = 0; k < arraySort.length; k++) {
            if ((i<lengthLeft)&&((j>=lengthRight)||(part1[i])<=part2[j])){
                arraySort[k] = part1[i];
                i++;
            }
            else{
                arraySort[k]=part2[j];
                j++;
            }
        }
        return arraySort;
    }

    static int binarySearch(double[ ] array, double value){
        int left = 0;
        int right = array.length-1;
        while (left<=right){
            int m = left+(right-left)/2;
            if (array[m]<value) left=m+1;
            else if (array[m]>value) right=m-1;
            else return m;
        }
        return -1;
    }

}
