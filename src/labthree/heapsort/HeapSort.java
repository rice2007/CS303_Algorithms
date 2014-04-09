package labthree.heapsort;

import java.util.Comparator;

public class HeapSort {

    private static int node;
    private static int heapSize;
    private static int left;
    private static int right;

    public static void heapSort(int[] array, Comparator comp) {
        buildHeap(array, comp);
        int temp;
        for (int i = array.length - 1; i >= 0; i--) {
            temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            heapSize--;
            heapify(array, 0, comp);
        }
    }

    private static void buildHeap(int[] array, Comparator comp) {
        heapSize = array.length;
        for (int i = (int) Math.floor((array.length) / 2) - 1; i >= 0; i--) {
            heapify(array, i, comp);
        }
    }

    private static void heapify(int[] array, int i, Comparator comp) {
        left = getLeft(i);
        right = getRight(i);
        node = ((left <= heapSize - 1) && (comp.compare(array[left], array[i]) > 0))
                ? left
                : i;
        if ((right <= heapSize - 1) && (comp.compare(array[right], array[node]) > 0)) {
            node = right;
        }
        if (node != i) {
            int temp = array[i];
            array[i] = array[node];
            array[node] = temp;
            heapify(array, node, comp);
        }
    }

    private static int getLeft(int i) {
        return (i * 2);
    }

    private static int getRight(int i) {
        return (i * 2 + 1);
    }

    private static int getParent(int i) {
        return (int) Math.floor((i / 2)) - 1;
    }
}
