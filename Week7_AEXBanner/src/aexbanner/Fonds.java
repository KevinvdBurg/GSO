/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aexbanner;

/**
 *
 * @author milton
 */
public class Fonds implements aexbanner.IFonds
{
    private String name;
    private double course;
    
    public Fonds(String name, double course)
    {
        if(name.isEmpty())
        {
            throw new IllegalArgumentException("name cant be empty");
        }
        
        this.name = name;
        this.course = course;
    }
    
    @Override
    public String getName()
    {
        return this.name;
    }
    
    @Override
    public double getCourse()
    {
        return this.course;
    }

}
