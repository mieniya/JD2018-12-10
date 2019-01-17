package by.it.subach.jd01_12;

import java.util.*;

public class TackC1 {

    public static void main(String[] args) {
//        List<String> list = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        HashMap<String, Integer> map = new HashMap<>();
        Random random = new Random();


        while (true) {
            String name = scanner.next();
            if (name.equals("end")) break;
            else {
                name = name.replaceAll("[,]", "");
                map.put(name, random.nextInt( ));
            }
        }

        int hash = random.nextInt();
        System.out.println(map.toString());





//        System.out.println(k);
//        System.out.println(list.toString());


    }
}
