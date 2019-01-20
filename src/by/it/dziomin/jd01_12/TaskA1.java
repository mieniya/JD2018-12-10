package by.it.dziomin.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TaskA1 {
    private List<Integer> grades = new ArrayList<>();

    public static void main(String[] args) {
        TaskA1 a1 = new TaskA1();
        for (int i = 0; i < 20; i++) {
            int grade = (int) (Math.random() * 10 + 1);
            a1.grades.add(grade);
        }
        System.out.println(a1.grades);
        a1.clearBad(a1.grades);
        System.out.println(a1.grades);
    }

    private void clearBad(List<Integer> gr) {
        Iterator<Integer> iterator = gr.iterator();
        while (iterator.hasNext()) {
            int current = iterator.next();
            if (current < 4) {
                iterator.remove();
            }
        }
    }

}
