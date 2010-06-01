package lab2;

import java.io.IOException;

public class RunOSProgram {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Runtime rt = Runtime.getRuntime();
		
		Process proc;
		
		
		try {
			if(System.getProperty("os.name").startsWith("Windows")) {
				
					proc = rt.exec("notepad");
				
			}
			else {
				proc = rt.exec("gedit");
			}
			
				try {
					proc.waitFor();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("notepad is an unknow command .");
		}
		
		
	}

}
