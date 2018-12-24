package by.it.yarmolenka.jd01_03;

class InOut {
    static double[] getArray(String line) {
        line = line.trim();
        String[] arr = line.split(" ");
        double[] mas = new double[arr.length];
        for (int i = 0; i < mas.length; i++) {
            mas[i] = Double.parseDouble(arr[i]);
        }
        return mas;
    }

    static void printArray(double[] arr) {
        for (double v : arr) {
            System.out.println(v);
        }
    }

    static void printArray(double[] arr, String name, int columnCount) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(name);
            System.out.printf("[% -3d]=%5.2f  ", i, arr[i]);
            if ((i + 1) % columnCount == 0 || (arr.length - 1) == 0) System.out.println();
        }
    }
}
