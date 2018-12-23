/**package by.it.agadzhanov.jd01_04;

import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        buildOneDimArray(line);
    }

    private static void buildOneDimArray(String line) {
        double[] array = InOut.getArray(line);
        InOut.printArray(array, "V", 5);
        double first = array[0];
        double last = array[array.length - 1];
        double[] sortedArray = mergeSort(array, 0, array.length - 1);
        InOut.printArray(sortedArray, "V", 4);
        for (int i = 0; i < array.length; i++) {
            if (first == sortedArray[i]) {
                System.out.printf("Index of first element=%d\n", i);
                break;
            }
        }
        for (int i = 0; i < array.length; i++) {
            if (last == sortedArray[i]) {
                System.out.printf("Index of last element=%d\n", i);
                break;
            }
        }
    }

    private static double[] merge(double[] partLeft, double[] partRight) {
        int totalLength = partLeft.length + partRight.length;
        double[] mergedMas = new double[totalLength];
        int l = 0;
        int r = 0;
        int i = 0;
        while (i < totalLength) {
            if (r < partRight.length && l < partLeft.length) {
                if (partLeft[l] < partRight[r]) {
                    mergedMas[i] = partLeft[l];
                    i++;
                    l++;
                }
                else {
                    mergedMas[i] = partRight[r];
                    i++;
                    r++;
                }
            }
            else if (r==partRight.length) {
                mergedMas[i]=partLeft[l];
                i++;
                l++;
            }
            else if (l==partLeft.length) {
                mergedMas[i]=partRight[r];
                i++;
                r++;
            }
        }
        return mergedMas;
    }

    private static double[] mergeSort(double[] array, int left, int right) {
        double[] sortedArray = new double[array.length];
        if (left < right) {
            int middle = (left + right) / 2;
            double[] arrayLeft = new double[middle - left + 1];
            double[] arrayRight = new double[right - middle];
            for (int i = left; i <= middle; i++) {
                arrayLeft[i - left] = array[i];
            }
            for (int j = middle + 1; j <= right; j++) {
                arrayRight[j - (middle + 1)] = array[j];
            }
            sortedArray = merge(mergeSort(arrayLeft, left, middle), mergeSort(arrayRight, middle + 1, right));
        }
        return sortedArray;
    }
}
 */