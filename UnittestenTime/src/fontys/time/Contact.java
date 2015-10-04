/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fontys.time;

import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Kevin van der Burg
 */
public class Contact {
    private String name;
    private List<Appointment> appointments;
    
    public Contact(String name){
        
    }
    
    public String getName(){
        return null;
    }
    
    boolean addAppointment(Appointment a){
        return false;
    }
    
    void removeAppointment(Appointment a){
        
    }
    
    public Iterator<Appointment> appointments(){
        return appointments.iterator();
    }
    
    
}
