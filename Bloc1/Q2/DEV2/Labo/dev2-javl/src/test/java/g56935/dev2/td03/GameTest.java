/*
 * Written by g56935 (HE2B-ESI)
 */
package g56935.dev2.td03;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author g56935
 */
public class GameTest {
    
    public GameTest() {
    }

    /**
     * Test of reveal method, of class Game.
     */
    @Test
    public void testReveal() {
        System.out.println("reveal");
        int pos = 0;
        Game instance = new Game(3);
        instance.reveal(pos);
        assertEquals(instance.isCardHidden(0), false);
    }

    /**
     * Test of getSize method, of class Game.
     */
    @Test
    public void testGetSize() {
        System.out.println("getSize");
        Game instance = new Game(3);
        int expResult = 6;
        int result = instance.getSize();
        assertEquals(expResult, result);
    }

    /**
     * Test of isCardHidden method, of class Game.
     */
    @Test
    public void testIsCardHiddenTrue() {
        System.out.println("isCardHidden");
        int pos = 0;
        Game instance = new Game(3);
        boolean expResult = true;
        boolean result = instance.isCardHidden(pos);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testIsCardHiddenFalse() {
        System.out.println("isCardHidden");
        int pos = 0;
        Game instance = new Game(3);
        instance.reveal(pos);
        boolean expResult = false;
        boolean result = instance.isCardHidden(pos);
        assertEquals(expResult, result);
    }

    /**
     * Test of getCardValue method, of class Game.
     */
    @Test
    public void testGetCardValue() {
        System.out.println("getCardValue");
        int pos = 0;
        Game instance = new Game(3);
        int expResult = 1;
        int result = instance.getCardValue(pos);
        assertEquals(expResult, result);
    }

    /**
     * Test of checkPosition method, of class Game.
     */
    @Test
    public void testCheckPositionError() {
        System.out.println("checkPosition");
        int pos1 = 0;
        int pos2 = 0;
        Game instance = new Game(3);
        assertThrows(IllegalArgumentException.class, () -> {
            instance.checkPosition(pos1, pos2);
        });
    }

    /**
     * Test of isGameOver method, of class Game.
     */
    @Test
    public void testIsGameOverFalse() {
        System.out.println("isGameOver");
        Game instance = new Game(3);
        boolean expResult = false;
        boolean result = instance.isGameOver();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testIsGameOverFalseOneMissing() {
        System.out.println("isGameOver");
        Game instance = new Game(3);
        instance.reveal(0);
        instance.reveal(1);
        instance.reveal(2);
        instance.reveal(3);
        instance.reveal(4);
        boolean expResult = false;
        boolean result = instance.isGameOver();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testIsGameOverTrue() {
        System.out.println("isGameOver");
        Game instance = new Game(3);
        instance.reveal(0);
        instance.reveal(1);
        instance.reveal(2);
        instance.reveal(3);
        instance.reveal(4);
        instance.reveal(5);
        boolean expResult = true;
        boolean result = instance.isGameOver();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Game.
     */
    @Test
    public void testToStringAllHidden() {
        System.out.println("toString");
        Game instance = new Game(3);
        String expResult = "? ? ? ? ? ? ";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testToStringHalfHidden() {
        System.out.println("toString");
        Game instance = new Game(3);
        instance.reveal(0);
        instance.reveal(2);
        instance.reveal(4);
        String expResult = "1 ? 2 ? 3 ? ";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testToStringNoHidden() {
        System.out.println("toString");
        Game instance = new Game(3);
        instance.reveal(0);
        instance.reveal(1);
        instance.reveal(2);
        instance.reveal(3);
        instance.reveal(4);
        instance.reveal(5);
        String expResult = "1 1 2 2 3 3 ";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class Game.
     */
    @Test
    public void testEqualsTrue() {
        System.out.println("equals");
        Object object = new Game(3);
        Game instance = new Game(3);
        boolean expResult = true;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testEqualsTrueSameObject() {
        System.out.println("equals");
        Game instance = new Game(3);
        Object object = instance;
        boolean expResult = true;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testEqualsFalseDifferentSize() {
        System.out.println("equals");
        Object object = new Game(4);
        Game instance = new Game(3);
        boolean expResult = true;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testEqualsFalseDifferentHiddenValues() {
        System.out.println("equals");
        Object object = new Game(3);
        Game instance = new Game(3);
        instance.reveal(0);
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
    }

    /**
     * Test of hashCode method, of class Game.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Game instance = new Game(3);
        int expResult = instance.hashCode();
        int result = instance.hashCode();
        assertEquals(expResult, result);
    }
    
}