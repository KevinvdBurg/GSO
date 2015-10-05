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
public class TimeSpan2Test {  
    private ITime bt = new Time(2, 2, 2, 2, 2);
    private long et = 1l;
    
    private ITime correctBt = new Time(3, 3, 3, 3, 3);
    private ITime incorrectBt = new Time(11, 11, 11, 11, 11);
    
    private ITime correctEt = new Time(11, 11, 11, 11, 11);
    private ITime incorrectEt = new Time(1, 1, 1, 1, 1);
    
    private ITime inBt = new Time(3, 3, 3, 3, 3);
    private long inEt =  10l;
    
    private ITime outBt = new Time(1, 1, 1, 1, 1);
    private long outEt = 10l;
    
    private long extendedEt = 10l;
    
    public TimeSpan2Test() {
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
        
        TimeSpan2 instance = new TimeSpan2(bt, et);
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
        
        TimeSpan2 instance = new TimeSpan2(bt, et);
        long expResult = et;
        ITime result = instance.getEndTime();
        assertEquals("expected endtime " + expResult + " does not equal returned endtime " + result, expResult, result);
    }

    /**
     * Test of length method, of class TimeSpan.
     */
    @Test
    public void testLength() {
        System.out.println("length");
        
        TimeSpan2 instance = new TimeSpan2(bt, et);
        int expResult = new TimeSpan2(bt, et).length();
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
        TimeSpan2 instance = new TimeSpan2(bt, et);
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
        TimeSpan2 instance = new TimeSpan2(bt, et);
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
        TimeSpan2 instance = new TimeSpan2(bt, et);
        TimeSpan2 expResult = new TimeSpan2(new Time(2, 2, 2, 2, 12), 10l);
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
        TimeSpan2 instance = new TimeSpan2(bt, et);
        instance.changeLengthWith(minutes);
        ITimeSpan expEt = new TimeSpan2(bt, extendedEt);      
        ITimeSpan result = instance;
        assertEquals("expected TimeSPan " + expEt.toString() + " does not equal returned TimeSpan " + result.toString(), expEt, result);
    }

    /**
     * Test of isPartOf method, of class TimeSpan.
     */
    @Test
    public void testIsPartOf() {
        System.out.println("isPartOf");
        
        ITimeSpan timeSpan = new TimeSpan2(inBt, inEt);
        TimeSpan2 instance = new TimeSpan2(bt, et);
        boolean expResult = true;
        boolean result = instance.isPartOf(timeSpan);
        assertEquals("expected isPartOf " + expResult + " does not equal returned isPartOf " + result, expResult, result);
        
        timeSpan = new TimeSpan2(outBt, outEt);
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
        
        ITimeSpan timeSpan = new TimeSpan2(inBt, inEt);
        ITimeSpan instance = new TimeSpan2(bt, et);
        ITimeSpan expResult = new TimeSpan2(bt, et);
        ITimeSpan result = instance.unionWith(timeSpan);
        assertEquals("expected union " + expResult.toString() + " does not equal returned union " + result.toString(), result, result);
        
        timeSpan = new TimeSpan2(inBt, et);
        expResult = new TimeSpan2(bt, et);
        result = instance.unionWith(timeSpan);
        assertEquals("expected union " + expResult + " does not equal returned union " + result, expResult, result);
        
        timeSpan = new TimeSpan2(inBt, outEt);
        expResult = new TimeSpan2(bt, outEt);
        result = instance.unionWith(timeSpan);
        assertEquals("expected union " + expResult + " does not equal returned union " + result, expResult, result);
        
//        timeSpan = new TimeSpan2(bt, inBt);
//        expResult = new TimeSpan2(bt, et);
//        result = instance.unionWith(timeSpan);
//        assertEquals("expected union " + expResult + " does not equal returned union " + result, expResult, result);
        
        timeSpan = new TimeSpan2(bt, et);
        expResult = new TimeSpan2(bt, et);
        result = instance.unionWith(timeSpan);
        assertEquals("expected union " + expResult + " does not equal returned union " + result, expResult, result);
        
        timeSpan = new TimeSpan2(bt, outEt);
        expResult = new TimeSpan2(bt, outEt);
        result = instance.unionWith(timeSpan);
        assertEquals("expected union " + expResult + " does not equal returned union " + result, expResult, result);
        
        timeSpan = new TimeSpan2(outBt, inEt);
        expResult = new TimeSpan2(outBt, et);
        result = instance.unionWith(timeSpan);
        assertEquals("expected union " + expResult + " does not equal returned union " + result, expResult, result);
        
        timeSpan = new TimeSpan2(outBt, et);
        expResult = new TimeSpan2(outBt, et);
        result = instance.unionWith(timeSpan);
        assertEquals("expected union " + expResult + " does not equal returned union " + result, expResult, result);
        
        timeSpan = new TimeSpan2(outBt, outEt);
        expResult = new TimeSpan2(outBt, outEt);
        result = instance.unionWith(timeSpan);
        assertEquals("expected union " + expResult + " does not equal returned union " + result, expResult, result);
    }

    /**
     * Test of intersectionWith method, of class TimeSpan2.
     */
    @Test
    public void testIntersectionWith() {
        System.out.println("intersectionWith");
        
        ITimeSpan timeSpan = new TimeSpan2(inBt, inEt);
        TimeSpan2 instance = new TimeSpan2(bt, et);
        ITimeSpan expResult = new TimeSpan2(inBt, inEt);
        ITimeSpan result = instance.intersectionWith(timeSpan);
        assertEquals("expected intersection " + expResult.toString() + " does not equal returned intersection " + result.toString(), expResult, result);

        timeSpan = new TimeSpan2(inBt, et);
        expResult = new TimeSpan2(inBt, et);
        result = instance.intersectionWith(timeSpan);
        assertEquals("expected intersection " + expResult + " does not equal returned intersection " + result, expResult, result);

        timeSpan = new TimeSpan2(inBt, outEt);
        expResult = new TimeSpan2(inBt, et);
        result = instance.intersectionWith(timeSpan);
        assertEquals("expected intersection " + expResult + " does not equal returned intersection " + result, expResult, result);
        
        timeSpan = new TimeSpan2(bt, inEt);
        expResult = new TimeSpan2(bt, inEt);
        result = instance.intersectionWith(timeSpan);
        assertEquals("expected intersection " + expResult + " does not equal returned intersection " + result, expResult, result);
        
        timeSpan = new TimeSpan2(bt, et);
        expResult = new TimeSpan2(bt, et);
        result = instance.intersectionWith(timeSpan);
        assertEquals("expected intersection " + expResult + " does not equal returned intersection " + result, expResult, result);
        
        timeSpan = new TimeSpan2(bt, outEt);
        expResult = new TimeSpan2(bt, et);
        result = instance.intersectionWith(timeSpan);
        assertEquals("expected intersection " + expResult + " does not equal returned intersection " + result, expResult, result);
        
        timeSpan = new TimeSpan2(outBt, inEt);
        expResult = new TimeSpan2(bt, inEt);
        result = instance.intersectionWith(timeSpan);
        assertEquals("expected intersection " + expResult + " does not equal returned intersection " + result, expResult, result);
        
        timeSpan = new TimeSpan2(outBt, et);
        expResult = new TimeSpan2(bt, et);
        result = instance.intersectionWith(timeSpan);
        assertEquals("expected intersection " + expResult + " does not equal returned intersection " + result, expResult, result);
        
        timeSpan = new TimeSpan2(outBt, outEt);
        expResult = new TimeSpan2(bt, et);
        result = instance.intersectionWith(timeSpan);
        assertEquals("expected intersection " + expResult + " does not equal returned intersection " + result, expResult, result);
    }
    
}
