package ass1;

import java.awt.Container;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class View2 extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Container c = this.getContentPane();
	public View2(){
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		init();
	}
public void init(){
	//build window
	this.setLayout(null);	
	this.setTitle("dang nhap");
	this.setLocation(200, 50);
	this.setSize(500, 500);
	
	//banner
	JLabel lb = new JLabel();
	lb.setLocation(150, 50);
	lb.setSize(300, 70);
	Font font = new Font("Time New Roman", Font.BOLD, 20);
	lb.setFont(font);
	lb.setText("Dang Nhap May Chu");
	c.add(lb);
	
	//label
	label("ten may chu", 50, 100);
	label("CSDL", 50, 130);
	label("ten dang nhap", 50, 160);
	label("mat khau", 50, 190);
	
	//text
	text(150, 100, 300);
	text(150, 130, 300);
	text(150, 160, 300);
	text(150, 190, 300);
	
	
	//button
	button("Dong Y", 100, 250, 100);
	button("Huy Bo", 250,250, 100);

	
	
	
	
	
	
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


public void button(String name, int x, int y, int size) {

	JButton bt = new JButton();
	bt.setSize(size, 20);
	bt.setLocation(x, y);
	bt.setText(name);

	// Icon ico = new ImageIcon("image/glass.jpg");
	// bt.setIcon(ico);
	c.add(bt);
}
public static void main(String[] str){
	new View2();
}
}
