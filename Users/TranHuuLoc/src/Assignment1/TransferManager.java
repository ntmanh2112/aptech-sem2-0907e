package Assignment1;

import java.util.Scanner;

public class TransferManager implements Runnable{
	/*
	 * 
	 */
	CustomerAccount srcAcc,desAcc;
	private int transferCount; 
	double WithrowBalance;
	public TransferManager(CustomerAccount srcAcc, CustomerAccount desAcc){
		 this.srcAcc=srcAcc;
		 this.desAcc=desAcc;		
	}
	public void setTransferCount(int transferCount) {
		this.transferCount = transferCount;
	}
	public int getTransferCount() {
		return transferCount;
	}
	@Override
	public void run() {
		System.out.println("input number tranfer loc change linh ? Please type: ");
		Scanner input=new Scanner(System.in);
		WithrowBalance=input.nextDouble();
		while(WithrowBalance>srcAcc.getBalance()||WithrowBalance<0) {
			System.out.println("No transfer. Try again: ");
			WithrowBalance=input.nextDouble();
		}
		srcAcc.setBalance(srcAcc.getBalance() - WithrowBalance);
		desAcc.setBalance(desAcc.getBalance() + WithrowBalance);
				
		
	}
	

}

