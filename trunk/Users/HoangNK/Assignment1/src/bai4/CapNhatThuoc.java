package bai4;

import java.awt.Container;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class CapNhatThuoc extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public CapNhatThuoc(){
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
		this.setTitle("Cap Nhat Thuoc");
		this.setLayout(null);
		this.setLocation(20, 20);
		this.setSize(1000, 1000);
		
		JLabel lbTieuDe = new JLabel("Cap Nhat Thuoc");
		lbTieuDe.setSize(300, 50);
		lbTieuDe.setLocation(100, 35);
		lbTieuDe.setFont(new Font("Arial",Font.ITALIC,30));
		
		JLabel lbTen = new JLabel("Ten");
		lbTen.setSize(200, 20);
		lbTen.setLocation(50, 165);
		lbTen.setFont(new Font("Arial",Font.ROMAN_BASELINE,14));
		
		String[] tenThuoc = { "Paracetamon", "Aspirin", "Insulin", "Morphin", "Taminflu" };
		JComboBox cbTen = new JComboBox(tenThuoc);
		cbTen.setLocation(200, 170);
		cbTen.setSize(200,30);
		
		JLabel lbTenQuocGia = new JLabel("Quoc gia");
		lbTenQuocGia.setSize(200, 20);
		lbTenQuocGia.setLocation(50, 200);
		lbTenQuocGia.setFont(new Font("Arial",Font.ROMAN_BASELINE,14));
		
		String[] tenQuocGia = { "My", "Uc", "Viet Nam", "Han Quoc", "Nhat Ban" };
		JComboBox cbTenQuocGia = new JComboBox(tenQuocGia);
		cbTenQuocGia.setLocation(200, 205);
		cbTenQuocGia.setSize(200,30);
		
		JLabel lbNhaSX = new JLabel("Nha san xuat");
		lbNhaSX.setSize(200, 30);
		lbNhaSX.setLocation(50, 240);
		lbNhaSX.setFont(new Font("Arial",Font.ROMAN_BASELINE,14));
		
		JTextField txtNhaSX = new JTextField();
		txtNhaSX.setSize(200,30);
		txtNhaSX.setLocation(200,245);
		
		JLabel lbCongThuc = new JLabel("Cong thuc");
		lbCongThuc.setSize(200, 30);
		lbCongThuc.setLocation(50, 280);
		lbCongThuc.setFont(new Font("Arial",Font.ROMAN_BASELINE,14));
		
		JTextField txtCongThuc = new JTextField();
		txtCongThuc.setSize(200,30);
		txtCongThuc.setLocation(200,285);
		
		JLabel lbCachDung = new JLabel("Cach dung");
		lbCachDung.setSize(200, 30);
		lbCachDung.setLocation(50, 330);
		lbCachDung.setFont(new Font("Arial",Font.ROMAN_BASELINE,14));
		
		JTextField txtCachDung = new JTextField();
		txtCachDung.setSize(200,30);
		txtCachDung.setLocation(200,335);
		
		JLabel lbDonVi = new JLabel("Don vi");
		lbDonVi.setSize(200, 30);
		lbDonVi.setLocation(50, 380);
		lbDonVi.setFont(new Font("Arial",Font.ROMAN_BASELINE,14));
		
		JTextField txtDonVi = new JTextField();
		txtDonVi.setSize(150,30);
		txtDonVi.setLocation(200,385);
		
		JLabel lbTrangThai = new JLabel("Trang thai");
		lbTrangThai.setSize(200, 30);
		lbTrangThai.setLocation(350, 380);
		lbTrangThai.setFont(new Font("Arial",Font.ROMAN_BASELINE,14));
		
		String[] TrangThai = { "Mo", "Dong"};
		JComboBox cbTrangThai = new JComboBox(TrangThai);
		cbTrangThai.setLocation(450, 385);
		cbTrangThai.setSize(200,30);
		
		JLabel lbSoLuong = new JLabel("So luong");
		lbSoLuong.setSize(200, 30);
		lbSoLuong.setLocation(50, 430);
		lbSoLuong.setFont(new Font("Arial",Font.ROMAN_BASELINE,14));
		
		JTextField txtSoLuong = new JTextField();
		txtSoLuong.setSize(150,30);
		txtSoLuong.setLocation(200,435);
		
		JLabel lbGia = new JLabel("Gia");
		lbGia.setSize(200, 30);
		lbGia.setLocation(350, 430);
		lbGia.setFont(new Font("Arial",Font.ROMAN_BASELINE,14));
		
		JTextField txtGia = new JTextField();
		txtGia.setSize(150,30);
		txtGia.setLocation(450,435);
		
		JButton btbCapNhat = new JButton("Cap nhat");
		btbCapNhat.setSize(100,20);
		btbCapNhat.setLocation(60, 480);
		
		JButton btbHuyBo = new JButton("Huy bo");
		btbHuyBo.setSize(100,20);
		btbHuyBo.setLocation(200, 480);
		
		c.add(btbCapNhat);
		c.add(btbHuyBo);
		c.add(txtCachDung);
		c.add(txtCongThuc);
		c.add(txtDonVi);
		c.add(txtGia);
		c.add(txtNhaSX);
		c.add(txtSoLuong);
		c.add(lbCachDung);
		c.add(lbCongThuc);
		c.add(lbDonVi);
		c.add(lbGia);
		c.add(lbNhaSX);
		c.add(lbSoLuong);
		c.add(lbTen);
		c.add(lbTenQuocGia);
		c.add(lbTieuDe);
		c.add(lbTrangThai);
		c.add(cbTen);
		c.add(cbTenQuocGia);
		c.add(cbTrangThai);
		
		this.setVisible(true);
		
	}
}
