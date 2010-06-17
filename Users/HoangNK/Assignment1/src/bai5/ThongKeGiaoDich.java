package bai5;

import java.awt.Container;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;

public class ThongKeGiaoDich extends JFrame {
	private static final long serialVersionUID = 1L;

	public ThongKeGiaoDich() {
		try {
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			this.initialize();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private void initialize() {
		Container c = this.getContentPane();
		this.setTitle("Thong Ke Giao Dich");
		this.setLayout(null);
		this.setLocation(20, 20);
		this.setSize(1000, 1000);

		JLabel lbTieuDe = new JLabel("Thong Ke Giao Dich");
		lbTieuDe.setSize(300, 50);
		lbTieuDe.setLocation(300, 15);
		lbTieuDe.setFont(new Font("Arial", Font.ITALIC, 20));
		c.add(lbTieuDe);

		JLabel lbNgayBD = new JLabel("Ngay bat dau");
		lbNgayBD.setSize(200, 20);
		lbNgayBD.setLocation(50, 65);
		lbNgayBD.setFont(new Font("Arial", Font.ROMAN_BASELINE, 14));
		c.add(lbNgayBD);

		String[] NgayBatDau = { "2010-06-15" };
		JComboBox cbNgayBatDau = new JComboBox(NgayBatDau);
		cbNgayBatDau.setSize(150, 20);
		cbNgayBatDau.setLocation(200, 70);
		c.add(cbNgayBatDau);

		JLabel lbNgayKT = new JLabel("Ngay ket thuc");
		lbNgayKT.setSize(200, 20);
		lbNgayKT.setLocation(50, 100);
		lbNgayKT.setFont(new Font("Arial", Font.ROMAN_BASELINE, 14));
		c.add(lbNgayKT);

		String[] NgayKT = { "2010-06-15" };
		JComboBox cbNgayKT = new JComboBox(NgayKT);
		cbNgayKT.setLocation(200, 105);
		cbNgayKT.setSize(150, 20);
		c.add(cbNgayKT);

		JButton btbTimKiem = new JButton("Tim kiem");
		btbTimKiem.setSize(100, 20);
		btbTimKiem.setLocation(370, 105);
		c.add(btbTimKiem);

		JButton btbHuyBo = new JButton("Huy bo");
		btbHuyBo.setSize(100, 20);
		btbHuyBo.setLocation(480, 105);
		c.add(btbHuyBo);

		JButton btbIn = new JButton("In");
		btbIn.setSize(100, 20);
		btbIn.setLocation(590, 105);
		c.add(btbIn);

		JLabel lbDatMua = new JLabel("Dat mua");
		lbDatMua.setSize(200, 20);
		lbDatMua.setLocation(50, 145);
		lbDatMua.setFont(new Font("Arial", Font.ROMAN_BASELINE, 20));
		c.add(lbDatMua);

		JLabel lbBanHang = new JLabel("Ban hang");
		lbBanHang.setSize(200, 20);
		lbBanHang.setLocation(250, 145);
		lbBanHang.setFont(new Font("Arial", Font.ROMAN_BASELINE, 20));
		c.add(lbBanHang);

		Object[][] cells = { { new Integer(1), "2010-10-10", "2010-11-02" } };
		String[] datmua = { "STT", "Ngay nhan", "Tra" };
		JTable tbDatMua = new JTable(cells, datmua);
		tbDatMua.setSize(400, 200);
		tbDatMua.setLocation(50, 175);
		c.add(tbDatMua);

		Object[][] cells2 = { { new Integer(1), "2010-10-10", "2010-11-02" } };
		String[] banhang = { "STT", "Ngay gui", "Tra" };
		JTable tbBanHang = new JTable(cells2, banhang);
		tbBanHang.setSize(400, 200);
		tbBanHang.setLocation(250, 175);
		c.add(tbBanHang);

		JLabel lbTienChietKhau = new JLabel("Tien chiet khau");
		lbTienChietKhau.setSize(100, 20);
		lbTienChietKhau.setLocation(50, 400);
		lbTienChietKhau.setFont(new Font("Arial", Font.ROMAN_BASELINE, 14));
		c.add(lbTienChietKhau);

		JTextField txtTienChietKhau = new JTextField();
		txtTienChietKhau.setSize(150, 20);
		txtTienChietKhau.setLocation(150, 405);
		c.add(txtTienChietKhau);

		JLabel lbTienChietKhau2 = new JLabel("Tien chiet khau");
		lbTienChietKhau2.setSize(200, 20);
		lbTienChietKhau2.setLocation(300, 400);
		lbTienChietKhau2.setFont(new Font("Arial", Font.ROMAN_BASELINE, 14));
		c.add(lbTienChietKhau2);

		JTextField txtTienChietKhau2 = new JTextField();
		txtTienChietKhau2.setSize(150, 20);
		txtTienChietKhau2.setLocation(400, 405);
		c.add(txtTienChietKhau2);

		JLabel lbTienThue = new JLabel("Tien thue");
		lbTienThue.setSize(200, 20);
		lbTienThue.setLocation(50, 430);
		lbTienThue.setFont(new Font("Arial", Font.ROMAN_BASELINE, 14));
		c.add(lbTienThue);

		JTextField txtTienThue = new JTextField();
		txtTienThue.setSize(150, 20);
		txtTienThue.setLocation(150, 435);
		c.add(txtTienThue);

		JLabel lbTienThue2 = new JLabel("Tien thue");
		lbTienThue2.setSize(200, 20);
		lbTienThue2.setLocation(300, 430);
		lbTienThue2.setFont(new Font("Arial", Font.ROMAN_BASELINE, 14));
		c.add(lbTienThue2);

		JTextField txtTienThue2 = new JTextField();
		txtTienThue2.setSize(150, 20);
		txtTienThue2.setLocation(400, 435);
		c.add(txtTienThue2);

		JLabel lbTienTra = new JLabel("Tien tra");
		lbTienTra.setSize(200, 20);
		lbTienTra.setLocation(50, 460);
		lbTienTra.setFont(new Font("Arial", Font.ROMAN_BASELINE, 14));
		c.add(lbTienTra);

		JTextField txtTienTra = new JTextField();
		txtTienTra.setSize(150, 20);
		txtTienTra.setLocation(150, 465);
		c.add(txtTienTra);

		JLabel lbTienTra2 = new JLabel("Tien tra");
		lbTienTra2.setSize(200, 20);
		lbTienTra2.setLocation(300, 460);
		lbTienTra2.setFont(new Font("Arial", Font.ROMAN_BASELINE, 14));
		c.add(lbTienTra2);

		JTextField txtTienTra2 = new JTextField();
		txtTienTra2.setSize(150, 20);
		txtTienTra2.setLocation(400, 465);
		c.add(txtTienTra2);

		JLabel lbTongTien = new JLabel("Tong thanh tien");
		lbTongTien.setSize(200, 20);
		lbTongTien.setLocation(50, 495);
		lbTongTien.setFont(new Font("Arial", Font.ROMAN_BASELINE, 14));
		c.add(lbTongTien);

		JTextField txtTongTien = new JTextField();
		txtTongTien.setSize(150, 20);
		txtTongTien.setLocation(150, 500);
		c.add(txtTongTien);

		JLabel lbTongTien2 = new JLabel("Tong thanh tien");
		lbTongTien2.setSize(200, 20);
		lbTongTien2.setLocation(300, 495);
		lbTongTien2.setFont(new Font("Arial", Font.ROMAN_BASELINE, 14));
		c.add(lbTongTien2);

		JTextField txtTongTien2 = new JTextField();
		txtTongTien2.setSize(150, 20);
		txtTongTien2.setLocation(400, 500);
		c.add(txtTongTien2);

		JLabel lbNo = new JLabel("Tien no");
		lbNo.setSize(200, 20);
		lbNo.setLocation(50, 525);
		lbNo.setFont(new Font("Arial", Font.ROMAN_BASELINE, 14));
		c.add(lbNo);

		JTextField txtNo = new JTextField();
		txtNo.setSize(150, 20);
		txtNo.setLocation(150, 530);
		c.add(txtNo);

		JLabel lbNo2 = new JLabel("Tien no");
		lbNo2.setSize(200, 20);
		lbNo2.setLocation(300, 525);
		lbNo2.setFont(new Font("Arial", Font.ROMAN_BASELINE, 14));
		c.add(lbNo2);

		JTextField txtNo2 = new JTextField();
		txtNo2.setSize(150, 20);
		txtNo2.setLocation(400, 530);
		c.add(txtNo2);

		this.setVisible(true);
	}
}
