package by.it.moroz.jd01_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TaskA {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] mas = new int[10];
        for (int i = 0; i < mas.length; i++) {
            mas[i] = Integer.parseInt(reader.readLine());
        }
        step1(mas);
        step2(mas);
        step3(mas);
    }

    private static void step1(int[] mas) {

        int min = mas[0];
        int max = mas[0];
        for (int element : mas) {
            if (min > element) min = element;
            if (max < element) max = element;
        }
        System.out.println(min + " " + max);
    }

    private static void step2(int[] mas) {

        double sum = 0;
        for (int element : mas) {

            sum += element;
        }
        double avg = sum/mas.length;
        for (int element : mas) {
            if(element<avg) System.out.println(element);
        }
    }

    private static void step3(int[] mas) {

        int min = mas[0];
        for (int element : mas)
            if (min > element) min = element;
        for (int i = mas.length-1; i>=0; i--){
            if (mas[i]==min) System.out.print(i+" ");
        }
    }
}
