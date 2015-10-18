/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aexbanner;

import java.util.Timer;
import java.util.TimerTask;
import javafx.application.Platform;

/**
 *
 * @author milton
 */
public class BannerController
{
    private IEffectenbeurs effectenbeurs;
    private Timer timer;
    private AEXBanner aEXBanner;
    private String fonds;
           
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
                GetAndSetFonds();
            }
        }
        timer.schedule(new RemindTask(), 1);
    }
    
    public void stop() {
        timer.cancel();
    }
    
    public void GetAndSetFonds(){
        fonds = "";
                
        for(IFonds fond : effectenbeurs.getCourses())
        {
            fonds += fond.getName() + " + " + fond.getCourse();
        }
        
        Platform.runLater(new Runnable()
        {
            @Override
            public void run()
            {
                aEXBanner.setKoersen(fonds);
            }
        });
        
    }
}
