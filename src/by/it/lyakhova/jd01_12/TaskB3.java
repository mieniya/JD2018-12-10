package by.it.lyakhova.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class TaskB3 {
    public static void main(String[] args) {
        ArrayList<String> array = new ArrayList<>();
        LinkedList<String> array2 = new LinkedList<>();

        for (int i = 1; i <= 4096; i++) {
            array.add("n" + i);
            array2.add("n" + i);
        }

        long time = System.nanoTime();
        System.out.println(process(array));
        System.out.println((System.nanoTime()-time)/1000);

        long time2 = System.nanoTime();
        System.out.println(process(array2));
        System.out.println((System.nanoTime()-time2)/1000);
    }

    static String process(ArrayList<String> peoples) {
        int step = 2;
        int k = 1;

        return recursProcess(peoples, step, k);
    }
    static String process(LinkedList<String> peoples) {
        int step = 2;
        int counterForRemove = 1;


        return queueProcess(peoples, step, counterForRemove);
    }

    private static String recursProcess (List<String> peoples, int step, int k){
        Iterator<String> itr = peoples.iterator();
        if (peoples.size() == 1) return peoples.get(0);
        else {
            while (itr.hasNext()) {
                itr.next();
                if (k++ % step == 0) {
                    itr.remove();
                }
            }
        }

        return recursProcess(peoples, step, k);
    }

    private static String queueProcess (LinkedList<String> peoples, int step, int k){
        LinkedList<String> temporary = new LinkedList<>();
        int i = 0;
        if (peoples.size()==1) return peoples.get(0);
        else{
            while (i < peoples.size()) {
                if (k++ % step == 0) peoples.poll();
                else temporary.offer(peoples.poll());
                i++;
            }
        }
        return queueProcess(temporary, step, k);
    }
}
