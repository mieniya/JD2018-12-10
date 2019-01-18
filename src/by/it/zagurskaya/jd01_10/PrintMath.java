package by.it.zagurskaya.jd01_10;


import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class PrintMath {
    public static void main(String[] args) {

        Class<Math> matchClass = Math.class;
        Method[] methods = matchClass.getMethods();
        Field[] fields = matchClass.getFields();
        doPrintPublicMethod(methods);
        doPrintPublicField(fields);
    }

    public static StringBuilder modifiersMatch(int modifiers) {
        StringBuilder mm = new StringBuilder();
        if (Modifier.isPublic(modifiers)) mm.append("public ");
        if (Modifier.isPrivate(modifiers)) mm.append("private ");
        if (Modifier.isProtected(modifiers)) mm.append("protected ");
        if (Modifier.isStatic(modifiers)) mm.append("static ");
        if (Modifier.isFinal(modifiers)) mm.append("final ");
        if (Modifier.isNative(modifiers)) mm.append("native ");
        return mm;
    }

    public static void doPrintPublicMethod(Method[] methods) {
        for (Method method : methods) {
            if (Modifier.isPublic(method.getModifiers())) {
                Class returnClass = method.getReturnType();
                String returnClassName = returnClass.getSimpleName();
                if (returnClassName.equalsIgnoreCase("void")) {
                    returnClassName = "";
                }
                String argumentClassNamesString = "";
                Class[] argumentClasses = method.getParameterTypes();
                for (int i = 0; i < argumentClasses.length; i++) {
                    argumentClassNamesString = argumentClassNamesString + argumentClasses[i].getSimpleName() + ',';
                }
                argumentClassNamesString = argumentClassNamesString.length() != 0 ?
                        argumentClassNamesString.substring(0, argumentClassNamesString.length() - 1) :
                        "";
                StringBuilder modifiersMatch = modifiersMatch(method.getModifiers());
                System.out.println(modifiersMatch + returnClassName + " " + method.getName() + "(" + argumentClassNamesString + ")");
            }
        }
    }

    public static void doPrintPublicField(Field[] fields) {
        for (Field field : fields) {
            if (Modifier.isPublic(field.getModifiers())) {
                Class returnClass = field.getType();

                String returnClassName = returnClass.getSimpleName();
                if (returnClassName.equalsIgnoreCase("void")) {
                    returnClassName = "";
                }


                System.out.print(modifiersMatch(field.getModifiers()) + " ");
                System.out.print(returnClassName + " ");
                System.out.println(field.getName());
            }
        }
    }
}
