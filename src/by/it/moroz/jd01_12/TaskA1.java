package by.it.moroz.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TaskA1 {

   private List<Integer> marks = new ArrayList<>();

    public static void main(String[] args) {

        TaskA1 instanse = new TaskA1();

        for (int i = 0; i < 10; i++) {
            int grade = (int) (Math.random()*10+1);
            instanse.marks.add(grade);
        }
        System.out.println(instanse.marks);

        instanse.clearBad(instanse.marks);

        System.out.println(instanse.marks);


    }

    private void clearBad(List<Integer> grades){
        Iterator<Integer> iterator = grades.iterator();
        while (iterator.hasNext()){
            int mark = iterator.next();
            if (mark<4) iterator.remove();
        }
    }

}
