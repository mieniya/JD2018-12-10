package by.it.moroz.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class PrintMath {

    public static void main(String[] args) {

        Class<Math> mathClass = Math.class;
        Method[] methods = mathClass.getDeclaredMethods();
        for (Method method : methods) {
            String name = method.getName();
            int modifiers = method.getModifiers();
            StringBuilder mm = new StringBuilder();
            if (Modifier.isPublic(modifiers)) mm.append("public ");
            Class<?> returnType = method.getReturnType();
            String ret = returnType.getSimpleName();
            Class<?>[] parameterTypes = method.getParameterTypes();
            System.out.printf("%s%s %s(????)\n", mm, ret, name);
            //for (Class<?> parameterType : parameterTypes){
            //    System.out.printf("%s", parameterType.getSimpleName());
            //}
            //System.out.printf(")\n");


        }

    }
}
