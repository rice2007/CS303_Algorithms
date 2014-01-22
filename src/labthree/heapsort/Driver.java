package labthree.heapsort;

import java.util.Arrays;
import java.util.Scanner;

public class Driver {

    private static long timeInitial;
    private static long timeFinal;
    private static long timeElapsed;

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter an exponent for the array length.");
        int input = scan.nextInt();
        scan.close();
        int n;
        for (int power = 4; power <= input; power++) {
            n = (int) Math.pow(2, power);
            int[] hArray = new int[n];
            for (int i = 0; i < n; i++) {
                hArray[i] = (int) (Math.random() * (n + 1));
            }
            int[] iArray = Arrays.copyOf(hArray, n);
            int[] mArray = Arrays.copyOf(hArray, n);

            System.out.print("Unsorted: " + Arrays.toString(hArray) + "\nMax-Heap order: ");
            startTimer();
            HeapSort.heapSort(hArray);
            stopTimer();
            System.out.println("Sorted: " + Arrays.toString(hArray) + "\n");
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
        System.out.println("timeElapsed: " + timeElapsed);
    }
}
