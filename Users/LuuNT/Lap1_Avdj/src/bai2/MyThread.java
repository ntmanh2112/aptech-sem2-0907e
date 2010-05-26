package bai2;

public class MyThread extends Thread{

	public MyThread() {
		
	}
	
	public void run(){
		System.out.println("Ten Cu Thread La : " +Thread.currentThread().getName());
		Thread.currentThread().setName("myJavaThread");
		System.out.println("Ten Moi Thread La : " +Thread.currentThread().getName());
		
		for(int i=1 ;i<10;i++){
			System.out.println(i);
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}
