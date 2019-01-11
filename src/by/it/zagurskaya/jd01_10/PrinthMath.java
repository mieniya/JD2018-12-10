package by.it.zagurskaya.jd01_10;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrinthMath {
    public static void main(String[] args) {
       Class<Math> mathClass = Math.class;
       // Class<String> mathClass = String.class;
       // для B
       //  Class<String> ss = String.class;
       //String s = ss.getConstructor().newInstance();
        System.out.println(mathClass.getName());
        Method[] methods = mathClass.getMethods();      // mathClass.getMethod().var

       for (Method method: methods) {
           String name = method.getName();
           int modifiers = method.getModifiers();
           StringBuilder mm =new StringBuilder();
           int start=0b1000;// только ствтические методы
           //Modifier.isPublic()
           //if ((start&modifiers)==start)
           if (Modifier.isPublic(modifiers)) mm.append("public ") ;
           if (Modifier.isPrivate(modifiers)) mm.append("privat ") ;
           if (Modifier.isAbstract(modifiers)) mm.append("abstract ") ;
           if (Modifier.isStatic(modifiers)) mm.append("static ") ;
           Class<?> returnType = method.getReturnType();
           String ret = returnType.getSimpleName();
           if (Modifier.isStatic(modifiers))
           System.out.printf("%d %s() = %s\n", modifiers, name,method);
       }
    }
}
