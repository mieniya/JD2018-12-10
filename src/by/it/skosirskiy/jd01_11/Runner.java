package by.it.skosirskiy.jd01_11;

import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        List<String> myList = new ListA<>();
        List<String> arList=new ArrayList<>();
        List<String> a1 = new ListB<>();
        List<String> a2 = new ListB<>();
        a1.add("1asd");
        a1.add("2asd");


        a2.add("5asd");
        a2.add("6asd");
        a2.add("7asd");

        a1.addAll(a2);
        System.out.println("res "+a1);

        myList.add("First");
        arList.add("First");
        myList.add("Two");
        arList.add("Two");
        myList.add("Four");
        arList.add("Four");
        System.out.println("add MyList:"+myList+"\narList:"+arList);
        myList.add(2,"Tree");
        arList.add(2,"Tree");
        myList.add(0,"Start");
        arList.add(0,"Start");
        System.out.println("add index myList:"+myList+"\narList:"+arList);
        myList.remove("Start");
        arList.remove("Start");
        myList.remove(3);
        arList.remove(3);
        System.out.println("remove index myList:"+myList+"\narList:"+arList);
        System.out.println("get index myList(0):"+myList.get(0)+"\narlist(0):"+arList.get(0));



    }

}
