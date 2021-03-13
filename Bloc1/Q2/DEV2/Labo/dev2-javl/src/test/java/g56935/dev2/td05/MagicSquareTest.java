/*
 * Written by g56935 (HE2B-ESI)
 */
package g56935.dev2.td05;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author g56935
 */
public class MagicSquareTest {
    
    public MagicSquareTest() {
    }

    /**
     * Test of toString method, of class MagicSquare.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        MagicSquare instance = new MagicSquare();
        String expResult = "    4    9    2\n    3    5    7\n    8    1    6\n";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of getNumber method, of class MagicSquare.
     */
    @Test
    public void testGetNumber() {
        System.out.println("getNumber");
        int ln = 2;
        int col = 3;
        MagicSquare instance = new MagicSquare(5);
        int expResult = 20;
        int result = instance.getNumber(ln, col);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetNumberError() {
        System.out.println("getNumber");
        int ln = 21;  // IndexOutOfBoundsException
        int col = 3;
        MagicSquare instance = new MagicSquare(5);
        assertThrows(IllegalArgumentException.class, () -> {
            instance.getNumber(ln, col);
        });
    }
}
