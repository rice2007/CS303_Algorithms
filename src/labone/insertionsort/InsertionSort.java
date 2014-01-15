package labone.insertionsort;

public class InsertionSort {
        
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
        ;
        System.out.println(Integer.MIN_VALUE);
        System.out.println("Linear search could not find the key. Time" +
                " elapsed is " + Driver.timeElapsed + " millisecond(s).");
            }
    }

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
}
