package server;

import shared.IFonds;

/**
 *
 * @author Kevin van der Burg & Milton van de Sanden
 */
public class Koers implements IFonds {
    private String name;
    private double koers;
    
    public Koers(String name, double koers) {
        this.name = name;
        this.koers = koers;
    }
    
    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getKoers() {
        return this.koers;
    }
    
    public void setKoers(double koers) {
        this.koers = koers;
    }
    
}