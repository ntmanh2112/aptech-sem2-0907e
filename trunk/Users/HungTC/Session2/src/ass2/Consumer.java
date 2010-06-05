package ass2;

import java.util.Scanner;

public class Consumer extends Thread {
	static ProducerConsumerQueue[] content = new ProducerConsumerQueue[100];

	public Consumer() {

	}

	public void run() {

		Scanner input = new Scanner(System.in);
		System.out.println("welcome, please choose the type of pizza: \n");
		for (int i = 0; i < 100; i++) {
			if (content[i].getType() != null) {
				System.out.println((i + 1) + "* " + content[i].getType()
						+ " ,quatity: " + content[i].getQuantity());
			}

		}

		System.out
				.println(" Are there any type of pizza which like your wish ?(Y/N): ");
		String choiceType = input.next();
		if (choiceType.equalsIgnoreCase("Y")) {
			System.out.println(" Your choice(please type exactly) : ");
			choiceType = input.next();
			for (int i = 0; i < 100; i++) {
				if (choiceType.equalsIgnoreCase(content[i].getType())) {
					System.out
							.println("Thank you, please wait about 30 mins, the pizza will be send ");
					content[i].setQuantity(content[i].getQuantity() - 1);
				}
			}
		} else {
			System.out.println(" please let me know your specific type : ");
			choiceType = input.next();
			for (int i = 0; i < 100; i++) {
				if (choiceType == null) {
					Producer product = new Producer();
					product.start();
				}
			}
			System.out.println("Thank you, we will contact as soon as we can ");
		}

	}

}
