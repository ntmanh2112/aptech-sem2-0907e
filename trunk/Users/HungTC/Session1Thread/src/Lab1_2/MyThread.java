package Lab1_2;

public class MyThread extends Thread {
	public MyThread(){
		setName("MyThread");
	}
	
	public void run(){
		System.out.println("Name of current thread: "+getName());
		this.setName("myJavaThread");
		System.out.println("Name after replace: "+getName());
		int number;
		for(number=2;number<20;number+=2){
			System.out.println("\t"+number);
			try{
				sleep(1500);
				System.out.println("I'm sleeping");
			}catch(Exception e){}
		}

		System.out.println("\t20");
	}

}
