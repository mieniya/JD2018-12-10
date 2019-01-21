package by.it.subach.jd01_12;

import java.util.*;

public class TaskB2 {

    public static void main(String[] args) {

//        Scanner scanner = new Scanner(System.in);
//        while(true){
//            String name = scanner.next();
//            if(name.equals("end"))  break;
//            else {
//                name = name.replaceAll("[,]", "");
//                instance.peoples1.add(name);
//                instance.peoples2.add(name);
//            }
//        }
//

        String names = "1, Addison2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16";
        String[] namesArr = names.split(", ");
        System.out.println(Arrays.toString(namesArr));

        List<String> peoples1 = new ArrayList<>(Arrays.asList(namesArr));
        List<String> peoples2 = new LinkedList<>(Arrays.asList(namesArr));


        String lastManStanding1 = process((ArrayList<String>) peoples1);
        String lastManStanding2 = process((LinkedList<String>) peoples2);

        System.out.println(lastManStanding1);
        System.out.println(lastManStanding2);

    }


    static String process(ArrayList<String> peoples) {
        List<String> killArray = new ArrayList<>(peoples);
        boolean last = true;
        int count = killArray.size();
        while (killArray.size() != 1) {
            Iterator<String> iter = killArray.iterator();
            if (killArray.size() == count || last == false) {
                iter.next();
            }
            while (iter.hasNext()) {
                iter.next();
                iter.remove();
                if (iter.hasNext()) {
                    iter.next();
                    last = true;
                } else last = false;
            }

        }
        return killArray.get(0);

    }

    static String process(LinkedList<String> peoples) {
        List<String> killArray = new LinkedList<>(peoples);
        boolean last = true;
        int count = killArray.size();
        while (killArray.size() != 1) {
            Iterator<String> iter = killArray.iterator();
            if (killArray.size() == count || last == false) {
                iter.next();
            }
            while (iter.hasNext()) {
                iter.next();
                iter.remove();
                if (iter.hasNext()) {
                    iter.next();
                    last = true;
                } else last = false;
            }

        }
        return killArray.get(0);

    }

}
