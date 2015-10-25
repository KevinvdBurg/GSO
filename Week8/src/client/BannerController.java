/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import shared.IEffectenbeurs;
import shared.IFonds;
import shared.IRemotePropertyListener;
import server.RMIServer;
import java.beans.PropertyChangeEvent;
import java.io.Serializable;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kevin van der Burg & Milton van de Sanden
 */

public class BannerController extends UnicastRemoteObject implements IRemotePropertyListener, Serializable {

    private transient AEXBanner banner;
    private transient IEffectenbeurs beurs;
    private Registry client;

    /**
     * Public constructor
     * @param banner AEXBanner instance die Application overeft.
     * @throws RemoteException
     */
    public BannerController(AEXBanner banner) throws RemoteException {
        try {
            this.banner = banner;
            this.client = LocateRegistry.getRegistry(RMIServer.PORT);
            
            ((IEffectenbeurs) client.lookup("beurs")).addListener(this, "fonds");
        } catch (RemoteException | NotBoundException ex) {
            Logger.getLogger(BannerController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Stopt beide timers. In de controller maar ook effectenbeurs.
     */
    public void stop() {
        try {
            ((IEffectenbeurs) client.lookup("beurs")).removeListener(this, "fonds");
        } catch (RemoteException | NotBoundException ex) {
            Logger.getLogger(BannerController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void updateString(List<IFonds> fonds) {
        try {
            StringBuilder b = new StringBuilder();
            
            for(IFonds s : fonds)
                b.append(String.format("%s %02.2f \t\t", s.getName(), s.getValue()));
            
            banner.setValues(b.toString());
        } catch (RemoteException ex) {
            Logger.getLogger(BannerController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
        public void propertyChange(PropertyChangeEvent evt) throws RemoteException {
                updateString((List<IFonds>) evt.getNewValue());
        }    
}
