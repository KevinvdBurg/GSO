/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aexbanner;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author HP user
 */
public class MockEffectenbeurs implements IEffectenbeurs{
    
    private List<IFonds> fondsen = new ArrayList<IFonds>();
    
    @Override
    public List<IFonds> getKoersen() {
        
        Koers f = new Koers("Kevin Corp", getRandomKoers());
        Koers f1= new Koers("Martin Corp", getRandomKoers());
        Koers f2 = new Koers("Milton Corp", getRandomKoers());
        Koers f3 = new Koers("Mark Corp", getRandomKoers());
        
        fondsen.add(f);
        fondsen.add(f1);
        fondsen.add(f2);
        fondsen.add(f3);
        
        return fondsen;
    }
    
     public double getRandomKoers() {
        
        Random random = new Random();
        int a = random.nextInt(99 - 10 + 1) + 10;
        return a;
    }
    
}
