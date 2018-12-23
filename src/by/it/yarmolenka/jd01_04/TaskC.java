package by.it.yarmolenka.jd01_04;

import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        buildOneDimArray(s);
    }

    private static void buildOneDimArray(String line) {
        double[] array = InOut.getDoubleArray(line);
        String name = "V";
        InOut.printArray(array, name, 5);
        double first = array[0];
        double last = array[array.length - 1];
        mergeSort(array);
        InOut.printArray(array, name, 4);
        int f = binarySearch(array, first);
        int l = binarySearch(array, last);
        System.out.printf("first element=%d\n", f);
        System.out.printf("last element=%d\n", l);
    }

    private static void mergeSort(double[] array) {
        int m = array.length / 2;
        mergeSort(array, 0, m - 1);
        mergeSort(array, m, array.length - 1);
        double[] array1 = new double[m];
        double[] array2 = new double[array.length - m];
        System.arraycopy(array,0,array1,0,array1.length);
        System.arraycopy(array, m, array2, 0, array2.length);
        double[] array3 = merge(array1, array2);
        System.arraycopy(array3,0,array,0,array.length);
    }

    private static void mergeSort(double[] array, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            mergeSort(array, l, m);
            mergeSort(array, m + 1, r);
            double[] array1 = new double[m - l + 1];
            double[] array2 = new double[r - m];
            System.arraycopy(array, l, array1, 0, array1.length);
            System.arraycopy(array, m+1, array2, 0, array2.length);
            double[] array3 = merge(array1, array2);
            System.arraycopy(array3, 0, array, l, array3.length);
        }
    }

    private static double[] merge(double[] part1, double[] part2) {
        double[] res = new double[part1.length + part2.length];
        int k = 0, l = 0;
        for (int i = 0; i < res.length; i++)
            if (k < part1.length && l < part2.length) {
                if (part1[k] < part2[l]) {
                    res[i] = part1[k];
                    k++;
                } else {
                    res[i] = part2[l];
                    l++;
                }
            } else if (k == part1.length) {
                res[i] = part2[l];
                l++;
            } else {
                res[i] = part1[k];
                k++;
            }
        return res;
    }

    private static int binarySearch(double[] array, double value) {
        int f = 0, l = array.length - 1;
        while (l > f) {
            int m = f + (l - f) / 2;
            if (array[m] > value) l = m - 1;
            else if (array[m] < value) f = m + 1;
            else return m;
        }
        return f;
    }
}
