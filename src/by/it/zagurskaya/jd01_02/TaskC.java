package by.it.zagurskaya.jd01_02;

import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        System.out.println("Введите размерность маатрицы n=");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        step1(n);
        //int[][] masM = {{1, -2, -2, 6}, {-1, 2, -2, 2}, {-2, -2, -6, -2}, {1, 2, -2, 6}};
        step2(step1(n));
        //step2(masM);
        //step13();
    }

    private static int[][] step1(int n) {
        boolean minStep1 = false;
        boolean maxStep1 = false;
        int[][] array = new int[n][n];
        do {
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[i].length; j++) {
                    array[i][j] = -n + (int) (Math.random() * (n * 2 + 1));
                }
            }
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[i].length; j++) {
                    if (array[i][j] == -n) {
                        minStep1 = true;
                    } else if (array[i][j] == n) {
                        maxStep1 = true;
                    }
                }
            }
        } while (minStep1 == false || maxStep1 == false);

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
        return array;
    }

    //мой
    private static int step2(int[][] mas) {
        boolean ij1 = false;
        boolean ij2 = false;
        int sum = 0;
        for (int i = 0; i < mas.length; i++){
            for (int j = 0; j < mas[i].length; j++) {
                if (mas[i][j] > 0 & ij1 == false) {
                    ij1 = true;
                   } else if (mas[i][j]>0 & ij1 == true & ij2 == false) {
                    ij2=true;
                }
                else if (ij1 == true & ij2 == false) sum=sum+mas[i][j];
            };
        ij1 = false;
        ij2 = false;
    }
        System.out.println("Сумма элементов " + sum);
        return sum;
    }

    private static void step131(int[][] mas) {
        int maxElement;
        int k = 0;
        int m = mas.length;
        int[][] newMas = new int[m][m];
        int[][] masIJ = new int[m][2];
        maxElement = mas[1][1];
        for (int i = 0; i < mas[i].length; i++) {
            for (int j = 0; j < mas[j].length; j++) {
                if (mas[i][j] > maxElement) {
                    maxElement = mas[i][j];
                }
            }
        }
    }

    static int[][] step3(int[][] mas) {
        boolean[] delCol = new boolean[mas[0].length];
        boolean[] delRov = new boolean[mas.length];
        //fin max
        int max = Integer.MAX_VALUE;
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas[i].length; j++) {
                if (mas[i][j] > max)
                    max = mas[i][j];
            }
        }
        //mark deleted position
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas[i].length; j++) {
                if (mas[i][j] > max) {
                    delCol[j] = true;
                    delRov[i] = true;
                }
            }
        }
        //calc zize
        int rowCount = 0;

        for (boolean value : delRov) if (!value) rowCount++;
        int colCount = 0;
        for (boolean value : delCol) if (!value) colCount++;
        //creat result
        int[][] res = new int[rowCount][colCount];
        //fin result
        int ir = 0;
        int jr = 0;
        for (int i = 0; i < mas.length; i++) {
            if (!delRov[i]) {
                for (int j = 0; j < mas[i].length; j++) {
                    if (!delRov[j]) {
                        res[ir][jr++] = mas[i][j];
                    }
                }
                ir++;
                jr = 0;
            }

        }
        return res;
    }

}
