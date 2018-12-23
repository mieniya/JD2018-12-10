package by.it.yarmolenka.jd01_02;

import java.util.Scanner;

public class TaskA {
    public static void main(String[] args) {
        int[] mas = new int[10];
        Scanner sc = new Scanner(System.in);
//        for (int i : mas) i = sc.nextInt();
        for (int i = 0; i < mas.length; i++) mas[i] = sc.nextInt();
        step1(mas);
        step2(mas);
        step3(mas);
    }

    private static void step1(int[] arr) {
        int max = arr[0];
        int min = arr[0];
        for (int i : arr) {
            if (i < min) min = i;
            if (i > max) max = i;
        }
        System.out.println(min + " " + max);
    }

    private static void step2(int[] arr) {
        int sum = 0;
        for (int i : arr) sum += i;
        double aver = (double) (sum / arr.length);
        for (int i : arr) if (i < aver) System.out.print(i + " ");
        System.out.println();
    }

    private static void step3(int[] arr) {
        int min = arr[0];
        for (int i : arr) if (i < min) min = i;
        for (int i = arr.length - 1; i >= 0; i--) if (arr[i] == min) System.out.print(i + " ");
    }
}

