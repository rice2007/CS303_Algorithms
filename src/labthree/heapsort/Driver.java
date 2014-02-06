package labthree.heapsort;

import labone.insertionsort.InsertionSort;
import labtwo.mergesort.MergeSort;

import java.util.Arrays;
<<<<<<< HEAD
import java.util.Comparator;
import java.util.Scanner;
=======
>>>>>>> origin/master

public class Driver {

    private static long timeInitial;
    private static long timeFinal;
    private static long timeElapsed;

    public static void main(String[] args) {
<<<<<<< HEAD

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter an exponent for the array length.");
        int input = scan.nextInt();
        scan.close();
        Comparator compLesser = new Lesser();
        Comparator compGreater = new Greater();
=======
>>>>>>> origin/master
        int n;
        for (int power = 4; power <= 25; power++) {
            n = (int) Math.pow(2, power);
            int[] hArray = new int[n];
            for (int i = 0; i < n; i++) {
                hArray[i] = (int) (Math.random() * (n + 1));
            }
            int[] iArray = Arrays.copyOf(hArray, n);
            int[] mArray = Arrays.copyOf(hArray, n);
            int[] temp = new int[n];

            System.out.println("Heap Sort iteration " + power + ": " );
            startTimer();
            HeapSort.heapSort(hArray);
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
