package by.it.dziomin.jd01_05;


import java.util.Random;

import static java.lang.Math.pow;

public class TaskC {
    public static void main(String[] args) {
        step1();
        step2();
    }

    public static void step1() {
        int colCount = 5;
        int sizeX = findArraySize(20, 40);
        double[] arrayX = createArrayX(sizeX, 5.33, 9);
        double[] arrayZ = createArrayZ(arrayX);

        System.out.println("-----------------------------------");
        System.out.println("Массив Z[]");
        printArray(arrayZ, colCount);

        double[] subArrayZ = createSubArrayZ(arrayZ, 3.5);

        System.out.println("\nМассив subZ[] из элементов массива Z > 3.5");
        printArray(subArrayZ, colCount);

        double avg = calculateAvg(subArrayZ);
        System.out.println("\nAVG=" + avg);
    }

    private static double calculateAvg(double[] array) {
        double avg = 1;
        for (double val : array) {
            avg = avg * val;
        }
        avg = avg / array.length;
        return avg;
    }

    private static double[] createSubArrayZ(double[] arrayZ, double value) {
        int subArraySize = 0;

        for (double v : arrayZ) {
            if (v > value) {
                subArraySize++;
            }
        }

        double[] subArrayZ = new double[subArraySize];
        int j = 0;
        for (int i = 0; j < subArraySize; i++) {
            if (arrayZ[i] > value) {
                subArrayZ[j] = arrayZ[i];
                j++;
            }
        }
        return subArrayZ;
    }

    private static void printArray(double[] array, int colCount) {
        for (int i = 0; i < array.length; i++) {
            System.out.printf("Z[ %-2d] = %-7.5f ", i, array[i]);
            if ((i + 1) % colCount == 0) {
                System.out.println();
            }
        }
    }

    private static double[] createArrayZ(double[] arrayX) {
        double[] arrayZ = new double[arrayX.length];
        for (int i = 0; i < arrayX.length; i++) {
            arrayZ[i] = pow((arrayX[i] * arrayX[i] + 4.5), 1 / 3.0);
        }
        return arrayZ;
    }

    private static double[] createArrayX(int sizeX, double left, double right) {
        double step = (right - left) / sizeX;

        double[] arrayX = new double[sizeX];
        for (int i = 0; i < sizeX - 1; i++) {
            arrayX[i] = left + step * i;
        }
        arrayX[sizeX - 1] = right;
        return arrayX;
    }

    private static int findArraySize(int left, int right) {
        Random random = new Random();
        return random.nextInt(left + 1) + right - left;
    }

    public static void step2() {
        int colCount = 5;
        int sizeA = 31;

        //создаем массив A
        int[] arrayA = createArrayA(sizeA);

        //печатаем массив A
        System.out.println("Массив A");
        printArray(arrayA, colCount);

        //создаем массив B
        int[] arrayB = createArrayB(arrayA);

        //сортировка В
        arrayB = sortArray(arrayB);

        //печатаем массив В
        System.out.println("Массив B");
        printArrayB(arrayB, colCount);
    }

    private static void printArrayB(int[] arr, int colCount) {
        int size = arr.length;
        if (size < colCount) {
            colCount = size;
        }

        int rowCount = (int) Math.ceil((double) size / colCount);

        int k = 0;
        boolean[][] isPrint = new boolean[rowCount][colCount];
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                if (k < size) {
                    isPrint[i][j] = true;
                } else {
                    isPrint[i][j] = false;
                }
                k++;
            }
        }

        k = 0;
        int[][] printIndex = new int[rowCount][colCount];
        for (int j = 0; j < colCount; j++) {
            for (int i = 0; i < rowCount; i++) {
                if (isPrint[i][j]) {
                    printIndex[i][j] = k;
                    k++;
                } else {
                    printIndex[i][j] = -1;
                }
            }
        }

        printUpline(colCount);

        for (int i = 0; i < rowCount; i++) {
            if (i > 0) {
                System.out.println();
                printMidline(colCount);
            }
            for (int j = 0; j < colCount; j++) {
                if (printIndex[i][j] >= 0) {
                    int ind = printIndex[i][j];
                    System.out.printf(" B[%2d]=%-4d\u2551", ind, arr[ind]);
                } else {
                    printEmptyCells();
                }
            }
        }
        printDownline(colCount);
    }

    private static int[] createArrayA(int size) {
        Random random = new Random();
        int[] arrayA = new int[size];
        for (int i = 0; i < size; i++) {
            arrayA[i] = random.nextInt(348) + 103;
        }
        return arrayA;
    }

    private static int[] createArrayB(int[] arrayA) {
        int sizeA = arrayA.length;
        int bCount = 0;
        //считаем размер массива В
        for (int i = 0; i < sizeA; i++) {
            if (arrayA[i] * 0.1 > i) {
                bCount++;
            }
        }

        int j = 0;
        int[] arrayB = new int[bCount];
        //заполняем массив В
        for (int i = 0; i < sizeA; i++) {
            if (arrayA[i] * 0.1 > i) {
                arrayB[j] = arrayA[i];
                j++;
            }
        }
        return arrayB;
    }

    private static int[] sortArray(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int needSort = 0;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                    needSort++;
                }
            }
            if (needSort == 0)
                break;
        }
        return arr;
    }


    private static void printArray(int[] arr, int colCount) {
        int size = arr.length;

        printUpline(colCount);

        for (int i = 0; i < size; i++) {
            System.out.printf(" A[%2d]=%-4d\u2551", i, arr[i]);
            if ((i + 1) % colCount == 0) {
                System.out.println();
                printMidline(colCount);
            }

        }
        int counEmptyCells = colCount - size % colCount;
        for (int i = 0; i < counEmptyCells; i++) {
            printEmptyCells();
        }

        printDownline(colCount);
    }

    public static void printUpline(int colCount) {
        System.out.print("\u2554");
        for (int i = 0; i < colCount; i++) {

            for (int j = 0; j < 11; j++) {
                System.out.print("\u2550");
            }
            if (i == colCount - 1) {
                break;
            }
            System.out.print("\u2566");
        }
        System.out.print("\u2557\n\u2551");
    }

    public static void printMidline(int colCount) {


        System.out.print("\u2560");
        for (int i = 0; i < colCount; i++) {

            for (int j = 0; j < 11; j++) {
                System.out.print("\u2550");
            }
            if (i == colCount - 1) {
                break;
            }
            System.out.print("\u256C");
        }
        System.out.print("\u2563\n\u2551");
    }

    public static void printDownline(int colCount) {
        System.out.print("\n\u255A");
        for (int i = 0; i < colCount; i++) {

            for (int j = 0; j < 11; j++) {
                System.out.print("\u2550");
            }
            if (i == colCount - 1) {
                break;
            }
            System.out.print("\u2569");
        }
        System.out.print("\u255D\n");
    }

    public static void printEmptyCells() {

        System.out.print("           \u2551");
    }
}
