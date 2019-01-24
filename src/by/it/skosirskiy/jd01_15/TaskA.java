package by.it.skosirskiy.jd01_15;
/* Создайте матрицу 6 строк на 4 столбца из целых случайных чисел от -15 до 15 включительно.
 Выведите матрицу в текстовый файл matrix.txt, расположенный в папке задания jd01_15. При выводе для
каждого числа нужно предусмотреть для него три знакоместа, после чисел – один пробел.
 Прочитайте файл и покажите его в консоли. Класс Scanner использовать нельзя. */

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class TaskA {
    static String src = System.getProperty("user.dir")+"/src/by/it/skosirskiy/";
    static String fileOutTxt = src+"jd01_15/matrix.txt";
    static int [][] mas= new int [6][4];

    public static void main(String[] args) {

        generateRandom(mas);

        try (PrintWriter print =
                new PrintWriter(
                        new FileWriter(fileOutTxt)
                )
            )
        {
            for (int[] rows : mas) {
                for (int element : rows) {

                    print.printf("%3d ",element);
                }
                print.println();
            }
            for (int[] rows : mas) {
                for (int element : rows) {

                    System.out.printf("%3d ",element);
                }
                System.out.println();
            }




        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void generateRandom(int[][] mas) {
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas[i].length; j++) {
                mas[i][j] = -15 + (int) (31 * Math.random());
            }
        }
    }
}
