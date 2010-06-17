package bai2;

import java.awt.Container;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class DangNhapMayChu extends JFrame{
	public DangNhapMayChu(){
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
		this.setTitle("Dang Nhap May Chu");
		this.setLayout(null);
		this.setLocation(500, 500);
		this.setSize(550, 500);
		
		JLabel lbTieuDe = new JLabel("Dang Nhap May Chu");
		lbTieuDe.setSize(300, 50);
		lbTieuDe.setLocation(100, 35);
		lbTieuDe.setFont(new Font("Arial",Font.ITALIC,30));
		
		JLabel lbTenMay = new JLabel("Ten May Chu");
		lbTenMay.setSize(200, 50);
		lbTenMay.setLocation(50, 165);
		lbTenMay.setFont(new Font("Arial",Font.ROMAN_BASELINE,16));
		
		JTextField txtTenMay = new JTextField();
		txtTenMay.setSize(200,30);
		txtTenMay.setLocation(200,170);
		
		JLabel lbCSDL = new JLabel("CSDL");
		lbCSDL.setSize(200, 50);
		lbCSDL.setLocation(50, 200);
		lbCSDL.setFont(new Font("Arial",Font.ROMAN_BASELINE,16));
		
		JTextField txtCSDL = new JTextField();
		txtCSDL.setSize(200,30);
		txtCSDL.setLocation(200,205);
		
		JLabel lbDangNhap = new JLabel("Dang Nhap");
		lbDangNhap.setSize(200, 50);
		lbDangNhap.setLocation(50, 250);
		lbDangNhap.setFont(new Font("Arial",Font.ROMAN_BASELINE,16));
		
		JTextField txtDangNhap = new JTextField();
		txtDangNhap.setSize(200,30);
		txtDangNhap.setLocation(200,255);
		
		JLabel lbMatKhau = new JLabel("Mat Khau");
		lbMatKhau.setSize(200, 50);
		lbMatKhau.setLocation(50, 300);
		lbMatKhau.setFont(new Font("Arial",Font.ROMAN_BASELINE,16));
		
		JPasswordField pwMatKhau = new JPasswordField();
		pwMatKhau.setSize(200,30);
		pwMatKhau.setLocation(200,305);
		
		JButton btbDongY = new JButton("Dong y");
		btbDongY.setSize(100,20);
		btbDongY.setLocation(40, 360);
		
		JButton btbHuyBo = new JButton("Huy bo");
		btbHuyBo.setSize(100,20);
		btbHuyBo.setLocation(200, 360);
		
		c.add(lbTieuDe);
		c.add(lbTenMay);
		c.add(txtTenMay);
		c.add(lbCSDL);
		c.add(txtCSDL);
		c.add(lbDangNhap);
		c.add(txtDangNhap);
		c.add(lbMatKhau);
		c.add(pwMatKhau);
		c.add(btbDongY);
		c.add(btbHuyBo);
		
		this.setVisible(true);
	}
}
