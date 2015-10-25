/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shared;

import java.io.Serializable;
import java.rmi.Remote;

/**
 *
 * @author Kevin van der Burg & Milton van de Sanden
 */
public interface IFonds extends Serializable  {
    String getNaam();
    double getKoers();
    
    @Override
    String toString();
}
