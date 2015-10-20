/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aexbanner;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author HP user
 */
public class MockEffectenbeurs implements IEffectenbeurs, Serializable, Remote{ 
    
    private List<IFonds> fondsen = new ArrayList<IFonds>();

    public Koers setKoers(String naam, int koers){
        Koers newKoers = new Koers(naam, koers);
        
        for(IFonds koer :  fondsen){
            if (koer.getNaam().equals(newKoers.getNaam()))
            {
                koer = newKoers;
            }
        }
        fondsen.add(newKoers);
        return newKoers;
    }
    
    @Override
    public List<IFonds> getKoersen() throws RemoteException { 
        return fondsen;
    }
    
     public int getRandomKoers() throws RemoteException {
        
        Random random = new Random();
        int a = random.nextInt(99 - 10 + 1) + 10;
        return a;
    }
    
}
