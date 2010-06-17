package bai7;

import java.awt.Container;
import java.awt.Font;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Login extends JFrame {
	private static final long serialVersionUID = 1L;

	public Login() {
		try {
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			this.initialize();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private void initialize() {
		Container c = this.getContentPane();
		this.setTitle("Login");
		this.setLayout(null);
		this.setLocation(20, 20);
		this.setSize(500, 500);

		ImageIcon icon = new ImageIcon("Contact.png");
		JLabel lbTieuDe = new JLabel("Login", icon, SwingConstants.LEFT);
		lbTieuDe.setIcon(icon);
		lbTieuDe.setSize(300, 50);
		lbTieuDe.setLocation(200, 15);
		lbTieuDe.setFont(new Font("Arial", Font.ITALIC, 20));
		c.add(lbTieuDe);

		JLabel lbTenDangNhap = new JLabel("User name");
		lbTenDangNhap.setSize(200, 20);
		lbTenDangNhap.setLocation(50, 65);
		lbTenDangNhap.setFont(new Font("Arial", Font.ROMAN_BASELINE, 16));
		c.add(lbTenDangNhap);

		JTextField txtTenDangNhap = new JTextField();
		txtTenDangNhap.setSize(200, 20);
		txtTenDangNhap.setLocation(200, 70);
		c.add(txtTenDangNhap);

		JLabel lbPassWord = new JLabel("Password");
		lbPassWord.setSize(200, 20);
		lbPassWord.setLocation(50, 95);
		lbPassWord.setFont(new Font("Arial", Font.ROMAN_BASELINE, 16));
		c.add(lbPassWord);

		JPasswordField txtPassWord = new JPasswordField();
		txtPassWord.setSize(200, 20);
		txtPassWord.setLocation(200, 100);
		c.add(txtPassWord);

		Icon ico = new ImageIcon("images data/changepass1.png");
		JButton btbDongY = new JButton("OK");
		btbDongY.setSize(100, 20);
		btbDongY.setLocation(100, 140);
		btbDongY.setIcon(ico);
		c.add(btbDongY);

		Icon ico2 = new ImageIcon("images data/Symbols-Delete-icon.png");
		JButton btbHuyBo = new JButton("Exit");
		btbHuyBo.setSize(100, 20);
		btbHuyBo.setLocation(220, 140);
		btbHuyBo.setIcon(ico2);
		c.add(btbHuyBo);

		this.setVisible(true);
	}
}
