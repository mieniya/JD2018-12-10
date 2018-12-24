package by.it.zagurskaya.jd01_05;

import static java.lang.Math.*;

public class TaskC {
    public static void main(String[] args) {
        step1();
        //step2();
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

}
