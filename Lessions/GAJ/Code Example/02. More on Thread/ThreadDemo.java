class ThreadDemo implements Runnable
{
	String name;
	Thread objTh;
	ThreadDemo(String str)
	{
		name = str;
		objTh = new Thread(this, name);
		System.out.println("New Threads are starting : " + objTh);
		objTh.start();
	}
	public void run()
	{
   		try
		{
     			for (int count = 0;count < 2;count++)
      			{
				System.out.println(name + " : "+count);
				objTh.sleep(1000);
   			}
		}
		catch(InterruptedException e)
     		{
			System.out.println(name + "  interrupted");
     		}
		System.out.println(name + "  exiting");
	}

	public static void main(String [] args)
		{
			ThreadDemo Objnew1 = new ThreadDemo("one");
			ThreadDemo Objnew2 = new ThreadDemo ("two");
			ThreadDemo Objnew3 = new ThreadDemo ("three");
			System.out.println("First thread is alive :" + Objnew1.objTh.isAlive());
			System.out.println("Second thread is alive :" + Objnew2.objTh.isAlive());
			System.out.println("Third thread is alive :" + Objnew3.objTh.isAlive());
			try
			{
	     			System.out.println("I am in the main and waiting for the threads to finish");
	     			Objnew1.objTh.join();
				Objnew2.objTh.join();
		     		Objnew3.objTh.join();
	   		}
			catch(InterruptedException e)
	  		{
	     			System.out.println("Main thread is interrupted");
	   		}
			System.out.println("First thread is alive :" + Objnew1.objTh.isAlive());
			System.out.println("Second thread is alive :" + Objnew2.objTh.isAlive());
			System.out.println("Third thread is alive :" + Objnew3.objTh.isAlive());
			System.out.println("Main thread is over and exiting");
		}
}
