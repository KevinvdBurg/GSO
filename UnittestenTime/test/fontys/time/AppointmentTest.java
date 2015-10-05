/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fontys.time;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Milton
 */
public class AppointmentTest {
    private String testSubject = "testSubject";
    private ITimeSpan timeSpan = new TimeSpan(new Time(2, 2, 2, 2, 2), new Time(10, 10, 10, 10, 10));
    
    private String testName = "testName";
    
    public AppointmentTest() {
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
     * Test of getSubject method, of class Appointment.
     */
    @Test
    public void testGetSubject() {
        System.out.println("getSubject");
        
        Appointment instance = new Appointment(this.testSubject, this.timeSpan);
        String expResult = testSubject;
        String result = instance.getSubject();
        assertEquals("returned subject: " + result + " does not equal expected subject: " + expResult, expResult, result);
    }

    /**
     * Test of getTimeSpan method, of class Appointment.
     */
    @Test
    public void testGetTimeSpan() {
        System.out.println("getTimeSpan");
        
        Appointment instance = new Appointment(this.testSubject, this.timeSpan);
        ITimeSpan expResult = this.timeSpan;
        ITimeSpan result = instance.getTimeSpan();
        assertEquals("returned timeSpan: " + result + " does not equal expected timeSpan: " + expResult, expResult, result);
    }

    /**
     * Test of invitees method, of class Appointment.
     */
    @Test
    public void testInvitees() {
        System.out.println("invitees");
        
        Appointment instance = new Appointment(this.testSubject, this.timeSpan);
        ArrayList<Contact> expResult = new ArrayList<>();
        ArrayList<Contact> result = instance.invitees();
        assertEquals("returned contacts: " + result + " does not equal expected contacts: " + expResult, expResult, result);
    }

    /**
     * Test of addContact method, of class Appointment.
     */
    @Test
    public void testAddContact() {
        System.out.println("addContact");
        
        Contact contact = new Contact(this.testName);
        Appointment instance = new Appointment(this.testSubject, this.timeSpan);
        boolean expResult = true;
        boolean result = instance.addContact(contact);
        assertEquals("returned boolean: " + result + " does not equal expected boolean: " + expResult, expResult, result);
    }

    /**
     * Test of removeContact method, of class Appointment.
     */
    @Test
    public void testRemoveContact() {
        System.out.println("removeContact");
        
        Contact contact = new Contact(this.testName);
        Appointment instance = new Appointment(this.testSubject, this.timeSpan);
        instance.addContact(contact);
        boolean expResult = true;
        boolean result = instance.removeContact(contact);
        assertEquals("returned boolean: " + result + " does not equal expected boolean: " + expResult, expResult, result);
    }
    
}
