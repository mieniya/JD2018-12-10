package by.it.moroz.jd01_10;

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

            Class<?> returnType = method.getReturnType();
            String ret = returnType.getSimpleName();
            if (Modifier.isPublic(modifiers) & !Modifier.isStatic(modifiers)) {
                StringBuilder mm = new StringBuilder();
                mm.append("public ");
                System.out.printf("%s%s %s", mm, ret, name);
            }
            if (Modifier.isPublic(modifiers) & Modifier.isStatic(modifiers)) {
                StringBuilder mm = new StringBuilder();
                mm.append("public static ");
                System.out.printf("%s%s %s", mm, ret, name);
            }
            Class<?>[] parameterTypes = method.getParameterTypes();
            if (parameterTypes.length == 1)
                System.out.printf("(%s)\n", parameterTypes[0]);
            else if (parameterTypes.length == 2)
                System.out.printf("(%s,%s)\n", parameterTypes[0], parameterTypes[1]);
            else if (parameterTypes.length == 3)
                System.out.printf("(%s,%s,%s)\n", parameterTypes[0], parameterTypes[1], parameterTypes[2]);
            else if (parameterTypes.length == 4)
                System.out.printf("(%s,%s,%s,%s)\n", parameterTypes[0], parameterTypes[1], parameterTypes[2], parameterTypes[3]);
            else if (parameterTypes.length == 0)
                System.out.printf("()\n");

        }
        Field[] fields = mathClass.getFields();
        for (Field field : fields) {
            String name = field.getName();
            int modifiers = field.getModifiers();
            Class<?> type = field.getType();
            String ret = type.getSimpleName();
            if (Modifier.isPublic(modifiers) & !Modifier.isStatic(modifiers)) {
                StringBuilder mm = new StringBuilder();
                mm.append("public ");
                System.out.printf("%s%s %s\n", mm, ret, name);
            }
            if (Modifier.isPublic(modifiers) & Modifier.isStatic(modifiers)) {
                StringBuilder mm = new StringBuilder();
                mm.append("public static ");
                System.out.printf("%s%s %s\n", mm, ret, name);
            }
        }
    }
}
