/*
 * Written by g56935 (HE2B-ESI)
 */
package g56935.dev2.td01;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author g56935
 */
public class ArrayUtilTest {

    public ArrayUtilTest() {
    }

    @Test
    public void testSwapGeneralCase() {
        //Arrange
        int[] array = {10, 11, 12};
        int pos1 = 0;
        int pos2 = 1;
        //Action
        ArrayUtil.swap(array, pos1, pos2);
        //Assert
        int[] expected = {11, 10, 12};
        assertArrayEquals(expected, array);
    }

    @Test
    public void testSwapOutsideArrayNegative() {
        int[] array = {10, 11, 12};
        int pos1 = -1;
        int pos2 = 0;
        assertThrows(IllegalArgumentException.class, () -> {
            ArrayUtil.swap(array, pos1, pos2);
        });
    }


    /*
    @Test
    public void testShuffle() {
        System.out.println("shuffle");
        int[] array = null;
        ArrayUtil.shuffle(array);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testSwap() {
        System.out.println("swap");
        int[] array = null;
        int pos1 = 0;
        int pos2 = 0;
        ArrayUtil.swap(array, pos1, pos2);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
     */
}
