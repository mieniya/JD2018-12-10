package by.it.zagurskaya.jd01_05;

import static java.lang.Math.*;

public class TaskC {
    public static void main(String[] args) {
        // step1();
        step2();
    }

    private static void step1() {
        double delta = (9 - 5.33) / 28;
        double[] array = new double[29];
        double[] arrNew = new double[29];
        double geom = 1;
        int j = 0;
        System.out.println("массив ARRAY");

        for (int i = 0; i <= 27; i++) {
            double x = 5.33 + delta * i;
            double z = pow((x * x + 4.5), 1.0 / 3);
            array[i] = z;
            if (z > 3.5) {
                arrNew[j] = z;
                geom = geom * arrNew[j];
            }
            System.out.println("x=" + x + "   array [" + i + "] " + array[i]);
            j++;
        }
        System.out.println("массив arrNew");
        for (double element : arrNew) {
            System.out.println("arrNew" + element);
        }
        double sredGeom = pow(geom, 1.0 / j);
        System.out.println("среднее геометрическое" + sredGeom);

    }

    private static void step2() {
        double[] array = new double[31];
        int quantityNewMAs = arrayNamberAndquantityNewMas(array);
        double[] arrNew = new double[quantityNewMAs];
        arrayNewMas(array, arrNew);
        sort(arrNew);
        printArray(array, "Старый массив", 4);
        printArray(arrNew, "Новый массив", 2);
    }

    public static int arrayNamberAndquantityNewMas(double[] array) {
        int quantity = 0;

        for (int i = 0; i < array.length; i++) {
            array[i] = 103 + (int) (Math.random() * 348);
            if (array[i] * 0.1 > i) {
                quantity++;
            }
        }
        return quantity;
    }

    public static void arrayNewMas(double[] array, double[] arrayNewMas) {
        int j = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] * 0.1 > i) {
                arrayNewMas[j] = array[i] * 0.1;
                j++;
            }
        }
    }

    public static void printArray(double[] array, String name, int cols) {
        int col = 0;
        System.out.println(name);
        topLine(cols);
        System.out.printf("\u2551");
        for (int i = 0; i < array.length; i++) {
            System.out.printf("[%-3d]=%-5.1f\u2551", i, array[i]);
            col++;
            if ((0 == col % cols) || (array.length - 1 == i)) {
                System.out.println();
                midlleLine(cols);
                System.out.printf("\u2551");
            }
        }
        System.out.println();
    }

    public static void topLine(int cols) {
        int col = 0;
        String symbol = new String("\u2566");
        System.out.printf("\u2554");
        for (int i = 0; i < cols; i++) {
            if (cols - 1 == i) {
                symbol = "\u2557";
            }
            else { symbol = "\u2566";}
            System.out.printf("\u2550" + "\u2550" + "\u2550" + "\u2550" + "\u2550" + "\u2550" + "\u2550" + "\u2550" + "\u2550" + "\u2550" + "\u2550" + symbol);
            col++;
        }
        System.out.println();
    }
    public static void midlleLine(int cols) {
        int col = 0;
        String symbol = new String("\u256C");
        System.out.printf("\u2560");
        for (int i = 0; i < cols; i++) {
            if (cols - 1 == i) {
                symbol = "\u2563";
            }
            else { symbol = "\u256C";}
            System.out.printf("\u2550" + "\u2550" + "\u2550" + "\u2550" + "\u2550" + "\u2550" + "\u2550" + "\u2550" + "\u2550" + "\u2550" + "\u2550" + symbol);
            col++;
        }
        System.out.println();
    }

    static void sort(double[] arr) {
        boolean swap = true;
        int last = arr.length;
        double buffer;
        do {
            swap = false;
            for (int i = 0; i < last - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    buffer = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = buffer;
                    swap = true;
                }
            }
            last--;
        } while (swap);

    }
}

