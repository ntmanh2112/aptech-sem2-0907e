package lab2_3;

import java.util.Scanner;

public class RunOSProgram {
	public static void processWindows (String a) {
		Runtime rt = Runtime.getRuntime();
		Process proc;
		try {
		if (System.getProperty("os.name").startsWith("Windows")) {	
			proc = rt.exec(a);
		} else {
			proc = rt.exec("regedit");
		}
		proc.waitFor();
		} catch (Exception e) {
		System.out.println("notepad is an unknown command.");
		}
	}
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		System.out.println("RUN MY FAVOURITE PROGRAMS \n" +
				"1. Notepad \n" +
				"2. Paint \n" +
				"3. Microsoft Word \n" +
				"4. Microsoft Excel \n" +
				"5. Calculator \n" +
				"6. Internet Explorer \n" +
				"7. Windows Explorer \n" +
				"8. Exit \n" +
				"Run: ");
		int choice = input.nextInt();
		switch (choice) {
		case 1:
		{
			String a = "notepad";
			processWindows(a);
		}
			break;
		case 2:
		{
			String a = "mspaint.exe";
			processWindows(a);
		}
			break;
		case 3:
		{
			String a = "WINWORD.EXE";
			processWindows(a);
		}
			break;
		case 4:
		{
			String a = "EXCEL.EXE";
			processWindows(a);
		}
			break;
		case 5:
		{
			String a = "calc.exe";
			processWindows(a);
		}
			break;
		case 6:
		{
			String a = "iexplore.exe";
			processWindows(a);
		}
			break;
		case 7:
		{
			String a = "explorer.exe";
			processWindows(a);
		}
			break;
		case 8:
		{
			System.out.println("EXIT");
		}
			break;
		default:
			System.out.println("Bad choice");
			break;
		}
		
	}
}
