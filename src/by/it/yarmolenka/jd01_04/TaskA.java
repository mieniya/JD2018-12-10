package by.it.yarmolenka.jd01_04;

import java.util.Scanner;

public class TaskA {
    private static void printMulTable() {
        for (int i = 2; i < 10; i++) {
            for (int j = 2; j < 10; j++) System.out.printf("%d*%d=%-2d ", i, j, i * j);
            System.out.println();
        }
    }

    private static void buildOneDimArray(String line) {
        double[] array = InOut.getDoubleArray(line);
        String name = "V";
        InOut.printArray(array, name, 5);
        double first = array[0];
        double last = array[array.length - 1];
        Helper.bubbleSort(array);
        InOut.printArray(array, name, 4);
        for (int i = 0; i < array.length; i++)
            if (array[i] == first) {
                System.out.printf("first element=%d\n", i);
                break;
            }
        for (int i = 0; i < array.length; i++)
            if (array[i] == last) {
                System.out.printf("last element=%d\n", i);
                break;
            }
    }

    public static void main(String[] args) {
        printMulTable();
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        buildOneDimArray(s);
    }
}
