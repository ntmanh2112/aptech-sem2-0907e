package Ass1;

import java.util.Scanner;

public class Transfer implements Runnable{
	
	CustomerAccount srcAcc,desAcc;
	private int transferCount; 
	double transferMoney;
	public Transfer(CustomerAccount srcAcc, CustomerAccount desAcc){
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
		
		System.out.println("nhap so tien ban  muon gui: ");
		Scanner input=new Scanner(System.in);
		transferMoney=input.nextDouble();
		while(transferMoney>srcAcc.getBalance()||transferMoney<0) {
			System.out.println("so tien gui > so tien trong tai khoan: ");
			transferMoney=input.nextDouble();
		}
		srcAcc.setBalance(srcAcc.getBalance() - transferMoney);
		desAcc.setBalance(desAcc.getBalance() + transferMoney);
		
		
		
	}
	

}
