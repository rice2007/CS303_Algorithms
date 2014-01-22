package labthree.heapsort;

/**
 * Created by Ajay on 1/22/14.
 */
public class HeapSort {

    private static int largest;
    private static int heapSize;
    private static int left;
    private static int right;

    public static void heapSort(int[] array) {
        buildMaxHeap(array);
        int temp;
        for (int i = array.length - 1; i >= 0; i--) {
            temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            heapSize--;
            maxHeapify(array, 0);
            if (i > 0) {
                System.out.print(array[i] + ", ");
            } else {
                System.out.println(array[i]);
            }
        }
    }

    private static void buildMaxHeap(int[] array) {
        heapSize = array.length;
        for (int i = (int) Math.floor((array.length) / 2) - 1; i >= 0; i--) {
            maxHeapify(array, i);
        }
    }

    private static void maxHeapify(int[] array, int i) {
        left = getLeft(i);
        right = getRight(i);
        largest = ((left <= heapSize - 1) && (array[left] > array[i]))
                ? left
                : i;
        if ((right <= heapSize - 1) && (array[right] > array[largest])) {
            largest = right;
        }
        if (largest != i) {
            int temp = array[i];
            array[i] = array[largest];
            array[largest] = temp;
            maxHeapify(array, largest);
        }
    }

    private static int getLeft(int i) {
        return (i * 2);
    }

    private static int getRight(int i) {
        return (i * 2 + 1);
    }

    private static int getPartent(int i) {
        return (int) Math.floor((i / 2)) - 1;
    }
}
