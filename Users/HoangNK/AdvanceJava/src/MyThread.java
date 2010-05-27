package lab1_2;

public class MyThread extends Thread {
	/*
	 * 
	 */
	public MyThread(String name) {
		setName(name);
	}
	public void run() {
		System.out.println("My thread name is "+getName());
		setName("myJavaThread");
		System.out.println("After rename,my thread name is "+getName());
		for(int i=0;i<10;i++){
			System.out.println(i+1);
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args){
		MyThread mythread=new MyThread("MyThread");
		mythread.start();
	}
}
