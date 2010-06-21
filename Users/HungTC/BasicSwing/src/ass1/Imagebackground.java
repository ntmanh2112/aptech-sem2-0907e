package ass1;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

public class Imagebackground  extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
//-------------------------------------------------------------------------------------------------------
	Image image;
	int h, w;
	
	public Imagebackground(Image image, int w, int h){
		this.image = image;
		this.h=h;
		this.w=w;
		
	}
	
	
	
	
	public void paintComponent(Graphics g){
		g.drawImage(image,0,0,w,h,null);
	}
	
	
	
	
	

}
