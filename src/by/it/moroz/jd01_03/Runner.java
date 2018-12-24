package by.it.moroz.jd01_03;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        double[] array = InOut.getArray(line);
        System.out.println("First out");
        InOut.printArray(array);
        System.out.println("Second out");
        InOut.printArray(array, "i", 5);
        double[] arr = InOut.getArray(line);
        System.out.println("Find MIN");
        System.out.println(Helper.findMin(arr));
        System.out.println("Find MAX");
        System.out.println(Helper.findMax(arr));
        System.out.println("Sorted massive");
        Helper.sort(arr);
        InOut.printArray(arr);



    }

}
