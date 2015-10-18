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
    private ArrayList<IFonds> fonds;
    private Timer timer;
    
    public MockEffectenbeurs()
    {
        fonds = new ArrayList<>();
        timer = new Timer();
        class RemindTask extends TimerTask
        {
            @Override
            public void run()
            {
                ChangeFonds();
            }
        }
        timer.schedule(new RemindTask(), 1, 1000);
    }
    
    @Override
    public ArrayList<IFonds> getCourses()
    { 
        //fonds = new ArrayList<>();
        
        return fonds;
    } 
    
    public void ChangeFonds(){
        
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
