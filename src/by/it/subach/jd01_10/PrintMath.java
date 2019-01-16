package by.it.subach.jd01_10;

import java.lang.reflect.*;

public class PrintMath {
    public static void main(String[] args) throws Exception {
        Class<Math> mathClass = Math.class;
        Method[] methods = mathClass.getDeclaredMethods();
        for (Method method : methods) {
            String name = method.getName();
            int modifiers = method.getModifiers();
            StringBuilder sb = new StringBuilder();
            if(Modifier.isPublic(modifiers))
                sb.append("public ");
            else continue;
            if(Modifier.isStatic(modifiers))
                sb.append("static ");
            if(Modifier.isPrivate(modifiers))
                sb.append("private ");
            if(Modifier.isProtected(modifiers))
                sb.append("protected ");

            Class<?> returnType = method.getReturnType();
            String retType = returnType.getName();
            sb.append(retType).append(" ").append(name).append("(");
            Class<?>[] parameterTypes = method.getParameterTypes();
            for (int i = 0; i < parameterTypes.length; i++) {
                String pt = parameterTypes[i].getSimpleName();
                sb.append(pt);
                if(i < parameterTypes.length-1){
                    sb.append(",");
                }

            }
            sb.append(")");
            System.out.println(sb);
        }

        Field[] fields = mathClass.getDeclaredFields();
        for (Field field : fields) {
            StringBuilder sb = new StringBuilder();
            int modifiers = field.getModifiers();
            if(Modifier.isPublic(modifiers))
                sb.append("public ");
            else continue;
            if(Modifier.isStatic(modifiers))
                sb.append("static ");
            if(Modifier.isPrivate(modifiers))
                sb.append("private ");
            if(Modifier.isProtected(modifiers))
                sb.append("protected ");

            sb.append(field.getType()).append(" ").append(field.getName());
            System.out.println(sb);
        }

    }
}
