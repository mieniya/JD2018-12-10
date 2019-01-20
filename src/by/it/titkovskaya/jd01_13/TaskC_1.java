package by.it.titkovskaya.jd01_13;

import java.util.LinkedList;
import java.util.Scanner;

/*
TaskC. Нужно написать в TaskC программу, которая будет вводить вещественные числа с
консоли, после каждой ошибки программа делает паузу в 100 мс и выводит накопленные числа в
обратном порядке.
 Используйте Scanner, но он должен создаваться только один раз и обязательно в методе main.
 Код по чтению чисел с клавиатуры должен быть в методе static void readData().
 Если пользователь ввёл какой-то текст, вместо ввода числа, то метод readData() должен перехватить
исключение, сделать паузу Thread.sleep(100) и вывести на экран все ранее введенные числа.
 Числа нужно выводить без форматирования, через пробел, в порядке обратном вводу.
 После 5 допущенных ошибок программа должна завершиться, пробрасывая ошибку в JVM.
 */
public class TaskC_1 {

    private static LinkedList<Object> numbers = new LinkedList<>();
    private static String input;
    private static int countException = 0;

    public static void main(String[] args) throws Exception{
        Scanner scanner = new Scanner(System.in);
        while (countException<5){
            input = scanner.nextLine();
            readData();
        }
        if (countException==5) throw new Exception();
    }

    private static void readData() throws Exception{
        try {
            input = input.trim().replace(" ", "").replace(",", ".");
            numbers.addFirst(Double.parseDouble(input));
        } catch (NumberFormatException e){
            countException++;
            Thread.sleep(100);
            for (Object o : numbers) {
                System.out.print(o+" ");
            }
        }
    }
}
