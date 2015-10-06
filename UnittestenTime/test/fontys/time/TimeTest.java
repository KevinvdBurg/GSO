/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fontys.time;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Kevin van der Burg
 */
public class TimeTest {
    private Time time;
    private final int year = 1992;
    private final int month = 10;
    private final int day = 31;
    private final int hours = 11;
    private final int minutes = 42;

    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        time = new Time(year, month, day, hours, minutes);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    (expected=IllegalArgumentException.class)
    public void timeExceptionM()
    {        
        Time time = new Time(20, 0, 20, 12, 12);
        time = new Time(20, 13, 20, 12, 12);
    }
    
    @Test
    (expected=IllegalArgumentException.class)
    public void timeExceptionD()
    {
        Time time = new Time(20, 1, 0, 12, 12);
        time = new Time(20, 1, 32, 12, 12);
    }
    
    @Test
    (expected = IllegalArgumentException.class)
    public void timeExceptionH()
    {
        Time time = new Time(20, 1, 1, -1, 12);
        time =  new Time(20, 1, 1, 24, 12);
    }
    
    @Test
    (expected = IllegalArgumentException.class)
    public void timeExceptionMin()
    {
        Time time = new Time(20, 1, 1, 1, -1);
        time = new Time(20, 1, 1, 1, 60);
    }
    
    /**
     * Test of getDayInWeek method, of class Time.
     */
    @Test
    public void testGetDayInWeek() {
        System.out.println("getDayInWeek");
        DayInWeek expResult = DayInWeek.SAT;
        DayInWeek result = this.time.getDayInWeek();
        assertEquals("31-10-1992 is op een Zaterdag",expResult, result);
    }

    /**
     * Test of getYear method, of class Time.
     */
    @Test
    public void testGetYear() {
        System.out.println("getYear");
        int expResult = 1992;
        int result = this.time.getYear();
        assertEquals("31-10-1992 is in het Jaar 1992",expResult, result);
    }

    /**
     * Test of getMonth method, of class Time.
     */
    @Test
    public void testGetMonth() {
        System.out.println("getMonth");
        int expResult = 10;
        int result = this.time.getMonth();
        assertEquals("31-10-1992 is in de 10de maand van het Jaar Oktober", expResult, result);
    }

    /**
     * Test of getDay method, of class Time.
     */
    @Test
    public void testGetDay() {
        System.out.println("getDay");
        int expResult = 31;
        int result = this.time.getDay();
        assertEquals("31-10-1992 is op 31ste", expResult, result);
    }

    /**
     * Test of getHours method, of class Time.
     */
    @Test
    public void testGetHours() {
        System.out.println("getHours");
        int expResult = 11;
        int result = this.time.getHours();
        assertEquals("Tijd op dat moment moet 11 uur bedragen", expResult, result);
    }

    /**
     * Test of getMinutes method, of class Time.
     */
    @Test
    public void testGetMinutes() {
        System.out.println("getMinutes");
        int expResult = 42;
        int result = this.time.getMinutes();
        assertEquals("huidige tijd moet 42 bedragen",expResult, result);
    }

    /**
     * Test of plus method, of class Time.
     */
    @Test
    public void testPlus() {
        System.out.println("plus");
        int minutes = 22;
        Time expResult = new Time(1992, 10, 31, 12, 4);
        ITime result = this.time.plus(minutes);
        
        assertEquals("Uur moet nu 12 zijn", expResult.getHours(), result.getHours());
        assertEquals("Minuten moeten nu 4 zijn", expResult.getMinutes(), result.getMinutes());
        assertEquals("Dag mag niet verandert zijn", expResult.getDay(), result.getDay());
        assertEquals("Maand mag niet verandert zijn", expResult.getMonth(), result.getMonth());
        assertEquals("Jaar mag niet verandert zijn", expResult.getYear(), result.getYear());
    }

    /**
     * Test of compareTo method, of class Time.
     */
    @Test
    public void testCompareTo() {
        System.out.println("compareTo");
        assertEquals("time == time | Time is hetzelfde", 0, time.compareTo(time));
       assertEquals("time != time | Time is niet hetzelfde", 1, time.compareTo(time.plus(5)));
       assertEquals("time == time | Time is hetzelfde", 0, time.plus(5).compareTo(time.plus(5)));
       
    }

    /**
     * Test of difference method, of class Time.
     */
    @Test
    public void testDifference() {
        System.out.println("difference");
        Time instance = (Time) time.plus(1000);
        int expResult = -1000;
        int result = time.difference(instance);
        assertEquals("Resultaat moet in de min zijn", expResult, result);

        instance = (Time) time.plus(-1000);
        expResult = 1000;
        result = time.difference(instance);
        assertEquals("Resultaat moet in de plus zijn", expResult, result);
    }
    
}
