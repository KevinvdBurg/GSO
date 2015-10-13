/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aexbanner;

import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author milton
 */
public class MockEffectenbeurs  implements IEffectenbeurs
{
    private Timer timer;
    private ArrayList<IFonds> fonds;

    @Override
    public ArrayList<IFonds> getCourses()
    {
        fonds = new ArrayList<>();

        return fonds;
    }

    public MockEffectenbeurs()
    {
        timer = new Timer();
        
        class RemindTask extends TimerTask
        {     
            @Override
            public void run()
            {
                fonds.clear();
                for (int i = 0; i <= 2; i++)
                {
                    Random r = new Random();
                    double course = 0 + (10 - 0) * r.nextDouble();

                    course = Math.round(course * 100.0) / 100.0;

                    IFonds fond = new Fonds(" Bedrijf " + (i+1) + " ", course);
                    fonds.add(fond);
                }
            }
        } 
        
        timer.schedule(new RemindTask(), 0, 1000000000);
    }
    
    
}
