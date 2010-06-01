package lab2_2;


public class RunAcc {
	
	
	
	public static void main (String[] agrs) {
	
		Runnable transfer = new Manager();
		Thread thread = new Thread(transfer);
		thread.start();
		
		
		
	}
}
