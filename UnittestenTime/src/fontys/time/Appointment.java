/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fontys.time;

import java.util.ArrayList;

/**
 *
 * @author kvdb
 */
class Appointment {
    private String subject;
    private ITimeSpan timeSpan;
    private ArrayList<Contact> contacts;
    
    public Appointment(String subject, ITimeSpan timeSpan){
        
    }
    
    public String getSubject(){
        return null;
    }

    public ITimeSpan getTimeSpan(){
        return null;
        
    }

    public ArrayList<Contact> invitees(){
        return null;
        
    }
    
    public boolean addContact(Contact contact){
        return false;
        
    }
    
    public boolean removeContact(Contact contact){
        return false;
        
    }
}