package by.it.naron.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintMath {
    public static void main(String[] args) {
        Class<Math> mathClass = Math.class;
        Method[] methodsArr = mathClass.getDeclaredMethods();
        StringBuilder mm = new StringBuilder();

        for (Method method : methodsArr){
            String name = method.getName();
            int modifiers = method.getModifiers();
            if (Modifier.isPublic(modifiers)) mm.append("public");
            if (Modifier.isPrivate(modifiers)) mm.append("private");
            if (Modifier.isProtected(modifiers)) mm.append("protected");
            if (Modifier.isStatic(modifiers)) mm.append("static");
            Class<?> returnType = method.getReturnType();
            String ret = returnType.getSimpleName();

            System.out.println("");
        }
    }
}
