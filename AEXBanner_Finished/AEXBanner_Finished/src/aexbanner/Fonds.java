/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aexbanner;

import java.util.Random;

/**
 *
 * @author HP user
 */
public class Fonds implements IFonds{
    Random rnd = new Random();
    int a;
    public Fonds(int a){
        this.a = a;
    }
            
    public enum Names {
    Kevin_Inc,salamiCorp,Miltonius_Enterprise,MineCon;
    }
    
    @Override
    public String getNaam() {
        
        switch(a){
            case(1):                          
                return Names.Kevin_Inc.toString();
            case(2):
                return Names.salamiCorp.toString();    
            case(3):
                return Names.Miltonius_Enterprise.toString();
            default:
                return Names.MineCon.toString();
        }
        
               
    }

    @Override
    public double getKoers() {
        
        Random random = new Random();
        int a = random.nextInt(99 - 10 + 1) + 10;
        
        
        return a;
    }
    
}
