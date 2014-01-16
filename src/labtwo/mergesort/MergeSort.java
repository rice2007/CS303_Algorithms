package labtwo.mergesort;

public class MergeSort {

    public static void mergeSort(int[] array, int[] temp, int low, int high) {
        if (low < high) {
            int mid = (int) Math.floor((low + high) / 2);
            mergeSort(array, temp, low, mid);
            mergeSort(array, temp, (mid + 1), high);
            merge(array, temp, low, mid, high);
        }
    }

    private static void merge(int[] array, int[] temp, int low, int high, int mid) {
        int i = low;
        int j = high + 1;
        for (int k = low; k <= mid; k++) {
            temp[k] = array[k];
        }
        for (int k = low; k <= mid; k++) {
            if (i > high) {
                array[k] = temp[j];
                j++;
            } else if (j > mid) {
                array[k] = temp[i];
                i++;
            } else if (temp[j] < temp[i]) {
                array[k] = temp[j];
                j++;
            } else {
                array[k] = temp[i];
                i++;
            }
        }
    }
}