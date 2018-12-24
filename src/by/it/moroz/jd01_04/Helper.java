package by.it.moroz.jd01_04;

import java.util.Arrays;

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
}
