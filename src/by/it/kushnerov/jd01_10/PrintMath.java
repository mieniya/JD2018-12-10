package by.it.kushnerov.jd01_10;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintMath {
    public static void main(String[] args) {
        Class<Math> mathClass = Math.class;
        Method[] methods = mathClass.getDeclaredMethods();
        for (Method method : methods) {
            String name = method.getName();
            int modifiers = method.getModifiers();
            StringBuilder mm = new StringBuilder();
            if (Modifier.isPublic(modifiers)) {
                mm.append("public ");
                if (Modifier.isPrivate(modifiers)) mm.append("private ");
                if (Modifier.isProtected(modifiers)) mm.append("protected ");
                if (Modifier.isStatic(modifiers)) mm.append("static ");
                Class<?> returnType = method.getReturnType();
                String ret = returnType.getSimpleName();
                int parameterCount = method.getParameterCount();
                Class<?>[] parameterTypes = method.getParameterTypes();
                for (int i = 0; i < parameterTypes.length; i++) {
                    if (parameterCount == 1) {
                        System.out.printf("%s%s %s(%s)\n", mm, ret, name, parameterTypes[i]);
                    }
                    if (parameterCount == 2) {
                        System.out.printf("%s%s %s(%s,%s)\n", mm, ret, name, parameterTypes[i], parameterTypes[i + 1]);
                        i++;
                    }
                }
                if (parameterCount!=1 && parameterCount!=2)  System.out.printf("%s%s %s()\n", mm, ret, name);
            }
        }
        Field[] fields = mathClass.getFields();
        for (Field field : fields) {
            Class<?> type = field.getType();
            System.out.printf("%s %s\n", type.getName(), field.getName());
        }
    }
}
