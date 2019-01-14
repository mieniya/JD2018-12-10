package by.it.zagurskaya.jd01_10;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class BeanTester {

    public static void main(String[] args) throws Exception {
        Class beanClass = Bean.class;
        Constructor beanConstructor = beanClass.getConstructor();
        Bean bean = (Bean) beanConstructor.newInstance();

        Method[] methods = beanClass.getDeclaredMethods();
        for (Method method: methods) {
            if (method.isAnnotationPresent(Param.class)) {
                Param annotation = method.getAnnotation(Param.class);
                double result = (double) method.invoke(bean, annotation.a(), annotation.b());
                System.out.println(method.getName() + " " + result);
            }
        }
    }
}
