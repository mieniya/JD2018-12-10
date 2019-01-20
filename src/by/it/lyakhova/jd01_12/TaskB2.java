package by.it.lyakhova.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class TaskB2 {
    public static void main(String[] args) {

        int[] expectedRes = {1, 1, 3, 1, 3, 5, 7, 1, 3, 5, 7, 9, 11, 13, 15, 1};
        ArrayList<String> array = new ArrayList<>();
        LinkedList<String> array2 = new LinkedList<>();
        for (int i = 0; i < expectedRes.length; i++) {
            array.add("n"+expectedRes[i]);
            array2.add("n"+expectedRes[i]);
        }
        long time = System.nanoTime();
        System.out.println(process(array));
        System.out.println(System.nanoTime()-time);

        long time2 = System.nanoTime();
        System.out.println(process(array2));
        System.out.println(System.nanoTime()-time2);
    }

    static String process(ArrayList<String> peoples) {
        int step = 2;
        int k = 1;

        return recursProcess(peoples, step, k);
    }
    static String process(LinkedList<String> peoples) {
        int step = 2;
        int counterForRemove = 1;


        return recursProcess(peoples, step, counterForRemove);
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
}
