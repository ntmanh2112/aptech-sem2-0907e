package lab33;

import java.util.Scanner;

public class FilesCounterUsingMultithreads {

	/**
	 * @param args
	 */
	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
while (true) {
		System.out.println("please choose the files you want to count lines: \n1. one file" +
				"\n2. two files \n5. five files \n 6.exit\n your choice: ");
		int choice;
		Scanner input = new Scanner(System.in);
		
		choice= input.nextInt();
		
switch 	(choice) {
case 1:
	LineCounter lineCounter = new LineCounter("F:\\WorkSpace\\Session 5\\src\\lab33\\one.txt");
	lineCounter.start();
	
	break;
case 2:
	LineCounter lineCounter1 = new LineCounter("F:\\WorkSpace\\Session 5\\src\\lab33\\one.txt");
	LineCounter lineCounter2 = new LineCounter("F:\\WorkSpace\\Session 5\\src\\lab33\\two.txt");
	lineCounter1.start();
	lineCounter2.start();
	while(Thread.currentThread().activeCount()!=1){
		try {
			Thread.currentThread().sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	System.out.println("time need to run: "+System.currentTimeMillis());
	
	
break;
case 5:
	LineCounter lineCounter11 = new LineCounter("F:\\WorkSpace\\Session 5\\src\\lab33\\one.txt");
	lineCounter11.start();
	LineCounter lineCounter22 = new LineCounter("F:\\WorkSpace\\Session 5\\src\\lab33\\twotxt");
	lineCounter22.start();
	LineCounter lineCounter3= new LineCounter("F:\\WorkSpace\\Session 5\\src\\lab33\\three.txt");
	lineCounter3.start();
	LineCounter lineCounter4 = new LineCounter("F:\\WorkSpace\\Session 5\\src\\lab33\\four.txt");
	lineCounter4.start();
	LineCounter lineCounter5 = new LineCounter("F:\\WorkSpace\\Session 5\\src\\lab33\\five.txt");
	lineCounter5.start();
	while(Thread.currentThread().activeCount()!=1){
		try {
			Thread.currentThread().sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	System.out.println("time need to run: "+System.currentTimeMillis());
	
	
break;
case 6:
	System.exit(1);
break;
default:

	break;
}
}

	
	
	}

}
