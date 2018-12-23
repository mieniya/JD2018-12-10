package by.it.pkzm.jd01_04;


import java.util.Scanner;

public class TaskA {
    static void printMulTable() {
        for (int i = 2; i < 10; i++) {
            for (int j = 2; j < 10; j++) {
                System.out.printf("%1d*%1d=%-2d ", i, j, i * j);
            }
            System.out.println();
        }

    }

    static void buildOneDimArray(String line) {
        double[] arr = InOut.getArray(line); // прочитали массив
        double start = arr[0];
        double stop = arr[arr.length - 1];
        InOut.printArray(arr, "V", 5);
        Helper.sort(arr);
        InOut.printArray(arr, "V", 4);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == start) {
                System.out.println("Index of first element= " + i);
                break;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == stop) {
                System.out.println("Index of last element= " + i);
                break;
            }
        }

    }

    public static void main(String[] args) {
        printMulTable();
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        buildOneDimArray(s);
    }
}