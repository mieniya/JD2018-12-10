package by.it.dziomin.jd01_10;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class BeanTester {
    public static void main(String[] args) throws Exception {

        Class<Bean> beanClass = Bean.class;
        Bean bean = beanClass.getDeclaredConstructor().newInstance();


        Class<Param> paramAnnotation = Param.class;
        Method aMethod = paramAnnotation.getMethod("a");
        Method bMethod = paramAnnotation.getMethod("b");

        Method[] methods = beanClass.getDeclaredMethods();

        for (Method method : methods) {
            Annotation[] declaredAnnotations = method.getDeclaredAnnotations();
            for (Annotation declaredAnnotation : declaredAnnotations) {
                if (declaredAnnotation.annotationType().equals(paramAnnotation)) {
                    int aValue = (int) aMethod.invoke(declaredAnnotation);
                    int bValue = (int) bMethod.invoke(declaredAnnotation);
                    double result = (Double) method.invoke(bean, aValue, bValue);
                    System.out.println(method.getName()+result);
                }
            }
        }
    }
}
