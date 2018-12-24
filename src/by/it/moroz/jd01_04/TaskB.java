package by.it.moroz.jd01_04;

import java.util.Scanner;

public class TaskB {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n  = scanner.nextInt();

        String [] name = new String[n];
        for (int i = 0; i < name.length; i++) {
            name[i]= scanner.next();
        }

        int [][] money = new int[n][4];
        for (int i = 0; i < money.length; i++) {
            System.out.println("Введите зарплату для "+ name[i]);
            for (int j = 0; j < money[0].length; j++) {
                money[i][j]=scanner.nextInt();
            }
        }

        double res=0;
        System.out.println("------------------------------------------------------");
        System.out.printf("%-7s%2s%-10s%-10s%-10s%-10s%-5s%n","Фамилия","  ","Квартал1","Квартал2","Квартал3","Квартал4","Итого");
        System.out.println("------------------------------------------------------");
        for (int i = 0; i < money.length; i++) {
            int g = 0;
            System.out.printf("%7s%2s",name[i],": ");
            for (int j = 0; j < money[0].length; j++) {
                g+=money[i][j];
                System.out.printf("%-10s",money[i][j]);
            }
            System.out.printf("%-5s%n", g);
            res+=g;
        }
        System.out.println("------------------------------------------------------");
        int res1 = (int) res;
        System.out.printf("%5s%4s%-10d%n","Итого","    ",res1);
        double mid = res/(4*n);
        System.out.printf("%7s%2s%-10.4f","Средняя","  ",mid);
    }
}
