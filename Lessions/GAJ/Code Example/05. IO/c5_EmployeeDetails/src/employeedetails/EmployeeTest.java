/*
 * EmployeeTest.java
 *
 * This application demonstrates object serialization by writing an
 * Employee object to a text file.
 * Copyright © 2007 Aptech Software Limited. All Rights Reserved.
 */

package employeedetails;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

/**
 * This class allows the user to enter details of employees and writes them to a
 * text file.
 * @author vincent
 */
public class EmployeeTest {
    
    /**
     * Creates a new instance of EmployeeTest
     */
    public EmployeeTest() {
    }
    
    /**
     * This is the entry point of the application.
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        // Variable to store the choice made by the user
        String choice;
        Scanner input = new Scanner(System.in);
        do {
            // Accept the employee details from the user
            System.out.println("Enter the details of an Employee:");
            System.out.println("Name:");
            String name = input.next();
            System.out.println("Experience:");
            int experience = input.nextInt();
            System.out.println("Salary:");
            double salary = input.nextDouble();
            
            // Check if the user has entered all the values corectly
            if ((name.length() > 0) && (experience >= 0)
            && (salary >= 0.0)) {
                try {
                    // Create an object of the serializable class Employee.
                    Employee emp = new Employee(name, experience, salary);
                    
                    // Create a FileOutputStream to write to a file
                    FileOutputStream fos =
                            new FileOutputStream("employeeDetails.txt", true);
                    
                    // Create an ObjectOutputStream to write an object to a file
                    ObjectOutputStream outStream = new ObjectOutputStream(fos);
                    
                    // Write the information to the file.
                    outStream.writeObject(emp.toString());
                    System.out.println("Saved employee details in the file.");
                    
                    // Clear and close the ObjectOutputStream
                    outStream.flush();
                    outStream.close();
                    fos.close();
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                    System.out.println("The file to be copied could not be" +
                            " located!");
                } catch (IOException ex) {
                    ex.printStackTrace();
                    System.out.println("An error occurred while reading from" +
                            " the file!");
                }
            } else {
                System.out.println("Enter all the employee details correctly!");
            }
            System.out.println("Do you want to continue? (y/n)");
            choice = input.next();
        } while (!choice.equalsIgnoreCase("n"));
    }
}
