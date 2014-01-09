package labone.insertionsort;

/**
 * Created by Ajay on 1/8/14.
 */
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
            key = (int) (Math.random() * Math.pow(2, power) + 1);
            System.out.println("The key on iteration " + (power - 1) + " is "
                    + key + ".");

            System.out.println(timeInitial = System.currentTimeMillis());
            InsertionSort.linearSearch(array, key);

            System.out.println(timeInitial = System.currentTimeMillis());
            InsertionSort.insertionSort(array);
            InsertionSort.binarySearch(array, key, 0, (n - 1));
            System.out.println();
        }
    }
    protected static long timeInitial;
    protected static long timeFinal;
    protected static long timeElapsed;
    protected static final long MILLI_TO_BASE = 1000;
}
