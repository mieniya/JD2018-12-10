package by.it.subach.jd01_05;

public class Helper {

    static void sort(int [] arr) {
        boolean change;
        int counter = arr.length - 1;
        do {
            change = false;
            for (int i = 0; i < counter; i++) {
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i + 1];
                    arr[i + 1] = arr[i];
                    arr[i] = temp;
                    change = true;
                }
            }
            counter--;
        }while (change == true);
    }
}
