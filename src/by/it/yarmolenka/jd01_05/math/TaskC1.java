package by.it.yarmolenka.jd01_05.math;

import static java.lang.Math.*;


public class TaskC1 {
    public static double[] formArray() {
        int n = (int) (random() * 21 + 20);
        double[] array = new double[n];
        for (int i = 0; i < array.length; i++) {
            double x = 5.33 + (9 - 5.33) * i / n;
            array[i] = calculate(x);
        }
        return array;
    }

    public static void printArray(double[] array, String name, int cols) {
        System.out.println("Массив " + name + "[]");
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%s[%2d]=%7.5f  ", name, i, array[i]);
            if ((i + 1) % cols == 0 || i==array.length-1) System.out.println();
        }
    }

    public static double[] formMaxArray(double[] array, double m) {
        int count = 0;
        for (double v : array)
            if (v > m) count++;
        double[] array2 = new double[count];
        int k = 0;
        for (double v : array)
            if (v > m) {
                array2[k] = v;
                k++;
            }
        return array2;
    }

    public static double avgGeom(double[] array){
        double mul = 1.0;
        for (double v : array)
            mul*=v;
        return mul/array.length;
    }

    private static double calculate(double x) {
        return pow((pow(x, 2) + 4.5), 1.0 / 3.0);
    }
}
