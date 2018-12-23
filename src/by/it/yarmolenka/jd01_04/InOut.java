package by.it.yarmolenka.jd01_04;

class InOut {
    static double[] getDoubleArray(String s) {
        s = s.trim();
        String[] array = s.split(" ");
        double[] arr = new double[array.length];
        for (int i = 0; i < arr.length; i++) arr[i] = Double.parseDouble(array[i]);
        return arr;
    }
    static void printArray(double[] arr, String name, int col){
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%s[% -3d]=%4.2f  ",name,i+1,arr[i]);
            if ((i+1)%col==0 || i==arr.length-1) System.out.println();
        }
    }
}
