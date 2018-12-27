package by.it.skosirskiy.jd01_07;

public class Runner {
    public static void main(String[] args) {
        String str="{1,2,4}";
        Var v1=new Scalar(3.1415);
        Var v2=new Vector(str);
        Var v3=new Scalar((Scalar) v1);


        Var v4=new Vector(str);


        System.out.println(v1);
        System.out.println(v2);
        System.out.println(v3);
    }


}
