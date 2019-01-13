package by.it.lyakhova.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class BeanTester {
    public static void main(String[] args) throws Exception{
        Class<Bean> bean = Bean.class;
        Object instance = bean.getDeclaredConstructor().newInstance();

        Method[] methods = bean.getDeclaredMethods();


        for (Method method : methods) {
            String name = method.getName();
            double result;
            int modifiers = method.getModifiers();
            if (method.isAnnotationPresent(Param.class)){
                Param ann = method.getAnnotation(Param.class);
                int a = ann.a();
                int b = ann.b();

            if (Modifier.isStatic(modifiers)) result = (double) method.invoke(null, a, b);
            else result = (double) method.invoke(instance, a, b);

            System.out.println(name +" "+ result);

            }
        }

    }
}
