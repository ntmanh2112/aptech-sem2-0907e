package ass1;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class View7 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Container c = this.getContentPane();
	public View7(){
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		init();
	}
	public void init() {
		this.setTitle("welcome to login form");
		this.setLayout(null);
		this.setSize(500, 350);
		this.setLocation(200, 50);
		this.setForeground(Color.gray);
		
		//image
		Icon ico = new ImageIcon("image/Contact.PNG");
			
		
		//banner
		JLabel lbbanner = new JLabel();
		Font font = new Font("Time New Roman", Font.ITALIC+Font.BOLD, 20);
		lbbanner.setFont(font);
		lbbanner.setIcon(ico);
		lbbanner.setForeground(Color.blue);
		lbbanner.setText("LOGIN");
		lbbanner.setLocation(50, 20);
		lbbanner.setSize(400, 100);
		c.add(lbbanner);
		
		//label
		label("User Name", 50, 100);
		label("Password", 50, 150);
		
		//text
		text(150, 100, 100);
		text(150, 150, 100);
		
		//button
		button("Ok", 100, 220, 100,"image/changepass1.PNG");
		button("Exit", 300, 220, 100,"image/button-cancel-icon.PNG");
		
		
		
		this.setVisible(true);
	}
	public void text(int x, int y, int size) {
		JTextField txt = new JTextField();
		txt.setSize(size, 20);
		txt.setLocation(x, y + 15);
		c.add(txt);
	}
	
	public void label(String name, int x, int y) {
		JLabel lb = new JLabel();
		lb.setText(name);
		lb.setLocation(x, y);
		lb.setSize(100, 50);
		c.add(lb);
	}
	
	public void button(String name, int x, int y, int size,String path) {

		JButton bt = new JButton();
		bt.setSize(size, 20);
		bt.setLocation(x, y);
		bt.setText(name);

		 Icon ico = new ImageIcon(path);
		 bt.setIcon(ico);
		c.add(bt);
	}
	
	
	public static void main(String[] str){
		new View7();
	}
	
	
	
	

}
