import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;


public class CopyFiles {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		String fileName;
		System.out.println("please input the path of source: ");
		Scanner input= new Scanner(System.in);
		fileName = input.nextLine();
		File path = new File(fileName);
		
			FileInputStream fin = new FileInputStream(path);
			
		
		System.out.println("please input the path where you want to copy: ");
		String fileCopyTo;
		fileCopyTo = input.next();
		FileOutputStream fos = new FileOutputStream(fileCopyTo+path.getName());
		int i=0;
		while(i != -1){
			
			try {				
				i=fin.read();
				if(i != -1){fos.write(i);}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
