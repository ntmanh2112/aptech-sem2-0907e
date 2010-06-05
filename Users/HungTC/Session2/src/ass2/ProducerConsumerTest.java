package ass2;

import java.util.Scanner;

public class ProducerConsumerTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Producer product = new Producer();
		Consumer consume = new Consumer();
		ProducerConsumerQueue queue = new ProducerConsumerQueue();
		boolean loops = true;
		while (loops) {
		System.out.println("please choose your option:\n1.Set menu\n2.Order\n3.Exit");
		Scanner input = new Scanner(System.in);
		int choiceOfPizza = input.nextInt();
		
			switch (choiceOfPizza) {
			case 1:
				product.start();
				queue.put(product);
				loops = false;
				try {
						product.join();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				System.out.println("continue?(y/n)");
				if(input.next().equalsIgnoreCase("y")){
					loops = true;
				}
				break;
			case 2:
				consume.start();
				queue.get(consume);
				loops = false;
				try {
						consume.join();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				System.out.println("continue?(y/n)");
				if(input.next().equalsIgnoreCase("y")){
					loops = true;
				}
				break;
			default:
				System.out.println("Thank you, see you again");
				System.exit(1);
				break;
			}
		}

	}

}
