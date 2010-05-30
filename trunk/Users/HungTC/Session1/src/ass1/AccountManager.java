package ass1;

public class AccountManager {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		CustomerAccount srcAcc= new CustomerAccount();
		CustomerAccount desAcc= new CustomerAccount();
			srcAcc.input();
			desAcc.input();
		System.out.println("the balance of" + srcAcc.getAccountType() + " is: " + srcAcc.getBalance());
		System.out.println("the balance of" + desAcc.getAccountType() + " is: " + desAcc.getBalance());
		TransferManager trans= new TransferManager(srcAcc,desAcc);
		Thread transfer= new Thread(trans);
		transfer.run();
		transfer.join();
		
		System.out.println("After transfer, the balance of" + srcAcc.getAccountType() + " is: " + srcAcc.getBalance());
		System.out.println("After transfer, the balance of" + desAcc.getAccountType() + " is: " + desAcc.getBalance());
		
		
			
	}
	
}
