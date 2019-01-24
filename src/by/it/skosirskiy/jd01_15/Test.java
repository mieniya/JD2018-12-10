package by.it.skosirskiy.jd01_15;

import java.io.File;
import java.util.Scanner;

public class Test {
    static String src = System.getProperty("user.dir")+"\\src\\by\\it\\skosirskiy\\";
    static String dir = src+"jd01_15\\TaskC.java";
    public static void main(String[] args) {


        File file = new File(dir);


        System.out.println(file.getAbsolutePath());


    }
}
