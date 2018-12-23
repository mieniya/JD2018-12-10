package by.it.agadzhanov.jd01_03;

import java.util.Scanner;

class InOut {
    /**
     * @param line Строка с числами через пробел
     * @return Массив с заданными числовыми элементами
     */
    static double[] getArray(String line) {
        line = line.trim();
        String[] strArr = line.split(" ");
        double[] res = new double[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            res[i] = Double.parseDouble(strArr[i]);
        }
        return res;
    }

    /**
     * @param arr Исходный массив из чисел
     */
    static void printArray(double[] arr) {
        for (double element : arr) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    /**
     * @param arr Исходный массив из чисел
     * @param name Имя массива
     * @param columnCount Число колонок нв выводе
     */
    static void printArray(double[] arr, String name, int columnCount) {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%s[% -3d]=%-10.4f ", name, i, arr[i]);
            if ((i + 1) % columnCount == 0 || i == arr.length - 1)
                System.out.println();
        }
    }

    /**
     * @param rows Количество рядов в матрице
     * @param columns Количество колонок в матрице
     * @return Получившаяся матрица
     */
    static double[][] getArray2D(int rows,int columns) {
        double[][] res=new double[rows][columns];
        Scanner scanner=new Scanner(System.in);
        for (int i = 0; i < rows; i++) {
            String line=scanner.nextLine();
            line = line.trim();
            String[] strArr = line.split(" ");
            for (int j = 0; j < columns; j++) {
                res[i][j]=Double.parseDouble(strArr[j]);
            }
        }
        return res;
    }

    /**
     * @param arr Исходная матрица
     */
    static void printArray2D(double[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j]+" ");
                if (j==arr[0].length-1)
                    System.out.println();
            }
        }
        System.out.println();
    }
}