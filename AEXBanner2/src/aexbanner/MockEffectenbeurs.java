/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aexbanner;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author milton
 */
public class MockEffectenbeurs  implements IEffectenbeurs
{

    @Override
    public ArrayList<aexbanner.IFonds> getCourses()
    {
        ArrayList<aexbanner.IFonds> fonds = new ArrayList<>();
        
        for (int i = 0; i <= 2; i++)
        {
            Random r = new Random();
            double course = 0 + (10 - 0) * r.nextDouble();
            
            course = Math.round(course * 100.0) / 100.0;
            
            IFonds fond = new Fonds("testName", course);
            fonds.add(fond);
        }
        return fonds;
    }    
}
