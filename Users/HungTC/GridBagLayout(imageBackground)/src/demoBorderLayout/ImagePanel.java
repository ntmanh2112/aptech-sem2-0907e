package demoBorderLayout;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;

public class ImagePanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//------------------------------------------------
	
	
	
	Image img;
	int w;
	int h;

	public ImagePanel(Image img, int w, int h) {
		this.img = img;
		this.w = w;
		this.h = h;
	}

//	public void init() {
//		this.setLayout(new GridBagLayout());
//	}

	//this is method of class JPanel which you extend "paintComponent"
	public void paintComponent(Graphics g) {
		g.drawImage(img, 0, 0, w, h, null);

	}

}
