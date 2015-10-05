/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fontys.time;

import java.util.Iterator;
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
public class ContactTest {
    private Contact contactKevin;
    private Contact contactMilton;
    public ContactTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        contactKevin = new Contact("Kevin");
        contactMilton = new Contact("Milton");
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getName method, of class Contact.
     */
    @org.junit.Test
    public void testGetName() {
        System.out.println("getName");
        String expResult = "Kevin";
        String result = contactKevin.getName();
        assertEquals("Namen moeten gelijk zijn: ",expResult, result);
        
        String expResult2 = "Milton";
        String result2 = contactMilton.getName();
        assertEquals("Namen moeten gelijk zijn: ", expResult2, result2);
        
        assertFalse("Namen moeten ongelijk zijn: ", result2.equals(result));
        
    }

    /**
     * Test of addAppointment method, of class Contact.
     */
    @org.junit.Test
    public void testAddAppointment() {
        
        System.out.println("addAppointment");
        boolean afspraak = false;
        Appointment aa = new Appointment("Afspraak 1", new TimeSpan2(new Time(2015, 10, 5, 0, 0), 90)); //wel
        Appointment ab = new Appointment("Afspraak 2", new TimeSpan2(new Time(2015, 11, 5, 1, 1), 60)); //wel
        Appointment ac = new Appointment("Afspraak 3", new TimeSpan2(new Time(2015, 12, 5, 3, 2), 15)); //wel
        Appointment ad = new Appointment("Afspraak 4", new TimeSpan2(new Time(2015, 10, 5, 1, 0), 90)); //niet
        Appointment ae = new Appointment("Afspraak 5", new TimeSpan2(new Time(2015, 11, 5, 1, 30), 60)); //niet
        Appointment af = new Appointment("Afspraak 6", new TimeSpan2(new Time(2015, 12, 5, 3, 0), 15)); //niet
        
        //Afspraak 1
        afspraak = contactKevin.addAppointment(aa);
        assertEquals("Moet goed gaan", true, afspraak);
        
        //Afspraak 2
        afspraak = contactKevin.addAppointment(ab);
        assertEquals("Moet goed gaan", true, afspraak);
        
        //Afspraak 3
        afspraak = contactKevin.addAppointment(ac);
        assertEquals("Moet goed gaan", true, afspraak);
        
        //Afspraak 4
        afspraak = contactKevin.addAppointment(ad);
        assertEquals("Moet niet goed gaan", false, afspraak);
        
        //Afspraak 5
        afspraak = contactKevin.addAppointment(ae);
        assertEquals("Moet niet goed gaan", false, afspraak);
        
        //Afspraak 6
        afspraak = contactKevin.addAppointment(af);
        assertEquals("Moet niet goed gaan", true, afspraak);
            
    }

    /**
     * Test of removeAppointment method, of class Contact.
     */
    @org.junit.Test
    public void testRemoveAppointment() {
        Appointment aa = new Appointment("Afspraak 1", new TimeSpan2(new Time(2015, 10, 5, 0, 0), 90)); //wel
        Appointment ab = new Appointment("Afspraak 2", new TimeSpan2(new Time(2015, 11, 5, 1, 1), 60)); //wel
        Appointment ac = new Appointment("Afspraak 3", new TimeSpan2(new Time(2015, 12, 5, 3, 2), 15)); //wel
        contactMilton.addAppointment(aa);
        contactMilton.addAppointment(ab);
        contactMilton.addAppointment(ac);
        
        contactMilton.removeAppointment(ac);
        contactMilton.removeAppointment(ab);
        
        
    }

    /**
     * Test of appointments method, of class Contact.
     */
    @org.junit.Test
    public void testAppointments() {
        Appointment aa = new Appointment("Afspraak 1", new TimeSpan2(new Time(2015, 10, 5, 0, 0), 90)); //wel
        Appointment ab = new Appointment("Afspraak 2", new TimeSpan2(new Time(2015, 11, 5, 1, 1), 60)); //wel
        Appointment ac = new Appointment("Afspraak 3", new TimeSpan2(new Time(2015, 12, 5, 3, 2), 15)); //wel
        Appointment ba = new Appointment("Afspraak 1", new TimeSpan2(new Time(2016, 10, 5, 0, 0), 90)); //wel
        Appointment bb = new Appointment("Afspraak 2", new TimeSpan2(new Time(2017, 11, 5, 1, 1), 60)); //wel
        Appointment bc = new Appointment("Afspraak 3", new TimeSpan2(new Time(2018, 12, 5, 3, 2), 15)); //wel
        contactMilton.addAppointment(aa);
        contactMilton.addAppointment(ab);
        contactMilton.addAppointment(ac);
        contactKevin.addAppointment(ba);
        contactKevin.addAppointment(bb);
        contactKevin.addAppointment(bc);
        
    }
    
}
