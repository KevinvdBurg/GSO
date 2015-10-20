/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;
import shared.IStudentAdmin;
import shared.Student;

/**
 * Example of RMI using Naming
 *
 * @author Nico Kuijpers
 */
public class RMIClient {

    // Set binding name for student administration
    private static final String bindingName = "StudentAdmin";

    // Reference to student administration
    private IStudentAdmin studentAdmin = null;

    // Constructor
    public RMIClient(String ipAddress, int portNumber) {

        // Print IP address and port number for registry
        System.out.println("Client: IP Address: " + ipAddress);
        System.out.println("Client: Port number " + portNumber);

        // Bind student administration using Naming
        try {
            studentAdmin = (IStudentAdmin) Naming.lookup("rmi://" + ipAddress + ":" + portNumber + "/" + bindingName);
        } catch (MalformedURLException ex) {
            System.out.println("Client: Cannot bind student administration");
            System.out.println("Client: MalformedURLException: " + ex.getMessage());
            studentAdmin = null;
        } catch (RemoteException ex) {
            System.out.println("Client: Cannot bind student administration");
            System.out.println("Client: RemoteException: " + ex.getMessage());
            studentAdmin = null;
        } catch (NotBoundException ex) {
            System.out.println("Client: Cannot bind student administration");
            System.out.println("Client: NotBoundException: " + ex.getMessage());
            studentAdmin = null;
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
        System.out.println("CLIENT USING NAMING");

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
