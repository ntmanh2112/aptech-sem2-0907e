import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;


public class ReadFile {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i=0;
		FileInputStream fin = null;
		try {
			fin = new FileInputStream("F:\\WorkSpace\\Training\\src\\text.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		do {
			try {
				i = fin.read();
				if (i != -1)
					System.out.println((char)i+" ASCII: "+ new Integer(i));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}while(i!=-1);
		
		
		
		
		
		Scanner input = new Scanner(System.in);
		System.out.println("please insert any key: ");
		byte[] str = input.next().getBytes();
		for(int o=0; o < str.length ; o++){
			System.out.print("charactor: "+(char)str[o]+" ASCII:"+new Integer(str[0])+"\n");
		}

	DataOutputStream dos;
	try {
		dos = new DataOutputStream(new FileOutputStream("F:\\WorkSpace\\Training\\src\\text.txt"));
		try {
			dos.write(str);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	
	
	
	
	
	
	}

}
