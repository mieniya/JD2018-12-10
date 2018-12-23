package by.it.lyakhova.jd01_04;

import java.util.Scanner;

public class TaskC {
    static void buildOneDimArray(String line){
        double[] array = InOut.getArray(line);
        InOut.printArray(array, "V", 5);
        double first = array[0];
        double last = array[array.length-1];

        mergeSort(array);
        InOut.printArray(array, "V", 4);

        int a = binarySearch(array, first);
        System.out.println("first element="+a);
        int b = binarySearch(array, last);
        System.out.println("last element="+b);
    }



    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        buildOneDimArray(line);
    }

    static void mergeSort(double[] array){
        int left = 0;
        int right = array.length-1;
        double[] arr = mergeSort(array, left, right);
        for (int i = 0; i < arr.length; i++) {
            array[i]=arr[i];
        }
    }

    private static double[] mergeSort(double[] array, int left, int right){

        if (left==right) return array;
        else {
            int middle=(left+right)/2;
            double[] part1 = new double[middle-left+1];
            for (int i = 0; i < part1.length; i++) {
                part1[i]=array[i];
            }
            part1 = mergeSort(part1, 0, part1.length-1);

            double[] part2 = new double[array.length-part1.length];
            for (int i = 0; i < part2.length; i++) {
                part2[i]=array[middle+1+i];
            }
            part2 = mergeSort(part2, 0, part2.length-1);

            array = merge(part1, part2);

        }
        return array;
    }

    private static double[] merge(double[] part1, double[] part2){
        int i=0;
        int j=0;
        double[] arraySort = new double[part1.length+part2.length];
        int lengthLeft = part1.length;
        int lengthRight = part2.length;
        for (int k = 0; k < arraySort.length; k++) {
            if((i<lengthLeft)&&(j<lengthRight)){
                if(part1[i]<=part2[j]) {
                    arraySort[k] = part1[i];
                    i++;
                }
                else{
                    arraySort[k]=part2[j];
                    j++;
                }
            }
            else if (i<lengthLeft){
                arraySort[k] = part1[i];
                i++;
            }
            else{
                arraySort[k]=part2[j];
                j++;
            }
        }
        return arraySort;
    }

    static int binarySearch(double[ ] array, double value){
        int left = 0;
        int right = array.length-1;
        while (left<=right){
            int m = left+(right-left)/2;
            if (array[m]<value) left=m+1;
            else if (array[m]>value) right=m-1;
            else return m;
        }
        return -1;
    }
}
