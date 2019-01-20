package by.it.skosirskiy.jd01_13;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Test {
    static int index=0;
    public static List<Double> linkedList = new LinkedList<>();

    static void readData() throws InterruptedException {
        try {
            Scanner scanner= new Scanner(System.in);
            linkedList.add(scanner.nextDouble());
        }
        catch (Exception e){

            index++;
            Thread.sleep(100);

        }



    }

    public static void main(String[] args) throws InterruptedException {


        while (!(index==5)) {
            readData();

        }
        System.out.println(linkedList);
    }
}