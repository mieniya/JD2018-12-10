package by.it.dziomin.jd01_02;

import java.util.*;

public final class TaskC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int mas[][] = step1(n);
        print(mas);
        step2(mas);
        step3(mas);
    }

    static void print(int[][] mas) {
        for (int[] stroka : mas) {
            for (int element : stroka) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    static int[][] step1(int n) {
        int mas[][] = new int[n][n];
        Random random = new Random();
        boolean max;
        boolean min;

        do {
            max = false;
            min = false;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    mas[i][j] = random.nextInt(2 * n + 1) - n;
                    if (mas[i][j] == n)
                        max = true;
                    else if (mas[i][j] == -n)
                        min = true;
                }
            }
        } while (!max || !min);

        return mas;
    }

    static int step2(int[][] mas) {
        int sum = 0;

        for (int[] stroka : mas) {
            int c = 0;
            int sumStr = 0;
            for (int element : stroka) {
                if (element > 0) {
                    c++;
                } else if (c == 1) {
                    sumStr = sumStr + element;
                }
            }
            if (c > 1) {
                sum = sum + sumStr;
            }
        }
        System.out.println(sum);
        return sum;
    }

    static int[][] step3(int[][] mas) {
        int k = mas.length;
        int n = mas[0].length;

        int max = mas[0][0];

        for (int[] stroka : mas) {
            for (int element : stroka) {
                if (element > max)
                    max = element;
            }
        }

        HashSet<Integer> ii = new HashSet<>();
        HashSet<Integer> jj = new HashSet<>();
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < n; j++) {
                if (mas[i][j] == max) {
                    ii.add(i);
                    jj.add(j);
                }
            }
        }

        int[][] result = new int[k - ii.size()][n - jj.size()];
        int a = 0;
        for (int i = 0; i < k; i++) {
            if (!ii.contains(i)) {
                //копируем строку
                int b = 0;
                for (int j = 0; j < n; j++) {
                    if (!jj.contains(j)) {
                        result[a][b] = mas[i][j];
                        b++;
                    }
                }
                a++;
            }
        }


        System.out.println("max " + max);
        print(result);
        return result;
    }

}
