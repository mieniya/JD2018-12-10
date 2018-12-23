package by.it.agadzhanov.jd01_04;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        String[] surname = new String[n];
        for (int i = 0; i < n; i++) {
            surname[i] = scanner.next();
        }

        int[][] salary = new int[n][4];
        for (int i = 0; i < n; i++) {
            System.out.println("Введите зарплату для " + surname[i]);
            for (int j = 0; j < 4; j++) {
                salary[i][j] = scanner.nextInt();
            }
        }

        System.out.println("---------------------------------------------------------");
        System.out.printf("%-12s%-10s%-10s%-10s%-10s%5s","Фамилия","Квартал1","Квартал2","Квартал3","Квартал4","Итого");
        System.out.println();
        System.out.println("---------------------------------------------------------");

        int[] sum=new int[n];
        for (int i = 0; i < n; i++) {
            sum[i]=salary[i][0]+salary[i][1]+salary[i][2]+salary[i][3];
            System.out.printf("%10s: %-10d%-10d%-10d%-10d%-5d",surname[i],salary[i][0],salary[i][1],salary[i][2],salary[i][3],sum[i]);
            System.out.println();
        }
        System.out.println("---------------------------------------------------------");

        double sumAll=0;
        for (int i = 0; i < n; i++) {
            sumAll=sumAll+sum[i];
        }
        System.out.printf("%-12s%-4f","Итого",sumAll);
        System.out.println();

        double avg=sumAll/(4*n);
        System.out.printf("%-12s%-10.4f","Средняя",avg);
    }
}