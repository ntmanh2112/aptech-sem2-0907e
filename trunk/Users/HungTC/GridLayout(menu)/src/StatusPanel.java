
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StatusPanel extends JPanel implements Runnable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */

String str = "abcvgfhdkjajakskvcjnk ";
JLabel lb1;
JLabel lb2;
JLabel lb3;
Thread myThread = new Thread(this);
	
	
	public StatusPanel() {
		lb1 = new JLabel();
		lb2 = new JLabel();
		lb3 = new JLabel();		
		myThread.start();
		init();

	}
	public void init() {
		this.setLayout(new GridLayout(1, 3));	
		
		
		lb1.setBorder(BorderFactory.createEtchedBorder());		
		lb2.setBorder(BorderFactory.createEtchedBorder());		
		lb3.setBorder(BorderFactory.createEtchedBorder());
		this.add(lb1);
		this.add(lb2);
		this.add(lb3);
	}

	public void run() {
		// TODO Auto-generated method stub
		Font font = new Font("Arial",0,20);
		
		while(true) {
			try {
				Thread.sleep(200);		
				str = str.substring(1,str.length())+str.substring(0,1);
				lb1.setText(str);
				lb1.setForeground(Color.blue);
				lb1.setFont(font);
				lb2.setText(str);
				lb2.setForeground(new Color(234,111,224));
				lb2.setFont(font);
				lb3.setText(str);
				lb3.setFont(font);
				lb3.setForeground(Color.green);
			} catch (InterruptedException e) {				
			}
		}
	}
	
	
	
	
	
	

}
