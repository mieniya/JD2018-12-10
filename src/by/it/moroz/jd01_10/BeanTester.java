package by.it.moroz.jd01_10;

import java.lang.annotation.Annotation;


public class BeanTester {

    public static void main(String[] args) throws Exception {

        Class bean = Bean.class;
        Annotation[] annotations = bean.getAnnotations();
        
    }

}
