package implement;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class ShowRoom extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @param args
	 */
	
	Contents contents;
	Left left;
	//****(-CONSTRUCTOR-)****
	public ShowRoom() throws IOException{
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		init();
	}
	//*****init()******
	public void init() throws IOException{
		
		//******set layout*******
		this.setLayout(new BorderLayout());
		this.setSize(800, 700);
		this.setLocation(50, 10);
		
		//****Add component
		Container c = this.getContentPane();
		
		BufferedImage image = ImageIO.read(new File("autum.jpg"));
		left= new Left(image,150,800);
		c.add(left,BorderLayout.WEST);
		
		contents = new Contents(600,600);
		c.add(contents,BorderLayout.CENTER);
		
		
		
//		this.pack();
		this.setVisible(true);
		
	}
	
	
	//****Main method
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		new ShowRoom();

	}

}
