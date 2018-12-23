package by.it.dziomin.jd01_04;

import java.util.Scanner;

public class TaskA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        String str = sc.nextLine();
        printMulTable();
        String str = sc.nextLine();
        buildOneDimArray(str);

    }

    static void printMulTable() {
        for (int i = 2; i < 10; i++) {
            for (int j = 2; j < 10; j++) {
                System.out.printf("%1d*%1d=%-3d", i, j, i * j);
            }
            System.out.println();
        }
    }

    static void buildOneDimArray(String line) {
        double[] array = InOut.getArray(line);
        double first = array[0];
        double last = array[array.length - 1];
        int firstIndex = 0;
        int lastIndex = 0;
        System.out.println();
        InOut.printArray(array, "V", 5);
        array = Helper.sort(array);
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

}
