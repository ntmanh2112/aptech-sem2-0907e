package ass1;

import java.awt.Container;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class View4 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Container contain = this.getContentPane();

	public View4() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		init();
	}

	private void init() {
		this.setTitle("thu thuoc");
		this.setLayout(null);
		this.setSize(500, 500);
		this.setLocation(200, 50);

		// create a banner
		JLabel lbbanner = new JLabel();
		Font font = new Font("Time New Roman", Font.BOLD, 20);
		lbbanner.setFont(font);
		lbbanner.setText("CAP NHAT THUOC");
		lbbanner.setLocation(150, 50);
		lbbanner.setSize(300, 70);
		contain.add(lbbanner);

		// create a label
		label("ten", 50, 100);
		label("Quoc gia", 50, 130);
		label("Nha san xuat", 50, 160);
		label("cong thuc", 50, 190);
		label("cach dung", 50, 220);
		label("don vi", 50, 250);
		label("so luong", 50, 280);
		label("trang thai", 300, 250);
		label("Gia", 300, 280);

		// create field text
		text(150, 160, 300);
		text(150, 190, 300);
		text(150, 220, 300);
		text(150, 280, 100);
		text(400, 280, 70);

		// Create comboBox
		String[] strOfMedicine = { "medicine1", "medicine2" };
		comboBox(strOfMedicine, 150, 100, 300);

		String[] strOfNation = { "Afghanistan", "VietNam" };
		comboBox(strOfNation, 150, 130, 300);

		String[] strOfType = { "pn", "kg" };
		comboBox(strOfType, 150, 250, 100);

		String[] strOfStatic = { "Open", "Off" };
		comboBox(strOfStatic, 400, 250, 70);
		// create button
		button("Cap Nhat", 150, 350, 100);
		button("Huy Bo", 300, 350, 100);

		this.setVisible(true);
	}

	public void comboBox(String[] string, int x, int y, int size) {
		JComboBox comBx = new JComboBox(string);
		comBx.setSelectedIndex(1);
		comBx.setLocation(x, y + 15);
		comBx.setSize(size, 20);
		contain.add(comBx);
	}

	public void button(String name, int x, int y, int size) {

		JButton bt = new JButton();
		bt.setSize(size, 20);
		bt.setLocation(x, y);
		bt.setText(name);

		// Icon ico = new ImageIcon("image/glass.jpg");
		// bt.setIcon(ico);
		contain.add(bt);
	}

	public void label(String name, int x, int y) {
		JLabel lb = new JLabel();
		lb.setText(name);
		lb.setLocation(x, y);
		lb.setSize(100, 50);
		contain.add(lb);
	}

	public void text(int x, int y, int size) {
		JTextField txt = new JTextField();
		txt.setSize(size, 20);
		txt.setLocation(x, y + 15);
		contain.add(txt);
	}
}
