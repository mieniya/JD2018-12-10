package by.it.subach.jd01_04;

public class Helper {

    static void sort(double[] arr) {
        boolean change;
        int counter = arr.length - 1;
        do {
            change = false;
            for (int i = 0; i < counter; i++) {
                if (arr[i] > arr[i + 1]) {
                    double temp = arr[i + 1];
                    arr[i + 1] = arr[i];
                    arr[i] = temp;
                    change = true;
                }
            }
            counter--;
        }while (change == true);
    }
}
