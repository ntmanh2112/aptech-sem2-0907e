package lab1;

public class Account {

	public synchronized void deposit(double amount){
		
		System.out.println("Step 1 : check amount ");
		System.out.println("Step 2 : transaction processing ");
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Step 3 : deposited  " + amount);
	}
	
	public void deposit1(double amount) {
		
		System.out.println("Step 1 : check amount ");
		System.out.println("Step 2 : transaction processing ");
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Step 3 : deposited  " + amount);
	}
	
	public double getBalance() {
		return 0;
	}
}
