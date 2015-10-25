package shared;

import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author Kevin van der Burg & Milton van de Sanden
 */ 
public interface IEffectenbeurs extends IRemotePublisher  {
    public List<IFonds> getValues() throws RemoteException;
}
