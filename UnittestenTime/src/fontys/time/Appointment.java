/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fontys.time;

import java.util.ArrayList;

/**
 *
 * @author Milton van de Sanden
 */
class Appointment {
    /**
    * the subject of the appointment
    */
    private String subject;
    
    /**
    *the timespan in which the appointment takes place
    */
    private ITimeSpan timeSpan;
    
    /**
    *a list of all contacts who have been invited to the appointment
    */
    private ArrayList<Contact> contacts;
    
    /**
    * Creates a new appointment. it needs to initialize the subject and timespan of the appointment
    *
    * @param subject of the appointment, it cant be empty or null
    * @param timeSpan in which the appointment takes place, it cant be null
    */
    public Appointment(String subject, ITimeSpan timeSpan) throws Exception{
        if (!subject.isEmpty() || timeSpan != null)
        {
            this.subject = subject;
            this.timeSpan = timeSpan;
            this.contacts = new ArrayList<>();
        }
        else{
            throw new Exception("Subject or timespan cant be empty or null");
        }
    }
    
    /**
     * Returnes the subject of the appointment
     * 
     * @return subject
     */
    public String getSubject(){
        return subject;
    }

    /**
     * returns the timespan in which the appointment takes place
     * 
     * @return timeSpan
     */
    public ITimeSpan getTimeSpan(){
        return timeSpan;
        
    }
    
    /**
     * returns the list of contacts who have been invited to the appointment
     * 
     * @return contacts
     */
    public ArrayList<Contact> invitees(){
        return contacts;
        
    }
    
    /**
     * Adds a new contact to the list of contacts who have been invited to the appointment
     * 
     * @param contact who has been invited to the appointment, cant be null or already a contact of the appointment
     * @return true when the contact has been succesfully added, false when the the contact has been unsuccesfully added
     */
    public boolean addContact(Contact contact){
        
        boolean result = false;
        
        if (contact != null) 
        {
            if(!contacts.contains(contact))
            {
                this.contacts.add(contact);
                result = true;
            } 
        }
                
        return result;
        
    }
    
    /**
     * Removes a contact who is already in the list of contacts from the list of contacts
     * 
     * @param contact who is to be removed from the list of contacts, cant be null and must be already contained within the list of contacts
     * @return true when the contact has been succesfully renoved, false when the contact has been unsuccesfully removed
     */
    public boolean removeContact(Contact contact){
       boolean result = false;
        
        if (contact != null) 
        {
            if(contacts.contains(contact))
            {
                this.contacts.remove(contact);
                result = true;
            } 
        }
                
        return result;
    }
}