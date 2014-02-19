package labfive.linkedlist;

import java.util.HashMap;

public class BucketSort {

    public static void bucketSort(int[] array) {
        int bucketDump = 0;
        HashMap<Integer, Integer> bucket = new HashMap<>();

        for (int i = 0; i < 10; i++) {
            bucket.put(i, 0);
        }
        for (int i = 0; i < array.length; i++) {
            bucket.put(array[i], bucket.get(array[i]) + 1);
        }
        for (int keys = 0; keys < 10; keys++) {
            for (int j = 0; j < bucket.get(keys); j++) {
                array[bucketDump] = keys;
                bucketDump++;
            }
        }

    }
}
