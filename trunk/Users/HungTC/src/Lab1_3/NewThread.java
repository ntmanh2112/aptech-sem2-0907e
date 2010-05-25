package Lab1_3;

public class NewThread extends Thread{
	public NewThread(String name){
		setName(name);
		System.out.println("New thread: Thread["+getName()+",5,main]");
		
	}
	public void run(){
		
		for(int i=5;i>0;i--){
			System.out.println(getName()+" : "+i);
			if(i==1)
				System.out.println(getName()+" exiting.");
		try{
			sleep(500);
			}catch(Exception e){}
		}
	}

}
