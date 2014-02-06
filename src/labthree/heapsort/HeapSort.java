package labthree.heapsort;

import java.util.Comparator;

/**
 * Created by Ajay on 1/22/14.
 */
public class HeapSort implements Comparator<Integer> {

    private static int largest;
    private static int heapSize;
    private static int left;
    private static int right;

    public static void heapSort(int[] array) {
        buildMaxHeap(array);
        int temp;
        for (int i = array.length - 1; i >= 0; i--) {
            temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            heapSize--;
            maxHeapify(array, 0);
            if (i > 0) {
                System.out.print(array[i] + ", ");
            } else {
                System.out.println(array[i]);
            }
        }
    }

    private static void buildMaxHeap(int[] array) {
        heapSize = array.length;
        for (int i = (int) Math.floor((array.length) / 2) - 1; i >= 0; i--) {
            maxHeapify(array, i);
        }
    }

    private static void maxHeapify(int[] array, int i) {
        left = getLeft(i);
        right = getRight(i);
        largest = ((left <= heapSize - 1) && (array[left] > array[i]))
                ? left
                : i;
        if ((right <= heapSize - 1) && (array[right] > array[largest])) {
            largest = right;
        }
        if (largest != i) {
            int temp = array[i];
            array[i] = array[largest];
            array[largest] = temp;
            maxHeapify(array, largest);
        }
    }

    private static int getLeft(int i) {
        return (i * 2);
    }

    private static int getRight(int i) {
        return (i * 2 + 1);
    }

    private static int getPartent(int i) {
        return (int) Math.floor((i / 2)) - 1;
    }

    /**
     * Compares its two arguments for order.  Returns a negative integer,
     * zero, or a positive integer as the first argument is less than, equal
     * to, or greater than the second.<p>
     * <p/>
     * In the foregoing description, the notation
     * <tt>sgn(</tt><i>expression</i><tt>)</tt> designates the mathematical
     * <i>signum</i> function, which is defined to return one of <tt>-1</tt>,
     * <tt>0</tt>, or <tt>1</tt> according to whether the value of
     * <i>expression</i> is negative, zero or positive.<p>
     * <p/>
     * The implementor must ensure that <tt>sgn(compare(x, y)) ==
     * -sgn(compare(y, x))</tt> for all <tt>x</tt> and <tt>y</tt>.  (This
     * implies that <tt>compare(x, y)</tt> must throw an exception if and only
     * if <tt>compare(y, x)</tt> throws an exception.)<p>
     * <p/>
     * The implementor must also ensure that the relation is transitive:
     * <tt>((compare(x, y)&gt;0) &amp;&amp; (compare(y, z)&gt;0))</tt> implies
     * <tt>compare(x, z)&gt;0</tt>.<p>
     * <p/>
     * Finally, the implementor must ensure that <tt>compare(x, y)==0</tt>
     * implies that <tt>sgn(compare(x, z))==sgn(compare(y, z))</tt> for all
     * <tt>z</tt>.<p>
     * <p/>
     * It is generally the case, but <i>not</i> strictly required that
     * <tt>(compare(x, y)==0) == (x.equals(y))</tt>.  Generally speaking,
     * any comparator that violates this condition should clearly indicate
     * this fact.  The recommended language is "Note: this comparator
     * imposes orderings that are inconsistent with equals."
     *
     * @param o1 the first object to be compared.
     * @param o2 the second object to be compared.
     * @return a negative integer, zero, or a positive integer as the
     * first argument is less than, equal to, or greater than the
     * second.
     * @throws NullPointerException if an argument is null and this
     *                              comparator does not permit null arguments
     * @throws ClassCastException   if the arguments' types prevent them from
     *                              being compared by this comparator.
     */
    @Override
    public int compare(Integer o1, Integer o2) {
        return 0;
    }
}
