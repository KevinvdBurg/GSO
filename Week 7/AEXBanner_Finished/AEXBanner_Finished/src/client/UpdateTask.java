/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import shared.IEffectenbeurs;
import shared.IFonds;

/**
 *
 * @author milton
 */
class UpdateTask extends java.util.TimerTask
{
    private IEffectenbeurs beurs;
    private String koersen;
    private AEXBanner banner;
    
    public UpdateTask(IEffectenbeurs beurs, AEXBanner banner)
    {
        this.beurs = beurs;
        this.banner = banner;
    }
                
    @Override
    public void run()
    {
        koersen = "";
                   
        try
        {
            for(IFonds koers : beurs.getKoersen())
            {
                koersen += koers.toString();
            }
        } catch (RemoteException ex)
        {
            Logger.getLogger(RMIClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        banner.setKoersen(koersen);
    }
}