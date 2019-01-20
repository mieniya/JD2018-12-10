package by.it.dziomin.jd01_12;


import java.util.*;

public class TaskA3 {
    private static int MAX = 50000;
    private static int[] ints = new Random().ints(MAX, 0, 3).toArray();

    public static void main(String[] args) {
        List<Integer> positive = new LinkedList<>();
        List<Integer> negative = new LinkedList<>();
        List<Integer> zero = new LinkedList<>();
        Scanner sc = new Scanner(System.in);

        while (true) {
            String input = sc.next();
            if (input.equals("end")) {
                break;
            }

            Integer value = Integer.valueOf(input);
            if (value < 0) {
                negative.add(value);
            } else if (value > 0) {
                positive.add(value);
            } else {
                zero.add(value);
            }
        }
        positive.addAll(zero);
        positive.addAll(negative);
        System.out.println(positive);


    }

    private static void testSpeed() {
        long res1 = test1();
        long res2 = test2();
        long res3 = test3();
        System.out.println("Test1: " + res1);
        System.out.println("Test2: " + res2);
        System.out.println("Test3: " + res3);
    }

    private static long test1() {
        long start = System.nanoTime();
        List<Integer> positive = new LinkedList<>();
        List<Integer> negative = new LinkedList<>();
        List<Integer> zero = new LinkedList<>();

        for (int value : ints) {
            if (value < 0) {
                negative.add(value);
            } else if (value > 0) {
                positive.add(value);
            } else {
                zero.add(value);
            }
        }
        long end = System.nanoTime();
        return end - start;
    }

    private static long test2() {
        long start = System.nanoTime();
        LinkedList<Integer> result = new LinkedList<>();
        int index = 0;
        for (int value : ints) {
            if (value < 0) {
                result.add(value);
            } else if (value > 0) {
                result.addFirst(value);
                index++;
            } else {
                result.add(index, value);
            }
        }
        long end = System.nanoTime();
        return end - start;
    }

    private static long test3() {
        long start = System.nanoTime();
        ArrayList<Integer> list = new ArrayList<>(MAX);
        int position = 0;
        for (int value : ints) {
            if (value < 0) {
                list.add(value);
            } else if (value == 0) {
                list.add(position, value);
            } else if (value > 0) {
                list.add(position++, value);
            }
        }
        long end = System.nanoTime();
        return end - start;
    }
}
