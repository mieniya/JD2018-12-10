package by.it.lyakhova.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintString {
    public static void main(String[] args) {
        Class<String> str = String.class;

        Method[] methods = str.getDeclaredMethods(); //находим все методы

        for (Method method : methods){

            String name = method.getName(); //вытягиваем имя каждого метода и присваиваем его строковой переменной

            int modifiers = method.getModifiers(); //определяем значение типа int, биты которого представляют модификаторы класса

            if(!Modifier.isStatic(modifiers)) System.out.printf("%s\n", name);

        }
    }


}
