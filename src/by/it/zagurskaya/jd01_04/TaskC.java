package by.it.zagurskaya.jd01_04;

public class TaskC {

    static void buildOneDimArray(String line) {
        double[] array = InOut.getArray(line);
        InOut.printArray(array, "V", 5);
        double first = array[0];
        double last = array[array.length - 1];
        Helper.sort(array);
        InOut.printArray(array, "V", 4);
        for (int i = 0; i < array.length; i++) {
            if (first == array[i]) {
                System.out.printf("Index of first element=%d\n", i);
                break;
            }
        }
        for (int i = 0; i < array.length; i++) {
            if (last == array[i]) {
                System.out.printf("Index of last element=%d\n", i);
                break;
            }
        }
    }

    static void mergeSort(double[ ] array) {}
}
