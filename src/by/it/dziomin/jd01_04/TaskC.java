package by.it.dziomin.jd01_04;

import java.util.Scanner;

public class TaskC {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        buildOneDimArray(str);
    }


    static void buildOneDimArray(String line) {
        double[] array = InOut.getArray(line);
        double first = array[0];
        double last = array[array.length - 1];
        int firstIndex = 0;
        int lastIndex = 0;
        System.out.println();
        InOut.printArray(array, "V", 5);
//        array = Helper.sort(array);
        array = mergeSort(array, 0, array.length - 1);
        System.out.println();
        InOut.printArray(array, "V", 4);
        for (int i = 0; i < array.length; i++) {
            if (first == array[i]) {
                firstIndex = i;
                break;
            }
        }
        for (int i = 0; i < array.length; i++) {
            if (last == array[i]) {
                lastIndex = i;
                break;
            }
        }
        System.out.println();
        System.out.printf("Index of first element=%-2d", firstIndex);
        System.out.printf("\nIndex of last element=%-2d\n", lastIndex);
    }

    static void mergeSort(double[] array) {

        double[] result = mergeSort(array, 0, array.length - 1);
        for (int i = 0; i < result.length; i++) {
            array[i] = result[i];
        }
    }

    private static double[] mergeSort(double[] array, int leftIndex, int rightIndex) {
        double[] result;

        if (leftIndex == rightIndex) {
            result = new double[]{array[leftIndex]};
            return result;
        }

        int mid = (leftIndex + rightIndex) / 2;

        double[] leftArray = mergeSort(array, leftIndex, mid);
        double[] rightArray = mergeSort(array, mid + 1, rightIndex);
        result = merge(leftArray, rightArray);

        return result;
    }


    private static double[] merge(double[] part1, double[] part2) {
        int size = part1.length + part2.length;
        double[] result = new double[size];

        int j = 0;
        int k = 0;
        for (int i = 0; i < size; i++) {
            if (j >= part1.length) {
                result[i] = part2[k];
                k++;
            } else if (k >= part2.length) {
                result[i] = part1[j];
                j++;
            } else if (part1[j] > part2[k]) {
                result[i] = part2[k];
                k++;
            } else {
                result[i] = part1[j];
                j++;
            }
        }
        return result;
    }

    private static int binarySearch(double[] array, double value) {
        return binarySearch(array, value, 0, array.length - 1);
    }

    private static int binarySearch(double[] array, double value, int left, int right) {
        if (array[left] == value) {
            return left;
        }

        if (array[right] == value) {
            return right;
        }

        int mid = (left + right) / 2;

        if (value <= array[mid]) {
            return binarySearch(array, value, left, mid);
        } else {
            return binarySearch(array, value, mid, right);
        }
    }

}

