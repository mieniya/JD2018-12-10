package by.it.yarmolenka.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class TaskA1 {
    private ArrayList<Integer> grades = new ArrayList<>();

    public static void main(String[] args) {
        TaskA1 task = new TaskA1();
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        for (int i = 0; i < size; i++) {
            task.grades.add((int) (Math.random() * 10 + 1));
        }
        System.out.println(task.grades);
        task.clearBad(task.grades);
        System.out.println(task.grades);
    }

    private void clearBad(List<Integer> grades) {
        Iterator<Integer> iterator = grades.iterator();
        while (iterator.hasNext())
            if (iterator.next() <= 3) iterator.remove();
    }
}