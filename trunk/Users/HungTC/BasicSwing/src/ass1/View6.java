package ass1;

import java.awt.Container;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class View6 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Container c = this.getContentPane();

	public View6() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		init();
	}

	public void init() {
		this.setTitle("tong ke giao dich");
		this.setLayout(null);
		this.setSize(700, 600);
		this.setLocation(200, 50);

		// create a banner
		JLabel lbbanner = new JLabel();
		Font font = new Font("Time New Roman", Font.BOLD, 20);
		lbbanner.setFont(font);
		lbbanner.setText("LAP HOA DON BAN HANG");
		lbbanner.setLocation(200, 20);
		lbbanner.setSize(300, 70);
		c.add(lbbanner);

		// label
		label("ten khach hang", 50, 100);
		label("ghi chu", 50, 130);
		label("tien tra", 50, 160);
		label("loai tien", 270, 160);
		label("so HD ban hang", 50, 190);

		label("tong so tien", 50, 420);
		label("tong thanh tien", 50, 450);

		label("ngay dat", 350, 100);
		label("ngay gui", 350, 130);
		label("ngay tra", 350, 160);

		label("tien chiet khau", 250, 420);
		label("tien thue", 250, 450);

		// text
		text(150, 130, 150);
		text(150, 160, 100);
		text(150, 190, 100);

		text(150, 420, 100);
		text(150, 450, 100);
		text(350, 420, 70);
		text(350, 450, 70);

		// button
		button("Dong Y", 450, 435, 100);
		button("Gui Thu", 450, 465, 100);
		button("Huy BO", 570, 435, 100);
		button("In", 570, 465, 100);

		// combobox
		String[] date = { "2010-05-09", "2010-05-04" };
		String[] name = { "customer1", "customer2" };
		comboBox(date, 450, 100, 100);
		comboBox(date, 450, 130, 100);
		comboBox(date, 450, 160, 100);
		comboBox(name, 150, 100, 150);

		// text Area
		JTextArea txtAre = new JTextArea();
		txtAre.setLocation(50, 230);
		txtAre.setSize(600, 170);
		txtAre.setColumns(4);

		c.add(txtAre);

		this.setVisible(true);
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

	public void label(String name, int x, int y) {
		JLabel lb = new JLabel();
		lb.setText(name);
		lb.setLocation(x, y);
		lb.setSize(100, 50);
		c.add(lb);
	}

	public void comboBox(String[] string, int x, int y, int size) {
		JComboBox comBx = new JComboBox(string);
		comBx.setSelectedIndex(1);
		comBx.setLocation(x, y + 15);
		comBx.setSize(size, 20);
		c.add(comBx);
	}

	public void text(int x, int y, int size) {
		JTextField txt = new JTextField();
		txt.setSize(size, 20);
		txt.setLocation(x, y + 15);
		c.add(txt);
	}
}
