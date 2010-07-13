package frame;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import common.Constants;

public class OpenFile {
	
	public OpenFile(){
		JFileChooser fc = new JFileChooser();
		int returnVal = fc.showOpenDialog(null);
		  if (returnVal == JFileChooser.APPROVE_OPTION) {
	            File file = fc.getSelectedFile();
	            
	            FileReader fr = null;
				try {
					fr = new FileReader(file.getPath());
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	            BufferedReader br = new BufferedReader(fr);
	            String s = "";
	            String a;
	            try {
					while((a = br.readLine()) != null) {
						s += a;
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Constants.txtArea.setText(s);
				
				
				Constants.duongDan = file.getPath();
				try {
					fr.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
	            
	            //This is where a real application would open the file.
	           
	        } else {
	        	JOptionPane.showMessageDialog(null,"Open command cancelled by user.");
	        }

	}
}
