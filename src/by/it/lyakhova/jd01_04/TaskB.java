package by.it.lyakhova.jd01_04;

import java.util.Scanner;

public class TaskB {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите количество людей");
        int n=scanner.nextInt();

        System.out.println("Введите фамилии");
        String[] families = new String[n];
        for (int i = 0; i < n; i++) {
            families[i]=scanner.next();
        }

        int paymentsAll=0;
        int[] sum = new int[n];

        int[][] payments = new int[n][4];
        for (int i = 0; i < n; i++) {
            System.out.println("Введите зарплату для "+families[i]);
            for (int j = 0; j < payments[0].length; j++) {
                payments[i][j]=scanner.nextInt();
                sum[i] = sum[i]+payments[i][j];
                paymentsAll = paymentsAll + payments[i][j];
            }
        }
        double avg = ((double) paymentsAll)/(n*payments[0].length);

        System.out.printf("%-9s%-9s%-9s%-9s%-9s%-6s\n", "Фамилия", "Квартал1", "Квартал2", "Квартал3", "Квартал4", "Итого");
        System.out.printf("---------------------------------------------------\n");
        for (int i = 0; i < n; i++) {
            System.out.printf("%8s ", families[i]+":");
            for (int j = 0; j < payments[0].length; j++) {
                System.out.printf("%-9d", payments[i][j]);
            }

            System.out.printf("%-6s\n", sum[i]);

        }
        System.out.printf("---------------------------------------------------\n");
        System.out.printf("%-9s%-9d\n", "Итого", paymentsAll);
        System.out.printf("%-9s%-9.6f\n", "Средняя", avg);
    }
}
