/*
 * Written by g56935 for HE2B-ESI (2021)
 */
package g56935.luckynumbers.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author g56935
 */
public class TileTest {
    
    public TileTest() {
    }

    /**
     * Test of getValue method, of class Tile.
     */
    @Test
    public void testGetValue() {
        Tile instance = new Tile(7);
        int expResult = 7;
        int result = instance.getValue();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of faceUp method, of class Tile.
     */
    @Test
    public void testFaceUp() {
        Tile instance = new Tile(7);
        assertEquals(instance.isFaceUp(), false);
    }
    
    @Test
    public void testFaceUpTrue() {
        Tile instance = new Tile(7);
        instance.flipFaceUp();
        assertEquals(instance.isFaceUp(), true);
    }

    /**
     * Test of flipFaceUp method, of class Tile.
     */
    @Test
    public void testFlipFaceUp() {
        Tile instance = new Tile(7);
        instance.flipFaceUp();
        assertEquals(instance.isFaceUp(), true);
    }
    
    @Test
    public void testFlipFaceUpThreeTimes() {
        Tile instance = new Tile(7);
        instance.flipFaceUp();
        instance.flipFaceUp();
        instance.flipFaceUp();
        assertEquals(instance.isFaceUp(), true);
    }   
}
