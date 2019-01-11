package by.it.subach.jd01_10;

import java.lang.reflect.Method;

public class PrintMath {
    public static void main(String[] args) {
        Class<Math> mathClass = Math.class;

        Method[] methods = mathClass.getDeclaredMethods();
        for (Method method : methods) {
            String name = method.getName();
            int modifiers = method.getModifiers();
            System.out.printf("%d %s()\n",modifiers, name, method);

        }
    }
}
