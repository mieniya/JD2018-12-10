package by.it.migunko.jd01_03;
import java.util.Arrays;
public class Helper {

    static double findMin(double[ ] arr){
        double min = arr [0];
        for (double element : arr) {
            if (min>element) min=element;
        }
        System.out.println("Min="+min);
        return min;
    }

    static double findMax(double[ ] arr){
        double max = arr [0];
        for (double element : arr) {
            if (max<element) max=element;
        }
        System.out.println("Max="+max);
        return max;
    }
    public static void sort(double[ ] arr){

        for (int i = 0; i < arr.length-1 ; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if(arr[i]>arr[j])
                {double m=arr[i];
                    arr[i]=arr[j];
                    arr[j]=m;}}}
        InOut.printArray(arr);


    }
}
