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
public class MemoryTest {

    public MemoryTest() {
    }

    @Test
    public void testInitCardsGeneral() {
        System.out.println("initCards General");
        int n = 4;
        int[] result = Memory.initCards(n);
        int[] expected = {1, 1, 2, 2, 3, 3, 4, 4};
        assertArrayEquals(expected, result);

    }

    @Test
    public void testInitCardsMinimum() {
        System.out.println("initCards Minimum");
        int n = 3;
        int[] result = Memory.initCards(n);
        int[] expected = {1, 1, 2, 2, 3, 3};
        assertArrayEquals(expected, result);

    }

    @Test
    public void testInitCardsMaximum() {
        System.out.println("initCards Maximum");
        int n = 20;
        int[] result = Memory.initCards(n);
        int[] expected = {1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9, 10, 10, 11, 11, 12, 12, 13, 13, 14, 14, 15, 15, 16, 16, 17, 17, 18, 18, 19, 19, 20, 20};
        assertArrayEquals(expected, result);

    }

    @Test
    public void testInitCardsTooLow() {
        System.out.println("initCards Too Low");
        int n = 2;
        assertThrows(IllegalArgumentException.class, () -> {
            Memory.initCards(n);
        });
    }

    @Test
    public void testInitCardsTooHigh() {
        System.out.println("initCards Too High");
        int n = 21;
        assertThrows(IllegalArgumentException.class, () -> {
            Memory.initCards(n);
        });
    }
}
