package by.it.subach.jd01_04;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        String[] lastName = new String[n];
        for (int i = 0; i < lastName.length; i++) {
            lastName[i] = scanner.next();
        }

        int[][] salary = new int[n][4];
//        for (int i = 0; i < n; i++) {
//            System.out.println("Введите зарплату для " + lastName[i]);
//            Scanner scanner1 = new Scanner(System.in);
//            String line = scanner.next();
//            line = line.trim();
//            String[] strArr = line.split(" ");
//            for (int j = 0; j < strArr.length; j++) {
//                salary[i][j] = Integer.parseInt(strArr[j]);
//            }
//
//        }

        for(int i = 0; i < n; i++){
            System.out.println("Введите зарплату для " + lastName[i]);
            for(int j = 0; j < salary[0].length; j++){
                salary[i][j] = scanner.nextInt();
            }
        }

        int sum = 0;
        System.out.println("--------------------------------------------------------");
        System.out.printf("%-10s%-10s%-10s%-10s%-10s%-10s\n", "Фамилия", "Квартал1", "Квартал2", "Квартал3", "Квартал4", "Итого");
        System.out.println("--------------------------------------------------------");
        for (int i = 0; i < n; i++) {
            System.out.printf("%-10s%-10d%-10d%-10d%-10d%-10d\n", lastName[i] + ":", salary[i][0], salary[i][1], salary[i][2], salary[i][3],
                    salary[i][0] + salary[i][1] + salary[i][2] + salary[i][3]);
             sum += salary[i][0] + salary[i][1] + salary[i][2] + salary[i][3];
        }
        System.out.println("---------------------------------------------------------");
        System.out.printf("%-10s%-10d\n", "Итого", sum);
        System.out.printf("%-10s%-10.4f\n", "Средняя", (double) sum / 4 / n);
    }
}
