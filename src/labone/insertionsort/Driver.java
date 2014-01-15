package labone.insertionsort;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static labone.insertionsort.InsertionSort.*;


public class Driver {

    public static void main(String[] args) throws FileNotFoundException {

        int key;
        int n;
        for (int power = 4; power <= 25; power++){
            n = (int) Math.pow(2, power);
            int[] array = new int[n];
            for (int i = 0; i < array.length; i++) {
                array[i] = (int) (Math.random() * n + 1);
            }
            key = (int) (Math.random() * (Math.pow(2, power) + 1));
            System.out.println("The key on iteration " + power + " is "
                    + key + ".");

            startTimer();
            System.out.println("timeInitial: " + timeInitial);
            linearSearch(array, key);
            stopTimer();

            startTimer();
            System.out.println("timeInitial: " + timeInitial);
            insertionSort(array);
            binarySearch(array, key, 0, (n - 1));
            stopTimer();
            System.out.println();
        }

        Scanner scan = new Scanner(new File("keys.csv"));
        scan.useDelimiter(",");
        n = 1000;
        key = (int) (Math.random() * n + 1);
        int[] csvArray = new int[n];
        for (int i = 0; scan.hasNext(); i++) {
            csvArray[i] = Integer.parseInt(scan.next());
        }
        scan.close();

        startTimer();
        System.out.println("timeInitial: " + timeInitial);
        linearSearch(csvArray, key);
        stopTimer();

        startTimer();
        System.out.println("timeInitial: " + timeInitial);
        insertionSort(csvArray);
        binarySearch(csvArray, key, 0, (n - 1));
        stopTimer();
        System.out.println();
    }

    private static void startTimer() {
        timeInitial = System.nanoTime();
    }
    
    private static void stopTimer() {
        timeFinal = System.nanoTime();
        System.out.println("timeFinal: " + timeFinal);
        timeElapsed = (timeFinal - timeInitial);
    }

    protected static long timeInitial;
    protected static long timeFinal;
    protected static long timeElapsed;
}
