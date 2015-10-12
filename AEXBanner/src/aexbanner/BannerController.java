package AEXBanner;

import java.util.Timer;
import java.util.TimerTask;

public class BannerController {
    private AEXBanner aEXBanner;
    private IEffectenbeurs effectenbeurs;
    private Timer timer;
    
    public static void main(String[] args)
    {
        
    }
    
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