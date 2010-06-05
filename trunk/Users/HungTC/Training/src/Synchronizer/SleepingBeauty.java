package Synchronizer;



class queue{
	int exchangeValue;
	boolean busy = false;
	synchronized int get() {
		if(!busy) 
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println(" Get: " + exchangeValue);
			notify();
			return exchangeValue;
		}
	synchronized void put (int exchangeValue){
		if(busy)
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			this.exchangeValue = exchangeValue;
			busy = true;
			System.out.println(" put: " + exchangeValue);
			}
}

class Publisher extends Thread {
	queue q;
	public Publisher (queue q) {
		this.q = q;
		this.start();
	}
	
	public void run() {
		for(int i =0; i <5 ; i++) {
			q.put(i);
		}
	}
	
}

class Consumer extends Thread {
	queue q;
	public Consumer(queue q) {
		this.q = q;
		this.start();		
	}
	
	public void run() {
		for(int i =0; i<5;i++) {
			q.get();
		}
	}
}

public class SleepingBeauty {
	public static void main(String[] str) {
		queue q = new queue();
		new Publisher(q);
		new Consumer(q);
	}
	
}

