package by.it.lyakhova.jd01_10;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;


public class PrintMath {
    public static void main(String[] args) {
        Class<Math> ss = Math.class;

        Method[] methods = ss.getDeclaredMethods(); //находим все методы
        for (Method method : methods) {

            String name = method.getName(); //вытягиваем имя каждого метода и присваиваем его строковой переменной

            int modifiers = method.getModifiers(); //определяем значение типа int, биты которого представляют модификаторы класса

            StringBuilder mm = new StringBuilder();
            if (Modifier.isPublic(modifiers)) mm.append("public ");
            if (Modifier.isPrivate(modifiers)) mm.append("private ");
            if (Modifier.isProtected(modifiers)) mm.append("protected ");
            if (Modifier.isStatic(modifiers)) mm.append("static ");

            Class<?> returnType = method.getReturnType();
            String ret = returnType.getSimpleName();

            Class[] typeParam = method.getParameterTypes();

            StringBuilder par = new StringBuilder();
            String del = "";

            for (Class el : typeParam) {
                par=par.append(del).append(el.getSimpleName());
                del = ",";
            }

            if (Modifier.isPublic(modifiers)) {
                System.out.printf("%s%s %s(%s)\n", mm, ret, name, par);

            }

        }

        Field[] fields = ss.getDeclaredFields();
        for (Field field : fields) {

            String name = field.getName();

            int modifiers = field.getModifiers();

            StringBuilder mm = new StringBuilder();
            if (Modifier.isPublic(modifiers)) mm.append("public ");
            if (Modifier.isPrivate(modifiers)) mm.append("private ");
            if (Modifier.isProtected(modifiers)) mm.append("final ");
            if (Modifier.isStatic(modifiers)) mm.append("static ");

            Class<?> returnType = field.getType();
            String ret = returnType.getSimpleName();

            if (Modifier.isPublic(modifiers)) System.out.printf("%s%s %s\n", mm, ret, name);

        }
    }

}
