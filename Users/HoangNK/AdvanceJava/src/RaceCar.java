package RaceCar;
	class RaceCar extends Thread
	{
	int finish;
	String name;
	RaceCar(int finish, String name)
	{
	this.finish = finish;
	this.name = name;
	}
	public void run()
	{
	for (int i=0; i<finish; i++)
	{
	System.out.println(name + ": " + (i+1));
	try {
	Thread.sleep(Math.round(Math.random()*5000));
	} catch(Exception e){}
	}
	System.out.println(name + " finished");
	}
	}
	