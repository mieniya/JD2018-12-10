package by.it.subach.jd01_02;

import java.util.Arrays;
import java.util.Scanner;

public class TaskC {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        step1(n);
        int[][] mas = new int[n][n];
        step2(mas);
        step3(mas);

    }


    //    Задание 1
    static int[][] step1(int n) {
        int[][] mas = new int[n][n];
        boolean negN;
        boolean posN;
        do {
            posN = false;
            negN = false;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    mas[i][j] = (int) (Math.random() * (2 * n + 1)) - n;
                    if (mas[i][j] == n) posN = true;
                    if (mas[i][j] == -n) negN = true;
                }
            }
        }
        while (posN == false || negN == false);

        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas.length; j++) {
                System.out.print(mas[i][j] + " ");
            }
            System.out.println();
        }
        return mas;
    }


    //    Задание 2
    static int step2(int[][] mas) {
        int sum = 0;
        for (int i = 0; i < mas.length; i++) {
            int indexStart = -1;
            int indexFinish = -1;
            for (int j = 0; j < mas[i].length; j++) {
                if (mas[i][j] > 0) {
                    if (indexFinish == indexStart)
                        indexStart = j + 1;
                    else
                        indexFinish = j;
                }
                if (indexFinish > indexStart) {
                    while (indexStart != indexFinish) {
                        sum += mas[i][indexStart];
                        indexStart++;
                    }
                }

            }
        }
        System.out.println(sum);
        return sum;
    }

    //    Задание 3
    static int[][] step3(int[][] mas) {

//          находим значение максимального элемента массива
        int max = mas[0][0];
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas[i].length; j++) {
                if (mas[i][j] > max) {
                    max = mas[i][j];
                }
            }
        }
        System.out.println(max);
//          заменяем все значения в строках и столбцах сод. максимальный элемент на max+1
        int indexI;
        int indexJ;
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas[i].length; j++) {
                if (mas[i][j] == max) {
                    mas[i][j] = max + 1;
                    for (indexI = 0; indexI < mas.length; indexI++) {
                        if (mas[indexI][j] < max) {
                            mas[indexI][j] = max + 1;
                        }
                    }
                    for (indexJ = 0; indexJ < mas[i].length; indexJ++) {
                        if (mas[i][indexJ] < max) {
                            mas[i][indexJ] = max + 1;
                        }
                    }
                }
            }
        }

//          считаем размер результирующего массива
        int resSizeI = 0;
        int resSizeJ = 0;
//        считаем количество столбцов
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas.length; j++) {
                if(mas[i][j] < max){
                    resSizeJ++;
                }
            }
            if(resSizeJ > 0)
                break;
        }
//        считаем количество строк
        for (int j = 0; j < mas.length; j++) {
            for (int i = 0; i < mas.length; i++) {
                if(mas[i][j] > 0){
                    resSizeI++;
                }
            }
            if(resSizeI > 0)
                break;
        }


        int[][] resArr = new int[resSizeI][resSizeJ];
        int iR = 0;     //индексы строк массива resArr
        int jR = 0;     //индексы столбцов массива resArr
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas[i].length; j++) {
                if (mas[i][j] < max) {
                    resArr[iR][jR] = mas[i][j];
                    if (jR < resArr.length) {
                        jR++;
                    } else {
                        iR++;
                        jR = 0;
                    }
                }
            }
        }


        System.out.println(resSizeI + " " + resSizeJ);
        System.out.println(Arrays.deepToString(mas));
        System.out.println(Arrays.deepToString(resArr));
        return resArr;
    }

}
