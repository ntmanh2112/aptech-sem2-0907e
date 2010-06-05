package lab22;

import java.util.Random;

public class Transaction extends Thread{
	int amount;
	String name;
	public Transaction(Accounts acc) {
		amount = acc.balance;	
		System.out.println("before deposit the balance of "+acc.name+" is: "+amount );
		name = acc.name;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();	
		Random ran = new Random();
	amount = amount + ran.nextInt(101);
	
		WaitingClass wait = new WaitingClass(amount);
	wait.waitForYou(name, false);	
	
	System.out.println("after deposit, "+name+" , the balance is: "+amount);

	
	
	
	
}		

	}
