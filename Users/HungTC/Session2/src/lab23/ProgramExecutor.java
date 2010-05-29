package lab23;

import java.io.IOException;
import java.text.BreakIterator;
import java.util.Scanner;

import com.sun.org.apache.bcel.internal.generic.INVOKEVIRTUAL;

public class ProgramExecutor {
	
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		Runtime rt = Runtime.getRuntime(); 
		 
        Process proc; 
        int choice;
        System.out.println("RUN MY FAVOURITE PROGRAMS\n1.Notepad \n2.Paint \n3.Microsoft Word \n4.Microsoft Excel \n5.Calculator \n6.Internet Explorer \n7.Windows Explorer \n8.Exit \nRun: ");
        Scanner input = new Scanner(System.in);
        choice = input.nextInt();
        switch (choice) {
        case 1:
        	System.getProperty("os.name").startsWith("Windows"); 
            proc = rt.exec("notepad"); 
            break;
        case 2:
        	System.getProperty("os.name").startsWith("Windows"); 
            proc = rt.exec("mspaint");
            break;
        case 3:
        	System.getProperty("os.name").startsWith("Windows"); 
            proc = rt.exec("C:\Program Files\Microsoft Office\OFFICE11\Winword.exe winword");
            break;
        case 4:
        	System.getProperty("os.name").startsWith("Windows"); 
            proc = rt.exec("excel");
            break;
        case 5:
        	System.getProperty("os.name").startsWith("Windows"); 
            proc = rt.exec("calc");
            break;
        case 6:
        	System.getProperty("os.name").startsWith("Windows"); 
            proc = rt.exec("iexplore");
            break;
        case 7:
        	System.getProperty("os.name").startsWith("Windows"); 
            proc = rt.exec("explorer"); 
            break;
        default:
        	break;           	
        }
		// TODO Auto-generated method stub

	}

}
