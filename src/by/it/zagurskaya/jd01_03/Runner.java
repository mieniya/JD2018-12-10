package by.it.zagurskaya.jd01_03;

import java.util.Scanner;

public class Runner {
    public static void main (String args) {
        Scanner scanner=new Scanner(System.in);
        String line = scanner.nextLine();
        double [] array =InOut.getArray(line);
        System.out.println("First out");
        InOut.printArray(array);
        System.out.println("Second out");
        InOut.printArray(array,"A",3);

    }
}
