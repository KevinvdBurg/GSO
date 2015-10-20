/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.stage.Stage;
import shared.IFonds;
import shared.IEffectenbeurs;



/**
 * Example of RMI using Registry
 *
 * @author Nico Kuijpers
 */
public class RMIClient{

    // Set binding name for student administration
    private static final String bindingName = "KoersAdmin";

    // References to registry and student administration
    private Registry registry = null;
    private ArrayList<IFonds> koersen;
    private IEffectenbeurs beurs;
    private static AEXBanner banner;
    private static String ipAddress = "localhost";
    private static int portNumber = 1099;

    // Constructor
    public RMIClient(String ipAddress, int portNumber, AEXBanner banner) {
        
        
        this.banner = banner;
        this.ipAddress = ipAddress;
        this.portNumber = portNumber;
        
        // Print IP address and port number for registry
        System.out.println("Client: IP Address: " + ipAddress);
        System.out.println("Client: Port number " + portNumber);

        // Locate registry at IP address and port number
        try {
            registry = LocateRegistry.getRegistry(ipAddress, portNumber);
        } catch (RemoteException ex) {
            System.out.println("Client: Cannot locate registry");
            System.out.println("Client: RemoteException: " + ex.getMessage());
            registry = null;
        }

        // Print result locating registry
        if (registry != null) {
            System.out.println("Client: Registry located");
        } else {
            System.out.println("Client: Cannot locate registry");
            System.out.println("Client: Registry is null pointer");
        }

        // Print contents of registry
        if (registry != null) {
            printContentsRegistry();
        }

        // Bind student administration using registry
        if (registry != null) {
            try {
                
                beurs = (IEffectenbeurs) registry.lookup(bindingName);
            } catch (RemoteException ex) {
                System.out.println("Client: Cannot bind student administration");
                System.out.println("Client: RemoteException: " + ex.getMessage());
                beurs = null;
            } catch (NotBoundException ex) {
                System.out.println("Client: Cannot bind student administration");
                System.out.println("Client: NotBoundException: " + ex.getMessage());
                beurs = null;
            }
        }

        // Print result binding student administration
        if (beurs != null) {
            System.out.println("Client: Student administration bound");
        } else {
            System.out.println("Client: Student administration is null pointer");
        }

        // Test RMI connection
        if (koersen != null) {

            Timer timer = new Timer();
            
            class UpdateTask extends java.util.TimerTask
            {
                private IEffectenbeurs beurs;
                private String koersen;
                
                public UpdateTask(IEffectenbeurs beurs)
                {
                    this.beurs = beurs;
                }
                
                @Override
                public void run()
                {
                   koersen = "";
                   
                    try
                    {
                        for(IFonds koers : beurs.getKoersen())
                        {
                            koersen += koersen.toString();
                        }} catch (RemoteException ex)
                    {
                        Logger.getLogger(RMIClient.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    banner.setKoersen(koersen);
                }
            }
            
            timer.schedule(new UpdateTask(beurs), 1);
        }
    }

    // Print contents of registry
    private void printContentsRegistry() {
        try {
            String[] listOfNames = registry.list();
            System.out.println("Client: list of names bound in registry:");
            if (listOfNames.length != 0) {
                for (String s : registry.list()) {
                    System.out.println(s);
                }
            } else {
                System.out.println("Client: list of names bound in registry is empty");
            }
        } catch (RemoteException ex) {
            System.out.println("Client: Cannot show list of names bound in registry");
            System.out.println("Client: RemoteException: " + ex.getMessage());
        }
    }

    
    // Main method
    public static void main(String[] args) {
//
//        // Welcome message
//        System.out.println("CLIENT USING REGISTRY");
//
//        // Get ip address of server
//        Scanner input = new Scanner(System.in);
//        System.out.print("Client: Enter IP address of server: ");
//        String ipAddress = input.nextLine();
//
//        // Get port number
//        System.out.print("Client: Enter port number: ");
//        int portNumber = input.nextInt();

        // Create client
        RMIClient client = new RMIClient(ipAddress, portNumber, banner);
    }

}
