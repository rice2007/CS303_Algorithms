package labtwo.mergesort;

import labone.insertionsort.InsertionSort;

public class MergeSort {

    /**
     * Recursively sorts an array using the merge sort algorithm. When the length of the
     * sub-arrays reaches half, insertion sort is called to sort on behalf of merge sort.
     *
     * @param array the array to be sorted.
     * @param temp a copy of the array that will be sorted
     * @param low the first element of the array to be sorted
     * @param high the last element of the array to be sorted
     */
    public static void mergeSort(int[] array, int[] temp, int low, int high) {

        if (low + (int) Math.floor(array.length * HALF) > high) {
            InsertionSort.insertionSort(array, low, high);
            return;
        }
        if (low < high) {

            int mid = (int) Math.floor((low + high) / 2);
            mergeSort(array, temp, low, mid);
            mergeSort(array, temp, (mid + 1), high);
            merge(array, temp, low, mid, high);
        }
    }

    /**
     * Merges the sub-arrays back into a single array.
     *
     * @param array the array to be sorted.
     * @param temp a copy of the array that will be sorted
     * @param low the first element of the array to be sorted
     * @param high the last element of the array to be sorted
     * @param mid the middle element of the array to be sorted
     */
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

    private static final double HALF = 0.33333;
}