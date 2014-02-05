package labtwo.mergesort;

import java.util.Arrays;
import labone.insertionsort.*;

public class Driver {

    private static long timeInitial;
    private static long timeFinal;
    private static long timeElapsed;
    private static final double ONE_FIFTH = 0.2;
    private static final double ONE_FOURTH = 0.25;
    private static final double ONE_THIRD = 0.33;
    private static final double ONE_HALF = 0.5;

    public static void main(String[] args) {
        int n;
        for (int power = 4; power <= 25; power++) {
            n = (int) Math.pow(2, power);
            int[] iArray = new int[n];
            int[] temp   = new int[n];
            for (int i = 0; i < n; i++) {
                iArray[i] = (int) (Math.random() * (n + 1));
            }
            int[] mArrayFifth = Arrays.copyOf(iArray, n);
            int[] mArrayFourth = Arrays.copyOf(iArray, n);
            int[] mArrayThird = Arrays.copyOf(iArray, n);
            int[] mArrayHalf = Arrays.copyOf(iArray, n);
            int[] mArray = Arrays.copyOf(iArray, n);

            System.out.println("Merge sort iteration " + power + " ");
                        /*
                         * Print statement is commented out. java.util.Arrays has been imported.
                         * System.out.println(Arrays.toString(mArray));
                         */
            startTimer();
            MergeSort.mergeSort(mArray, temp, 0, n - 1);
            stopTimer();
                        /*
                         * Print statement is commented out. java.util.Arrays has been imported.
                         * System.out.println(Arrays.toString(mArray));
                         */

            System.out.println("Merge sort with insertion sort at 1/5 iteration " + power + " ");
                        /*
                         * Print statement is commented out. java.util.Arrays has been imported.
                         * System.out.println(Arrays.toString(mArrayFifth));
                         */
            startTimer();
            MergeSort.mergeInsertionSort(mArrayFifth, temp, 0, n - 1, ONE_FIFTH);
            stopTimer();
                        /*
                         * Print statement is commented out. java.util.Arrays has been imported.
                         * System.out.println(Arrays.toString(mArrayFifth));
                         */

            System.out.println("Merge sort with insertion sort at 1/4 iteration " + power + " ");
                        /*
                         * Print statement is commented out. java.util.Arrays has been imported.
                         * System.out.println(Arrays.toString(mArrayFourth));
                         */
            startTimer();
            MergeSort.mergeInsertionSort(mArrayFourth, temp, 0, n - 1, ONE_FOURTH);
            stopTimer();
                        /*
                         * Print statement is commented out. java.util.Arrays has been imported.
                         * System.out.println(Arrays.toString(mArrayFourth));
                         */

            System.out.println("Merge sort with insertion sort at 1/3 iteration " + power + " ");
                        /*
                         * Print statement is commented out. java.util.Arrays has been imported.
                         * System.out.println(Arrays.toString(mArrayThird));
                         */
            startTimer();
            MergeSort.mergeInsertionSort(mArrayThird, temp, 0, n - 1, ONE_THIRD);
            stopTimer();
                        /*
                         * Print statement is commented out. java.util.Arrays has been imported.
                         * System.out.println(Arrays.toString(mArrayThird));
                         */

            System.out.println("Merge sort with insertion sort at 1/2 iteration " + power + " ");
                        /*
                         * Print statement is commented out. java.util.Arrays has been imported.
                         * System.out.println(Arrays.toString(mArrayHalf));
                         */
            startTimer();
            MergeSort.mergeInsertionSort(mArrayHalf, temp, 0, n - 1, ONE_HALF);
            stopTimer();
                        /*
                         * Print statement is commented out. java.util.Arrays has been imported.
                         * System.out.println(Arrays.toString(mArrayHalf));
                         */

            System.out.println("Insertion sort iteration " + power + " ");
                        /*
                         * Print statement is commented out. java.util.Arrays has been imported.
                         * System.out.println(Arrays.toString(iArray));
                         */
            startTimer();
            InsertionSort.insertionSort(iArray);
            stopTimer();
                        /*
                         * Print statement is commented out. java.util.Arrays has been imported.
                         * System.out.println(Arrays.toString(iArray));
                         */
            System.out.println("---------------------------------------");
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