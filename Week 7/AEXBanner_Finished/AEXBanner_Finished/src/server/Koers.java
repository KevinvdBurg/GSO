/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import shared.IFonds;
import java.io.Serializable;
import java.rmi.Remote;
import java.util.Random;

/**
 *
 * @author HP user
 */
public class Koers implements IFonds{
    String naam;
    double koers;

    Koers(String naam, double koers)
    {
        this.naam = naam;
        this.koers = koers;
    }
    
    @Override
    public String getNaam() {
        return this.naam;
  
    }

    @Override
    public double getKoers() {
        return this.koers;
    }
    
    @Override
    public String toString(){
        return naam + " : " + koers;
    }
    
}
