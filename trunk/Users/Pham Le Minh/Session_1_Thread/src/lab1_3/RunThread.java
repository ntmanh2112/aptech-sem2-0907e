package lab1_3;

public class RunThread {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Runnable t1 = new JaThread();
		Runnable t2 = new JaThread();
		Runnable t3 = new JaThread();
		
		Thread t4 = new Thread(t1);
		Thread t5 = new Thread(t2);
		Thread t6 = new Thread(t3);
		
		t4.setName("First");
		t5.setName("Second");
		t6.setName("Third");
		
		t4.start();
		t5.start();
		t6.start();
		try {
			t6.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Main thread exiting");
		

	}

}
