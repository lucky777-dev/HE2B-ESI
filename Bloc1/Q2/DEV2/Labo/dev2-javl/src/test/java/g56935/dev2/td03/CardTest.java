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
public class CardTest {
    
    public CardTest() {
    }

    /**
     * Test of reveal method, of class Card.
     */
    @Test
    public void testReveal() {
        System.out.println("reveal");
        Card instance = new Card(1);
        String expResult = "1";
        instance.reveal();
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Card.
     */
    @Test
    public void testToStringUnrevealed() {
        System.out.println("toString");
        Card instance = new Card(1);
        String expResult = "?";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    @Test
    public void testToStringRevealed() {
        System.out.println("toString");
        Card instance = new Card(1);
        instance.reveal();
        String expResult = "1";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class Card.
     */
    @Test
    public void testEqualsNormalTrue() {
        System.out.println("equals");
        Object object = new Card(1);
        Card instance = new Card(1);
        boolean expResult = true;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testEqualsSameObjectTrue() {
        System.out.println("equals");
        Card instance = new Card(1);
        boolean expResult = true;
        boolean result = instance.equals(instance);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testEqualsValueFalse() {
        System.out.println("equals");
        Object object = new Card(1);
        Card instance = new Card(2);
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testEqualsHiddenFalse() {
        System.out.println("equals");
        Object object = new Card(1);
        Card instance = new Card(1);
        instance.reveal();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testEqualsObjectNull() {
        System.out.println("equals");
        Object object = null;
        Card instance = new Card(1);
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
    }

    /**
     * Test of hashCode method, of class Card.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Card instance = new Card(1);
        int expResult = instance.hashCode();
        int result = instance.hashCode();
        assertEquals(expResult, result);
    }
    
}