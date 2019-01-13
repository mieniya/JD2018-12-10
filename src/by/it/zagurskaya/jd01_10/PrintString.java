package by.it.zagurskaya.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintString {
    public static void main(String[] args) {
        Class<String> stringClass = String.class;
        Method[] methods = stringClass.getDeclaredMethods();
        String previousMethodName = "";
        for (Method method : methods) {
            if (!Modifier.isStatic(method.getModifiers())) {
                if (!previousMethodName.equalsIgnoreCase(method.getName())) {
                    System.out.println(method.getName());
                    previousMethodName = method.getName();
                }
            }
        }
    }
}
