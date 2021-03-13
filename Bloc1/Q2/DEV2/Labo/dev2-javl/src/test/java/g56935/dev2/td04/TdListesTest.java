/*
 * Written by g56935 (HE2B-ESI)
 */
package g56935.dev2.td04;

import g56935.dev2.td02.Moment;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author g56935 <g56935@etu.he2b.be>
 */
public class TdListesTest {
    
    public TdListesTest() {
    }

    /**
     * Test of sum method, of class TdListes.
     */
    @Test
    public void testSum() {
        System.out.println("sum");
        ArrayList<Integer> list = new ArrayList<>();
        list.add(19);
        list.add(3);
        list.add(14);
        list.add(6);
        int expResult = 42;
        int result = TdListes.sum(list);
        assertEquals(expResult, result);
    }

    /**
     * Test of concatenation method, of class TdListes.
     */
    @Test
    public void testConcatenation() {
        System.out.println("concatenation");
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        list1.add(7);
        list1.add(21);
        list1.add(77);
        list2.add(14);
        list2.add(21);
        list2.add(42);
        TdListes.concatenation(list1, list2);
        assertEquals("[7, 21, 77, 14, 21, 42]", list1.toString());
    }

    /**
     * Test of delExtremes method, of class TdListes.
     */
    @Test
    public void testDelExtremes() {
        System.out.println("delExtremes");
        ArrayList<Integer> list = new ArrayList<>();
        list.add(42);
        list.add(14);
        list.add(777);
        list.add(21);
        list.add(7);
        list.add(77);
        TdListes.delExtremes(list);
        assertEquals("[42, 14, 21, 77]", list.toString());
    }

    /**
     * Test of delDuplicatesNewList method, of class TdListes.
     */
    @Test
    public void testDelDuplicatesNewList() {
        System.out.println("delDuplicatesNewList");
        ArrayList<Integer> list = new ArrayList<>();
        list.add(42);
        list.add(14);
        list.add(7);
        list.add(14);
        list.add(42);
        list.add(77);
        ArrayList<Integer> expResult = new ArrayList<>();
        expResult.add(42);
        expResult.add(14);
        expResult.add(7);
        expResult.add(77);
        ArrayList<Integer> result = TdListes.delDuplicatesNewList(list);
        assertEquals(expResult, result);
    }

    /**
     * Test of delDuplicates method, of class TdListes.
     */
    @Test
    public void testDelDuplicates() {
        System.out.println("delDuplicates");
        ArrayList<Integer> list = new ArrayList<>();
        list.add(42);
        list.add(14);
        list.add(7);
        list.add(14);
        list.add(42);
        list.add(77);
        TdListes.delDuplicates(list);
        assertEquals("[42, 14, 7, 77]", list.toString());
    }

    /**
     * Test of merge method, of class TdListes.
     */
    @Test
    public void testMerge() {
        System.out.println("merge");
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(7);
        list1.add(21);
        list1.add(42);
        list1.add(777);
        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(14);
        list2.add(21);
        list2.add(42);
        list2.add(77);
        list2.add(777);
        ArrayList<Integer> expResult = new ArrayList<>();
        expResult.add(7);
        expResult.add(14);
        expResult.add(21);
        expResult.add(21);
        expResult.add(42);
        expResult.add(42);
        expResult.add(77);
        expResult.add(777);
        expResult.add(777);
        ArrayList<Integer> result = TdListes.merge(list1, list2);
        assertEquals(expResult, result);
    }

    /**
     * Test of earlier method, of class TdListes.
     */
    @Test
    public void testEarlier() {
        System.out.println("earlier");
        ArrayList<Moment> moments = new ArrayList<>();
        moments.add(new Moment(7, 14, 14));
        moments.add(new Moment(7, 21, 7));
        moments.add(new Moment(7, 14, 7));
        moments.add(new Moment(14, 7, 21));
        Moment expResult = moments.get(2);
        Moment result = TdListes.earlier(moments);
        assertEquals(expResult, result);
    }
    
}
