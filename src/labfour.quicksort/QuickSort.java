package labfour.quicksort;

import labone.insertionsort.InsertionSort;

public class Quicksort {

    public static void quicksort(int[] array, int p, int r) {
        if (p < r) {
            int q = partition(array, p, r);
            quicksort(array, p, q - 1);
            quicksort(array, q + 1, r);
        }
    }

    public static void quicksortPartition(int[] array, int p, int r) {
        int n = r - p + 1;
        if (n <= 15) {
            InsertionSort.insertionSort(array, p, r);
            return;
        }
        int m = medianThree(array, p, p + (n / 2), r);
        int temp = array[m];
        array[m] = array[r];
        array[r] = temp;
        int q = partition(array, p, r);
        quicksort(array, p, q - 1);
        quicksort(array, q + 1, r);
    }

    private static int medianThree(int[]array, int i, int j, int k) {
        if (((array[i] > array[j]) && (array[i] < array[k])) || ((array[i] < array[j]) && (array[i] > array[k]))) {
            return i;
        } else if (((array[j] > array[i]) && (array[j] < array[k])) || ((array[j] < array[i]) && (array[j] > array[k]))) {
            return j;
        } else {
            return k;
        }
    }

    private static int partition(int[] array, int p, int r) {
        int x = array[r];
        int i = p - 1;
        for (int j = p; j <= r - 1 ; j++) {
            if (array[j] <= x) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        int temp = array[i + 1];
        array[i + 1] = array[r];
        array[r] = temp;
        return i + 1;
    }
}
