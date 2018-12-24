package by.it.agadzhanov.jd01_07;

public class Runner {
    public static void main(String[] args) {
        Scalar var1=new Scalar(1);
        Scalar var2=new Scalar("222");
        Scalar var3=new Scalar(var1);
        System.out.println("Var1="+var1);
        System.out.println("Var2="+var2);
        System.out.println("Var3="+var3);
        double[] test={1,2,3,4,5,6,7,8};
        Var vec=new Vector(test);
        System.out.println(vec);
    }
}