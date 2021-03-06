/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aexbanner;

import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author milton
 */
public class BannerController
{
    private IEffectenbeurs effectenbeurs;
    private Timer timer;
    private AEXBanner aEXBanner;
           
    /**
    * 
    * @param banner
    */
    public BannerController(AEXBanner banner) {
        this.aEXBanner = banner;
        this.effectenbeurs = new MockEffectenbeurs();
        
        timer = new Timer();
        
        class RemindTask extends TimerTask
        {
            @Override
            public void run()
            {
                String fonds = "";
                
                for(IFonds fond : effectenbeurs.getCourses())
                {
                    fonds += fond.getName() + ": " + fond.getCourse();
                }
                
                aEXBanner.setKoersen(fonds);
            }
        }
        timer.schedule(new RemindTask(), 1);
    }
    
    public void stop() {
        timer.cancel();
    }
    
}
