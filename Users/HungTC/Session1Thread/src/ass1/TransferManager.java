package ass1;

import java.util.Scanner;

public class TransferManager implements Runnable{
	/*
	 * blablabla....
	 */
	CustomerAccount srcAcc,desAcc;
	private int transferCount; 
	double transferMoney;
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
		
		int yesNo=1,i=0;;
		while(yesNo == 1) {			
		setTransferCount(i++);
		System.out.println("How much do you want to transfer? Please type: ");
		Scanner input=new Scanner(System.in);
		transferMoney=input.nextDouble();
		while(transferMoney>srcAcc.getBalance()||transferMoney<0) {
			System.out.println("You do not have enough money or you did input wrong number. Try again: ");
			transferMoney=input.nextDouble();
		}
		srcAcc.setBalance(srcAcc.getBalance() - transferMoney);
		desAcc.setBalance(desAcc.getBalance() + transferMoney);
		System.out.println("Would you like to transfer again?\n1.yes\n2.no");
		yesNo = input.nextInt();
		if(yesNo > 2 || yesNo < 1) {
			System.out.println("Bad choice!");
			yesNo=0;
		}
		}
		
	}
	

}
