package lab22;

public class WaitingClass {
	double amount =0.0;
	public WaitingClass(){
	
}
	public WaitingClass(double amount){
		this.amount = amount;
	}
	
	
	
	synchronized void waitForYou(String name, boolean wakeUp) {
		if (!wakeUp) {
			try {

				System.out.println("I'm " + name
						+ ", I'm waiting for other Thread brothers ");
				wait();
				
				} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		System.out.println("I'm " + name
				+ ", I will wake my Thread brothers up.");
		notifyAll();	
		
	}
}
