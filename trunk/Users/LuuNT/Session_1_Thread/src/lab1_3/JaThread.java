package lab1_3;

public class JaThread implements Runnable{

	
	@Override
	public void run() {
		
		System.out.println("New Thread : Thread [ "+
				Thread.currentThread().getName() +",5,main]");
		
		for(int i = 5 ; i > 0 ; i--){
			try {
				Thread.currentThread().sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+" : "+i);
		}
		System.out.println(Thread.currentThread().getName()+" exiting");
	}
	
	

}
