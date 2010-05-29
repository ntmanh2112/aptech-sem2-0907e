package applet;
import java.awt.*;
import java.applet.*;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Example extends Applet implements Runnable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int count; 
	Thread objTh;
	String str=" hello world, my name is Hung, class 0907E ";
	
	public void init()
	{
		objTh = new Thread(this);
     	objTh.start();
  	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		for(count = 1; count <= 20; count++) {
			try {
				repaint();
				Thread.sleep(200);		
				str = str.substring(1,str.length())+str.substring(0,1);
			} catch (InterruptedException e) {				
			}
		}
	}
	public void paint(Graphics g) {
	g.setColor(Color.green);
	g.drawString(getDateTime(), 30, 30);
	g.setColor(Color.blue);
	g.drawString(str, 50, 50);
	}
	
	private String getDateTime() {
        final DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        final Date date = new Date();
        return dateFormat.format(date);
    }
}


