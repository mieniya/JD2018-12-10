package by.it.zagurskaya.jd01_11;
import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        List<String> a=new ArrayList<>();
        List<String> aNew=new ArrayList<>();
        a.add("One"); //0
        a.add("Two"); //1
        a.add("3"); //2
        a.add("4"); //3
        a.add("5Object"); //4
        a.add("6"); //5
        a.add("7");
        a.add("8");
        System.out.println(a);
        a.remove("5Object");
        a.remove(5);
        aNew.add("1"); //5
        aNew.add("2");
        aNew.add("3");
         System.out.println(a);
        System.out.println(a.get(4));
        a.set(2,"5Object");
        System.out.println(a);
        a.add(2,"10");
        System.out.println(a);
        a.addAll(aNew);
        System.out.println(a);

        System.out.println("===================================");

        List<String> b=new ListB<>();
        b.add("One"); //0
        b.add("Two"); //1
        b.add("3"); //2
        b.add("4"); //3
        b.add("5Object"); //4
        b.add("6"); //5
        b.add("7");
        b.add("8");
        System.out.println(b);
        b.remove("5Object");
        b.remove(5);
        System.out.println(b);
        System.out.println(b.get(4));
        //b.set(2,"5Object");
       // System.out.println(b);
        b.add(2,"10");
        System.out.println(b);

    }
}
