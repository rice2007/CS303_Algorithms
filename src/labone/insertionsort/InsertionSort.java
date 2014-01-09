package labone.insertionsort;

public class InsertionSort {
	
	public static int linearSearch(int[] array, int key) {
		boolean foundFlag = false;
        int index = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == key) {
                index = i;
                System.out.println(Driver.timeFinal = System.currentTimeMillis());
                Driver.timeElapsed = (Driver.timeFinal - Driver.timeInitial);
                foundFlag = true;
                System.out.println("Linear search returned key " + key
                        + " at index " + i + " in " + Driver.timeElapsed
                        + " millisecond(s).");
                break;
			}
		}
		if (!foundFlag) {
            System.out.println(Driver.timeFinal = System.currentTimeMillis());
            Driver.timeElapsed = (Driver.timeFinal - Driver.timeInitial);
            System.out.println(Integer.MIN_VALUE);
            System.out.println("Linear search could not find the key. Time" +
                    " elapsed is " + Driver.timeElapsed + " millisecond(s).");
        }
		return index;
	}
	
	public static int binarySearch(int[] array, int key, int min, int max) {
        if (max < min) {
            System.out.println(Driver.timeFinal = System.currentTimeMillis());
            Driver.timeElapsed = (Driver.timeFinal - Driver.timeInitial);
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
                System.out.println(Driver.timeFinal = System.currentTimeMillis());
                Driver.timeElapsed = (Driver.timeFinal - Driver.timeInitial);
                System.out.println("Binary search returned key " + key
                        + " at index " + mid + " in " + Driver.timeElapsed
                        + " millisecond(s).");
                return mid;
            }
        }
	}

    public static int[] insertionSort(int[] array) {
        int key;
        int i;
        for (int j = 1; j < array.length; j++) {
            i = j;
            while(i > 0 && array[i - 1] > array[i]) {
                key = array[i];
                array[i] = array[i - 1];
                array[i - 1] = key;
                i--;
            }
        }
        return array;
    }
    private static final long ZERO = 0;
}