package by.it.moroz.jd01_03;

public class Helper {

    static double findMin(double[ ] arr){
        if (0==arr.length){
            return Double.MIN_VALUE;
        }
        else {
            double min = arr[0];
            for (double m : arr) {
                if (min>m) min=m;
            }
            return min;
        }
    }

    static double findMax(double[ ] arr){
        if (0==arr.length){
            return Double.MAX_VALUE;
        }
        else {
            double max = arr[0];
            for (double m : arr) {
                if (max<m) max=m;
            }
            return max;
        }
    }

    static double[] sort(double[] arr){

        boolean swap;
        int last = arr.length-1;
        do{
            swap=false;
            for (int j=0; j<last; j++){
                if (arr[j]> arr[j+1]){
                   double buffer = arr[j];
                   arr [j]=arr[j+1];
                   arr[j+1]=buffer;
                   swap=true;
                }
            }
            last--;
        }
        while (swap);
        return arr;
    }

    static double[ ] mul(double[ ][ ] matrix, double[ ] vector){

        double[]mat = new double[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < vector.length; j++) {
                mat[i]=mat[i]+matrix[i][j]*vector[j];
            }
            
        }
        return mat;
    }

    static double[ ][ ] mul(double[ ][ ] matrixLeft, double[ ][ ] matrixRight){

        double[][]mat = new double[matrixLeft.length][matrixRight[0].length];
        for (int i = 0; i < matrixLeft.length; i++) {
            for (int j = 0; j < matrixRight[0].length; j++) {
                for (int g=0; g<matrixRight.length; g++){
                    mat[i][j]= mat[i][j]+matrixLeft[i][g]*matrixRight[g][j];
                }
            }
        }
        return mat;
    }

}
