package Mosquito;

	class Mosquito implements Runnable
	{
	private int id;
	public Mosquito(int id)
	{
	this.id = id;
	}
	// override
	public void run()
	{
	if (id == 12) {
	try {
	Thread.sleep(10000);
	} catch(Exception e){}
	}
	for (int i=0; i<10; i++)
	{
	System.out.println("Vo ve " + id);
	}
	}
	}
	public class RunnableMosquitoTest
	{
	public static void main(String args[])
	{
	Mosquito m1 = new Mosquito(12);
	Mosquito m2 = new Mosquito(21);
	Mosquito m3 = new Mosquito(22);
	Mosquito m4 = new Mosquito(32);
	Thread t1 = new Thread(m1);
	t1.start();
	Thread t2 = new Thread(m2);
	t2.start();
	System.out.println(t1.getName());
	System.out.println(t2.getName());
	System.out.println("No. of Thread: " +
	Thread.activeCount());
	}
	}
