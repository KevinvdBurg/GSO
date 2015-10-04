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
 * @author kvdb
 */
public class ITimeTest {
    
    public ITimeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getYear method, of class ITime.
     */
    @Test
    public void testGetYear() {
        System.out.println("getYear");
        ITime instance = new ITimeImpl();
        int expResult = 0;
        int result = instance.getYear();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMonth method, of class ITime.
     */
    @Test
    public void testGetMonth() {
        System.out.println("getMonth");
        ITime instance = new ITimeImpl();
        int expResult = 0;
        int result = instance.getMonth();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDay method, of class ITime.
     */
    @Test
    public void testGetDay() {
        System.out.println("getDay");
        ITime instance = new ITimeImpl();
        int expResult = 0;
        int result = instance.getDay();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHours method, of class ITime.
     */
    @Test
    public void testGetHours() {
        System.out.println("getHours");
        ITime instance = new ITimeImpl();
        int expResult = 0;
        int result = instance.getHours();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMinutes method, of class ITime.
     */
    @Test
    public void testGetMinutes() {
        System.out.println("getMinutes");
        ITime instance = new ITimeImpl();
        int expResult = 0;
        int result = instance.getMinutes();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDayInWeek method, of class ITime.
     */
    @Test
    public void testGetDayInWeek() {
        System.out.println("getDayInWeek");
        ITime instance = new ITimeImpl();
        DayInWeek expResult = null;
        DayInWeek result = instance.getDayInWeek();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of plus method, of class ITime.
     */
    @Test
    public void testPlus() {
        System.out.println("plus");
        int minutes = 0;
        ITime instance = new ITimeImpl();
        ITime expResult = null;
        ITime result = instance.plus(minutes);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of difference method, of class ITime.
     */
    @Test
    public void testDifference() {
        System.out.println("difference");
        ITime time = null;
        ITime instance = new ITimeImpl();
        int expResult = 0;
        int result = instance.difference(time);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class ITimeImpl implements ITime {

        public int getYear() {
            return 0;
        }

        public int getMonth() {
            return 0;
        }

        public int getDay() {
            return 0;
        }

        public int getHours() {
            return 0;
        }

        public int getMinutes() {
            return 0;
        }

        public DayInWeek getDayInWeek() {
            return null;
        }

        public ITime plus(int minutes) {
            return null;
        }

        public int difference(ITime time) {
            return 0;
        }
    }
    
}
