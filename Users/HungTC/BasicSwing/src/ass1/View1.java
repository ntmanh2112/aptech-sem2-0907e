package ass1;

import java.awt.Container;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class View1 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Container c = this.getContentPane();

	public View1() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		init();
	}

	private void init() {
		this.setTitle("dang nhap");
		this.setLayout(null);
		this.setSize(500, 500);
		this.setLocation(200, 50);
		// label
		JLabel lb = new JLabel();
		lb.setLocation(150, 50);
		lb.setSize(300, 70);

		Font font = new Font("Time New Roman", Font.BOLD, 20);
		lb.setFont(font);
		lb.setText("Lua Chon Dang Nhap");
		c.add(lb);
		
		
		// buttons
		button("Viet", 70, 75, 70);
		button("Anh", 370, 75, 70);
		button("Ket Noi", 50, 300, 100);
		button("Khong Ket Noi", 175, 300, 150);
		button("Dang Nhap", 350, 300, 100);
		
		//checksBox
		checkbox("Ket noi CSDL", 75, 200,100);
		checkbox("Khong ket noiCSDL",300 , 200, 200);

		this.setVisible(true);
	}
	
	
	public void checkbox (String name, int x, int y, int size){
		JCheckBox chk = new JCheckBox();
		chk.setLocation(x, y);
		chk.setSize(size, 20);
		chk.setText(name);
		
		c.add(chk);
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
}
