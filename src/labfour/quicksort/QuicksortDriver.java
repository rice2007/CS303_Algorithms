package labfour.quicksort;

import labone.insertionsort.InsertionSort;
import labthree.heapsort.Greater;
import labthree.heapsort.Heapsort;
import labtwo.mergesort.MergeSort;

import java.util.Arrays;
import java.util.Comparator;

public class QuicksortDriver {

    private static long timeInitial;
    private static long timeFinal;
    private static long timeElapsed;

    public static void main(String[] args) {

        Comparator maxComp = new Greater();
        int n;
        for (int power = 4; power <= 25; power++) {
            n = (int) Math.pow(2, power);
            int[] qArray = new int[n];
            int[] temp = new int[n];
            for (int i = 0; i < n; i++) {
                qArray[i] = (int) (Math.random() * (n + 1));
            }
            int[] iArray = Arrays.copyOf(qArray, n);
            int[] mArray = Arrays.copyOf(qArray, n);
            int[] hArray = Arrays.copyOf(qArray, n);
            int[] qPArray = Arrays.copyOf(qArray, n);

            System.out.println("Insertion sort iteration " + power + ": ");
            startTimer();
            InsertionSort.insertionSort(iArray);
            stopTimer();

            System.out.println("Merge sort iteration " + power + ": ");
            startTimer();
            MergeSort.mergeSort(mArray, temp, 0, (n - 1));
            stopTimer();

            System.out.println("Maxheapsort iteration " + power + ": ");
            startTimer();
            Heapsort.heapSort(hArray, maxComp);
            stopTimer();

            System.out.println("Quicksort iteration " + power + ": ");
            startTimer();
            Quicksort.quicksort(qArray, 0, (n - 1));
            stopTimer();

            System.out.println("Quicksort w/ partition iteration " + power + ": ");
            startTimer();
            Quicksort.quicksortPartition(qPArray, 0, (n - 1));
            stopTimer();
            System.out.println("---------------------------------------\n");
        }
    }

    /**
     * Gets an arbitrary point in time expressed in nanoseconds.
     */
    private static void startTimer() {
        timeInitial = System.nanoTime();
    }

    /**
     * Gets an arbitrary point in time expressed in nanoseconds then calculates the time elapsed since
     * {@link #startTimer()} was last called.
     */
    private static void stopTimer() {
        timeFinal = System.nanoTime();
        System.out.println("timeInitial: " + timeFinal);
        System.out.println("timeFinal: " + timeFinal);
        timeElapsed = (timeFinal - timeInitial);
        System.out.println("timeElapsed: " + timeElapsed + "\n");
    }
}
