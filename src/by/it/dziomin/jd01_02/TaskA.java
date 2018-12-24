package by.it.dziomin.jd01_02;

import java.util.Scanner;

public class TaskA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] mas = new int[10];
        for (int i = 0; i < mas.length; i++) {
            mas[i] = sc.nextInt();
        }
        step1(mas);
        step2(mas);
        step3(mas);
    }

    static void step1(int[] mas) {
        int min = mas[0];
        int max = mas[0];
        for (int i : mas) {
            if (min > i) min = i;
            if (max < i) max = i;
        }
        System.out.println(min + " " + max);
    }

    static void step2(int[] mas) {
        int sum = 0;
        for (int element : mas) {
            sum = sum + element;
        }
        float avg = (float) sum / mas.length;
        for (int element : mas) {
            if (element < avg)
                System.out.println(element);
        }
    }

    static void step3(int[] mas) {
        int min = mas[0];
        for (int element : mas) {
            if (min > element) min = element;
        }
        for (int i = mas.length - 1; i >= 0; i--) {
            if (mas[i] == min)
                System.out.print(i + " ");
        }

    }
}
