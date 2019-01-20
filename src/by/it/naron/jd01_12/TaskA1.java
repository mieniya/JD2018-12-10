package by.it.naron.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TaskA1 {
    private List<Integer> gredes = new ArrayList<>();

    public static void main(String[] args) {
        TaskA1 instance = new TaskA1();
        for (int i = 0; i < 10; i++) {
            int grade = (int)(Math.random()*10+1);
            instance.gredes.add(grade);
        }
        System.out.println(instance.gredes);
        instance.clearBad(instance.gredes);
        System.out.println(instance.gredes);
    }

    private void clearBad(List<Integer> gr) {
        Iterator<Integer> iterator = gr.iterator();
        while (iterator.hasNext()){
            Integer current = iterator.next();
            if (current<4){
                iterator.remove();
            }
        }
    }
}
