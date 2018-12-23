 package by.it.agadzhanov.jd01_03;

import by.it.agadzhanov.jd01_02.TaskC;

import java.util.Scanner;

 public class Runner {
     public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
         String str=scanner.nextLine();
         double[] array=InOut.getArray(str);
         InOut.printArray(array);
         InOut.printArray(array,"V",3);
         double min=Helper.findMin(array);
         System.out.println("Наименьший элемент массива Min="+min);
         double max=Helper.findMax(array);
         System.out.println("Набольший элемент массива Max="+max);
         Helper.sort(array);
         InOut.printArray(array);

         double[][] matrixLeft=InOut.getArray2D(2,3);
         InOut.printArray2D(matrixLeft);
         String vectorline=scanner.nextLine();
         double[] vector=InOut.getArray(vectorline);
         InOut.printArray(vector);
         System.out.println();
         double[] resvector=Helper.mul(matrixLeft,vector);
         InOut.printArray(resvector);

         double[][] matrixRight=InOut.getArray2D(3,4);
         InOut.printArray2D(matrixRight);
         double[][] resmatrix=Helper.mul(matrixLeft,matrixRight);
         InOut.printArray2D(resmatrix);
         }
     }