package by.it.dziomin.jd01_10;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;

public class PrintMath {
    public static void main(String[] args) {
        Class<Math> mathClass = Math.class;
        Method[] methods = mathClass.getDeclaredMethods();
        Field[] fields = mathClass.getFields();
        for (Method method : methods) {
            int modifier = method.getModifiers();
            if (Modifier.isPublic(modifier)) {
                System.out.print(Modifier.toString(modifier) + " ");
                System.out.print(method.getReturnType() + " ");
                System.out.print(method.getName() + "(");
                Type[] types = method.getGenericParameterTypes();
                for (int i = 0; i < types.length; i++) {
                    System.out.print(types[i].toString());
                    if (i != types.length - 1) {
                        System.out.print(",");
                    }
                }
                System.out.println(")");
            }
        }
        for (Field field : fields) {
            int modifier = field.getModifiers();
            if (Modifier.isPublic(modifier)) {
                System.out.print(Modifier.toString(modifier) + " ");
                System.out.print(field.getType()+" ");
                System.out.println(field.getName());
            }
        }
    }

}
