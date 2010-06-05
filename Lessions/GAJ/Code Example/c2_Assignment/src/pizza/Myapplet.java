/*
<applet code = Myapplet width = 200 height = 200>
</applet>
*/

package pizza;

import java.awt.*;
import java.applet.*;
public class Myapplet extends Applet implements Runnable
{
	int count; 
	Thread objTh;
	public void init()
	{
		objTh = new Thread(this);
     	objTh.start();
  	}
	
	public void run()
	{
		for(count = 1; count <= 20; count++) 
	    	{
	    	 	 try
			 {
					repaint();
					Thread.sleep(500);
	 	  	}
		  	catch (InterruptedException e)
		  	{}
		}
	   }
	
	   public void paint(Graphics g)
	   {
			g.drawString("count = "+count, 30, 30);
			System.out.println("count = "+count);
	   }
}
