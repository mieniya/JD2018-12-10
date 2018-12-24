package by.it.pkzm.jd01_03;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter array");
        String line = scanner.nextLine();
        double[] array = InOut.getArray(line);
        System.out.println("First output");
        InOut.printArray(array);
        System.out.println("Second output");
        InOut.printArray(array, "A", 3);
        System.out.println("Максимум " + Helper.findMax(array));
        System.out.println(" Минимум " + Helper.findMin(array));
        Helper.sort(array);

    }
}
