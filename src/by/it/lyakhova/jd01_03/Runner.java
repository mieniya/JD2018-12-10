package by.it.lyakhova.jd01_03;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        double[] array = InOut.getArray(line);
        System.out.println("First output");
        InOut.printArray(array);

        System.out.println("Second output");
        InOut.printArray(array, "A", 5);

        System.out.println("Минимум = " + Helper.findMin(array));
        System.out.println("Максимум = " + Helper.findMax(array));

        System.out.println("Sorted massive");
        Helper.sort(array);

        double[][] matrixLeft = {
                {1, 2, 3},
                {4, 5, 6}
        };
        double[][] matrixRight = {
                {1, 2},
                {2, 3},
                {3, 4}
        };
        double[] vector = {1, 2, 4};

        double[] vectorMult = Helper.mul(matrixLeft, vector);
        System.out.println("Vector");
        InOut.printArray(vectorMult);

        double[][] matrixMult = Helper.mul(matrixLeft, matrixRight);
        System.out.println("Matrix");
        InOut.printArray(matrixMult);
    }
}
