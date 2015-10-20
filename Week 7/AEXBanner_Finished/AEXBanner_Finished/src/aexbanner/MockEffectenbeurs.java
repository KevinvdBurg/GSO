/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aexbanner;

import java.io.Serializable;
import java.rmi.Remote;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author HP user
 */
public class MockEffectenbeurs implements IEffectenbeurs, Serializable, Remote{ 
    
    private List<IFonds> fondsen = new ArrayList<IFonds>();

    public void setKoers(String naam, int koers){
        Koers newKoers = new Koers(naam, koers);
        
        for(IFonds koer :  fondsen){
            if (koer.getNaam().equals(newKoers.getNaam()))
            {
                koer = newKoers;
                return;
            }
            
        }
        fondsen.add(newKoers);
    }
    
    @Override
    public List<IFonds> getKoersen(){
        return fondsen;
    }
    
     public double getRandomKoers() {
        
        Random random = new Random();
        int a = random.nextInt(99 - 10 + 1) + 10;
        return a;
    }
    
}
