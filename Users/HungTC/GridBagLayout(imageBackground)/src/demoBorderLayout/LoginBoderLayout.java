package demoBorderLayout;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class LoginBoderLayout extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Container c = this.getContentPane();
	GridBagConstraints constraints = new GridBagConstraints();

	BufferedImage img = ImageIO.read(new File("wellcome.jpg"));

	ImagePanel image;

	public LoginBoderLayout() throws IOException {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		init();
	}

	public void init() throws IOException {

		this.setLayout(new BorderLayout());
		this.setSize(500, 500);

		image = new ImagePanel(img, this.getSize().width, this.getSize().height);
		image.setLayout(new GridBagLayout());
		// label
		JLabel lb = new JLabel();
		lb.setText("Lua Chon Dang Nhap");
		constraints.gridx = 1;
		constraints.gridy = 0;
		constraints.gridwidth = 1;
		constraints.insets = new Insets(20, 100, 5, 100);
		Font font = new Font("Time New Roman", Font.BOLD, 20);
		lb.setFont(font);
		image.add(lb, constraints);
		constraints.insets = new Insets(0, 0, 0, 0);

		// check box
		checkbox("Ket Noi CSDL", 0, 1, 100);
		checkbox("Khong Ket Noi CSDL", 2, 1, 200);

		// button
		button("Viet", 0, 0, 70);
		button("Anh", 2, 0, 70);
		button("Ket Noi", 0, 2, 100);
		button("Khong Ket Noi", 1, 2, 150);
		button("Dang Nhap", 2, 2, 100);

		c.add(image, BorderLayout.CENTER);
		// fit cho vua content trong win
		this.pack();
		this.setVisible(true);
	}

	public void checkbox(String name, int x, int y, int size) {
		JCheckBox chk = new JCheckBox();
		constraints.gridx = x;
		constraints.gridy = y;
		chk.setPreferredSize(new Dimension(size, 20));
		chk.setText(name);
		constraints.insets = new Insets(10, 50, 5, 2);
		image.add(chk, constraints);
		constraints.insets = new Insets(0, 0, 0, 0);
	}

	public void button(String name, int x, int y, int size) {

		JButton bt = new JButton();
		constraints.gridx = x;
		constraints.gridy = y;
		bt.setPreferredSize(new Dimension(size, 20));
		bt.setText(name);
		constraints.insets = new Insets(10, 50, 5, 2);
		image.add(bt, constraints);
		constraints.insets = new Insets(0, 0, 0, 0);
	}

	public static void main(String[] str) throws IOException {
		new LoginBoderLayout();
	}
}
