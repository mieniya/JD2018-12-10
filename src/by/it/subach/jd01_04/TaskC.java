package by.it.subach.jd01_04;

import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        double[] array = {64, 21, 33, 70, 12, 85, 60, 0};
        mergeSort(array);
        InOut.printArray(array);
//        Scanner scanner = new Scanner(System.in);
//        String line = scanner.nextLine();
//        buildOneDimArray(line);

    }

    static void buildOneDimArray(String line) {
        double[] array = InOut.getArray(line);
        double firstElement = array[0];
        double lastElement = array[array.length - 1];
        InOut.printArray(array, "V", 4);
        mergeSort(array);
        System.out.println("first element=" + binarySearch(array, firstElement));
        System.out.println("last element=" + binarySearch(array, lastElement));

    }

    static void mergeSort(double[] array) {
        double[] resultArray = mergeSort(array, 0, array.length - 1);
        for (int i = 0; i < resultArray.length; i++) {
            array[i] = resultArray[i];
        }

    }

    private static double[] mergeSort(double[] array, int left, int right) {
        if (left == right) {
            double[] res = new double[1];
            res[0] = array[left];
            return res;
        }
        int mid = (left + right) / 2;

        double[] part1 = mergeSort(array, left, mid);

        double[] part2 = mergeSort(array, mid + 1, right);

        return merge(part1, part2);
    }

    //метод для слияния (merge) двух массивов
    private static double[] merge(double[] part1, double[] part2) {
        double[] mergArray = new double[part1.length + part2.length];
        int i = 0;      //индекс для массива part1
        int j = 0;      //индекс для массива part2
        int r = 0;      //индекс для результирующего массива mergArray

        //сравниваем эл-ты массивов, пока они не закончатся хотябы в одном из них
        while (i < part1.length && j < part2.length) {
            if (part1[i] < part2[j]) {
                mergArray[r] = part1[i];
                i++;
                r++;
            } else {
                mergArray[r] = part2[j];
                j++;
                r++;
            }
        }

        //если закончились в part2 - копируем оставшиеся эл-ты из part1
        while (i < part1.length) {
            mergArray[r] = part1[i];
            i++;
            r++;
        }

        //если закончились в part1 - копируем оставшиеся эл-ты из part2
        while (j < part2.length) {
            mergArray[r] = part2[j];
            j++;
            r++;
        }

        return mergArray;
    }

    static int binarySearch(double[] array, double value) {
        int firstIndex = 0;
        int lastIndex = array.length - 1;
        if (value == array[firstIndex]) {
            return firstIndex;
        }
        if (value == array[lastIndex]) {
            return lastIndex;
        }

        int mid = 0;
        while (array[mid] != value) {
            mid = (firstIndex + lastIndex) / 2;
            if (array[mid] < value) {
                firstIndex = mid + 1;
            } else {
                lastIndex = mid;
            }
        }
        return mid;

    }
}
