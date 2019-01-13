package by.it.migunko.jd01_10;

import java.lang.reflect.Method;
public class BeanTester {
    public static void main(String[] args) throws Exception{
        Class<Bean> beanClass = Bean.class;
        Method[] methods = beanClass.getDeclaredMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(Param.class)) {
                Param params = method.getAnnotation(Param.class);
                System.out.println("Метод: "+method.getName()+ " результат= " +
                        method.invoke(beanClass.getDeclaredConstructor().newInstance(), params.a(), params.b()));
            }
        }
    }
}
