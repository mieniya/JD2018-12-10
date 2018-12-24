package by.it.zagurskaya.jd01_04;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите количество человек");
        int number = scanner.nextInt();

        System.out.println("Введите ФИО сотрудника");
        // String line = scanner.next();
        String[] masName = new String[number];
        for (int i = 0; i < number; i++) {
            masName[i] = scanner.next();
        }
        //printArrayName(masName);

        System.out.println("Введите зп поквартально для сотрудников");
        int[][] salary = new int[number][4];
        for (int i = 0; i < number; i++) {
            System.out.println("Введите зарплату для  " + masName[i]);
            for (int j = 0; j < salary[0].length; j++) {
                salary[i][j] = scanner.nextInt();
            }
        }
        //printArraySalary(salary);
        int sumAll =0;
        double salaryAvg=0;
        System.out.printf("%-11s%-11s%-11s%-11s%-11s%-11s%n", "Фамилия", "Квартал1", "Квартал2", "Квартал3", "Квартал4", "Итого");
        System.out.println("--------------------------------------------------------------");
        for (int i = 0; i < number; i++) {
            int sum = 0;
            System.out.printf("%-11s", masName[i]);
            for (int j = 0; j < salary[0].length; j++) {
                System.out.printf("%-11d", salary[i][j]);
                sum = sum + salary[i][j];
                sumAll=sumAll+salary[i][j];
            }
            System.out.printf("%-11s%n", sum);
        }
        System.out.println("--------------------------------------------------------------");
        System.out.printf("%-11s%-11s%n", "Итого",sumAll);
        // как сделать чтоб не округлять??????
        salaryAvg=(double)sumAll / (number * salary[0].length);
        System.out.printf("%-11s%-11.4f%n", "Итого",salaryAvg);
    }

    /**
     * Print one-dimensional array
     * @param  arr one-dimensional array
     */
    static void printArrayName(String[] arr) {
        System.out.println("Сотрудники");
        for (String element : arr) {
            System.out.print(element + " ");
            System.out.println();
        }
    }

    /**
     * Print two-dimensional array
     * @param arr two-dimensional array
     */
    static void printArraySalary(int[][] arr) {
        System.out.println("ЗП");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }
}
