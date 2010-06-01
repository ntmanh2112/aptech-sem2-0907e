package applet;

import java.applet.Applet;
import java.awt.Graphics;
import java.util.Date;

import javax.print.attribute.standard.MediaSize.NA;

public class MyApplet extends Applet implements Runnable {

	int count ;
	Thread objTh ;
	String name = "Nguyen Thanh Luu ";
	String a;
	String b;
	public void init() {
		objTh = new Thread(this);
		objTh.start();
	}

	@Override
	public void run() {
		
		boolean dk = true ;
		while( dk == true){
			repaint();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void paint(Graphics g) {
		Date d=new Date();
	    g.drawString("Today date is "+ d ,30,30);
	    g.drawString(name,50,50);
	    a = name.substring(0,1);
	    b = name.substring(1,name.length());
	    name = b+a;
	}
}
