package bai3;

import java.awt.Container;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class DangNhapQuanLy extends JFrame{
	public DangNhapQuanLy(){
		try{
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			this.initialize();
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}
	private void initialize(){
		Container c = this.getContentPane();
		this.setTitle("Dang Nhap Quan Ly");
		this.setLayout(null);
		this.setLocation(500, 500);
		this.setSize(550, 500);
		
		JLabel lbTieuDe = new JLabel("Dang Nhap Quan Ly");
		lbTieuDe.setSize(300, 50);
		lbTieuDe.setLocation(100, 35);
		lbTieuDe.setFont(new Font("Arial",Font.ITALIC,30));
		
		JLabel lbTenDangNhap = new JLabel("Ten Dang Nhap");
		lbTenDangNhap.setSize(200, 50);
		lbTenDangNhap.setLocation(50, 165);
		lbTenDangNhap.setFont(new Font("Arial",Font.ROMAN_BASELINE,16));
		
		JTextField txtTenDangNhap = new JTextField();
		txtTenDangNhap.setSize(200,30);
		txtTenDangNhap.setLocation(200,170);
		
		JLabel lbMatKhau = new JLabel("Mat Khau");
		lbMatKhau.setSize(200, 50);
		lbMatKhau.setLocation(50, 200);
		lbMatKhau.setFont(new Font("Arial",Font.ROMAN_BASELINE,16));
		
		JPasswordField pwMatKhau = new JPasswordField();
		pwMatKhau.setSize(200,30);
		pwMatKhau.setLocation(200,205);
		
		JButton btbDongY = new JButton("Dong y");
		btbDongY.setSize(100,20);
		btbDongY.setLocation(40, 260);
		
		JButton btbHuyBo = new JButton("Huy bo");
		btbHuyBo.setSize(100,20);
		btbHuyBo.setLocation(200, 260);
		
		c.add(lbTieuDe);
		c.add(lbMatKhau);
		c.add(lbTenDangNhap);
		c.add(txtTenDangNhap);
		c.add(pwMatKhau);
		c.add(btbDongY);
		c.add(btbHuyBo);
		
		this.setVisible(true);
		
	}
}
