/*
 * Written by someone, improved by g56935 (HE2B-ESI)
 */

package g56935.dev2.td01;

import java.util.Random;

/**
 * Various useful methods for arrays
 */
public class ArrayUtil {

    /**
     * Shuffle the array
     *
     * @param array the array to shuffle
     */
    public static void shuffle(int[] array) {
        int index;
        Random random = new Random();
        for (int i = array.length - 1; i > 0; i--) {
            index = random.nextInt(i + 1);
            swap(array, i, index);
        }
    }

    /**
     * Swap the contents of two array cells. Swap the content of the cells in
     * position <code>pos1</code> and <code>pos2</code>, in the array
     * <code>array</code>. These two positions are assumed to be correct.
     *
     * @param array the array with two cells being swapped
     * @param pos1 the position of the first cell to swap
     * @param pos2 the position of the second cell to swap
     * @throws IllegalArgumentException if at least one of the positions is strictly negative
     */
    public static void swap(int[] array, int pos1, int pos2) {
        if (pos1 < 0 || pos2 < 0) {
            throw new IllegalArgumentException("<error> Positions must be positive integers ! : "
                    + pos1 + " " + pos2+" invalid");
        }
        int savedValue = array[pos1];
        array[pos1] = array[pos2];
        array[pos2] = savedValue;
    }
}
