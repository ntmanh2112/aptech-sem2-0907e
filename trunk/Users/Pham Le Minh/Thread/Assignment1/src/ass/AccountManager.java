package ass;

public class AccountManager {
	
	public static void main (String[] agrs) {
		CustomerAccount src = new CustomerAccount("VIP", 10000);
		CustomerAccount des = new CustomerAccount("NOR", 5000);
		
		System.out.println("So tien cua tai khoan nguon truoc khi chuyen la : " + src.getBalance());
		System.out.println("So tien cua tai khoan dich truoc khi chuyen la : " + des.getBalance());
		
		Runnable transfer = new TransferManager(src, des);
		Thread t = new Thread(transfer);
		t.start();
		
			try {
				t.join();
			} catch (Exception e) {
			}
			
		System.out.println("So tien cua tai khoan nguon sau khi chuyen la : " + src.getBalance());
		System.out.println("So tien cua tai khoan dich sau khi chuyen la : " + des.getBalance());
	}
}
