package bai1;

import java.awt.Container;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

public class LuaChonDangNhap extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public LuaChonDangNhap(){
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
		this.setTitle("Lua Chon Dang Nhap");
		this.setLayout(null);
		this.setLocation(500, 500);
		this.setSize(550, 500);
		
		JButton btbViet = new JButton("Viet");
		btbViet.setSize(100,20);
		btbViet.setLocation(40, 150);
		
		JLabel lbLuaChon = new JLabel("Lua Chon Dang Nhap");
		lbLuaChon.setSize(200, 50);
		lbLuaChon.setLocation(180, 135);
		lbLuaChon.setFont(new Font("Arial",Font.BOLD,16));
		
		JButton btbAnh = new JButton("Anh");
		btbAnh.setSize(100,20);
		btbAnh.setLocation(400, 150);
		
		JRadioButton rdCSDL = new JRadioButton("Ket noi CSDL",false);
		rdCSDL.setSize(100,20);
		rdCSDL.setLocation(60, 250);
		
		JRadioButton rdKoCSDL = new JRadioButton("Khong ket noi CSDL",true);
		rdKoCSDL.setSize(250,20);
		rdKoCSDL.setLocation(350, 250);
		
		JButton btbKetNoi = new JButton("Ket noi");
		btbKetNoi.setSize(100,20);
		btbKetNoi.setLocation(40, 280);
		
		JButton btbKoKetNoi = new JButton("Khong ket noi");
		btbKoKetNoi.setSize(140,20);
		btbKoKetNoi.setLocation(180, 280);
		
		JButton btbDangNhap = new JButton("Dang nhap");
		btbDangNhap.setSize(140,20);
		btbDangNhap.setLocation(360, 280);
		
		c.add(btbViet);
		c.add(lbLuaChon);
		c.add(btbAnh);
		c.add(rdCSDL);
		c.add(rdKoCSDL);
		c.add(btbKetNoi);
		c.add(btbKoKetNoi);
		c.add(btbDangNhap);
		
		this.setVisible(true);
	}
}
