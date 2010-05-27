package Labs1_2;

import Labs1_2.MyThread;

public class MyThread extends Thread {
/*
 * 
 */
	public MyThread()	{
		setName("My Thread");
	}
	public void run()	{
		System.out.println("Name of the current thread: " + getName());
		this.setName("myJavaThread");
		System.out.println("New Name of the current therad: " + getName());
		int loc;
		for(loc=10;loc>0;loc--){
			System.out.println(loc);
			try {
				sleep(1500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args)	{
		MyThread thread = new MyThread();
		thread.start();
	}
}
