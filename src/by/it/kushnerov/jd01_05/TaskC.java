package by.it.kushnerov.jd01_05;

import static java.lang.Math.*;

public class TaskC {
    public static void main(String[] args) {
        int col =0;
        int coll = 0;
        int n = (int) (Math.random()*21 + 20);
        System.out.println(n);
        double[] a = new double[n];
        int i =0;
        int j = 0;
        for (double x = 5.33; x <= 9; x=x+((9-5.33)/n)) {
            double z = pow((x*x+4.5),1.0/3);
            a[i] =z;
            if (z >3.5){
                j++;
            }
            System.out.printf("%s[%- 3d]=%-10.5f","A",i,a[i]);
            col++;
            if (col%4==0 || col==n){
                System.out.println();
            }
            if(i+1 < n)
            i++;
        }
        System.out.println();
        double[] b = new double[j];
        int m =0;
        for (int k = 0; k < n; k++) {
            if (a[k]>3.5){
                b[m] = a[k];
                System.out.printf("%s[%- 3d]=%-10.5f","B",m,b[m]);
                coll++;
                if (coll%4==0 || coll==j){
                    System.out.println();
                }
                m++;
            }
        }
    }
}
