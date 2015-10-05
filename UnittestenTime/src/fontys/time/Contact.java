/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fontys.time;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kevin van der Burg
 */
public class Contact {
    /**
    * The name of the contact
    */
    private String name;
    
    /**
    * A list of all the appointments
    */
    private List<Appointment> appointments;
    
    
    /**
    * Creates a new contact. It needs to initialize the appointments list of that contact
    * 
    * @param name of the Contact, it can't be empty or null
    * 
    * @author
    */
    public Contact(String name){
        if(name.isEmpty() || name == null){
            try {
                throw new Exception("name cant be empty or null");
            } catch (Exception ex) {
                Logger.getLogger(Contact.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        this.name = name;
        this.appointments = new ArrayList<Appointment>();
    }
    
    
    /**
    * Gets name of the contact
    * @return name of the contact
    * @author
    */
    public String getName(){
        return name;
    }
    
    /**
    * Adds a new Appointment. There can't be an overlap in appointments and the begintime must come after the the endtime Example Begintime: 12:00 > EndTime: 13:00  
    * @param a A appointment to be added in the List.
    * @return true or false if the method fails or succeeds to add a Appointment 
    * @author
    */
    boolean addAppointment(Appointment a){
        for(Appointment appointment : appointments){
            if(a.getTimeSpan().getBeginTime().compareTo(appointment.getTimeSpan().getBeginTime()) >= 0){
                try {
                    throw new Exception("appointment cant take place during another appointment");
                } catch (Exception ex) {
                    Logger.getLogger(Contact.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if(a.getTimeSpan().getEndTime().compareTo(appointment.getTimeSpan().getEndTime()) <= 0){
                try {
                    throw new Exception("appointment cant take place during another appointment");
                } catch (Exception ex) {
                    Logger.getLogger(Contact.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if(a.getTimeSpan().getBeginTime().compareTo(a.getTimeSpan().getEndTime()) >= 0){
                try {
                    throw new Exception("begintime must be after endtime");
                } catch (Exception ex) {
                    Logger.getLogger(Contact.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        this.appointments.add(a);
        
        return true;
    }
    
    /**
    * Removes Appointment. The appointment must exist in the list or else it does nothing.
    * @param a the appointment to be deleted
    * @return true or false if the method fails or succeeds to add a Appointment 
    * @author
    */
    boolean removeAppointment(Appointment a){
        boolean result = false;
        
        if(this.appointments.contains(a)){
            this.appointments.remove(a);
            result = true;
        }
        
        return result;
    }
    
    /**
    * Compares Appointments. 
    * @return A Iterator with all the appointments
    * @author
    */
    public Iterator<Appointment> appointments(){
        return appointments.iterator();
    }
    
    
}
