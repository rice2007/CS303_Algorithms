package labtwo.mergesort;

import java.util.Arrays;
import labone.insertionsort.*;

public class Driver {

	public static void main(String[] args) {
		
		int n;
		for (int power = 4; power <= 25; power++){
			n = (int) Math.pow(2, power);
			int[] iArray = new int[n];
			int[] mArray = new int[n];
			int[] temp   = new int[n];
			for (int i = 0; i < n; i++) {
				iArray[i] = (int) (Math.random() * (n + 1));
				mArray[i] = iArray[i];
			}
			
			System.out.println("Merge sort iteration " + power + " ");
			/*
			 * Print statement is commented out. java.util.Arrays has been imported.
			 * System.out.println(Arrays.toString(iArray));
			 */
			startTimer();
			MergeSort.mergeSort(iArray, temp, 0, n - 1);
			stopTimer();
			/*
			 * Print statement is commented out. java.util.Arrays has been imported.
			 * System.out.println(Arrays.toString(iArray));
			 */
			
			System.out.println("Insertion sort iteration " + power + " ");
			/*
			 * Print statement is commented out. java.util.Arrays has been imported.
			 * System.out.println(Arrays.toString(mArray));
			 */
			startTimer();
			InsertionSort.insertionSort(mArray);
			stopTimer();
			/*
			 * Print statement is commented out. java.util.Arrays has been imported.
			 * System.out.println(Arrays.toString(mArray));
			 */
		}
	}
	
    private static void startTimer() {
        timeInitial = System.nanoTime();
    }
    
    private static void stopTimer() {
        timeFinal = System.nanoTime();
        System.out.println("timeInital: " + timeFinal);
        System.out.println("timeFinal: " + timeFinal);
        timeElapsed = (timeFinal - timeInitial);
        System.out.println("timeElapsed: " + timeElapsed + "\n");
    }

    protected static long timeInitial;
    protected static long timeFinal;
    protected static long timeElapsed;
}
