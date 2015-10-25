package shared;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Kevin van der Burg & Milton van de Sanden
 */
public interface IFonds extends Remote, Serializable {
    
    /**
     * Get the name of this stock
     * @return name of stock
     * @throws RemoteException when RMI does not like you 
     */
    public String getName() throws RemoteException;
    
    /**
     * Get the value of this stock
     * @return double value of this stock
     * @throws RemoteException when RMI does not like you
     */
    public double getValue() throws RemoteException;
}
