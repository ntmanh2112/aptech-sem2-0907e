package lab1_3;

public class RunJaThread{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JaThread mythread1= new JaThread();
		JaThread mythread2= new JaThread();
		JaThread mythread3= new JaThread();
		Thread myThread1 = new Thread(mythread1);
		Thread myThread2 = new Thread(mythread2);
		Thread myThread3 = new Thread(mythread3);
		myThread1.setName("First");
		myThread2.setName("Second");
		myThread3.setName("Third");

		myThread1.start();
		myThread2.start();
		myThread3.start();
		
	    while(Thread.activeCount() >= 1) {
		if(Thread.activeCount()==1) {  
		System.out.println("Main thread exiting.");
		break;
		}
	    }
	}

}
