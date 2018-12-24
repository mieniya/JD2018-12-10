package by.it.yarmolenka.jd01_03;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Введите строку чисел");
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        double[] array = InOut.getArray(s);
        InOut.printArray(array);
        String name = "Массив";
        int col = 4;
        InOut.printArray(array, name, col);
        double max = Helper.findMax(array);
        double min = Helper.findMin(array);
        Helper.sort(array);
        System.out.println("max = " + max + ", min = " + min);
        double[][] matrix1 = {{1, 4, 2}, {6, 2, 1}, {8, 5, 3}};
        double[][] matrix2 = {{4, 3, 2}, {2, 7, 3}, {9, 2, 7}};
        double[] vector = {5, 5, 5};
        double[] res = Helper.mul(matrix1, vector);
        double[][] arr = Helper.mul(matrix1, matrix2);
        System.out.println(res[0]);
        System.out.println(arr[0][0]);
    }
}
