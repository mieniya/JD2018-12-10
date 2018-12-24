package by.it.kushnerov.jd01_04;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();
        String[] mas = new String[n];
        int[][] salary = new int[n][4];
        int sumall = 0;
        int[] sumsal = new int[n];


        for (int i = 0; i < n; i++) {
            mas[i]=scanner.next();
        }

        for (int i = 0; i < n; i++) {
            int summ = 0;
                System.out.println("Введите зарплату для "+mas[i]+"а");
            for (int j = 0; j < 4; j++) {
                salary[i][j] = scanner.nextInt();
                summ = summ + salary[i][j];
            }
            sumsal[i] = summ;
            sumall += sumsal[i];
        }
        double avrg =(double) sumall/4/n;

        System.out.println("-----------------------------------------------------------------------------------");
        System.out.printf("%-9s%-10s%-10s%-10s%-10s%-5s%n","Фамилия","Квартал1","Квартал2","Квартал3","Квартал4","Итого");
        System.out.println("-----------------------------------------------------------------------------------");
        for (int i = 0; i < n; i++) {
                System.out.printf("%-9s:%-10d%-10d%-10d%-10d%-10d%n",mas[i],salary[i][0],salary[i][1],salary[i][2],salary[i][3],sumsal[i]);
        }
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.printf("%-9s%-5d%n","Итого",sumall);
        System.out.printf("%-9s%-10.5f ","Средняя",avrg);
    }
}
