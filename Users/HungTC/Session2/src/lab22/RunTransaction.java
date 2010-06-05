package lab22;

import java.util.Scanner;

public class RunTransaction {
	static int choice = 0;
	static Scanner input = new Scanner(System.in);

	/**
	 * @param args
	 */
	public static int menuChoice() {
		System.out
				.println("Menu\n------------\n1. Create n accounts\n2.Do transactions\n3.exit\nyour choice: ");

		choice = input.nextInt();
		while (choice < 1 || choice > 3) {
			System.out.println("bad choice");
			System.out
					.println("Menu\n------------\n1. Create n accounts\n2.Do transactions\n3.exit\nyour choice: ");
			choice = input.nextInt();
		}
		return choice;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Accounts[] acc = new Accounts[10];
		int num = 0;
		Transaction[] tran;

		int again = 1;
		while (again == 1) {
			choice = menuChoice();
			switch (choice) {
			case 1:
				System.out.println("please insert the number of accs: ");
				num = input.nextInt();
				acc = new Accounts[num];
				for (int i = 0; i < num; i++) {
					System.out.println("please insert name of acc: ");
					String name = input.next();
					acc[i] = new Accounts(i, name);
				}
				again = 1;
				break;
			case 2:
				if (num == 0) {
					System.out.println("there are not any acc");
				}
				tran = new Transaction[num];
				for (int i = 0; i < num; i++) {
					tran[i] = new Transaction(acc[i]);
					tran[i].start();
				}
					
				
				try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
			WaitingClass waiting = new WaitingClass();
			waiting.waitForYou("main thread", true);				
				

				again = 0;
				break;
			case 3:
				System.out.println("exiting");
				again = 0;
				break;
			default:
				again = 0;
				break;
			}
		}
	}

}
