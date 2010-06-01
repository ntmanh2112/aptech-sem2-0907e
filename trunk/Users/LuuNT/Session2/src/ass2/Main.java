package ass2;

public class Main {

	
	public static void main(String[] args){
		
		ProducerConsumerQueue queue = new ProducerConsumerQueue();
		
		Producer t1 = new Producer(queue);
		Consumer t2 = new Consumer(queue);

		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
