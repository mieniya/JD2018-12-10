package by.it.moroz.jd01_05;

import static java.lang.Math.cbrt;
import static java.lang.Math.pow;

public class TaskC {

    public static void main(String[] args) {
        int n = (int) (Math.random() * 21) + 20;
        double d = (9 - 5.33) / n;
        double x = 5.33;
        double[] array = new double[n];
        System.out.println("Массив А[]");
        for (int i = 0; i < array.length; i++) {
            if (x <= 9) {
                array[i] = cbrt(pow(x, 2) + 4.5);
            }
            x += d;
        }
        printArray(array, "A", 5);
        System.out.println();
        double count = 0;
        for (double v : array) {
            if (v > 3.5) {
                count++;
            }
        }
        double[] arr = new double[(int) count];
        double sum = 1;
        System.out.println("Массив B[] из элементов массива A > 3.5");
        int j = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 3.5) {
                arr[j] = array[i];
                sum = sum * arr[j];
                j++;
            }
        }
        double mid = sum / count;
        printArray(arr, "B", 5);
        System.out.println();
        System.out.println(mid);
    }

    static void printArray(double[] arr, String name, int columnCount) {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%s[% -3d]=%-7f   ", name, i, arr[i]);
            if ((i + 1) % columnCount == 0 || i == arr.length - 1)
                System.out.println();
        }
    }
}
