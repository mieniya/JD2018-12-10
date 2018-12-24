package by.it.moroz.jd01_05;

public class MergeSort {

    static int[] mergeSort(int[] array) {
        int[] res = mergeSort(array, 0, (array.length - 1));
        for (int i = 0; i < array.length; i++) {
            array[i] = res[i];
        }
        return res;
    }
    public static int[] mergeSort(int[] array, int left, int right) {
        int length = right - left + 1;
        if (length == 1) {
            return new int[]{array[left]};
        }
        int half = (right + left) / 2;
        int[] a = mergeSort(array, left, half);
        int[] b = mergeSort(array, half + 1, right);

        return merge(a, b);
    }

    private static int[] merge(int[] part1, int[] part2) {
        int[] arr = new int[part1.length + part2.length];
        int i = 0;
        int j = 0;
        for (int k = 0; k < arr.length; k++) {
            if (i == part1.length) {
                arr[k] = part2[j];
                j++;
            } else if (j == part2.length) {
                arr[k] = part1[i];
                i++;
            } else {
                if (part1[i] < part2[j]) {
                    arr[k] = part1[i];
                    i++;
                } else {
                    arr[k] = part2[j];
                    j++;
                }
            }
        }
        return arr;
    }
}
