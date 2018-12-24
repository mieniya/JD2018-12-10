package by.it.moroz.jd01_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TaskB {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int month = Integer.parseInt(reader.readLine());
        double a = Double.parseDouble(reader.readLine());
        double b = Double.parseDouble(reader.readLine());
        double c = Double.parseDouble(reader.readLine());

        step1();
        step2(month);
        step3(a, b, c);
    }
    static void step1(){
        int [][] matrix = {{1, 2, 3, 4, 5},
                           {6, 7, 8, 9, 10},
                           {11, 12, 13, 14, 15},
                           {16, 17, 18, 19, 20},
                           {21, 22, 23, 24, 25}};

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(matrix[i][j]+ " ");
            }
            System.out.println();
        }

    }
    static void step2(int month){
        switch (month){
            case 1:{
                System.out.println("январь");
                break;
            }
            case 2:{
                System.out.println("февраль");
                break;
            }
            case 3:{
                System.out.println("март");
                break;
            }
            case 4:{
                System.out.println("апрель");
                break;
            }
            case 5:{
                System.out.println("май");
                break;
            }
            case 6:{
                System.out.println("июнь");
                break;
            }
            case 7:{
                System.out.println("июль");
                break;
            }
            case 8:{
                System.out.println("август");
                break;
            }
            case 9:{
                System.out.println("сентябрь");
                break;
            }
            case 10:{
                System.out.println("октябрь");
                break;
            }
            case 11:{
                System.out.println("ноябрь");
                break;
            }
            case 12:{
                System.out.println("декабрь");
                break;
            }
            default:{
                System.out.println("нет такого месяца");
            }
        }

    }
    static void step3(double a, double b, double c){

        double D = b*b -4*a*c;
        if (D>0){
            double d1 =(-b+Math.sqrt(D))/(2*a);
            double d2 =(-b-Math.sqrt(D))/(2*a);
            System.out.println(d1 +" "+ d2);
        }
        else if (D==0) {
            double d = -b/(2*a);
            System.out.println(d);
        }
        else System.out.println("корней нет");
    }
}
