package by.it.lyakhova.jd01_02;

import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите размер матрицы");
        int n=scanner.nextInt();

        int[][] mas = new int[n][n];
       /* for (int i = 0; i < mas.length; i++, System.out.println()) {
            for (int j = 0; j < mas[i].length; j++) {
                mas[i][j] = (int) (Math.random() * (2 * n + 1)) - n;
                System.out.print(mas[i][j]+" ");
            }
        }*/

       // step1(n);
        mas = step1(n);

        for (int i = 0; i < mas.length; i++, System.out.println()) {
            for (int j = 0; j < mas[i].length; j++) {
                System.out.print(mas[i][j] + " ");
            }
        }
        System.out.println();

        step2(mas);
        System.out.println();

        step3(mas);

    }

    private static int[][] step1(int n) {

        int[][] massive = new int[n][n];
        boolean min=false;
        boolean max=false;
       // int[][] mass = new int[n][n];

        while((min==false)||(max==false)) {

            for (int i = 0; i < massive.length; i++) {
                for (int j = 0; j < massive[i].length; j++) {
                    massive[i][j] = (int) (Math.random() * (2 * n + 1)) - n;
                }
            }

            for (int[] row : massive) {
                for (int el : row) {
                    if (el == n) max = true;
                    if (el == (-n)) min = true;
                }
            }
        }

        /*for (int i = 0; i < massive.length; i++, System.out.println()) {
            for (int j = 0; j < massive[i].length; j++) {
                System.out.print(massive[i][j] + " ");
            }
        }*/


        return massive;
    }

   private static int step2(int[][] mas) {
        int sum=0;

       /*for (int i = 0; i < mas.length; i++, System.out.println()) {
           for (int j = 0; j < mas[i].length; j++) {
               System.out.print(mas[i][j] + " ");
           }
       }*/


        for (int i=0; i<mas.length; i++){
            int count=0;
            for(int j=0; j < mas[i].length; j++){
                if(mas[i][j]>=0) count++;
                if((mas[i][j]<0)&&(count==1)) sum=sum+mas[i][j];
            }
        }
       System.out.println(sum);


        return sum;
    }

    private static int[][] step3(int[][] mas) {
        //int m = mas.length;
        //int max = mas.length;
        //int maxI = -1;
        //int maxJ = -1;
        //int count=0;


        boolean[] delCol= new boolean[mas[0].length];
        boolean[] delRow = new boolean[mas.length];
        int max=Integer.MIN_VALUE;
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas[i].length; j++) {
                if(mas[i][j]>max) max=mas[i][j];
            }
        }

        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas[i].length; j++) {
                if(mas[i][j]==max) {
                    delCol[j]=true;
                    delRow[i]=true;
                }
            }
        }

        int rowCount = 0;
        int colCount = 0;

        for (boolean value : delRow) {
            if(!value) rowCount++;
        }
        for (boolean value : delCol) {
            if (!value) colCount++;
        }
        int[][] res = new int[rowCount][colCount];
        int ir=0;
        int jr=0;

        for (int i = 0; i < mas.length; i++) {
            if(!delRow[i]){
                for (int j = 0; j < mas[i].length; j++) {
                    if (!delCol[j]){
                        res[ir][jr++]=mas[i][j];
                    }
                }
                ir++;
                jr=0;
            }
        }
        //complete result

       // int[][] mas2 = new int[m][m];

        //for (int i = 0; i < mas.length; i++) {
         //   System.arraycopy(mas[i], 0, mas2[i], 0, mas[i].length);
       // }

        //int max = max(mas2);
        //System.out.println("max="+max);

        //while(true) {
          //  count=0;
            //for (int i = 0; i < m; i++) {
              //  for (int j = 0; j < m; j++) {
                //    if (mas2[i][j] == max) {
                  //      maxI = i;
                    //    maxJ = j;
                      //  count++;
                       // System.out.println(i + " " + j);
                    //}
                //}
            //}
            //if(count>0) {
              //  m = m - 1;
                //int[][] mas3 = new int[m][m];
                //for (int i = 0; i < mas3.length; i++/*, System.out.println()*/) {
                  //  for (int j = 0; j < mas3.length; j++) {
                    //    if ((i < maxI) && (j < maxJ)) mas3[i][j] = mas2[i][j];
                      //  else if ((i >= maxI) && (j >= maxJ)) mas3[i][j] = mas2[i + 1][j + 1];
                       // else if (i < maxI) mas3[i][j] = mas2[i][j + 1];
                        //else mas3[i][j] = mas2[i + 1][j];
                        //System.out.print(mas3[i][j] + " ");
                    //}
                //}
                //mas2 = mas3;
               // System.out.println();
            //}
            //else {
              //  for (int i = 0; i < mas2.length; i++, System.out.println()) {
                //    for (int j = 0; j < mas2[i].length; j++) {
                  //      System.out.print(mas2[i][j] + " ");
                   // }
                //}
                //break;}

        //}

        return res;
    }

    private static int max(int[][] mas){
        int max = mas[0][0];
        for (int[] row : mas) {
            for (int el : row) {
                if(max<el) max=el;

            }
        }

        return max;
    }

}
