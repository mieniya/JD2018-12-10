package by.it.moroz.jd01_10;

import java.lang.reflect.Method;


public class BeanTester {

    public static void main(String[] args) throws Exception {

        Class<Bean> bean = Bean.class;
        Method[] declaredMethods = bean.getDeclaredMethods();

        for (Method declaredMethod : declaredMethods) {
            if (declaredMethod.isAnnotationPresent(Param.class)){
                System.out.println(declaredMethod.getName()+ " " +
                        declaredMethod.invoke(bean.getDeclaredConstructor().newInstance(), declaredMethod.getAnnotation(Param.class).a(), declaredMethod.getAnnotation(Param.class).b()));
            }
        }

    }

}
