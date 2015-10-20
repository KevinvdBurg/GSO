/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aexbanner;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HP user
 */
public class MockEffectenbeurs implements IEffectenbeurs{
    
    private List<IFonds> fondsen = new ArrayList<IFonds>();
    
    @Override
    public List<IFonds> getKoersen() {
        Fonds f = new Fonds(0);
        Fonds f1 = new Fonds(1);
        Fonds f2 = new Fonds(2);
        Fonds f3 = new Fonds(3);
        fondsen.add(f);
        fondsen.add(f1);
        fondsen.add(f2);
        fondsen.add(f3);
        
        return fondsen;
    }
    
}
