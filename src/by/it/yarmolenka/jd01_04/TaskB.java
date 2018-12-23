package by.it.yarmolenka.jd01_04;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите количество людей");
        int n = sc.nextInt();
        String[] fam = new String[n];
        System.out.println("Введите фамилии");
        for (int i = 0; i < fam.length; i++) fam[i] = sc.next();
        int[][] array = new int[n][4];
        for (int i = 0; i < array.length; i++) {
            System.out.println("Введите зарплату для " + fam[i]);
            for (int j = 0; j < array[0].length; j++) array[i][j] = sc.nextInt();
        }
        System.out.println("-------------------------------------------------------");
        System.out.printf("%-10s%-10s%-10s%-10s%-10s%-5s\n", "Фамилия", "Квартал1", "Квартал2", "Квартал3", "Квартал4", "Итого");
        System.out.println("-------------------------------------------------------");
        int sum, sum1 = 0;
        for (int i = 0; i < fam.length; i++) {
            System.out.printf("%10s", fam[i]);
            sum = 0;
            for (int j = 0; j < array[0].length; j++){
                sum+=array[i][j]; sum1+=array[i][j];
                System.out.printf("%-10d", array[i][j]);
            }
            System.out.printf("%-5d\n", sum);
        }
        System.out.println("-------------------------------------------------------");
        System.out.printf("%-10s%-5d\n","Итого", sum1);
        double aver = (double)sum1/(double)(array.length*array[0].length);
        System.out.printf("%-10s%-10.5f\n","Средняя", aver);
    }
}
