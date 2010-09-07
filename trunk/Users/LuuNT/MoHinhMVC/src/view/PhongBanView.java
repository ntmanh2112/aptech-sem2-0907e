package view;

import java.awt.BorderLayout;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Rectangle;
import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JButton;

import model.PhongBanModel;

import dao.PhongBanDAO;

public class PhongBanView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JLabel lbTieuDe = null;
	private JLabel lbTenPhong = null;
	private JLabel lbMaPhong = null;
	private JLabel lbTruongPhong = null;
	private JLabel lbNgayNhanChuc = null;
	private JTextField txtTenPhong = null;
	private JTextField txtMaPhong = null;
	private JTextField txtTruongPhong = null;
	private JTextField txtNgayNhanChuc = null;
	private JButton btnPri = null;
	private JButton btnNew = null;
	private JButton btnUpdate = null;
	private JButton btnDelete = null;
	private JButton btnNext = null;
	private int mount = 0 ;  //  @jve:decl-index=0:
	private ArrayList listPhongBan = new ArrayList() ;  //  @jve:decl-index=0:
	/**
	 * This is the default constructor
	 */
	public PhongBanView() {
		super();
		initialize();
		this.setVisible(true);
		getDataBase();
		setTXT();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	public void getDataBase(){

		listPhongBan = PhongBanDAO.getPhongBan();
	}
	public void setTXT(){
		txtTenPhong.setText(((PhongBanModel)	listPhongBan.get(mount)).getTenPHG());
		txtMaPhong.setText(((PhongBanModel)	listPhongBan.get(mount)).getMaPHG());
		txtTruongPhong.setText(((PhongBanModel)	listPhongBan.get(mount)).getTrPHG());
		txtNgayNhanChuc.setText(((PhongBanModel)	listPhongBan.get(mount)).getNg_NhanChuc());
	}
	private void initialize() {
		this.setSize(462, 512);
		this.setContentPane(getJContentPane());
		this.setTitle("JFrame");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			lbNgayNhanChuc = new JLabel();
			lbNgayNhanChuc.setText("Ngay Nhan Chuc");
			lbNgayNhanChuc.setSize(new Dimension(105, 16));
			lbNgayNhanChuc.setLocation(new Point(45, 196));
			lbTruongPhong = new JLabel();
			lbTruongPhong.setText("Truong Phong");
			lbTruongPhong.setSize(new Dimension(105, 16));
			lbTruongPhong.setLocation(new Point(45, 166));
			lbMaPhong = new JLabel();
			lbMaPhong.setText("Ma Phong");
			lbMaPhong.setSize(new Dimension(105, 16));
			lbMaPhong.setLocation(new Point(46, 135));
			lbTenPhong = new JLabel();
			lbTenPhong.setBounds(new Rectangle(46, 106, 105, 16));
			lbTenPhong.setText("Ten Phong");
			lbTieuDe = new JLabel();
			lbTieuDe.setBounds(new Rectangle(183, 59, 103, 30));
			lbTieuDe.setForeground(new Color(240, 14, 14));
			lbTieuDe.setFont(new Font("Dialog", Font.BOLD, 18));
			lbTieuDe.setText("Phong Ban");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(lbTieuDe, null);
			jContentPane.add(lbTenPhong, null);
			jContentPane.add(lbMaPhong, null);
			jContentPane.add(lbTruongPhong, null);
			jContentPane.add(lbNgayNhanChuc, null);
			jContentPane.add(getTxtTenPhong(), null);
			jContentPane.add(getTxtMaPhong(), null);
			jContentPane.add(getTxtTruongPhong(), null);
			jContentPane.add(getTxtNgayNhanChuc(), null);
			jContentPane.add(getBtnPri(), null);
			jContentPane.add(getBtnNew(), null);
			jContentPane.add(getBtnUpdate(), null);
			jContentPane.add(getBtnDelete(), null);
			jContentPane.add(getBtnNext(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes txtTenPhong	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtTenPhong() {
		if (txtTenPhong == null) {
			txtTenPhong = new JTextField();
			txtTenPhong.setSize(new Dimension(197, 18));
			txtTenPhong.setLocation(new Point(181, 105));
		}
		return txtTenPhong;
	}

	/**
	 * This method initializes txtMaPhong	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtMaPhong() {
		if (txtMaPhong == null) {
			txtMaPhong = new JTextField();
			txtMaPhong.setSize(new Dimension(197, 18));
			txtMaPhong.setLocation(new Point(181, 135));
			txtMaPhong.setEditable(false);
		}
		return txtMaPhong;
	}

	/**
	 * This method initializes txtTruongPhong	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtTruongPhong() {
		if (txtTruongPhong == null) {
			txtTruongPhong = new JTextField();
			txtTruongPhong.setLocation(new Point(181, 165));
			txtTruongPhong.setSize(new Dimension(197, 18));
		}
		return txtTruongPhong;
	}

	/**
	 * This method initializes txtNgayNhanChuc	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtNgayNhanChuc() {
		if (txtNgayNhanChuc == null) {
			txtNgayNhanChuc = new JTextField();
			txtNgayNhanChuc.setLocation(new Point(181, 195));
			txtNgayNhanChuc.setSize(new Dimension(197, 18));
		}
		return txtNgayNhanChuc;
	}

	/**
	 * This method initializes btnPri	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtnPri() {
		if (btnPri == null) {
			btnPri = new JButton();
			btnPri.setBounds(new Rectangle(30, 241, 77, 29));
			btnPri.setText("Pri");
			btnPri.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if(btnNew.getText().equals("Add")){
						txtMaPhong.setEditable(false);
						btnNew.setText("New");
					}
					if(mount == 0){
						JOptionPane.showMessageDialog(null,"Dang O Trang Dau Tien");
					} else {
						mount = mount -1 ;
						setTXT();
					}
					//System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return btnPri;
	}

	/**
	 * This method initializes btnNew	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtnNew() {
		if (btnNew == null) {
			btnNew = new JButton();
			btnNew.setLocation(new Point(135, 240));
			btnNew.setText("New");
			btnNew.setSize(new Dimension(77, 29));
			btnNew.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if(btnNew.getText().equals("New")){
						btnNew.setText("Add");
						txtMaPhong.setText("");
						txtNgayNhanChuc.setText("");
						txtMaPhong.setEditable(true);
						txtTenPhong.setText("");
						txtTruongPhong.setText("");
					}else{
						int ketQua = PhongBanDAO.insertPhongBan(txtTenPhong.getText(), txtMaPhong.getText(), txtTruongPhong.getText(), txtNgayNhanChuc.getText());
						if(ketQua == 1){
							getDataBase();
							setTXT();
							txtMaPhong.setEditable(false);
							JOptionPane.showMessageDialog(null,"Thanh Cong");
						}
						else{
						JOptionPane.showMessageDialog(null,"That Bai");
						}
					}
					//System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return btnNew;
	}

	/**
	 * This method initializes btnUpdate	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtnUpdate() {
		if (btnUpdate == null) {
			btnUpdate = new JButton();
			btnUpdate.setLocation(new Point(241, 240));
			btnUpdate.setText("Update");
			btnUpdate.setSize(new Dimension(77, 29));
			btnUpdate.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					int ketQua = PhongBanDAO.updatePhongBan(txtTenPhong.getText(), txtMaPhong.getText(), txtTruongPhong.getText(), txtNgayNhanChuc.getText());
					if(ketQua == 1){
						getDataBase();
						setTXT();
						txtMaPhong.setEditable(false);
						JOptionPane.showMessageDialog(null,"Thanh Cong");
					}
					else{
					JOptionPane.showMessageDialog(null,"That Bai");
					}
				}
			});
			
		}
		return btnUpdate;
	}

	/**
	 * This method initializes btnDelete	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtnDelete() {
		if (btnDelete == null) {
			btnDelete = new JButton();
			btnDelete.setText("Delete");
			btnDelete.setSize(new Dimension(77, 29));
			btnDelete.setLocation(new Point(345, 240));
		}
		return btnDelete;
	}

	/**
	 * This method initializes btnNext	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtnNext() {
		if (btnNext == null) {
			btnNext = new JButton();
			btnNext.setLocation(new Point(181, 286));
			btnNext.setText("Next");
			btnNext.setSize(new Dimension(77, 29));
			btnNext.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					if(btnNew.getText().equals("Add")){
						txtMaPhong.setEditable(false);
						btnNew.setText("New");
					}
					if(mount+1 == listPhongBan.size()){
						JOptionPane.showMessageDialog(null,"Dang O Trang Cuoi Cung");
					}else{
						mount = mount +1;
						setTXT();
					}
				}
			});
		}
		return btnNext;
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
