package Lab1_3;

public class RunNewThread{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NewThread mythread1= new NewThread("First");
		NewThread mythread2= new NewThread("Second");
		NewThread mythread3= new NewThread("Third");
		mythread1.setPriority(8);
		mythread2.setPriority(5);
		mythread3.setPriority(2);
		mythread1.start();
		mythread2.start();
		mythread3.start();
				
		 try {
	            Thread.sleep(6000);
	        } catch (Exception ex) { }
	    if(Thread.activeCount()==1)   
		System.out.println("Main thread exiting.");
		
	}

}
