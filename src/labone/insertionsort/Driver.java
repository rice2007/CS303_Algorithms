package labone.insertionsort;

public class Driver {

    public static void main(String[] args) {
        int n;
        int key;
        for (int power = 1; power < 26; power++){
            n = (int) Math.pow(2, power);
            int[] array = new int[n];
            for (int i = 0; i < array.length; i++) {
                array[i] = (int) (Math.random() * n + 1);
            }
            key = (int) (Math.random() * (Math.pow(2, power) + 1));
            System.out.println("The key on iteration " + power + " is "
                    + key + ".");

            InsertionSort.insertionSort(array);

            timeInitial = System.currentTimeMillis();
            System.out.println("timeInitial: " + timeInitial);
            InsertionSort.linearSearch(array, key);

            timeInitial = System.currentTimeMillis();
            System.out.println("timeInitial: " + timeInitial);
            InsertionSort.binarySearch(array, key, 0, (n - 1));
            System.out.println();
        }
        n = 1000;
        int[] unsorted = new int[n];
        for (int i = n - 1; i <= 0; i--) {
            unsorted[n] = i;
        }
        key = (int) (Math.random() * (n +1));
        InsertionSort.linearSearch(unsorted, key);
        InsertionSort.binarySearch(unsorted, key, 0, (n-1));
    }
    static long timeInitial;
    static long timeFinal;
    static long timeElapsed;
    protected static final long MILLI_TO_BASE = 1000;
}
