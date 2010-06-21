package demo;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class View5Bag extends JFrame{
	

	private static final long serialVersionUID = 1L;
	Container c = this.getContentPane();
	GridBagConstraints constraints = new GridBagConstraints();

	public View5Bag() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		init();
	}

	public void init() {
		this.setTitle("tong ke giao dich");
		this.setLayout(new GridBagLayout());
		this.setSize(800,600);

		// create a banner
		JLabel lbbanner = new JLabel();
		Font font = new Font("Time New Roman", Font.BOLD, 20);
		lbbanner.setFont(font);
		lbbanner.setText("THONG KE GIAO DICH");
		constraints.gridy =0;
		constraints.gridx =0;
		constraints.gridwidth =4;
//		constraints.insets = new Insets(20,100,5,100);
		c.add(lbbanner,constraints);
		constraints.insets = new Insets(0,0,0,0);

		// two big banners
		JLabel lbbanner1 = new JLabel();
		Font font1 = new Font("Time New Roman", Font.BOLD, 15);
		lbbanner1.setFont(font1);
		lbbanner1.setText("DAT MUA");
		constraints.gridx =0;
		constraints.gridy =3;
		constraints.gridwidth =1;
		constraints.insets = new Insets(10,50,5,2);
		c.add(lbbanner1,constraints);
		constraints.insets = new Insets(0,0,0,0);

		JLabel lbbanner2 = new JLabel();

		lbbanner2.setFont(font1);
		lbbanner2.setText("DAT BAN");
		constraints.gridx =2;
		constraints.gridy =3;
		constraints.gridwidth =1;
		constraints.insets = new Insets(10,50,5,2);
		c.add(lbbanner2,constraints);
		constraints.insets = new Insets(0,0,0,0);

		// label
		label("ngay bat dau", 0, 1);
		label("ngay ket thuc", 0,2);

		label("tien chiet khau",0, 5);
		label("tien thue", 0, 6);
		label("tien tra", 0, 7);
		label("tong tien", 0,8);
		label("tien no", 0, 9);

		label("tien chiet khau", 2, 5);
		label("tien thue", 2, 6);
		label("tien tra", 2, 7);
		label("tong tien", 2, 8);
		label("tien no", 2, 9);
		
		
		
		
		
		
		
		// button
		JButton bt1 = new JButton();
		JButton bt2 = new JButton();
		JButton bt3 = new JButton();
		bt1.setPreferredSize(new Dimension(100,20));
		bt2.setPreferredSize(new Dimension(100,20));
		bt3.setPreferredSize(new Dimension(100,20));

		bt1.setText("tim kiem");

		bt2.setText("huy bo");
		bt3.setText("in");
		constraints.gridx =2;
		constraints.gridy =2;
		constraints.gridwidth=1;
		constraints.insets = new Insets(10,50,5,2);
		c.add(bt1,constraints);
		constraints.insets = new Insets(10,250,5,2);
		c.add(bt2,constraints);
		constraints.insets = new Insets(10,450,5,2);
		c.add(bt3,constraints);
		constraints.insets = new Insets(0,0,0,0);
	
//		c.add(bt);

		// text
		text(1, 5);
		text(1, 6);
		text(1, 7);
		text(1, 8);
		text(1, 9);

		text(3, 5);
		text(3, 6);
		text(3, 7);
		text(3, 8);
		text(3, 9);

		// combo box
		String[] date = { "2010-05-05", "2012-06-08" };
		comboBox(date, 1,1);
		comboBox(date, 1,2);

		// field
		field(0, 4);
		field(2,4);
		
		
		this.pack();
		this.setVisible(true);

	}

	public void comboBox(String[] string, int x, int y) {
		JComboBox comBx = new JComboBox(string);
		comBx.setSelectedIndex(1);
		comBx.setPreferredSize(new Dimension(100,20));
//		comBx.setLocation(x, y + 15);
//		comBx.setSize(size, 20);
		constraints.gridx =x;
		constraints.gridy =y;
		constraints.insets = new Insets(10,50,5,2);
		c.add(comBx,constraints);
		constraints.insets = new Insets(0,0,0,0);
	
	}

	

	public void field(int x, int y) {

		JTextArea txtAre = new JTextArea();
		txtAre.setPreferredSize(new Dimension(300,100));
		constraints.gridx =x;
		constraints.gridy =y;
		constraints.gridwidth=2;
		constraints.insets = new Insets(10,50,5,2);
		c.add(txtAre,constraints);
		constraints.insets = new Insets(0,0,0,0);
	

//		c.add(txtAre);
	}

	public void text(int x, int y) {
		JTextField txt = new JTextField();
		txt.setPreferredSize(new Dimension(130,20));
//		txt.setSize(130, 20);
		constraints.gridx =x;
		constraints.gridy =y;
		constraints.insets = new Insets(10,50,5,2);
		c.add(txt,constraints);
		constraints.insets = new Insets(0,0,0,0);
	
	}

	public void label(String name, int x, int y) {
		JLabel lb = new JLabel();
		lb.setText(name);
		constraints.gridx =x;
		constraints.gridy =y;
		constraints.insets = new Insets(10,50,5,2);
		c.add(lb,constraints);
		constraints.insets = new Insets(0,0,0,0);
	
	}

}
