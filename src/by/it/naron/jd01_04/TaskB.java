package by.it.naron.jd01_04;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        System.out.println("Введите с консоли число людей");
        Scanner scan = new Scanner(System.in);
        int countPeople =scan.nextInt();
        System.out.println("вы ввели:"+countPeople+" человек");

        String [] lName = new String [countPeople];
        for (int i = 0; i <countPeople ; i++) {
            System.out.println("Введите фамилию "+(i+1)+" человека");
            lName [i] = scan.next();
        }

        System.out.println("Список людей");
        for (String element : lName){
            System.out.println(element);
        }
        int countKvartal = 4;
        int [] []zarplata = new int[countPeople][countKvartal];
        for (int i = 0; i <countPeople ; i++) {
            for (int j = 0; j < countKvartal; j++) {
                System.out.println("Введите зарплату для "+lName[i]+" за "+(j+1)+" квартал");
                zarplata [i] [j]=scan.nextInt();

            }
        }
        System.out.println("--------------------------------------------------------");
        System.out.printf("%1$-10s%2$-10s%3$-10s%4$-10s%5$-10s%6$5s\n",
                "Фамалия","Квартал1","Квартал2","Квартал3","Квартал4","Итого");
        System.out.println("--------------------------------------------------------");
        int commonSum = 0;
        for (int i = 0; i <countPeople ; i++) {
            System.out.printf("%1$-10s",lName[i]);
            int sumPerson=0 ;
            for (int j = 0; j <countKvartal ; j++) {
                System.out.printf("%1$-10d",zarplata[i][j]);
                sumPerson +=zarplata[i][j];
            }
            System.out.println(sumPerson);
            commonSum+=sumPerson;
        }
        System.out.println("--------------------------------------------------------");
        System.out.printf("%1$-50s%2$-5d\n","Итого:",commonSum);
      double avg =(double) commonSum / ((double) lName.length*(double)countKvartal);
       System.out.printf("%1$-48s%2$-7.4f","Средняя:",avg);
            }
}
