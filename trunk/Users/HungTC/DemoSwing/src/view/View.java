package view;

import java.awt.Container;
import java.awt.Font;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class View extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Container contain = this.getContentPane();
	public View(){
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		init();
	}
	
	private void init(){
		this.setTitle("thu thuoc");
		this.setLayout(null);
		this.setSize(500,500);
		this.setLocation(300,100);
		
		//create a banner
		JLabel lbbanner = new JLabel();
		lbbanner.setText("CAP NHAT THUOC");
		lbbanner.setLocation(200,50);
		lbbanner.setSize(300,70);
		contain.add(lbbanner);
		
		
		//create a label
		label("ten",50,150);
		label("Quoc gia",50,170);
		label("Nha san xuat",50,190);
		label("cong thuc", 50,210);
		label("cach dung", 50,230);
		label("don vi",50,250);
		label("so luong",50,270);
		label("trang thai", 300, 250);
		label("Gia", 300,270);
		
		
		
		
			
		
		//create field text
		text(150,200,300);
		text(150, 220, 300);
		text(150, 240,300);
		text(150,290,100);
		text(400,290,70);
		
		
		
		
		//create a button
		Icon ico = new ImageIcon("image/glass.jpg");
		
		JButton bt = new JButton();
		bt.setSize(200,50);
		bt.setLocation(100,100);
		bt.setName("submit");
		bt.setText("submit");
		bt.setIcon(ico);
		contain.add(bt);
				
		
		this.setVisible(true);
	}
	
	
	public void label(String name,int weight,int height){
		JLabel lb = new JLabel();
		lb.setText(name);
		lb.setLocation(weight,height);
		lb.setSize(100,50);
		contain.add(lb);
	}

	public void text(int x, int y,int size){
		JTextField txt = new JTextField();
		txt.setSize(size,20);
		txt.setLocation(x,y);
		contain.add(txt);
	}
}
