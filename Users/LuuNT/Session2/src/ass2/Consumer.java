package ass2;


public class Consumer extends Thread{
	ProducerConsumerQueue xuatHang;
	public Consumer(ProducerConsumerQueue xuatHang) {
		this.xuatHang = xuatHang;
	}
	
	public void run(){		
		while(true){
			xuatHang.xuatHang();
			
			try {
				sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
