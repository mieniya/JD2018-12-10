package by.it.subach.jd01_02;

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


    static void step1(int[] mas) {
        int max = mas[0];
        int min = mas[0];
        for (int i = 0; i < mas.length; i++) {
            if (mas[i] > max) max = mas[i];
            if (mas[i] < min) min = mas[i];
        }

        System.out.println(min + " " + max);

    }

    static void step2(int[] mas) {
        double avg;
        int sum = 0;
        for (int elem : mas) {
            sum += elem;
        }
        avg = sum / mas.length;

        for (int elem : mas) {
            if (elem < avg)
                System.out.println(elem);
        }
    }

    static void step3(int[] mas) {
        int min = mas[0];

        for (int elem : mas) {
            if (elem < min) min = elem;
        }

        for (int i = mas.length - 1; i >= 0; i--) {
            if (mas[i] == min)
                System.out.print(i + " ");
        }

    }

}
