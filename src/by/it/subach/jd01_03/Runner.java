package by.it.subach.jd01_03;

import java.util.Arrays;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        double [] array = InOut.getArray(line);
        InOut.printArray(array);
        System.out.println();
        InOut.printArray(array, "v", 5);

        Helper.sort(array);
















    }
}
