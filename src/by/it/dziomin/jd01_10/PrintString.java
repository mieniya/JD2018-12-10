package by.it.dziomin.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashSet;

class PrintString {
    public static void main(String[] args) {
        Class<String> s = String.class;
        Method[] declaredMethods = s.getDeclaredMethods();
        HashSet<String> methodsHashSet = new HashSet<>();
        for (Method declaredMethod : declaredMethods) {
            if (!Modifier.isStatic(declaredMethod.getModifiers())) {
                methodsHashSet.add(declaredMethod.getName());
            }
        }
        for (String str : methodsHashSet) {
            System.out.println(str);
        }
    }
}

