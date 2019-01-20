package by.it.zagurskaya.jd01_12;


import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TaskA1 {
    private List<Integer> grades = new ArrayList<>();

    public static void main(String[] args) {
        TaskA1 instans=new TaskA1();
        for (int i = 0; i < 10; i++) {
            int grade = (int)(Math.random()*10+1);
            instans.grades.add(grade);
        }
        System.out.println(instans.grades);
        instans.clearBad(instans.grades);
        System.out.println(instans.grades);
    }

    private void clearBad(List<Integer> gr) {
        Iterator<Integer> iterator = gr.iterator();
        while (iterator.hasNext()){
            Integer current=iterator.next();
            if (current<4){
                iterator.remove();
            }
        }
    }
}
