package by.it.kushnerov.jd01_12;

import by.it.dziomin.jd01_03.InOut;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TaskA1 {
    private List<Integer> grades = new ArrayList<>();

    public static void main(String[] args) {
        TaskA1 instance = new TaskA1();
        for (int i = 0; i < 20; i++) {
            int grade = (int)(Math.random()*10+1);
            instance.grades.add(grade);
        }
        System.out.println(instance.grades);
        instance.clearBad(instance.grades);
        System.out.println(instance.grades);
    }

    private void clearBad(List<Integer> gr) {
        Iterator<Integer> iterator = gr.iterator();
        while(iterator.hasNext()){
            Integer current = iterator.next();
            if (current < 4){
                iterator.remove();
            }
        }
    }
}
