package by.it.yarmolenka.jd01_04;

class Helper {
    static void bubbleSort(double[] array) {
        boolean swap;
        int end = array.length - 1;
        do {
            swap = false;
            for (int i = 0; i < end; i++)
                if (array[i] > array[i + 1]) {
                    double temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    swap = true;
                }
            end--;
        }
        while (swap);
    }
}
