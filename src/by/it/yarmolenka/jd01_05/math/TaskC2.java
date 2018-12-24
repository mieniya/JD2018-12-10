package by.it.yarmolenka.jd01_05.math;

public class TaskC2 {
    public static int[] formArray(int length) {
        int[] array = new int[length];
        for (int i = 0; i < length; i++)
            array[i] = (int) (Math.random() * 348 + 103);
        return array;
    }

    public static int[] formArrayB(int[] array) {
        int count = 0;
        for (int i = 0; i < array.length; i++)
            if ((double) array[i] * 0.1 > (double) i) count++;
        int[] arr = new int[count];
        int k = 0;
        for (int i = 0; i < array.length; i++)
            if ((double) array[i] * 0.1 > (double) i) {
                arr[k] = array[i];
                k++;
            }
        return arr;
    }

    public static void printArray(int[] array, String name, int cols, boolean ind) {
        if (ind) System.out.println("Array " + name + " <Index to rows>");
        else System.out.println("Array " + name + " <Index to cols>");
        int index;

        //Псевдографика
        String hor = "\u2550";
        String ver = "\u2551";
        String top_right = "\u255a";
        String bottom_left = "\u2557";
        String top_left = "\u255d";
        String bottom_right = "\u2554";
        String top_right_bottom = "\u2560";
        String right_bottom_left = "\u2566";
        String bottom_left_top = "\u2563";
        String left_top_right = "\u2569";
        String cross = "\u256c";

        //Выводим в консоль верхнюю границу таблицы
        System.out.print(bottom_right + hor + hor + hor + hor + hor + hor + hor + hor + hor + hor + hor);
        for (int i = 1; i < cols; i++)
            System.out.print(right_bottom_left + hor + hor + hor + hor + hor + hor + hor + hor + hor + hor + hor);
        System.out.println(bottom_left);

        //Выводим в консоль тело таблицы с границами
        for (int i = 0; i <= array.length / cols; i++) {                       //Перебираем строки
            for (int j = i * cols; j < (i * cols + cols); j++) {                     //Перебираем элементы в строках
                if (j < array.length) {                                               //Заполняем ячейку (если есть чем)
                    if (ind) index = j;
                    else index = (j % cols) * (array.length / cols) + i;
                    System.out.printf("%s %s[%2d]=%-4d", ver, name, index, array[index]);
                } else System.out.printf("%s           ", ver);                        //Или выводим пустую ячейку
                if ((j + 1) % cols == 0) System.out.println(ver);
            }
            if ((i + 1) * cols == array.length) break;                //Выходим из цикла если элементы закончились
            if (i < array.length / cols) {                        //Выводим нижнюю границу ячеек
                System.out.print(top_right_bottom + hor + hor + hor + hor + hor + hor + hor + hor + hor + hor + hor);
                for (int k = 1; k < cols; k++)
                    System.out.print(cross + hor + hor + hor + hor + hor + hor + hor + hor + hor + hor + hor);
                System.out.println(bottom_left_top);
            }
        }

        //Выводим в консоль нижнюю границу таблицы
        System.out.print(top_right + hor + hor + hor + hor + hor + hor + hor + hor + hor + hor + hor);
        for (int i = 1; i < cols; i++)
            System.out.print(left_top_right + hor + hor + hor + hor + hor + hor + hor + hor + hor + hor + hor);
        System.out.println(top_left);
    }
}
