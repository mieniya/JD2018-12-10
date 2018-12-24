package by.it.kushnerov.jd01_03;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String line = scanner.nextLine();
        double[] arr = InOut.getArray(line);
        InOut.getArray(line);
        InOut.printArray(arr);
//        InOut.printArray(arr,"A",5);
//        Helper.findMin(arr);
//        Helper.findMax(arr);
        Helper.sort(arr);
    }
}
