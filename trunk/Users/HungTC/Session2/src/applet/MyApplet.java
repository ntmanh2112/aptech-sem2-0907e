package applet;
import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class MyApplet extends Applet implements Runnable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	String name="My name is Hung APTECH 0907E hello world, bounjour monde ";
	Thread objTh;
	@Override
	public void init()
	{
		objTh = new Thread(this);
     	objTh.start();
  	}
	
	public void run()
	{
		while(true) 
	    	{
	    	 	 try
			 {		repaint();
					Thread.sleep(100);
					
	 	  	}
		  	catch (InterruptedException e)
		  	{}	
		 
		   
		   name=name.substring(1,name.length())+name.substring(0,1);
		}
	   }
	   public void paint(Graphics g)
	   {	g.setColor(Color.BLUE.brighter());
			g.drawString(getDateTime(), 30, 30);
						
			g.drawString(name, 50, 50);
	   }
		
	
	private String getDateTime() {
    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    Date date = new Date();
    return dateFormat.format(date);
	}
	
}
