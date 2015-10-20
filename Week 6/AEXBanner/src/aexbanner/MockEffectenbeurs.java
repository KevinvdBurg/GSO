package AEXBanner;

import java.util.ArrayList;
import java.util.Random;

public class MockEffectenbeurs implements IEffectenbeurs {

    @Override
    public ArrayList<aexbanner.IFonds> getCourses()
    {
        ArrayList<aexbanner.IFonds> fonds = new ArrayList<>();
        
        for (int i = 0; i <= 2; i++)
        {
            Random r = new Random();
            double course = 0 + (10 - 0) * r.nextDouble();
            
            IFonds fond = new Fonds("testName", course);
            fonds.add(fond);
        }
        return fonds;
    }
}