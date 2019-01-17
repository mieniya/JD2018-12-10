package by.it.a_khmelev.jd01_10;


import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintMath {
    public static void main(String[] args){
        Class<Math> ss = Math.class;
        Method[] methods = ss.getDeclaredMethods();
        for (Method method : methods) {
            String name = method.getName();
            int modifiers = method.getModifiers();
            StringBuilder mm = new StringBuilder();
            if (Modifier.isPublic(modifiers)) mm.append("public ");
            if (Modifier.isPrivate(modifiers)) mm.append("private ");
            if (Modifier.isProtected(modifiers)) mm.append("protected ");
            if (Modifier.isStatic(modifiers)) mm.append("static ");
            Class<?> returnType = method.getReturnType();
            String ret = returnType.getSimpleName();
            if (Modifier.isStatic(modifiers))
                System.out.printf("%s%s %s(????)\n", mm, ret, name);
        }
    }
}
