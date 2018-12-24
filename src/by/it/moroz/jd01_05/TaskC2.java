package by.it.moroz.jd01_05;

import java.util.Arrays;

public class TaskC2 {
    public static void main(String[] args) {
        int [] arr1 = new int[31];
        for (int i = 0; i < arr1.length; i++) {
            arr1[i]= (int) (Math.random()*348)+103;
        }
        System.out.println(Arrays.toString(arr1));
        int [] arr2 = MergeSort.mergeSort(arr1);
        for (int i = 0; i < arr1.length; i++) {
            arr2[i] = arr1[i];
        }
        int count = 0;
        for (int i = 0; i < arr2.length; i++) {
            if (arr2[i]%0.1 > i) {
                count++;
            }
        }
        int [] arr3 = new int[count];
        int j=0;
        for (int i = 0; i < arr2.length; i++) {
            //double v = arr2[i]*0.1;
            if ((arr2[i]*0.1) > i) {
                arr3[j]=arr2[i];
                j++;
            }
        }
        System.out.println(Arrays.toString(arr3));
    }

}
