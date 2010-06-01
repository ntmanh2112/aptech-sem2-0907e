package Ass1;

public class AccountManager {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		CustomerAccount srcAcc= new CustomerAccount();
		CustomerAccount desAcc= new CustomerAccount();
			srcAcc.nhapAccount();
			desAcc.nhapAccount();
		System.out.println("Tai khoan cua " + srcAcc.getAccountType() + " la: " + srcAcc.getBalance());
		System.out.println("Tai khoan cua " + desAcc.getAccountType() + " la: " + desAcc.getBalance());
		Transfer trans= new Transfer(srcAcc,desAcc);
		Thread transfer= new Thread(trans);
		transfer.run();
		transfer.join();
		
		System.out.println("Tai khoan sau khi gui cua " + srcAcc.getAccountType() + " la : " + srcAcc.getBalance());
		System.out.println("Tai khoan sau khi gui cua " + desAcc.getAccountType() + " la: " + desAcc.getBalance());
		
		
			
	}
	
}
