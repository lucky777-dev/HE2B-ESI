/*
 * Written by g56935 for HE2B-ESI (2021)
 */
package g56935.luckynumbers.model;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author g56935
 */
public class DeckTest {
    
    public DeckTest() {
    }

    /**
     * Test of faceDownCount method, of class Deck.
     */
    @Test
    public void testFaceDownCount() {
        Deck instance = new Deck(2);
        int expResult = 40;
        int result = instance.faceDownCount();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testFaceDownCount3Players() {
        Deck instance = new Deck(3);
        int expResult = 60;
        int result = instance.faceDownCount();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testFaceDownCount4Players() {
        Deck instance = new Deck(4);
        int expResult = 80;
        int result = instance.faceDownCount();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testFaceDownCount1Picked() {
        Deck instance = new Deck(2);
        instance.pickFaceDown();
        int expResult = 39;
        int result = instance.faceDownCount();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testFaceDownCount2Picked() {
        Deck instance = new Deck(2);
        instance.pickFaceDown();
        instance.pickFaceDown();
        int expResult = 38;
        int result = instance.faceDownCount();
        assertEquals(expResult, result);
    }

    /**
     * Test of faceUpCount method, of class Deck.
     */
    @Test
    public void testFaceUpCount() {
        Deck instance = new Deck(2);
        int expResult = 0;
        int result = instance.faceUpCount();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testFaceUpCount1PutBack() {
        Deck instance = new Deck(2);
        instance.putBack(instance.pickFaceDown());
        int expResult = 1;
        int result = instance.faceUpCount();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testFaceUpCount2PutBack() {
        Deck instance = new Deck(2);
        instance.putBack(instance.pickFaceDown());
        instance.putBack(instance.pickFaceDown());
        int expResult = 2;
        int result = instance.faceUpCount();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAllFaceUp method, of class Deck.
     */
    @Test
    public void testGetAllFaceUp() {
        Deck instance = new Deck(2);
        Tile tile = instance.pickFaceDown();
        ArrayList<Tile> test = new ArrayList<>();
        test.add(tile);
        instance.putBack(tile);
        assertEquals(test.get(0), instance.getAllFaceUp().get(0));
    }
    
    @Test
    public void testHasFaceUpTrue() {
        Deck instance = new Deck(2);
        instance.putBack(instance.pickFaceDown());
        assertEquals(true, instance.hasFaceUp(instance.getAllFaceUp().get(0)));
    }
    
    @Test
    public void testHasFaceUpTrueIfJustPicked() {
        Deck instance = new Deck(2);
        assertEquals(true, instance.pickFaceDown().isFaceUp());
    }

    /**
     * Test of putBack method, of class Deck.
     */
    @Test
    public void testPutBack() {
        Deck instance = new Deck(2);
        Tile tile = instance.pickFaceDown();
        instance.putBack(tile);
        assertEquals(tile, instance.getAllFaceUp().get(0));
    }
    
}
