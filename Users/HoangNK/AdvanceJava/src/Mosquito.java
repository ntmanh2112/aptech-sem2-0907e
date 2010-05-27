package Mosquito;

	class Mosquito implements Runnable
	{
	private int id;
	public Mosquito(int id){
	this.id = id;}

	
	// override
	public void run()
	{
	if (id == 12) {
	try {
	Thread.sleep(10000);
	} catch(Exception e){}
	}
	for (int i=0; i<10; i++)
		System.out.println("Vo ve " + id);
	}
	
	}
	
