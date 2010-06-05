package Synchronizer;

public class abc {
	void display(String s) {
		System.out.print ("(" + s);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.print(")");
		
	}
}

class MyThread extends Thread{
	String s1;
	abc abc;
	public MyThread(String s1, abc abc) {
		this.s1 = s1;
		this.abc = abc;
		this.start();
	}
	public void run() {
		synchronized (abc) {
			abc.display(s1);			
		}
	}
	
}

class Demo {
	public static void main(String[] str) {
		abc abc = new abc();
		@SuppressWarnings("unused")
		MyThread m1 = new MyThread("I do that", abc);
		@SuppressWarnings("unused")
		MyThread m2 = new MyThread("He does this",abc);
	}
	
}
