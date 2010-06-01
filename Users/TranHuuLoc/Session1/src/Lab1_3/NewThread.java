package Lab1_3;

public class NewThread implements Runnable{
	public NewThread() {
		
	}
	public void run(){
		
		System.out.println("New thread: Thread["+Thread.currentThread().getName()+",5,main]");
		try{
			Thread.sleep(1000);
			}catch(Exception e){				
			}		
	
		for(int i=5;i>0;i--){
			System.out.println(Thread.currentThread().getName()+" : "+i);
			if(i==1)
				System.out.println(Thread.currentThread().getName()+" exiting.");
			try{
				Thread.sleep(1000);
				}catch(Exception e){				
				}
				
		}
		
	}

}
