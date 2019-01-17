package by.it.skosirskiy.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class TaskB2 {
    private static String process(ArrayList<String> peoples){
        return "";
    }
    static int count=0;
    static String process(LinkedList<String> peoples){
        Iterator<String> iterator = peoples.iterator();

        while (iterator.hasNext()){
            if(count==0) iterator.next();
            if (!iterator.hasNext()){
                System.out.println("first break");
                break;

            }
            iterator.next();
            if(!iterator.hasNext()) {
                System.out.println("second break");
                break;}
            iterator.remove();
            count=0;
            while (iterator.hasNext()){
                iterator.next();
                count=1;
                if (iterator.hasNext())
                {
                    iterator.next();
                    iterator.remove();
                    count=0;
                }
            }

            process(peoples);


        }


        return peoples.element();
    }

    public static void main(String[] args) {

        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("111");
        linkedList.add("222");
        linkedList.add("333");
        linkedList.add("444");
        linkedList.add("555");
        linkedList.add("666");
        linkedList.add("777");
        linkedList.add("888");




        System.out.println(process(linkedList));

    }
}
