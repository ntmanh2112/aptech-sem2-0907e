package timer;

import java.util.*;
import java.awt.*;

public class Task extends TimerTask
{
	int num = 3;
	Toolkit kit = Toolkit.getDefaultToolkit();
	public void run()
	{
		if (num > 0)
		{
    		kit.beep();
	    	System.out.println("Beeping");
			num--;
		}
	}

	public static void main(String [] args)
	{
		Task t = new Task();

		/* Schedule the timer to perform
	   task t every 500 milliseconds.
	   Start the timer after 1000 milliseconds
	  */
		Timer tmr = new Timer();
		tmr.schedule(t, 2000, 1000);
		try
		{
			Thread.sleep(5000);
	  	}
		catch (InterruptedException e)
    	{
		}
		System.out.println("Beeping over");

		// Stop the timer
		tmr.cancel();
	}

}

