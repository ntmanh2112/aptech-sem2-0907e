package Lab1_3;

public class RunNewThread{

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NewThread mythread1= new NewThread();
		NewThread mythread2= new NewThread();
		NewThread mythread3= new NewThread();
		Thread myThread1 = new Thread(mythread1);
		Thread myThread2 = new Thread(mythread2);
		Thread myThread3 = new Thread(mythread3);
		myThread1.setName("First");
		myThread2.setName("Second");
		myThread3.setName("Third");
		myThread3.setPriority(4);
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
