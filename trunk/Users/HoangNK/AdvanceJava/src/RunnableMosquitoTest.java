package Mosquito;

public class RunnableMosquitoTest {

	/**
	 * @param args
	 */
public RunnableMosquitoTest(){}

				public static void main (String args[]){
					
				Mosquito m1 = new Mosquito(12);
				Mosquito m2 = new Mosquito(21);
				Mosquito m3 = new Mosquito(22);
				Mosquito m4 = new Mosquito(32);
				Thread t1 = new Thread(m1);
				t1.start();
				Thread t2 = new Thread(m2);
				t2.start();
				Thread t3 = new Thread(m3);
				t3.start();
				Thread t4 = new Thread(m4);
				t4.start();
				System.out.println(t1.getName());
				System.out.println(t2.getName());
				System.out.println("No. of Thread: " +
				Thread.activeCount());
				}
				}

