package by.it.lyakhova.jd01_05;

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

    static void printArray(int[] arr){
        for (int element : arr) {
            System.out.print(element+" ");
        }
        System.out.println();
    }

    public static void printArray(double[] arr, String name, int columnCount){
        int col=0;
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%s[% -3d]=%-10.5f", name, i, arr[i]);
            col++;
            if (col%columnCount==0||col==arr.length){
                System.out.println();
            }
        }
    }

    public static void printArray(int[] arr, String name, int columnCount){
        int col=0;
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%s[%2d]=%-8d", name, i, arr[i]);
            col++;
            if (col%columnCount==0||col==arr.length){
                System.out.println();
            }
        }
    }

    public static void printArrayGraf(int[] arr, String name, int columnCount, boolean horizontPrint){
        char topLeftCorner = '\u2554';//╔
        char topRightCorner = '\u2557';//╗
        char topMiddleCorner = '\u2566';//╦
        char middleLeftCorner = '\u2560';//╠
        char middleCorner = '\u256c';//╬
        char middleRightCorner = '\u2563';//╣
        char bottomLeftCorner = '\u255a';//╚
        char bottomRightCorner = '\u255d';//╝
        char bottomMiddleCorner = '\u2569';//╩
        char horizontLine = '\u2550';//═
        char verticalLine = '\u2551';//║


       String topLine = printFullLine(topLeftCorner, topMiddleCorner, topRightCorner, columnCount); //Верхняя линия

       String middleLine = printFullLine(middleLeftCorner, middleCorner, middleRightCorner, columnCount); //Центральная линия

       String bottomLine = printFullLine(bottomLeftCorner, bottomMiddleCorner, bottomRightCorner, columnCount); //Нижняя линия

        System.out.println(topLine);
        //int rowCount = arr.length/columnCount + 1;
        int rowCount = (int) Math.ceil((double)arr.length/(double) columnCount);
        int count = 0;
        for (int row = 0; row < rowCount; row++) {
            for (int i = 0; i < columnCount; i++) {
                System.out.print(verticalLine);
                if (horizontPrint) {
                    if (count < arr.length) {
                        System.out.printf("%s[%2d]=%-5d", name, count, arr[count]);
                        count++;
                    }
                    else
                        System.out.print("           ");
                     }
                else {
                    int index = i * rowCount + row;
                    if (index < arr.length)
                        System.out.printf("%s[%2d]=%-5d", name, index, arr[index]);
                    else
                        System.out.print("           ");
                }
            }
            System.out.println(verticalLine);
            if (row < rowCount - 1) System.out.println(middleLine);
        }
        System.out.println(bottomLine);
        System.out.println();
    }

    private static String printFullLine(char left, char center, char right, int columnCount){
        char horizontLine = '\u2550';//═
        StringBuilder line = new StringBuilder();
        line.append(left);
        for (int i = 0; i < columnCount; i++) {
            for (int j = 0; j < 11; j++) {
                line.append(horizontLine);
            }
            if (i<(columnCount-1)) line.append(center);
        }
        line.append(right);
        String completedLine = line.toString();

        return completedLine;
    }
}
