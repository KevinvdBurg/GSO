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
public class ITimeSpanTest {
    
    public ITimeSpanTest() {
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
     * Test of getBeginTime method, of class ITimeSpan.
     */
    @Test
    public void testGetBeginTime() {
        System.out.println("getBeginTime");
        ITimeSpan instance = new ITimeSpanImpl();
        ITime expResult = null;
        ITime result = instance.getBeginTime();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEndTime method, of class ITimeSpan.
     */
    @Test
    public void testGetEndTime() {
        System.out.println("getEndTime");
        ITimeSpan instance = new ITimeSpanImpl();
        ITime expResult = null;
        ITime result = instance.getEndTime();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of length method, of class ITimeSpan.
     */
    @Test
    public void testLength() {
        System.out.println("length");
        ITimeSpan instance = new ITimeSpanImpl();
        int expResult = 0;
        int result = instance.length();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setBeginTime method, of class ITimeSpan.
     */
    @Test
    public void testSetBeginTime() {
        System.out.println("setBeginTime");
        ITime beginTime = null;
        ITimeSpan instance = new ITimeSpanImpl();
        instance.setBeginTime(beginTime);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEndTime method, of class ITimeSpan.
     */
    @Test
    public void testSetEndTime() {
        System.out.println("setEndTime");
        ITime endTime = null;
        ITimeSpan instance = new ITimeSpanImpl();
        instance.setEndTime(endTime);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of move method, of class ITimeSpan.
     */
    @Test
    public void testMove() {
        System.out.println("move");
        int minutes = 0;
        ITimeSpan instance = new ITimeSpanImpl();
        instance.move(minutes);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of changeLengthWith method, of class ITimeSpan.
     */
    @Test
    public void testChangeLengthWith() {
        System.out.println("changeLengthWith");
        int minutes = 0;
        ITimeSpan instance = new ITimeSpanImpl();
        instance.changeLengthWith(minutes);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isPartOf method, of class ITimeSpan.
     */
    @Test
    public void testIsPartOf() {
        System.out.println("isPartOf");
        ITimeSpan timeSpan = null;
        ITimeSpan instance = new ITimeSpanImpl();
        boolean expResult = false;
        boolean result = instance.isPartOf(timeSpan);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of unionWith method, of class ITimeSpan.
     */
    @Test
    public void testUnionWith() {
        System.out.println("unionWith");
        ITimeSpan timeSpan = null;
        ITimeSpan instance = new ITimeSpanImpl();
        ITimeSpan expResult = null;
        ITimeSpan result = instance.unionWith(timeSpan);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of intersectionWith method, of class ITimeSpan.
     */
    @Test
    public void testIntersectionWith() {
        System.out.println("intersectionWith");
        ITimeSpan timeSpan = null;
        ITimeSpan instance = new ITimeSpanImpl();
        ITimeSpan expResult = null;
        ITimeSpan result = instance.intersectionWith(timeSpan);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class ITimeSpanImpl implements ITimeSpan {

        public ITime getBeginTime() {
            return null;
        }

        public ITime getEndTime() {
            return null;
        }

        public int length() {
            return 0;
        }

        public void setBeginTime(ITime beginTime) {
        }

        public void setEndTime(ITime endTime) {
        }

        public void move(int minutes) {
        }

        public void changeLengthWith(int minutes) {
        }

        public boolean isPartOf(ITimeSpan timeSpan) {
            return false;
        }

        public ITimeSpan unionWith(ITimeSpan timeSpan) {
            return null;
        }

        public ITimeSpan intersectionWith(ITimeSpan timeSpan) {
            return null;
        }
    }
    
}
