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
public class BoardTest {
    
    public BoardTest() {
    }

    /**
     * Test of getSize method, of class Board.
     */
    @Test
    public void testGetSize() {
        Board instance = new Board();
        int expResult = 4;
        int result = instance.getSize();
        assertEquals(expResult, result);
    }

    /**
     * Test of isInside method, of class Board.
     */
    @Test
    public void testIsInside() {
        Position position = new Position(0, 3);
        Board instance = new Board();
        boolean expResult = true;
        boolean result = instance.isInside(position);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testIsInsideFalse() {
        Position position = new Position(0, 4);
        Board instance = new Board();
        boolean expResult = false;
        boolean result = instance.isInside(position);
        assertEquals(expResult, result);
    }

    /**
     * Test of getTile method, of class Board.
     */
    @Test
    public void testGetTile() {
        Position position = new Position(0, 0);
        Board instance = new Board();
        Tile expResult = new Tile(7);
        instance.put(expResult, position);
        Tile result = instance.getTile(position);
        assertEquals(expResult, result);
    }

    /**
     * Test of canBePut method, of class Board.
     */
    @Test
    public void testCanBePut() {
        Tile tile = new Tile(7);
        Position position = new Position(1, 2);
        Board instance = new Board();
        boolean expResult = true;
        boolean result = instance.canBePut(tile, position);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testCanBePutTrueLeft() {
        Tile tile = new Tile(7);
        Position position = new Position(1, 2);
        Board instance = new Board();
        instance.put(new Tile(8), new Position(3, 2));
        boolean expResult = true;
        boolean result = instance.canBePut(tile, position);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testCanBePutTrueRight() {
        Tile tile = new Tile(7);
        Position position = new Position(1, 2);
        Board instance = new Board();
        instance.put(new Tile(6), new Position(0, 2));
        boolean expResult = true;
        boolean result = instance.canBePut(tile, position);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testCanBePutTrueAbove() {
        Tile tile = new Tile(7);
        Position position = new Position(1, 2);
        Board instance = new Board();
        instance.put(new Tile(9), new Position(1, 3));
        boolean expResult = true;
        boolean result = instance.canBePut(tile, position);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testCanBePutTrueBelow() {
        Tile tile = new Tile(7);
        Position position = new Position(1, 2);
        Board instance = new Board();
        instance.put(new Tile(1), new Position(1, 1));
        boolean expResult = true;
        boolean result = instance.canBePut(tile, position);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testCanBePutFalseLeft() {
        Tile tile = new Tile(7);
        Position position = new Position(1, 2);
        Board instance = new Board();
        instance.put(new Tile(7), new Position(2, 2));
        boolean expResult = false;
        boolean result = instance.canBePut(tile, position);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testCanBePutFalseRight() {
        Tile tile = new Tile(7);
        Position position = new Position(1, 2);
        Board instance = new Board();
        instance.put(new Tile(8), new Position(0, 2));
        boolean expResult = false;
        boolean result = instance.canBePut(tile, position);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testCanBePutFalseAbove() {
        Tile tile = new Tile(7);
        Position position = new Position(1, 2);
        Board instance = new Board();
        instance.put(new Tile(7), new Position(1, 3));
        boolean expResult = false;
        boolean result = instance.canBePut(tile, position);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testCanBePutFalseBelow() {
        Tile tile = new Tile(7);
        Position position = new Position(1, 2);
        Board instance = new Board();
        instance.put(new Tile(9), new Position(1, 0));
        boolean expResult = false;
        boolean result = instance.canBePut(tile, position);
        assertEquals(expResult, result);
    }

    /**
     * Test of isFull method, of class Board.
     */
    @Test
    public void testIsFull() {
        Board instance = new Board();
        for(int i=0;i<4;i++) {
            for (int j = 0; j <4; j++) {
                instance.put(new Tile(7), new Position(i, j));
            }
        }
        boolean expResult = true;
        boolean result = instance.isFull();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testIsFullFalse() {
        Board instance = new Board();
        for(int i=0;i<4;i++) {
            for (int j = 0; j <3; j++) { // Last column is null
                instance.put(new Tile(7), new Position(i, j));
            }
        }
        boolean expResult = false;
        boolean result = instance.isFull();
        assertEquals(expResult, result);
    }
    
}
