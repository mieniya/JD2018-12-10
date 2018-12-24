package by.it.yarmolenka.jd01_02;

import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите размер матрицы: ");
        int n = sc.nextInt();
        int[][] arr = step1(n);
        int sum = step2(arr);
        arr = step3(arr);
        System.out.println(sum);
        for (int[] ints : arr) {
            for (int anInt : ints) {
                System.out.print(anInt+" ");
            }
            System.out.println();
        }
    }

    private static int[][] step1(int n) {
        int[][] arr = new int[n][n];
        boolean max, min;
        do {
            max = false;
            min = false;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = (int) (Math.random() * (2 * n + 1)) - n;
                    if (arr[i][j] == n) max = true;
                    if (arr[i][j] == -n) min = true;
                }
            }
        }
        while (!(max && min));
        for (int[] i : arr) {
            for (int j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
        return arr;
    }

    private static int step2(int[][] arr) {
        int sum = 0;
        for (int[] i : arr) {
            for (int j = 0; j < arr[0].length; j++) {
                if (i[j] > 0) {
                    for (int k = j + 1; k < arr.length; k++) {
                        if (i[k] > 0) break;
                        else sum += i[k];
                    }
                    break;
                }
            }
        }
        System.out.println("Сумма элементов между пер..... : " + sum);
        return sum;
    }

    private static int[][] step3(int[][] arr) {
        int max = arr[0][0];
        for (int[] i : arr)
            for (int j : i)
                if (j > max) max = j;
        boolean[] arri = new boolean[arr.length];
        boolean[] ar = new boolean[arr.length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == max) {
                    arri[i] = true;
                    ar[j] = true;
                }
            }
        }
        int it = 0, jit = 0;
        for (boolean b : arri) if (b) it += 1;
        for (boolean b : ar) if (b) jit += 1;
        int[][] res = new int[arr.length - it][arr[0].length - jit];
        int k = 0;
        for (int i = 0; i < arr.length; i++) {
            if (!arri[i]) {
                for (int j = 0, l = 0; j < arr.length; j++) {
                    if (!ar[j]) {
                        res[k][l] = arr[i][j];
                        l++;
                    }
                }
                k++;
            }
        }
        for (int[] re : res) {
            for (int i : re) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
        return res;
    }
}

