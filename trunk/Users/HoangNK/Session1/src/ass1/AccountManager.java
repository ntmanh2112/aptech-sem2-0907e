package ass1;

public class AccountManager {
	public static void main(String[] args) {
		CustomerAccount srcAccount = new CustomerAccount("VIP",10000);
		CustomerAccount desAccount = new CustomerAccount("NOR",3000);
		System.out.println("Current srcAccount before transfer is "+ srcAccount.getBalance());
		System.out.println("Current desAccount before transfer is "+ desAccount.getBalance());
		Runnable transfer =new TransferManager(srcAccount,desAccount);
		Thread t = new Thread(transfer);
		t.start();
		try {
			t.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Current srcAccount after transfer is "+ srcAccount.getBalance());
		System.out.println("Current desAccount after transfer is "+ desAccount.getBalance());
	}
}
