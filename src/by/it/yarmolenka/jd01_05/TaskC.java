package by.it.yarmolenka.jd01_05;

import by.it.yarmolenka.jd01_05.math.TaskC1;
import by.it.yarmolenka.jd01_05.math.TaskC2;

import java.util.Arrays;

public class TaskC {
    public static void main(String[] args) {
        
        //Задание C1
        double[] array = TaskC1.formArray();
        String name = "A";
        int cols = 5;
        TaskC1.printArray(array, name, cols);
        double m = 3.5;
        double[] doubles = TaskC1.formMaxArray(array, m);
        String name2 = "B";
        TaskC1.printArray(doubles, name2, cols);
        double avg = TaskC1.avgGeom(doubles);
        System.out.printf("Среднее геометрическое элементов массива %s = %-30.5f\n\n", name2, avg);
        
        //Задание C2
        int length = 31;
        int[] arrayA = TaskC2.formArray(length);
        int[] arrayB = TaskC2.formArrayB(arrayA);
        Arrays.sort(arrayB);
        TaskC2.printArray(arrayA, "A", 5, true);
        TaskC2.printArray(arrayB, "B", 2, false);
    }
}

