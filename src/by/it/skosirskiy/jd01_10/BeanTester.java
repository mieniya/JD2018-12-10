package by.it.skosirskiy.jd01_10;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class BeanTester {

    public static void main(String[] args) throws Exception{
        Class ss = Bean.class;
        Constructor beanConstructor = ss.getConstructor();
        Bean bean = (Bean) beanConstructor.newInstance();
        Method[] methods= ss.getDeclaredMethods();
        for (Method method : methods) {
            if(method.isAnnotationPresent(Param.class)){
                Param annotation = method.getAnnotation(Param.class);
                double result=(double) method.invoke(bean, annotation.a(), annotation.b());
                System.out.printf("%s %s\n", method.getName(), result);
            }
        }
    }
}
