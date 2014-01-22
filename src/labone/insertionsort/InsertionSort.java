package labone.insertionsort;

public class InsertionSort {

    /**
     * Searches an array using the brute-force method of linear search
     *
     * @param array the array to be searched.
     * @param key the value linear search will find.
     */
    public static void linearSearch(int[] array, int key) {
        boolean foundFlag = false;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == key) {
                foundFlag = true;
                System.out.println("Linear search returned key " + key
                        + " at index " + i + " in " + Driver.timeElapsed
                        + " millisecond(s).");
                break;
            }
        }
        if (!foundFlag) {
            System.out.println(Integer.MIN_VALUE);
            System.out.println("Linear search could not find the key. Time" +
                    " elapsed is " + Driver.timeElapsed + " millisecond(s).");
        }
    }

    /**
     * Searches an array using the divide-and-conquer method of binary search
     *
     * @param array the array to be searched.
     * @param key the value to be searched.
     * @param min the lower bound of the array to be searched
     * @param max the upper bound of the array to be searched
     * @return the key if found. If the key is not found, returns Integer.MIN_VALUE.
     */
    public static int binarySearch(int[] array, int key, int min, int max) {
        if (max < min) {
            System.out.println(Integer.MIN_VALUE + "\nBinary search could not "
                    + "find the key. Time elapsed is " + Driver.timeElapsed
                    + " millisecond(s).");
            return Integer.MIN_VALUE;
        }
        else {
            int mid = (min + (max - min) / 2);
            if (array[mid] > key) {
                return binarySearch(array, key, min, (mid - 1));
            } else if (array[mid] < key ) {
                return binarySearch(array, key, (mid + 1), max);
            } else {
                System.out.println("Binary search returned key " + key
                        + " at index " + mid + " in " + Driver.timeElapsed
                        + " millisecond(s).");
                return mid;
            }
        }
    }

    /**
     * Sorts an array using the insertion sort algorithm.
     *
     * @param array the array to be sorted.
     */
    public static void insertionSort(int[] array) {
        int key;
        int i;
        for (int j = 1; j < array.length; j++) {
            key = array[j];
            i = j - 1;
            while((i >= 0) && (array[i] > key)) {
                array[i + 1] = array[i];
                i--;
            }
            array[i + 1] = key;
        }
    }

    /**
     * Sorts an array using the insertion sort algorithm.
     *
     * @param array the array to be sorted.
     * @param low the lower bound of the array to be searched.
     * @param high the upper bound of the array to be searched.
     */
    public static void insertionSort(int[] array, int low, int high) {
        int key;
        int i;
        for (int j = low + 1; j <= high; j++) {
            key = array[j];
            i = j - 1;
            while((i >= low) && (array[i] > key)) {
                array[i + 1] = array[i];
                i--;
            }
            array[i + 1] = key;
        }
    }
}