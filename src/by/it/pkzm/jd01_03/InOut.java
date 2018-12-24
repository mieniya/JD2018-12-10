package by.it.pkzm.jd01_03;

public class InOut {
    static double[] getArray(String line) {
        line = line.trim();//обрезает пробелы в начале и конце строки
        String[] strArr = line.split(" "); //разбивает стринговый массив на элементы используя разелитель " "
        double[] res = new double[strArr.length]; // объявили массив длинной как стринговый
        for (int i = 0; i < strArr.length; i++) {
            res[i] = Double.parseDouble(strArr[i]);  // преобразует String в Double

        }
        return res;
    }

    static void printArray(double[] arr) {
        for (double element : arr) {  // (объявление : выражение) объявляется переменная, которой присваиваются элементы массива
            System.out.print(element + " ");
        }
        System.out.println();
    }
    static void printArray(double[ ] arr, String name, int columnCount){
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%s[%-1d]=%-7.3f",name,i,arr[i]); /* строка=name, [десятичное целое 3 знака выравнено по левому краю = i],
            десятичное с плавающей точкой 7 знаков 3 после точки выровнено по левому = элемент массива  */
            if ((i+1)%columnCount==0 || i==arr.length-1)
                System.out.println();

        }
    }
}

