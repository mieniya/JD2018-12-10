package by.it.yarmolenka.jd01_05;

import by.it.yarmolenka.jd01_05.math.*;

public class TaskA {
    public static void main(String[] args) {

        //Задание А1
        double x = 0.3, a = 756.13;
        double z1 = TaskA1.part1(x) - TaskA1.part2(x, a) - TaskA1.part3(x, a);
        double z2 = TaskA1.calculate(x, a);
        TaskA1.printA1(z1,z2);

        //Задание А2
        double fun = TaskA2.calculate(1.21,0.371);
        TaskA2.printA2(fun);

        //Задание А3
        double xx = 12.1;
        double aa = 3.75;
        TaskA3.printA3(xx,aa);
    }

}
