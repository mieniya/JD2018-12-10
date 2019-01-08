package by.it.kushnerov.jd01_04;

import java.util.Arrays;
import java.util.Scanner;

public class TaskC {

    static void buildOneDimArray(String line){
        double[] array = InOut.getArray(line);
        InOut.printArray(array,"V",5);

        double first = array[0];
        double last = array[array.length-1];

        Helper.sort(array);
        InOut.printArray(array,"V",4);

        for (int i = 0; i < array.length; i++) {
            if (first==array[i])
                System.out.printf("Index of first element=%d\n",i);
            break;
        }

        for (int i = 0; i < array.length; i++) {
            if (last==array[i])
                System.out.printf("Index of first element=%d\n",i);
            break;
        }
    }

     static void mergeSort(double[] array){
         double[] result = mergeSort(array, 0, array.length-1);
         for (int i = 0; i < array.length; i++) {
             array[i] = result[i];
         }
     }

    private static double[] mergeSort(double[] array, int left, int right){
        if (right == left) return array;
        int mid = (left + right)/2;
        return merge(mergeSort(array,left,mid),mergeSort(array,mid+1,right));
    }

    private static double[] merge(double[] part1,double[] part2){
        int len = part1.length + part2.length;
        double[] result=new double[len];
        int i1 = 0;
        int i2 = 0;
        int i = 0;
        while(i1+i2<len){
            if (i2 == part2.length || i1 < part1.length && part1[i1] <part2[i2]){
                result[i++] = part1[i1++];
            } else {
                result[i++] = part2[i2++];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        double[] mas = {1,2,3,46,76,44,123,1,1};
        mergeSort(mas);
        System.out.println(Arrays.toString(mas));
//        Scanner scanner = new Scanner(System.in);
//        String line = scanner.nextLine();
//        buildOneDimArray(line);
    }
}
