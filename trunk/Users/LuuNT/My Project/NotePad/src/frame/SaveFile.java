package frame;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import common.Constants;

public class SaveFile {

	
	
	

	public SaveFile(){
		
	}
	public SaveFile(String txt){
		if(Constants.duongDan.equals("")){
			JFileChooser fc = new JFileChooser();
			int returnVal = fc.showSaveDialog(null);
			  if (returnVal == JFileChooser.APPROVE_OPTION) {
		            File file = fc.getSelectedFile();
		            	char buffer[] = new char[txt.length()];
		            	txt.getChars(0, txt.length(), buffer, 0);
		            	FileWriter f0 = null;
						try {
							f0 = new FileWriter(file.getPath());
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		            	for (int i=0; i < buffer.length; i++) {
		            	try {
							f0.write(buffer[i]);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		            	}
		            	try {
							f0.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		            	
		            	
		    		
		          
		        } else {
		        	JOptionPane.showMessageDialog(null,"Open command cancelled by user.");
		        }
		}else{
		
			
		           
		            //This is where a real application would open the file.
			char buffer[] = new char[txt.length()];
        	txt.getChars(0, txt.length(), buffer, 0);
        	FileWriter f0 = null;
			try {
				f0 = new FileWriter(Constants.duongDan);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	for (int i=0; i < buffer.length; i++) {
        	try {
				f0.write(buffer[i]);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	}
        	try {
				f0.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	
		}


	}
}
