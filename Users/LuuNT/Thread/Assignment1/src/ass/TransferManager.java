package ass;

import java.util.Scanner;

public class TransferManager implements Runnable {
	private CustomerAccount srcAccount;
	private CustomerAccount desAccount;
	private int transferCount = 0;
	
	/*
	 * 
	 */
	public TransferManager (CustomerAccount src, CustomerAccount des) {
		this.srcAccount = src;
		this.desAccount = des;
	}
	@Override
	public void run() {
		System.out.println("Nhap so tien can chuyen : ");
		Scanner input = new Scanner(System.in);
		double transferAmount = input.nextInt();
		if (transferAmount < srcAccount.getBalance()) {
			srcAccount.setBalance(srcAccount.getBalance() - transferAmount);
			desAccount.setBalance(desAccount.getBalance() + transferAmount);
			transferCount++;
		}else {
			System.out.println("So tien ban can chuyen lon hon so tien hien co");
		}
	}
}
