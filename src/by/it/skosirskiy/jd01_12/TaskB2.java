package by.it.skosirskiy.jd01_12;

import java.util.*;

public class TaskB2 {


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
        String [] peoples = {"0", "1", "2", "3", "4", "5", "6", "7", "8"};
        ArrayList <String> arrayList= new ArrayList(Arrays.asList(peoples));
        LinkedList <String> linkedList= new LinkedList(Arrays.asList(peoples));

        System.out.println("Array "+process(arrayList));
        System.out.println("Linked "+process(linkedList));


    }
}
