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
 * @author Milton van de Sanden
 */
public class TimeSpanTest {  
    private ITime bt = new Time(2, 2, 2, 2, 2);
    private ITime et = new Time(10, 10, 10, 10, 10);
    
    private ITime correctBt = new Time(3, 3, 3, 3, 3);
    private ITime incorrectBt = new Time(11, 11, 11, 11, 11);
    
    private ITime correctEt = new Time(11, 11, 11, 11, 11);
    private ITime incorrectEt = new Time(1, 1, 1, 1, 1);
    
    private ITime inBt = new Time(3, 3, 3, 3, 3);
    private ITime inEt = new Time(9, 9, 9, 9, 9);
    
    private ITime outBt = new Time(1, 1, 1, 1, 1);
    private ITime outEt = new Time(11, 11, 11, 11, 11);
    
    private ITime extendedEt = new Time(10, 10, 10, 10, 20);
    
    public TimeSpanTest() {
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
     * Test of getBeginTime method, of class TimeSpan.
     */
    @Test
    public void testGetBeginTime() {
        System.out.println("getBeginTime");
        
        TimeSpan instance = new TimeSpan(bt, et);
        ITime expResult = bt;
        ITime result = instance.getBeginTime();
        assertEquals("expected begintime " + expResult + " is not equal to returned begintime " + result, expResult, result);
    }

    /**
     * Test of getEndTime method, of class TimeSpan.
     */
    @Test
    public void testGetEndTime() {
        System.out.println("getEndTime");
        
        TimeSpan instance = new TimeSpan(bt, et);
        ITime expResult = et;
        ITime result = instance.getEndTime();
        assertEquals("expected endtime " + expResult + " does not equal returned endtime " + result, expResult, result);
    }

    /**
     * Test of length method, of class TimeSpan.
     */
    @Test
    public void testLength() {
        System.out.println("length");
        
        TimeSpan instance = new TimeSpan(bt, et);
        int expResult = new TimeSpan(bt, et).length();
        int result = instance.length();
        assertEquals("expected length " + expResult + " does not equal returned length " + result,expResult, result);
    }

    /**
     * Test of setBeginTime method, of class TimeSpan.
     */
    @Test
    public void testSetBeginTime() {
        System.out.println("setBeginTime");
        
        ITime beginTime = correctBt;
        TimeSpan instance = new TimeSpan(bt, et);
        instance.setBeginTime(beginTime);
        assertEquals("expected beginTime " + beginTime + " does not equal returned beginTime " + instance.getBeginTime(), beginTime, instance.getBeginTime());
        
        /*beginTime = incorrectBt;
        instance.setBeginTime(beginTime);
        assertEquals("expected beginTime " + bt + " does not equal returned beginTime " + instance.getBeginTime(), bt, instance.getBeginTime());*/
    }

    /**
     * Test of setEndTime method, of class TimeSpan.
     */
    @Test
    public void testSetEndTime() {
        System.out.println("setEndTime");
        
        ITime endTime = correctEt;
        TimeSpan instance = new TimeSpan(bt, et);
        instance.setEndTime(endTime);
        assertEquals("expected endTime " + endTime + " does not equal returned endTime " + instance.getEndTime(), endTime, instance.getEndTime());
        
        /*endTime = incorrectEt;
        instance.setEndTime(endTime);
        assertEquals("expected endTime " + et + " does not equal returned endTime " + instance.getEndTime(), et, instance.getEndTime());*/
    }

    /**
     * Test of move method, of class TimeSpan.
     */
    @Test
    public void testMove() {
        System.out.println("move");
        
        int minutes = 10;
        TimeSpan instance = new TimeSpan(bt, et);
        TimeSpan expResult = new TimeSpan(new Time(2, 2, 2, 2, 12), new Time(10, 10, 10, 10, 20));
        instance.move(minutes);
        assertEquals("expected TimeSpan " + expResult.toString() + " does not equal returned beginTime " + instance.toString(), expResult, instance);
    }

    /**
     * Test of changeLengthWith method, of class TimeSpan.
     */
    @Test
    public void testChangeLengthWith() {
        System.out.println("changeLengthWith");
        
        int minutes = 10;
        TimeSpan instance = new TimeSpan(bt, et);
        instance.changeLengthWith(minutes);
        ITimeSpan expEt = new TimeSpan(bt, extendedEt);      
        ITimeSpan result = instance;
        assertEquals("expected TimeSPan " + expEt.toString() + " does not equal returned TimeSpan " + result.toString(), expEt, result);
    }

    /**
     * Test of isPartOf method, of class TimeSpan.
     */
    @Test
    public void testIsPartOf() {
        System.out.println("isPartOf");
        
        ITimeSpan timeSpan = new TimeSpan(inBt, inEt);
        TimeSpan instance = new TimeSpan(bt, et);
        boolean expResult = true;
        boolean result = instance.isPartOf(timeSpan);
        assertEquals("expected isPartOf " + expResult + " does not equal returned isPartOf " + result, expResult, result);
        
        timeSpan = new TimeSpan(outBt, outEt);
        expResult = false;
        result = instance.isPartOf(timeSpan);
        assertEquals("expected isPartOF " + expResult + " does not equal returned isPartOf " + result, expResult, result);
    }

    /**
     * Test of unionWith method, of class TimeSpan.
     */
    @Test
    public void testUnionWith() {
        System.out.println("unionWith");
        
        ITimeSpan timeSpan = new TimeSpan(inBt, inEt);
        ITimeSpan instance = new TimeSpan(bt, et);
        ITimeSpan expResult = new TimeSpan(bt, et);
        ITimeSpan result = instance.unionWith(timeSpan);
        assertEquals("expected union " + expResult.toString() + " does not equal returned union " + result.toString(), result, result);
        
        timeSpan = new TimeSpan(inBt, et);
        expResult = new TimeSpan(bt, et);
        result = instance.unionWith(timeSpan);
        assertEquals("expected union " + expResult + " does not equal returned union " + result, expResult, result);
        
        timeSpan = new TimeSpan(inBt, outEt);
        expResult = new TimeSpan(bt, outEt);
        result = instance.unionWith(timeSpan);
        assertEquals("expected union " + expResult + " does not equal returned union " + result, expResult, result);
        
        timeSpan = new TimeSpan(bt, inBt);
        expResult = new TimeSpan(bt, et);
        result = instance.unionWith(timeSpan);
        assertEquals("expected union " + expResult + " does not equal returned union " + result, expResult, result);
        
        timeSpan = new TimeSpan(bt, et);
        expResult = new TimeSpan(bt, et);
        result = instance.unionWith(timeSpan);
        assertEquals("expected union " + expResult + " does not equal returned union " + result, expResult, result);
        
        timeSpan = new TimeSpan(bt, outEt);
        expResult = new TimeSpan(bt, outEt);
        result = instance.unionWith(timeSpan);
        assertEquals("expected union " + expResult + " does not equal returned union " + result, expResult, result);
        
        timeSpan = new TimeSpan(outBt, inEt);
        expResult = new TimeSpan(outBt, et);
        result = instance.unionWith(timeSpan);
        assertEquals("expected union " + expResult + " does not equal returned union " + result, expResult, result);
        
        timeSpan = new TimeSpan(outBt, et);
        expResult = new TimeSpan(outBt, et);
        result = instance.unionWith(timeSpan);
        assertEquals("expected union " + expResult + " does not equal returned union " + result, expResult, result);
        
        timeSpan = new TimeSpan(outBt, outEt);
        expResult = new TimeSpan(outBt, outEt);
        result = instance.unionWith(timeSpan);
        assertEquals("expected union " + expResult + " does not equal returned union " + result, expResult, result);
    }

    /**
     * Test of intersectionWith method, of class TimeSpan.
     */
    @Test
    public void testIntersectionWith() {
        System.out.println("intersectionWith");
        
        ITimeSpan timeSpan = new TimeSpan(inBt, inEt);
        TimeSpan instance = new TimeSpan(bt, et);
        ITimeSpan expResult = new TimeSpan(inBt, inEt);
        ITimeSpan result = instance.intersectionWith(timeSpan);
        assertEquals("expected intersection " + expResult.toString() + " does not equal returned intersection " + result.toString(), expResult, result);

        timeSpan = new TimeSpan(inBt, et);
        expResult = new TimeSpan(inBt, et);
        result = instance.intersectionWith(timeSpan);
        assertEquals("expected intersection " + expResult + " does not equal returned intersection " + result, expResult, result);

        timeSpan = new TimeSpan(inBt, outEt);
        expResult = new TimeSpan(inBt, et);
        result = instance.intersectionWith(timeSpan);
        assertEquals("expected intersection " + expResult + " does not equal returned intersection " + result, expResult, result);
        
        timeSpan = new TimeSpan(bt, inEt);
        expResult = new TimeSpan(bt, inEt);
        result = instance.intersectionWith(timeSpan);
        assertEquals("expected intersection " + expResult + " does not equal returned intersection " + result, expResult, result);
        
        timeSpan = new TimeSpan(bt, et);
        expResult = new TimeSpan(bt, et);
        result = instance.intersectionWith(timeSpan);
        assertEquals("expected intersection " + expResult + " does not equal returned intersection " + result, expResult, result);
        
        timeSpan = new TimeSpan(bt, outEt);
        expResult = new TimeSpan(bt, et);
        result = instance.intersectionWith(timeSpan);
        assertEquals("expected intersection " + expResult + " does not equal returned intersection " + result, expResult, result);
        
        timeSpan = new TimeSpan(outBt, inEt);
        expResult = new TimeSpan(bt, inEt);
        result = instance.intersectionWith(timeSpan);
        assertEquals("expected intersection " + expResult + " does not equal returned intersection " + result, expResult, result);
        
        timeSpan = new TimeSpan(outBt, et);
        expResult = new TimeSpan(bt, et);
        result = instance.intersectionWith(timeSpan);
        assertEquals("expected intersection " + expResult + " does not equal returned intersection " + result, expResult, result);
        
        timeSpan = new TimeSpan(outBt, outEt);
        expResult = new TimeSpan(bt, et);
        result = instance.intersectionWith(timeSpan);
        assertEquals("expected intersection " + expResult + " does not equal returned intersection " + result, expResult, result);
    }
    
}
