/*
 * Written by g56935 (HE2B-ESI)
 */
package g56935.dev2.td04;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author g56935
 */
public class NombresTest {
    
    public NombresTest() {
    }

    /**
     * Test of add method, of class Nombres.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        int val = 7;
        Nombres instance = new Nombres();
        instance.add(val);
        int expResult = 7;
        int result = instance.getNombre(0);
        assertEquals(expResult, result);
    }

    /**
     * Test of remove method, of class Nombres.
     */
    @Test
    public void testRemove() {
        System.out.println("remove");
        Nombres instance = new Nombres();
        instance.add(7);
        instance.add(14);
        instance.add(21);
        instance.remove(1);
        String expResult = "7 21 ";
        assertEquals(expResult, instance.toString());
    }
    
    @Test
    public void testRemoveError() {
        System.out.println("remove");
        Nombres instance = new Nombres();
        instance.add(7);
        assertThrows(IllegalArgumentException.class, () -> {
            instance.remove(2);
        });
    }

    /**
     * Test of sum method, of class Nombres.
     */
    @Test
    public void testSum() {
        System.out.println("sum");
        Nombres instance = new Nombres();
        instance.add(19);
        instance.add(3);
        instance.add(14);
        instance.add(6);
        int expResult = 42;
        int result = instance.sum();
        assertEquals(expResult, result);
    }

    /**
     * Test of getNombres method, of class Nombres.
     */
    @Test
    public void testGetNombres() {
        System.out.println("getNombres");
        Nombres instance = new Nombres();
        ArrayList<Integer> expResult = new ArrayList<>();
        instance.add(7);
        instance.add(14);
        expResult.add(7);
        expResult.add(14);
        ArrayList<Integer> result = instance.getNombres();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Nombres.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Nombres instance = new Nombres();
        instance.add(7);
        instance.add(14);
        instance.add(21);
        String expResult = "7 14 21 ";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of getNombre method, of class Nombres.
     */
    @Test
    public void testGetNombre() {
        System.out.println("getNombre");
        Nombres instance = new Nombres();
        instance.add(7);
        instance.add(14);
        instance.add(21);
        int expResult = 14;
        int result = instance.getNombre(1);
        assertEquals(expResult, result);
    }

    /**
     * Test of concatenation method, of class Nombres.
     */
    @Test
    public void testConcatenation() {
        System.out.println("concatenation");
        ArrayList<Integer> list = new ArrayList<>();
        list.add(7);
        list.add(21);
        list.add(14);
        Nombres instance = new Nombres();
        instance.concatenation(list);
        String expResult = "7 21 14 ";
        assertEquals(expResult, instance.toString());
    }

    /**
     * Test of delExtremes method, of class Nombres.
     */
    @Test
    public void testDelExtremes() {
        System.out.println("delExtremes");
        Nombres instance = new Nombres();
        instance.add(42);
        instance.add(14);
        instance.add(777);
        instance.add(21);
        instance.add(7);
        instance.add(77);
        instance.delExtremes();
        String expResult = "42 14 21 77 ";
        assertEquals(expResult, instance.toString());
    }
    
}