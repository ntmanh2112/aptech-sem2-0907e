package ass1;

import java.util.Scanner;



public class TransferManager implements Runnable{

	private CustomAccount account1;
	private CustomAccount account2;
	double total;
	
	/*
	 * 
	 */
	public TransferManager (CustomAccount account1, CustomAccount account2) {
		this.account1 = account1;
		this.account2 = account2;
	}
	@Override
	public void run() {
		System.out.println("So tien can chuyen : ");
		Scanner input = new Scanner(System.in);
		total = input.nextInt();
		if (total < account1.getBalance()) {
			account1.setBalance(account1.getBalance() - total);
			account2.setBalance(account2.getBalance() + total);
		}else {
			System.out.println("So Tien Cua Ban Khong Du De Chuyen");
		}
	}
}
