package lab2_3;

import java.io.IOException;
import java.util.Scanner;

public class RunProgram {

	public RunProgram(){
		
	}
	public void Program(String namePro) {
		// TODO Auto-generated method stub
		
		Runtime rt = Runtime.getRuntime();
		
		Process proc;
		
		
		try {
			if(System.getProperty("os.name").startsWith("Windows")) {
				
					proc = rt.exec(namePro);
				
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
			System.out.println(namePro + " is an unknow command .");
		}
		
	}
	
	public void kt(int kt) {
		
		if(kt == 1){
			this.Program("C:/Program Files/Microsoft Office/Office14/WINWORD.exe");
			this.nhapSo();
		}else if(kt == 2){
			this.Program("C:/Program Files/Microsoft Office/Office14/EXCEL.exe");
			this.nhapSo();
		}else if(kt == 3){
			this.Program("calc.exe");
			this.nhapSo();
		}else if(kt == 4){
			
		}
	}
	
	public void nhapSo(){
		
		Scanner input = new Scanner(System.in);
		System.out.println("Run My Favourite Program");
		System.out.println("1.WinWord");
		System.out.println("2.Excel");
		System.out.println("3.Calculator");
		System.out.println("4.Exit");
		System.out.println("Run.......");
		this.kt(input.nextInt());
	}
}