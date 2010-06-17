package ass1;

import java.awt.Container;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class View5 extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Container c = this.getContentPane();

	public View5() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		init();
	}

	public void init() {
		this.setTitle("tong ke giao dich");
		this.setLayout(null);
		this.setSize(600, 500);
		this.setLocation(200, 50);

		// create a banner
		JLabel lbbanner = new JLabel();
		Font font = new Font("Time New Roman", Font.BOLD, 20);
		lbbanner.setFont(font);
		lbbanner.setText("THONG KE GIAO DICH");
		lbbanner.setLocation(150, 20);
		lbbanner.setSize(300, 70);
		c.add(lbbanner);

		// two big banners
		JLabel lbbanner1 = new JLabel();
		Font font1 = new Font("Time New Roman", Font.BOLD, 15);
		lbbanner1.setFont(font1);
		lbbanner1.setText("DAT MUA");
		lbbanner1.setLocation(50, 130);
		lbbanner1.setSize(100, 50);
		c.add(lbbanner1);

		JLabel lbbanner2 = new JLabel();

		lbbanner2.setFont(font1);
		lbbanner2.setText("DAT BAN");
		lbbanner2.setLocation(300, 130);
		lbbanner2.setSize(100, 50);
		c.add(lbbanner2);

		// label
		label("ngay bat dau", 50, 70);
		label("ngay ket thuc", 50, 100);

		label("tien chiet khau", 50, 330);
		label("tien thue", 50, 360);
		label("tien tra", 50, 390);
		label("tong tien", 50, 420);
		label("tien no", 50, 450);

		label("tien chiet khau", 300, 330);
		label("tien thue", 300, 360);
		label("tien tra", 300, 390);
		label("tong tien", 300, 420);
		label("tien no", 300, 450);
		// button
		button("tim kiem", 300, 120, 100);
		button("huy bo", 410, 120, 75);
		button("in", 500, 120, 75);

		// text
		text(150, 330);
		text(150, 360);
		text(150, 390);
		text(150, 420);
		text(150, 450);

		text(400, 330);
		text(400, 360);
		text(400, 390);
		text(400, 420);
		text(400, 450);

		// combo box
		String[] date = { "2010-05-05", "2012-06-08" };
		comboBox(date, 150, 70, 100);
		comboBox(date, 150, 100, 100);

		// field
		field(50, 180);

		field(300, 180);
		this.setVisible(true);

	}

	public void comboBox(String[] string, int x, int y, int size) {
		JComboBox comBx = new JComboBox(string);
		comBx.setSelectedIndex(1);
		comBx.setLocation(x, y + 15);
		comBx.setSize(size, 20);
		c.add(comBx);
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

	public void field(int x, int y) {

		JTextArea txtAre = new JTextArea();
		txtAre.setLocation(x, y);
		txtAre.setSize(220, 150);
		txtAre.setColumns(4);

		c.add(txtAre);
	}

	public void text(int x, int y) {
		JTextField txt = new JTextField();
		txt.setSize(130, 20);
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

}
