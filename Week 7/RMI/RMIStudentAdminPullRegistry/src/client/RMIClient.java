/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;
import shared.IStudentAdmin;
import shared.Student;

/**
 * Example of RMI using Registry
 *
 * @author Nico Kuijpers
 */
public class RMIClient {

    // Set binding name for student administration
    private static final String bindingName = "MockEffectenbeurs";

    // References to registry and student administration
    private Registry registry = null;
    private IStudentAdmin studentAdmin = null;

    // Constructor
    public RMIClient(String ipAddress, int portNumber) {

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
                studentAdmin = (IStudentAdmin) registry.lookup(bindingName);
            } catch (RemoteException ex) {
                System.out.println("Client: Cannot bind student administration");
                System.out.println("Client: RemoteException: " + ex.getMessage());
                studentAdmin = null;
            } catch (NotBoundException ex) {
                System.out.println("Client: Cannot bind student administration");
                System.out.println("Client: NotBoundException: " + ex.getMessage());
                studentAdmin = null;
            }
        }

        // Print result binding student administration
        if (studentAdmin != null) {
            System.out.println("Client: Student administration bound");
        } else {
            System.out.println("Client: Student administration is null pointer");
        }

        // Test RMI connection
        if (studentAdmin != null) {
            testStudentAdministration();
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

    // Test RMI connection
    private void testStudentAdministration() {
        // Get number of students
        try {
            System.out.println("Client: Number of students: " + studentAdmin.getNumberOfStudents());
        } catch (RemoteException ex) {
            System.out.println("Client: Cannot get number of students");
            System.out.println("Client: RemoteException: " + ex.getMessage());
        }

        // Add student Jan to student administration
        try {
            Student jan = studentAdmin.addStudent("Jan", "Jansen", 1995);
            System.out.println("Client: Student " + jan.toString() + " added to student administration");
        } catch (RemoteException ex) {
            System.out.println("Client: Cannot add first student to student administration");
            System.out.println("Client: RemoteException: " + ex.getMessage());
        }

        // Add Student Piet to student administration
        try {
            Student piet = studentAdmin.addStudent("Piet", "Pietersen", 1994);
            System.out.println("Client: Student " + piet.toString() + " added to student administration");
        } catch (RemoteException ex) {
            System.out.println("Client: Cannot add second student to student administration");
            System.out.println("Client: RemoteException: " + ex.getMessage());
        }

        // Get number of students
        try {
            System.out.println("Client: Number of students: " + studentAdmin.getNumberOfStudents());
        } catch (RemoteException ex) {
            System.out.println("Client: Cannot get number of students");
            System.out.println("Client: RemoteException: " + ex.getMessage());
        }

        // Get first student
        try {
            System.out.println("Client: First student: " + studentAdmin.getStudent(0));
        } catch (RemoteException ex) {
            System.out.println("Client: Cannot get first student");
            System.out.println("Client: RemoteException: " + ex.getMessage());
        }

        // Get second student
        try {
            System.out.println("Client: Second student: " + studentAdmin.getStudent(1));
        } catch (RemoteException ex) {
            System.out.println("Client: Cannot get second student");
            System.out.println("Client: RemoteException: " + ex.getMessage());
        }

        // Get third student (does not exist)
        try {
            System.out.println("Client: Third student: " + studentAdmin.getStudent(2));
        } catch (RemoteException ex) {
            System.out.println("Client: Cannot get third student");
            System.out.println("Client: RemoteException: " + ex.getMessage());
        }
    }

    // Main method
    public static void main(String[] args) {

        // Welcome message
        System.out.println("CLIENT USING REGISTRY");

        // Get ip address of server
        Scanner input = new Scanner(System.in);
        System.out.print("Client: Enter IP address of server: ");
        String ipAddress = input.nextLine();

        // Get port number
        System.out.print("Client: Enter port number: ");
        int portNumber = input.nextInt();

        // Create client
        RMIClient client = new RMIClient(ipAddress, portNumber);
    }
}
