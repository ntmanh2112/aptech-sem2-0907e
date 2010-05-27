package Assignment1;

public class AccountManager {

	/*
	 *  
	 */
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		CustomerAccount srcAcc= new CustomerAccount("loc",90000.0);
		CustomerAccount desAcc= new CustomerAccount("linh",50000.0);
			
		System.out.println("the balance of " + srcAcc.getAccountType() + " is: " + srcAcc.getBalance());
		System.out.println("the balance of " + desAcc.getAccountType() + " is: " + desAcc.getBalance());
		TransferManager trans= new TransferManager(srcAcc,desAcc);
		Thread transfer= new Thread(trans);
		transfer.run();
		transfer.join();
		
		System.out.println("After transfer balance, the balance of " + srcAcc.getAccountType() + " is: " + srcAcc.getBalance());
		System.out.println("After transfer balance, the balance of " + desAcc.getAccountType() + " is: " + desAcc.getBalance());
		
		
			
	}
	
}
