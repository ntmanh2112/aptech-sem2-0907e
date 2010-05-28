package ass1;

import java.util.Scanner;

public class TransferManager implements Runnable{
	private int transferCount;
	private CustomerAccount srcAccount;
	private CustomerAccount desAccount;

	public TransferManager(CustomerAccount src,CustomerAccount des){
		this.srcAccount = src;
		this.desAccount = des;
	}
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Please enter amount for transfer ");
		Scanner input=new Scanner(System.in);
		double transferAmount = input.nextDouble();
		if(transferAmount < srcAccount.getBalance()){
			srcAccount.setBalance(srcAccount.getBalance() - transferAmount);
			desAccount.setBalance(desAccount.getBalance() + transferAmount);
			transferCount++;
		} else {
			System.out.println("Sorry,your balance is not enough money");
		}
		
	}

}
