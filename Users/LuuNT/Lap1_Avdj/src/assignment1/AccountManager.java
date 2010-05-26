package assignment1;



public class AccountManager {

	public static void main (String[] agrs) {
		CustomAccount account1 = new CustomAccount("Xanh", 20000);
		CustomAccount account2 = new CustomAccount("Trang", 10000);
		
		System.out.println("So tien cua tai khoan 1 la : " + account1.getBalance());
		System.out.println("So tien cua tai khoan 2 la : " + account2.getBalance());
		
		Runnable transfer = new TransferManager(account1, account2);
		Thread thread = new Thread(transfer);
		thread.start();
		
			try {
				thread.join();
			} catch (Exception e) {
			}
			
		System.out.println("So tien cua tai khoan 1 sau khi chuyen la : " + account1.getBalance());
		System.out.println("So tien cua tai khoan 2 sau khi chuyen la : " + account2.getBalance());
	}
}
