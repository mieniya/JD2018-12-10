package by.it.skosirskiy.jd01_12;

import java.sql.Time;
import java.util.*;

public class TaskB3 {


    static String process(ArrayList<String> peoples){
        return schetchik(peoples);
    }
    static String process(LinkedList<String> peoples){
        return schetchik(peoples);
    }

    static String schetchik (List<String> collection){
        int index=0;
        while(!(collection.size()==1)){

            Iterator <String> iterator= collection.iterator();
            while (!(collection.size()==1) && iterator.hasNext()){
                iterator.next();

                if (++index%2==0) iterator.remove();
            }
        }


        return collection.get(0);
    }

    public static void main(String[] args) {
        String[] peoples = new String[4096];
        for (int i = 0; i < 4096; i++) {
            peoples[i] =  ""+i;
        }


        ArrayList <String> arrayList= new ArrayList(Arrays.asList(peoples));
        LinkedList <String> linkedList= new LinkedList(Arrays.asList(peoples));
        long start = System.nanoTime();
        System.out.println("Array "+process(arrayList));
        long end = System.nanoTime();
        System.out.println("array time "+(end-start));
        start = System.nanoTime();
        System.out.println("Linked "+process(linkedList));
        end = System.nanoTime();
        System.out.println("Linked time "+(end-start));



    }
}
