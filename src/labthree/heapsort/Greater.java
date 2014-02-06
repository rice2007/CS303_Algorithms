package labthree.heapsort;

import java.util.Comparator;

/**
 * Aaron Rice
 * rice2007
 * CS303_Algorithms
 */
public class Greater implements Comparator<Integer> {

    @Override
    public int compare(Integer i, Integer j) {
        return (i >= j)
                ? 1
                : -1;

    }
}
