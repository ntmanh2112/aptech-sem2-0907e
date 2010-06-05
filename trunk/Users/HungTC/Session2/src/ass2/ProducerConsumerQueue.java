package ass2;

public class ProducerConsumerQueue {
	private String type;
	private int quantity;
	boolean toBeOrNotToBe = false;

	public ProducerConsumerQueue() {

	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	synchronized void put(Producer product) {

		if (toBeOrNotToBe) {
			try {
				product.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		toBeOrNotToBe = false;
	}

	synchronized void get(Consumer consume) {
		toBeOrNotToBe = true;
		consume.notifyAll();
	}

}
