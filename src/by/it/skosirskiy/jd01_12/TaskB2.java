package by.it.skosirskiy.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class TaskB2 {

    private static int count=0;
    private static int count1=0;
    static String process(LinkedList<String> peoples){

        Iterator<String> iterator = peoples.iterator();
        while (iterator.hasNext()){
            if(count1==0) iterator.next();
            if (!iterator.hasNext()){
  //              System.out.println("first break");
                break;
            }
            iterator.next();
            if(!iterator.hasNext()) {
      //          System.out.println("second break");
                if(iterator.hasNext()) iterator.remove();
                else
                break;}
            iterator.remove();
            count1=0;
            while (iterator.hasNext()){
                iterator.next();
                count1=1;
                if (iterator.hasNext())
                {
                    iterator.next();
                    iterator.remove();
                    count1=0;
                }
            }
            process(peoples);

        }
        return peoples.element();
    }

    static String process(ArrayList<String> peoples){

        Iterator<String> iterator = peoples.iterator();
        while (iterator.hasNext()){
            if(count==0) iterator.next();
            if (!iterator.hasNext()){
      //          System.out.println("first break");
                break;
            }
            iterator.next();
            if(!iterator.hasNext()) {
         //       System.out.println("second break");
                if(iterator.hasNext()) iterator.remove();
                else
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
            break;
        }
        peoples.trimToSize();
        return peoples.get(0);
    }

    public static void main(String[] args) {

        LinkedList<String> linkedList = new LinkedList<>();
        ArrayList<String> arrayList = new ArrayList<>();

        linkedList.add("1");
        linkedList.add("2");
        linkedList.add("3");
        linkedList.add("4");
        linkedList.add("5");
        linkedList.add("6");
        linkedList.add("7");
        linkedList.add("8");
        linkedList.add("9");
        linkedList.add("10");
        linkedList.add("11");
        linkedList.add("12");
        linkedList.add("13");
        linkedList.add("14");
        linkedList.add("15");
        linkedList.add("16");
        linkedList.add("17");
        linkedList.add("18");

        arrayList.add("1");
        arrayList.add("2");
        arrayList.add("3");
        arrayList.add("4");
        arrayList.add("5");
        arrayList.add("6");
        arrayList.add("7");
        arrayList.add("8");
        arrayList.add("9");
        arrayList.add("10");
        arrayList.add("11");
        arrayList.add("12");
        arrayList.add("13");
        arrayList.add("14");
        arrayList.add("15");
        arrayList.add("16");
        arrayList.add("17");
        arrayList.add("18");

        System.out.println("linked "+process(linkedList));
        System.out.println("array "+process(arrayList));






    }
}
