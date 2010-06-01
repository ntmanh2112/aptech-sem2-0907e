package ass2;

import java.util.Random;

public class ProducerConsumerQueue {

	static int mount = 0;
	static int [] hangKho = new int[20];
	
	public void producerConsumer(int maHang){
		
			hangKho[mount] = maHang ;
		}
	
	public synchronized void nhapHang() {
		
		if(mount == 20){
			try {
				System.out.println("Kho Day Hang Cho Xuat Hang");
				Thread.currentThread().wait();								
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else{
			Random maRanDom = new java.util.Random();
			
			this.producerConsumer(maRanDom.nextInt(100));
			System.out.println("So Luong Hang Vua Nhap La "+(mount+1));
			mount++;
		}
		notifyAll();
	}
	public synchronized void xuatHang() {
		
		if(mount ==0){
			try {
				System.out.println("Kho Het Hang Cho Nhap Hang");	
				Thread.currentThread().wait();			
				notifyAll();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else{
			System.out.println("Ban Da Lay Ma Hang "+hangKho[mount-1]+" So Luong Hang Con Lai La "+(mount-1));
			mount--;
		}
	}
	
	
}
