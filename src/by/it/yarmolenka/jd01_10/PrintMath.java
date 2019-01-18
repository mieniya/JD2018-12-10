package by.it.yarmolenka.jd01_10;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintMath {
    public static void main(String[] args){
        Class<Math> m = Math.class;
        Method[] methods = m.getDeclaredMethods();
        for (Method method : methods) {
            String name = method.getName();
            int modifiers = method.getModifiers();
            StringBuilder sb = new StringBuilder();
            if (Modifier.isPublic(modifiers)) sb.append("public ");
            if (Modifier.isPrivate(modifiers)) sb.append("private ");
            if (Modifier.isProtected(modifiers)) sb.append("protected ");
            if (Modifier.isStatic(modifiers)) sb.append("static ");
            Class<?> returnType = method.getReturnType();
            String s = returnType.toString();
            Class<?>[] exceptionTypes = method.getParameterTypes();
            StringBuilder exc = new StringBuilder();
            for (int i = 0; i < exceptionTypes.length; i++) {
                String ss = exceptionTypes[i].toString();
                exc.append(ss);
                if (i<(exceptionTypes.length-1)) exc.append(",");
            }
            if (Modifier.isPublic(modifiers))
            System.out.printf("%s%s %s(%s)\n", sb, s, name, exc);
        }
        Field[] fields = m.getDeclaredFields();
        for (Field field : fields) {
            String name = field.getName();
            int modifiers = field.getModifiers();
            Class<?> type = field.getType();
            String s = type.toString();
            if (Modifier.isPublic(modifiers))
                System.out.printf("%s %s\n", s, name);
        }
    }
}
