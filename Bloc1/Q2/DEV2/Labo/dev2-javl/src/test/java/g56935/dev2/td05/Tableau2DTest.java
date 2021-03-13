/*
 * Written by g56935 (HE2B-ESI)
 */
package g56935.dev2.td05;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author g56935 <g56935@etu.he2b.be>
 */
public class Tableau2DTest {
    
    public Tableau2DTest() {
    }

    /**
     * Test of displayTab2D method, of class Tableau2D.
     */
    @Test
    public void testDisplayTab2DError() {
        System.out.println("displayTab2D");
        int[][] tab = null;
        assertThrows(IllegalArgumentException.class, () -> {
            Tableau2D.displayTab2D(tab);
        });
    }
    
    /**
     * Test of proportionNuls method, of class Tableau2D.
     */
    @Test
    public void testProportionNuls() {
        System.out.println("proportionNuls");
        int[][] tab = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        double expResult = 0;
        double result = Tableau2D.proportionNuls(tab);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testProportionNuls4on9() {
        System.out.println("proportionNuls");
        int[][] tab = {{1, 0, 0}, {4, 5, 0}, {0, 8, 9}};
        double expResult = ((double)4/9)*100;
        double result = Tableau2D.proportionNuls(tab);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testProportionNulsAll() {
        System.out.println("proportionNuls");
        int[][] tab = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        double expResult = 100;
        double result = Tableau2D.proportionNuls(tab);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testProportionNulsError() {
        System.out.println("proportionNuls");
        int[][] tab = null;
        assertThrows(IllegalArgumentException.class, () -> {
            Tableau2D.proportionNuls(tab);
        });
    }

    /**
     * Test of onlyPositive method, of class Tableau2D.
     */
    @Test
    public void testOnlyPositive() {
        System.out.println("onlyPositive");
        int[][] tab = {{1, 2 , 3}, {4, 5, 6}, {7, 8, 9}};
        boolean expResult = true;
        boolean result = Tableau2D.onlyPositive(tab);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testOnlyPositiveFalse() {
        System.out.println("onlyPositive");
        int[][] tab = {{1, 2 , 3}, {-4, 5, 6}, {7, 8, 9}};
        boolean expResult = false;
        boolean result = Tableau2D.onlyPositive(tab);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testOnlyPositiveError() {
        System.out.println("onlyPositive");
        int[][] tab = null;
        assertThrows(IllegalArgumentException.class, () -> {
            Tableau2D.onlyPositive(tab);
        });
    }
}
