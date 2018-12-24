package by.it.moroz.jd01_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TaskC {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        step1(n);
        step2();
        //step3();
    }

    private static int[][] step1(int n) {
        int [][] mas = new int[n][n];

        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                mas[i][j]= (int) (Math.random()*(2*n+1)-n);
                System.out.print(mas[i][j]+ " ");
            }
            System.out.println();
        }
    return null;
    }
    private static void step2() {
    }
    private static int[][] step3(int [][] mas) {
        boolean[] delCol = new boolean[mas[0].length];
        boolean[] delRow = new boolean[mas.length];
        int max = Integer.MIN_VALUE;
        for (int i=0; i<mas.length; i++){
            for (int j = 0; j < mas[i].length; j++) {
                if(mas[i][j]>max);
                max=mas[i][j];
            }
        }

        for (int i=0; i<mas.length; i++){
            for (int j = 0; j < mas[i].length; j++) {
                if(mas[i][j]==max);
                delCol[j]=true;
                delRow[i]=true;
            }
        }
        //calc size
        int rowCount = 0;
        for (boolean value : delRow) if(!value) rowCount++;
        int colCount = 0;
        for (boolean value : delCol) if(!value) colCount++;

        int[][] res = new int[rowCount][colCount];

        int ir=0;
        int jr=0;
        for (int i = 0; i < mas.length; i++) {
            if(!delRow[i]){
                for (int j = 0; j < mas.length; j++) {
                    if(!delCol[j]){
                        res[ir][jr+1]=mas[i][j];
                    }

                }
                ir++;
                jr=0;
            }

        }
        //complete result
        return res;
    }


}
