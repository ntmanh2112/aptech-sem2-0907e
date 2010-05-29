package lab1;

public class DepositTransaction implements Runnable{

	private Account acc;
	private double amount;
	
	public DepositTransaction(Account acc , double amount) {
		this.acc = acc;
		this.amount = amount;
	}

	@Override
	public void run() {
		
		System.out.println("Deposit money");
		
		acc.deposit(amount);
		
		synchronized(acc) {
			
			acc.deposit1(amount);
		}
		
	}
}
