package by.it.kushnerov.jd01_10;

import java.lang.reflect.Method;

public class BeanTester {
    public static void main(String[] args) throws Exception {
        Class<Bean> beanClass= Bean.class;
        Method[] methods = beanClass.getDeclaredMethods();
        for (Method method:methods){
            if (method.isAnnotationPresent(Param.class)){
                System.out.println(method.getName()+method.invoke(beanClass.newInstance(),
                        method.getAnnotation(Param.class).a(),method.getAnnotation(Param.class).b()));
            }
        }
    }
}
