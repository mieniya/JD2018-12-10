package by.it.zagurskaya.jd02_03;

import java.util.Arrays;

public class Test {


    public static void main(String[] args) {
        Boolean test[] = new Boolean[10];
        test[0] = true;
        test[1] = false;
        test[2] = true;
        test[3] = false;
        test[4] = true;
        test[5] = false;
        test[6] = true;
        test[7] = true;
        test[8] = true;
        test[9] = true;

        System.out.println(Arrays.stream(test).filter(b -> !b).count());
    }

}
