package by.it.a_khmelev.jd01_12;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class TaskC1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line;
        Map<Long, String> c1 = new HashMap<>();
        while (!(line = scanner.nextLine()).equalsIgnoreCase("end")) {
            c1.put(System.nanoTime(), line);
        }
        Iterator<String> iterator = c1.values().iterator();
        Set<String> vvvv = new HashSet<>();
        while (iterator.hasNext()) {
            if (!vvvv.add(iterator.next())) {
                iterator.remove();
            }
        }


    }
}
