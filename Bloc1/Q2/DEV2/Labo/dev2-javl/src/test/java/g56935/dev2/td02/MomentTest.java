/*
 * Written by g56935 (HE2B-ESI)
 */
package g56935.dev2.td02;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author g56935
 */
public class MomentTest {
    
    public MomentTest() {
    }

    /**
     * Test of Moment instance (General case)
     */
    @Test
    public void testNewInstanceGeneral() {
        System.out.println("NewInstance General");
        Moment instance = new Moment(2, 45, 30);
        int expResultHour = 2;
        int expResultMinute = 45;
        int expResultSecond = 30;
        String expResultToString = "02:45:30";
        int resultHour = instance.getHour();
        int resultMinute = instance.getMinute();
        int resultSecond = instance.getSecond();
        String resultToString = instance.toString();
        assertEquals(expResultHour, resultHour);
        assertEquals(expResultMinute, resultMinute);
        assertEquals(expResultSecond, resultSecond);
        assertEquals(expResultToString, resultToString);
    }
    
    /**
     * Test of Moment instance (Minimum case)
     */
    @Test
    public void testNewInstanceMinimum() {
        System.out.println("NewInstance Minimum");
        Moment instance = new Moment(0, 0, 0);
        int expResultHour = 0;
        int expResultMinute = 0;
        int expResultSecond = 0;
        String expResultToString = "00:00:00";
        int resultHour = instance.getHour();
        int resultMinute = instance.getMinute();
        int resultSecond = instance.getSecond();
        String resultToString = instance.toString();
        assertEquals(expResultHour, resultHour);
        assertEquals(expResultMinute, resultMinute);
        assertEquals(expResultSecond, resultSecond);
        assertEquals(expResultToString, resultToString);
    }
    
    /**
     * Test of Moment instance (Maximum case)
     */
    @Test
    public void testNewInstanceMaximum() {
        System.out.println("NewInstance Maximum");
        Moment instance = new Moment(23, 59, 59);
        int expResultHour = 23;
        int expResultMinute = 59;
        int expResultSecond = 59;
        String expResultToString = "23:59:59";
        int resultHour = instance.getHour();
        int resultMinute = instance.getMinute();
        int resultSecond = instance.getSecond();
        String resultToString = instance.toString();
        assertEquals(expResultHour, resultHour);
        assertEquals(expResultMinute, resultMinute);
        assertEquals(expResultSecond, resultSecond);
        assertEquals(expResultToString, resultToString);
    }
    
    /**
     * Test of Moment instance (Too low 'minute' case)
     */
    @Test
    public void testNewInstanceTooLowMinute() {
        System.out.println("NewInstance To Low 'Minute'");
        assertThrows(IllegalArgumentException.class, () -> {
            Moment instance = new Moment(2, -4, 30);
        });
    }
    
    /**
     * Test of Moment instance (Too high 'second' case)
     */
    @Test
    public void testNewInstanceTooHighSecond() {
        System.out.println("NewInstance To High 'Second'");
        assertThrows(IllegalArgumentException.class, () -> {
            Moment instance = new Moment(2, 45, 64);
        });
    }

    /**
     * Test of compareTo method, of class Moment. (Positive case)
     */
    @Test
    public void testCompareToPositive() {
        System.out.println("compareTo Positive");
        Moment other = new Moment(1, 15, 10);
        Moment instance = new Moment(2, 30, 20);
        int expResult = 4510;
        int result = instance.compareTo(other);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of compareTo method, of class Moment. (Negative case)
     */
    @Test
    public void testCompareToNegative() {
        System.out.println("compareTo Negative");
        Moment other = new Moment(3, 45, 30);
        Moment instance = new Moment(2, 25, 15);
        int expResult = -4815;
        int result = instance.compareTo(other);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of compareTo method, of class Moment. (Equals case)
     */
    @Test
    public void testCompareToEqual() {
        System.out.println("compareTo Equal");
        Moment other = new Moment(2, 30, 45);
        Moment instance = new Moment(2, 30, 45);
        int expResult = 0;
        int result = instance.compareTo(other);
        assertEquals(expResult, result);
    }
}