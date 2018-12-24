package by.it.lyakhova.jd01_04;

public class InOut {

    static double[] getArray(String line){
        //1 2 4 6 99 89___
        line=line.trim();
        String[] strArr = line.split(" ");
        double[] res=new double[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            res[i] = Double.parseDouble(strArr[i]);
        }
        return res;
    }

    static void printArray(double[] arr){
        for (double element : arr) {
            System.out.print(element+" ");
        }
        System.out.println();
    }

    static void printArray(double[][] arr){
        for (double[] row : arr) {
            for (double element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    public static void printArray(double[] arr, String name, int columnCount){
        int col=0;
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%s[% -3d]=%-7.3f", name, i, arr[i]);
            col++;
            if (col%columnCount==0||col==arr.length){
                System.out.println();
            }
        }
    }
}
