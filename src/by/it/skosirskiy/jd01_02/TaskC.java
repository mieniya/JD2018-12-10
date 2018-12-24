package by.it.skosirskiy.jd01_02;

import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] mas= step1(n);

        step2(mas);
        step3();

    }

    private static int[ ][ ] step1(int n) {
        int [][]mas = new int[n][n];
        boolean n1 = false;
        boolean n2 =false;

        do {

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    mas[i][j] = (int) (Math.random()*(n-(-n)+1))-n;
                    if (mas[i][j] == n) n1 = true;
                    if (mas[i][j] == -n) n2 = true;

                }
            }
            for (int i = 0; i <n ; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(" "+mas[i][j]);

                }
                System.out.println();
            }


        }
        while (!(n1==true&& n2==true));
        return mas;
    }

     private static int step2(int[][] mas) {
       int sum=0;
       int buf[]= new int[2];


        for (int i = 0; i < mas.length; i++) {
            int sumstroki = 0;
            int count=0;
            for (int j = 0; j < mas.length; j++) {
                if (mas[i][j]>0) {
                    buf[count]=j;
                    ++count;
                    if (count==2) {
                        for (int k = buf[0]+1; k < buf[1]; k++) {
                            sumstroki=sumstroki+mas[i][k];

                        }
                    sum=sum+sumstroki;
                        break;
                    }

                }


            }


        }
        System.out.println(sum);


        return sum;
    }
    private static void step3() {
    }


}
