package by.it.pkzm.jd01_04;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class TaskB {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); //объявляем сканнер
        System.out.println("Enter number of people ");
        int size = input.nextInt(); // Читаем с клавиатуры размер массива и записываем в size
        String[] arrNames = new String[size]; // создали массив String  размером size
        System.out.println("ВВедите фамилии: ");
        for (int i = 0; i < size; i++) {
            arrNames[i] = input.next();  // заполняем массив с клавиатуры
        }
        int[][] arrSalary = new int[size][4];
        for (int i = 0; i < size; i++) {
            System.out.println(" введите зарплату " + arrNames[i]);
            for (int j = 0; j < 4 - 1; j++) {

                arrSalary[i][j] = input.nextInt();

            }

        }

        String[][] arrTable = new String[size][6];
        for (int i = 0; i < size; i++) {
            arrTable[i][1] = arrNames[i];
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j <4-1 ; j++) {
//               arrTable[i][j] = arrSalary[i][j];
            }



        }

    }
}
