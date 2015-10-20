/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import shared.IFonds;
import shared.IEffectenbeurs;
import java.io.Serializable;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author HP user
 */
public class MockEffectenbeurs extends UnicastRemoteObject implements IEffectenbeurs{ 
    private static final String bindingName = "KoersAdmin";
    private Registry registry = null;
    //private List<Koers> koersen;
    private List<IFonds> fondsen = new ArrayList<IFonds>();
    
    public MockEffectenbeurs() throws RemoteException
    {
    }
    
    public Koers setKoers(String naam, int koers){
        Koers newKoers = new Koers(naam, koers);
        
        for(IFonds koer : fondsen){
            if (koer.getNaam().equals(newKoers.getNaam()))
            {
                koer = newKoers;
            }
        }
        fondsen.add(newKoers);
        System.out.println("beurs koersen: " + fondsen.toString());
        return newKoers;
    }
    
    @Override
    public List<IFonds> getKoersen() throws RemoteException {
//        System.out.println("beurs koersen: " + fondsen.toString());
        return fondsen;
    }
    
     public int getRandomKoers() throws RemoteException {
        
        Random random = new Random();
        int a = random.nextInt(99 - 10 + 1) + 10;
        return a;
    }    
}
