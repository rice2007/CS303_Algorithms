package labtwo.mergesort;

/**
 * Created by Ajay on 1/15/14.
 */
public class MergeSort {

    public static void mergeSort(int[] array, int[] temp, int p, int q) {
        if (p < q) {
            int r = Math.floorDiv((p + q), 2);
            mergeSort(array, temp, p, r);
            mergeSort(array, temp, (r + 1), q);
            merge(array, temp, p, r, q);
        }
    }

    private static void merge(int[] array, int[] temp, int p, int q, int r) {
        int i = p;
        int j = q + 1;
        for (int k = p; k <= r; k++) {
            temp[k] = array[k];
        }
        for (int k = p; k <= r; k++) {
            if (i > q) {
                array[k] = temp[j];
                j++;
            } else if (j > r) {
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
