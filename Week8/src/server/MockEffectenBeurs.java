package server;

import shared.IEffectenbeurs;
import shared.IFonds;
import shared.IRemotePropertyListener;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author Kevin van der Burg & Milton van de Sanden
 */
public class MockEffectenBeurs extends UnicastRemoteObject implements IEffectenbeurs {
    private List<IFonds> fonds;
    private transient Timer timer;
    private transient Random rand;
    private transient BasicPublisher publisher;
    
    public MockEffectenBeurs(List<IFonds> stocks) throws RemoteException {
        this.fonds = stocks;
        publisher = new BasicPublisher(new String[]{"fonds"});
    }
    
    public MockEffectenBeurs() throws RemoteException {
        fonds = new ArrayList<>();
        publisher = new BasicPublisher(new String[]{"fonds"});
    }
    
    @Override
    public List<IFonds> getValues() {        
        return Collections.unmodifiableList(fonds);
    }
    
    /**
     * Start random stock timer. Generates new values every 3 seconds.
     */
    public void start() {
        if(timer == null) {
            this.rand = new Random();
            this.timer = new Timer();
            this.timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    fonds.stream().forEach((f) -> {
                        ((Koers) f).setValue(rand.nextDouble() + rand.nextInt(100));
                    });
                    publisher.inform(this, "fonds", null, getValues());
                }      
            }, 0, 3000);
        }
    }
    
    /**
     * Stop random stock timer.
     */
    public void stop() {
        if(timer != null)
            this.timer.cancel();
    }
    
    @Override
    public void addListener(IRemotePropertyListener listener, String property) throws RemoteException {
        publisher.addListener(listener, property);
    }
    
    @Override
    public void removeListener(IRemotePropertyListener listener, String property) throws RemoteException {
        publisher.removeListener(listener, property);
    }
}
