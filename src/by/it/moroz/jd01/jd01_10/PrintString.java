package by.it.moroz.jd01.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintString {

    public static void main(String[] args) {
        Class<String> stringClass = String.class;
        Method[] methods = stringClass.getDeclaredMethods();
        for (Method method : methods){
            String name = method.getName();
            int modifiers = method.getModifiers();
            Class<?> returnType = method.getReturnType();
            String ret = returnType.getSimpleName();

            if (!Modifier.isStatic(modifiers)) {
                System.out.println(name);
            }

        }
    }
}
