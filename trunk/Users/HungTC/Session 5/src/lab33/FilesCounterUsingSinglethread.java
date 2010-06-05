package lab33;

import java.util.Scanner;

public class FilesCounterUsingSinglethread {
	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		while (true) {
			System.out
					.println("please choose the files you want to count lines: \n1. one file"
							+ "\n2. two files \n5. five files \n 6.exit\n your choice: ");
			int choice;
			Scanner input = new Scanner(System.in);

			choice = input.nextInt();

			switch (choice) {
			case 1:
				LineCounter lineCounter = new LineCounter(
						"F:\\WorkSpace\\Session 5\\src\\lab33\\one.txt");
				lineCounter.start();
				break;
			case 2:
				LineCounter lineCounter1 = new LineCounter(
						"F:\\WorkSpace\\Session 5\\src\\lab33\\one.txt");
				LineCounter lineCounter2 = new LineCounter(
						"F:\\WorkSpace\\Session 5\\src\\lab33\\two.txt");
				try {
					lineCounter1.join();
					lineCounter2.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
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
				LineCounter lineCounter11 = new LineCounter(
						"F:\\WorkSpace\\Session 5\\src\\lab33\\one.txt");

				LineCounter lineCounter22 = new LineCounter(
						"F:\\WorkSpace\\Session 5\\src\\lab33\\twotxt");

				LineCounter lineCounter3 = new LineCounter(
						"F:\\WorkSpace\\Session 5\\src\\lab33\\three.txt");
				LineCounter lineCounter4 = new LineCounter(
						"F:\\WorkSpace\\Session 5\\src\\lab33\\four.txt");
				LineCounter lineCounter5 = new LineCounter(
						"F:\\WorkSpace\\Session 5\\src\\lab33\\five.txt");
				try {
					lineCounter11.join();
					lineCounter22.join();
					lineCounter3.join();
					lineCounter4.join();
					lineCounter5.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
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
