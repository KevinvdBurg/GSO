package server;

import shared.IFonds;

/**
 *
 * @author Kevin van der Burg & Milton van de Sanden
 */
public class Koers implements IFonds {
    private String name;
    private double value;
    
    public Koers(String name, double value) {
        this.name = name;
        this.value = value;
    }
    
    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getValue() {
        return value;
    }
    
    public void setValue(double value) {
        this.value = value;
    }
    
}