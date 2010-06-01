package ass2;

import java.util.Random;

public class Producer extends Thread{
	ProducerConsumerQueue nhapHang;
	
	public Producer(ProducerConsumerQueue nhapHang) {
		this.nhapHang = nhapHang;
	}
	
	public void run(){		
							
		while(true){
			nhapHang.nhapHang();
			try {
				sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
