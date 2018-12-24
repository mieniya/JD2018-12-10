package by.it.dziomin.jd01_04;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите число людей");
        int count = sc.nextInt();
        System.out.println("Введите фамилии");
        String[] str = new String[count];
        for (int i = 0; i < count; i++) {
            str[i] = sc.next();
        }
        int[][] salary = new int[count][4];
        int[] salaryYear = new int[count];
        int itogo = 0;
        for (int i = 0; i < count; i++) {
            System.out.println("Введите зарплату для " + str[i]);
            for (int j = 0; j < 4; j++) {
                salary[i][j] = sc.nextInt();
                salaryYear[i] = salaryYear[i] + salary[i][j];
            }
            itogo = itogo + salaryYear[i];
        }
        double avg = (itogo / (4.0 * count));
        System.out.println("------------------------------------------------------------------------");
        System.out.printf("%10s%10s%10s%10s%10s%10s", "Фамилия", "Квартал1", "Квартал2", "Квартал3", "Квартал4", "Итого\n");
        System.out.println("------------------------------------------------------------------------");
        for (int i = 0; i < count; i++) {
            System.out.printf("%10s: ",str[i]);
            for (int j = 0; j < 4; j++) {
                System.out.printf("%-10d",salary[i][j]);
            }
            System.out.printf("%6d\n",salaryYear[i]);
        }
        System.out.println("------------------------------------------------------------------------");
        System.out.printf("%-15s%-10d", "Итого",itogo );
        System.out.printf("\n%-15s%-10.4f", "Средняя",avg);

    }
}
