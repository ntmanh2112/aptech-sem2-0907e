package filecopier;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;


public class CopyFile {
    
 
    public CopyFile() {
    }
    

    public static void main(String[] args) {
        System.out.println("\t **** Welcome to the File Copier " +
                "Application ****");
        try {
            // Accept the location of the source file
            System.out.println("Enter the path of source file along " +
                    "with the filename:");
            Scanner input = new Scanner(System.in);
            String path = input.next();
            
            // Create a File object
            File fileName = new File(path);
            String location = path.substring(0,
                    path.indexOf(fileName.getName()));
            
            // Create an stream to read from the file
            FileInputStream fin = new FileInputStream(path);
            
            // Accept the location where the file is to be copied
            System.out.println("\n Enter the path where file is to be copied:");
            String copy = input.next();
            
            // Check if the location of the file is the same as the location
            // where the file is to be copied
            if (copy.equals(location)) {
                System.out.println("The source and the destination " +
                        "path are the same!");
                
                // Close all system resources
                fin.close();
                System.exit(0);
            } else {
                // Create a stream to write to the copy
                FileOutputStream fout = new FileOutputStream(copy +
                        fileName.getName());
                int data;
                while((data = fin.read()) != -1) 
                {
                    fout.write(data);                    
                }
                    
                System.out.println("A copy of the file :" + fileName.getName()+
                        "has been successfully created at the location :" +
                        copy + fileName.getName() + "!");
                
                // Close all system resources
                fin.close();
                fout.close();
            }
        } catch (Exception e) {
            //
        }
    }
}