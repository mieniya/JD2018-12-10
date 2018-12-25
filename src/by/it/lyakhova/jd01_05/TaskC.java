package by.it.lyakhova.jd01_05;

import java.util.ArrayList;

import static java.lang.Math.*;

public class TaskC {
    public static void main(String[] args) {
        step1();
        step2();
    }

    private static void step1() {

        int lengthArr = (int) ceil(random()*21+20);
        double stepX = (9-5.33)/lengthArr;
        double[] array = new double[lengthArr+1];
        int i = 0;
        int k = 0;

        for (double x = 5.33; x < 9; x=x+stepX) {
            array[i] = cbrt(x * x + 4.5);
            i++;
        }
        System.out.println("Массив A[]");
        InOut.printArray(array, "A", 5);

        ArrayList<Double> arrayB = new ArrayList<>();
        for (int j = 0; j < array.length; j++) {
            if (array[j]>3.5) arrayB.add(array[j]);
        }

        double[] lastArr = new double[arrayB.size()];
        for (double elem: arrayB) {
            lastArr[k] = elem;
            k++;
        }
        System.out.println("Массив B[] из элементов массива A > 3.5");
        InOut.printArray(lastArr, "B", 5);
        System.out.println();

    }

    private static void step2() {

        int elem = 0;
        int[] arrA = new int[31];
        for (int i = 0; i < arrA.length; i++) {
            arrA[i]= (int) round(random()*348+103);
        }

        ArrayList<Integer> listB = new ArrayList<>();
        for (int i = 0; i < arrA.length; i++) {
            if (arrA[i]*0.1>i) listB.add(arrA[i]);
        }

        int[] arrB = new int[listB.size()];

        for (int el : listB) {
            arrB[elem] = el;
            elem++;
        }

        Helper.sort(arrB);
        System.out.println("Unsorted array A");
        InOut.printArrayGraf(arrA, "A", 5, true);
        System.out.println("Sorted array B");
        InOut.printArrayGraf(arrB, "B", 2, false);

    }
}
