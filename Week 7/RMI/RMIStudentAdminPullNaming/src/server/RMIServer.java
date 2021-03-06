/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/**
 * Example of RMI using Naming
 *
 * @author Nico Kuijpers
 */
public class RMIServer {

    // Set port number
    private static final int portNumber = 1099;

    // Set binding name for student administration
    private static final String bindingName = "StudentAdmin";

    // Reference to student administration
    private StudentAdmin studentAdmin = null;

    // Constructor
    public RMIServer() {

        // Print port number for registry
        System.out.println("Server: Port number " + portNumber);

        // Create student administration
        try {
            studentAdmin = new StudentAdmin();
            System.out.println("Server: Student administration created");
        } catch (RemoteException ex) {
            System.out.println("Server: Cannot create student administration");
            System.out.println("Server: RemoteException: " + ex.getMessage());
            studentAdmin = null;
        }

        // Bind student adiministration using Naming
        if (studentAdmin != null) {
            try {
                LocateRegistry.createRegistry(portNumber);
                Naming.rebind(bindingName, studentAdmin);
            } catch (MalformedURLException ex) {
                System.out.println("Server: Cannot bind student administration");
                System.out.println("Server: MalformedURLException: " + ex.getMessage());
            } catch (RemoteException ex) {
                System.out.println("Server: Cannot bind student administration");
                System.out.println("Server: RemoteException: " + ex.getMessage());
            }
            System.out.println("Server: Student administration bound to " + bindingName);
        } else {
            System.out.println("Server: Student administration not bound");
        }
    }

    // Print IP addresses and network interfaces
    private static void printIPAddresses() {
        try {
            InetAddress localhost = InetAddress.getLocalHost();
            System.out.println("Server: IP Address: " + localhost.getHostAddress());
            // Just in case this host has multiple IP addresses....
            InetAddress[] allMyIps = InetAddress.getAllByName(localhost.getCanonicalHostName());
            if (allMyIps != null && allMyIps.length > 1) {
                System.out.println("Server: Full list of IP addresses:");
                for (InetAddress allMyIp : allMyIps) {
                    System.out.println("    " + allMyIp);
                }
            }
        } catch (UnknownHostException ex) {
            System.out.println("Server: Cannot get IP address of local host");
            System.out.println("Server: UnknownHostException: " + ex.getMessage());
        }

        try {
            System.out.println("Server: Full list of network interfaces:");
            for (Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces(); en.hasMoreElements();) {
                NetworkInterface intf = en.nextElement();
                System.out.println("    " + intf.getName() + " " + intf.getDisplayName());
                for (Enumeration<InetAddress> enumIpAddr = intf.getInetAddresses(); enumIpAddr.hasMoreElements();) {
                    System.out.println("        " + enumIpAddr.nextElement().toString());
                }
            }
        } catch (SocketException ex) {
            System.out.println("Server: Cannot retrieve network interface list");
            System.out.println("Server: UnknownHostException: " + ex.getMessage());
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // Welcome message
        System.out.println("SERVER USING NAMING");

        // Print IP addresses and network interfaces
        printIPAddresses();

        // Create server
        RMIServer server = new RMIServer();
    }
}
