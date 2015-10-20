/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aexbanner;

import java.util.Random;

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
        Random r = new Random();
        double randomValue = 0 + (20 - 0) * r.nextDouble();
        randomValue = Math.round(randomValue * 100.0) / 100.0;
        
        return randomValue;
//        return this.course;
    }

}
