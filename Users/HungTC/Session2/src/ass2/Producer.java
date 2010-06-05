package ass2;

import java.util.Scanner;

public class Producer extends Thread {
	static ProducerConsumerQueue[] content = new ProducerConsumerQueue[100];
	static int indexOfLastContent = 0;

	public Producer() {

	}

	Scanner input = new Scanner(System.in);

	public void run() {
		System.out.println("Please insert the type of pizza: ");
		String pizza = input.next();
		content[indexOfLastContent].setType(pizza);

		System.out.println("Please insert the quatity of pizza "
				+ content[indexOfLastContent].getType() + " is: ");
		int qu = input.nextInt();
		content[indexOfLastContent].setQuantity(qu);

		indexOfLastContent+=1;
	}
}
