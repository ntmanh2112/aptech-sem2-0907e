package lab1;

public class BankTransaction {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		

		Account aac = new Account();
		Account aac2 = new Account();
		
		Thread t1 = new Thread(new DepositTransaction(aac,1000));
		Thread t2 = new Thread(new DepositTransaction(aac2,2000));
		Thread t3 = new Thread(new DepositTransaction(aac,1000));
		
		t1.start();
		t2.start();
		t3.start();
	}

}
