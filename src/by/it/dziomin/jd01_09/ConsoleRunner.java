package by.it.dziomin.jd01_09;

import java.util.Scanner;

public class ConsoleRunner {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String input;
        Printer printer = new Printer();
        Parser pars = new Parser();
        while (!(input = sc.nextLine()).equalsIgnoreCase("END")) {
            printer.print(pars.calc(input));
        }

    }


}
