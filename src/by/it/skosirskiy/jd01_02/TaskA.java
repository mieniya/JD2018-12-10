package by.it.skosirskiy.jd01_02;

import java.util.Scanner;

public class TaskA {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] mas = new int[10];

        for (int i = 0; i < mas.length; i++) {
            mas[i] = scanner.nextInt();
        }
        step1(mas);
        step2(mas);
        step3(mas);

    }
         private static void step1(int[] mas){
            int min=mas[0];
            int max=mas[0];
            for (int element : mas) {
                if (min > element) min = element;
                if (max < element) max = element;

            }
            System.out.println(min+" "+max);
        }
        private static void step2(int[] mas){

            double average=0;
            double sum=0;

            for (int i = 0; i < mas.length; i++) {

                sum=sum+mas[i];
            }
            average=sum/mas.length;

            for (int i = 0; i < mas.length; i++) {
                if (average>mas[i])
                    System.out.print(mas[i]+" ");
                }

            }
        private static void step3(int[] mas){
            int min=mas[0];
            for (int i = 0; i < mas.length; i++) {
                if (min > mas[i]) min = mas[i];
            }
            for (int i = mas.length-1; i >=0 ; i--) {
                if (min == mas[i]) System.out.print(i+" ");

            }
            }



        }



