package by.it.skosirskiy.jd02_01;

public class Test {

    interface Interface1 {
        String commonString = "commonString from Interface1";
    }

    interface Interface2 {
        String commonString = "commonString from Interface2";
    }

     class MixedClass1 implements Interface1,Interface2 {
    }

    public  class Test1 {
        public  void main(String[] args) {

            System.out.println("Test N1");
            System.out.println(
                    "Two interfaces have property with the same signature");

            MixedClass1 mixedClass = new MixedClass1();

    /* reference to commonString is ambiguous,
    both variable commonString in Interface1
    and variable commonString in Interface2 match */

            //System.out.println(mixedClass.commonString);

            Interface1 Interface = mixedClass;
            System.out.println(Interface.commonString);
            System.out.println(((Interface2) mixedClass).commonString);
        }
    }


}
