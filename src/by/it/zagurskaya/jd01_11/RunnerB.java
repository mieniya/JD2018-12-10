package by.it.zagurskaya.jd01_11;

import java.util.HashSet;
import java.util.Set;

public class RunnerB {
    public static void main(String[] args) {
        Set<String> states = new HashSet<>();
        Set<String> statesDel = new HashSet<>();
        // добавим в список ряд элементов
        states.add("Germany");
        states.add("France");
        states.add("Italy");
        states.add("Deutsh");
        states.add("France");
        System.out.println(states);

//        statesDel.add("Germany");
//        statesDel.add("France");
//        System.out.println(statesDel);
//remove
//        states.remove("France");
//        System.out.println(states);
//contains
//        System.out.println(states.contains("France"));
//        System.out.println(states.contains("mm"));
//isEmpty
        System.out.println(states.isEmpty());
        System.out.println(statesDel.isEmpty());


        System.out.printf("Set contains %d elements \n", states.size());    // 3
        System.out.println(states);


        System.out.println("===================");

        SetC<String> statesMain = new SetC<String>();
        SetC<String> statesMainDell = new SetC<String>();
        // добавим в список ряд элементов
//add-
        statesMain.add("Germany");
        statesMain.add("France");
        statesMain.add("Italy");
        statesMain.add("France");

        System.out.printf("Set contains %d elements \n", statesMain.size());    // 3
        System.out.println(statesMain);
//remove-
//        statesMain.remove("France");
//        System.out.println(statesMain);
//contains-
//        System.out.println(statesMain.contains("France"));
//        System.out.println(statesMain.contains("mm"));
// isEmpty+
        System.out.println(statesMain.isEmpty());
        System.out.println(statesMainDell.isEmpty());
    }
}
