package labthree.heapsort;

import labone.insertionsort.InsertionSort;
import labtwo.mergesort.MergeSort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Driver {

    private static long timeInitial;
    private static long timeFinal;
    private static long timeElapsed;

    public static void main(String[] args) {

        Comparator minComp = new Lesser();
        Comparator maxComp = new Greater();
        int n;
        for (int power = 4; power <= 5; power++) {
            n = (int) Math.pow(2, power);
            int[] maxArray = new int[n];
            for (int i = 0; i < n; i++) {
                maxArray[i] = (int) (Math.random() * (n + 1));
            }
            int[] iArray = Arrays.copyOf(maxArray, n);
            int[] mArray = Arrays.copyOf(maxArray, n);
            int[] minArray = Arrays.copyOf(maxArray, n);
            int[] temp = new int[n];

            System.out.println("MaxHeap Sort iteration " + power + ": " );
            startTimer();
            HeapSort.heapSort(maxArray, maxComp);
            stopTimer();

            System.out.println("MinHeap Sort iteration " + power + ": " );
            startTimer();
            HeapSort.heapSort(minArray, minComp);
            stopTimer();

            System.out.println("Insertion Sort iteration " + power + ": " );
            startTimer();
            InsertionSort.insertionSort(iArray);
            stopTimer();

            System.out.println("Merge Sort iteration " + power + ": " );
            startTimer();
            MergeSort.mergeSort(mArray, temp, 0, n - 1);
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
