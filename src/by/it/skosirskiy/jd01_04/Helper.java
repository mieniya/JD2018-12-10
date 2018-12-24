package by.it.skosirskiy.jd01_04;

/**
 *ishet max, min.
 */


public class Helper {

    static double findMin(double[ ] arr) {
        double buffer=arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (buffer > arr[i]) {buffer = arr[i];}
        }

    return buffer;
    }
    static double findMax(double[ ] arr) {
        double buffer=arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (buffer < arr[i]) {buffer = arr[i];}
        }

        return buffer;
    }
    static void sort(double[ ] arr) {
        double buffer;
        boolean count = false;
        while (count==false) {
            count = true;

            for (int i = 0; i < arr.length-1; i++) {
                if (arr[i] > arr[i + 1]) {
                    count=false;
                    buffer = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = buffer;

                }

            }
        }

    }
    static double[ ] mul(double[ ][ ] matrix, double[ ] vector){
        double[] z=new double[matrix.length];
        for (int i = 0; i < matrix.length ; i++) {
            for (int j = 0; j < vector.length; j++) {
                z[i] = z[i]+matrix[i][j]*vector[j];

            }

        }
        return z;
    }

    static double[ ][ ] mul(double[ ][ ] matrixLeft, double[ ][ ] matrixRight){
    double [][] z=new double[matrixLeft.length][matrixRight[0].length];
        for (int i = 0; i <matrixLeft.length ; i++) {
            for (int j = 0; j < matrixRight[0].length; j++) {
                for (int k = 0; k < matrixRight.length; k++) {
                    z[i][j]=z[i][j]+matrixLeft[i][k]*matrixRight[k][j];
                }
            }
        }


        return z;
    }


}
