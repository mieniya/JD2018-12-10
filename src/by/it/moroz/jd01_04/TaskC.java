package by.it.moroz.jd01_04;

import java.util.Arrays;
import java.util.Scanner;

public class TaskC {

    static void buildOneDimArray(String line) {
        double[] array = InOut.getArray(line);
        mergeSort(array);

    }

    static void mergeSort(double[] array) {
        double[] res = mergeSort(array, 0, (array.length - 1));
        for (int i = 0; i < array.length; i++) {
            array[i] = res[i];
        }
    }

    private static double[] mergeSort(double[] array, int left, int right) {
        int length = right - left + 1;
        if (length == 1) {
            return new double[]{array[left]};
        }
        int half = (right + left) / 2;
        double[] a = mergeSort(array, left, half);
        double[] b = mergeSort(array, half + 1, right);

        return merge(a, b);
    }

    private static double[] merge(double[] part1, double[] part2) {
        double[] arr = new double[part1.length + part2.length];
        int i = 0;
        int j = 0;
        for (int k = 0; k < arr.length; k++) {
            if (i == part1.length) {
                arr[k] = part2[j];
                j++;
            } else if (j == part2.length) {
                arr[k] = part1[i];
                i++;
            } else {
                if (part1[i] < part2[j]) {
                    arr[k] = part1[i];
                    i++;
                } else {
                    arr[k] = part2[j];
                    j++;
                }
            }
        }
        return arr;
    }

    static int binarySearch(double[] array, double value) {
        int low = 0;
        int high = array.length-1;
        while (low<=high){
            int mid = (low+high)/2;
            if (array[mid]==value){
                return mid;
            }
            else if (array[mid]>value){
                high=mid-1;
            }
            else low=mid+1;
        }
        return -1;
    }

    public static void main(String[] args) {
        //Scanner scanner = new Scanner(System.in);
        //String line = scanner.nextLine();
        //buildOneDimArray(line);

        double[] t = {8, 7, 9, 4, 3, 5, 6, 2, 0, 1};
        double a = t[0];
        double b = t[t.length-1];
        mergeSort(t);
        System.out.println(Arrays.toString(t));
        System.out.println(binarySearch(t, a));
        System.out.println(binarySearch(t, b));
    }
}
