package by.it.skosirskiy.jd01_03;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str=scanner.nextLine();
        double min, max;
        double[] array = InOut.getArray(str);
        double[][] mas_dv={
                {6, 8, 1},
                {4, 2, 3},
                {7, 9, 4}
        };
        double[] vek= {7, 9, 5};
        InOut.printArray(array);
        InOut.printArray(array,"V",3);
        min=Helper.findMin(array);
        System.out.println("MIN:");
        System.out.println(min);
        max=Helper.findMax(array);
        System.out.println("MAX:");
        System.out.println(max);
        Helper.sort(array);
        System.out.println("otsortirovaniy massiv:");
        InOut.printArray(array);
        Helper.mul(mas_dv, vek);
        Helper.mul(mas_dv, mas_dv);
    }

}

