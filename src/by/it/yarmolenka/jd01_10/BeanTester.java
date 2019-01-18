package by.it.yarmolenka.jd01_10;

import java.lang.reflect.Method;

public class BeanTester {
    public static void main(String[] args) throws Exception {
        Class<Bean> beanClass = Bean.class;
        Method[] declaredMethods = beanClass.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            if (declaredMethod.isAnnotationPresent(Param.class)){
                Param annotation = declaredMethod.getAnnotation(Param.class);
                Object invoke = declaredMethod.invoke(Bean.class.newInstance(), annotation.a(), annotation.b());
                System.out.printf("%s result = %s\n", declaredMethod.getName(), invoke.toString());
            }
        }
    }
}
