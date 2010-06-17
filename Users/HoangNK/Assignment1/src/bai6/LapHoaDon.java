package bai6;

import java.awt.Container;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;

public class LapHoaDon extends JFrame {
	private static final long serialVersionUID = 1L;

	public LapHoaDon() {
		try {
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			this.initialize();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private void initialize() {
		Container c = this.getContentPane();
		this.setTitle("Lap hoa don ban hang");
		this.setLayout(null);
		this.setLocation(20, 20);
		this.setSize(1000, 1000);

		JLabel lbTieuDe = new JLabel("Lap hoa don ban hang");
		lbTieuDe.setSize(300, 50);
		lbTieuDe.setLocation(300, 15);
		lbTieuDe.setFont(new Font("Arial", Font.ITALIC, 20));
		c.add(lbTieuDe);

		JLabel lbTenKH = new JLabel("Ten khach hang");
		lbTenKH.setSize(200, 20);
		lbTenKH.setLocation(50, 65);
		lbTenKH.setFont(new Font("Arial", Font.ROMAN_BASELINE, 14));
		c.add(lbTenKH);

		String[] tenkhachhang = { "Customer1", "Customer2", "Customer3",
				"Customer4" };
		JComboBox cbTenKhach = new JComboBox(tenkhachhang);
		cbTenKhach.setSize(150, 20);
		cbTenKhach.setLocation(200, 70);
		c.add(cbTenKhach);
		
		JLabel lbNgayDat = new JLabel("Ngay dat");
		lbNgayDat.setSize(200, 20);
		lbNgayDat.setLocation(400, 65);
		lbNgayDat.setFont(new Font("Arial", Font.ROMAN_BASELINE, 14));
		c.add(lbNgayDat);

		String[] ngaydat = { "24-10-2010", "25-12-2010"};
		JComboBox cbNgayDat = new JComboBox(ngaydat);
		cbNgayDat.setSize(150, 20);
		cbNgayDat.setLocation(500, 70);
		c.add(cbNgayDat);
		
		JLabel lbGhiChu = new JLabel("Ghi chu");
		lbGhiChu.setSize(200, 20);
		lbGhiChu.setLocation(50,95);
		lbGhiChu.setFont(new Font("Arial", Font.ROMAN_BASELINE, 14));
		c.add(lbGhiChu);

		JTextField txtGhiChu = new JTextField();
		txtGhiChu.setSize(150, 20);
		txtGhiChu.setLocation(200,100);
		c.add(txtGhiChu);
		
		JLabel lbNgayGui = new JLabel("Ngay gui");
		lbNgayGui.setSize(200, 20);
		lbNgayGui.setLocation(400, 95);
		lbNgayGui.setFont(new Font("Arial", Font.ROMAN_BASELINE, 14));
		c.add(lbNgayGui);

		String[] ngaygui = { "24-10-2010", "25-12-2010"};
		JComboBox cbNgayGui = new JComboBox(ngaygui);
		cbNgayGui.setSize(150, 20);
		cbNgayGui.setLocation(500,100);
		c.add(cbNgayGui);
		
		JLabel lbTienTra = new JLabel("Tien tra");
		lbTienTra.setSize(200, 20);
		lbTienTra.setLocation(50,125);
		lbTienTra.setFont(new Font("Arial", Font.ROMAN_BASELINE, 14));
		c.add(lbTienTra);

		JTextField txtTienTra = new JTextField();
		txtTienTra.setSize(150, 20);
		txtTienTra.setLocation(200,130);
		c.add(txtTienTra);
		
		JLabel lbNgayTra = new JLabel("Ngay tra");
		lbNgayTra.setSize(200, 20);
		lbNgayTra.setLocation(400, 125);
		lbNgayTra.setFont(new Font("Arial", Font.ROMAN_BASELINE, 14));
		c.add(lbNgayTra);

		String[] ngaytra = { "24-10-2010", "25-12-2010"};
		JComboBox cbNgayTra = new JComboBox(ngaytra);
		cbNgayTra.setSize(150, 20);
		cbNgayTra.setLocation(500,130);
		c.add(cbNgayTra);
		
		Object[][] cells = { {"Click",new Integer(0),new Integer(0),new Integer(0)} };
		String[] datmua = { "Ten thuoc", "So luong", "Gia" ,"Tong tien"};
		JTable tbHoaDon = new JTable(cells,datmua);
		tbHoaDon.setSize(400,150);
		tbHoaDon.setLocation(200,165);
		c.add(tbHoaDon);
		
		JLabel lbTongTien = new JLabel("Tong so tien");
		lbTongTien.setSize(200, 20);
		lbTongTien.setLocation(20,365);
		lbTongTien.setFont(new Font("Arial", Font.ROMAN_BASELINE, 14));
		c.add(lbTongTien);

		JTextField txtTongTien = new JTextField();
		txtTongTien.setSize(150, 20);
		txtTongTien.setLocation(150,370);
		c.add(txtTongTien);
		
		JLabel lbChietKhau = new JLabel("Chiet khau");
		lbChietKhau.setSize(200, 20);
		lbChietKhau.setLocation(320,365);
		lbChietKhau.setFont(new Font("Arial", Font.ROMAN_BASELINE, 14));
		c.add(lbChietKhau);

		JTextField txtChietKhau = new JTextField();
		txtChietKhau.setSize(150, 20);
		txtChietKhau.setLocation(400,370);
		c.add(txtChietKhau);
		
		JButton btbDongY = new JButton("Dong y");
		btbDongY.setSize(100, 20);
		btbDongY.setLocation(570, 365);
		c.add(btbDongY);
		
		JButton btbHuy = new JButton("Huy bo");
		btbHuy.setSize(100, 20);
		btbHuy.setLocation(680, 365);
		c.add(btbHuy);
		
		JLabel lbTongThanhTien = new JLabel("Tong thanh tien");
		lbTongThanhTien.setSize(200, 20);
		lbTongThanhTien.setLocation(20,395);
		lbTongThanhTien.setFont(new Font("Arial", Font.ROMAN_BASELINE, 14));
		c.add(lbTongThanhTien);

		JTextField txtTongThanhTien = new JTextField();
		txtTongThanhTien.setSize(150, 20);
		txtTongThanhTien.setLocation(150,400);
		c.add(txtTongThanhTien);
		
		JLabel lbThue = new JLabel("Tien thue");
		lbThue.setSize(200, 20);
		lbThue.setLocation(320,395);
		lbThue.setFont(new Font("Arial", Font.ROMAN_BASELINE, 14));
		c.add(lbThue);

		JTextField txtThue = new JTextField();
		txtThue.setSize(150, 20);
		txtThue.setLocation(400,400);
		c.add(txtThue);
		
		JButton btbGuiThu = new JButton("Gui thu");
		btbGuiThu.setSize(100, 20);
		btbGuiThu.setLocation(570, 395);
		c.add(btbGuiThu);
		
		JButton btbIn = new JButton("In");
		btbIn.setSize(100, 20);
		btbIn.setLocation(680,395);
		c.add(btbIn);

		this.setVisible(true);
	}
}
