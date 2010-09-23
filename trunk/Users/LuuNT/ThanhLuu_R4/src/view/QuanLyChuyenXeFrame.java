package view;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Rectangle;
import javax.swing.JComboBox;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;

import model.ChuyenXeModel;
import model.SoGheModel;


import dao.ChuyenXeDAO;
import dao.SoGheDAO;
import java.awt.Font;
import javax.swing.ImageIcon;

public class QuanLyChuyenXeFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JLabel lbTenChuyenXe = null;
	private JComboBox cboTenChuyenXe = null;
	private JLabel lbSoGhe = null;
	private JTextField txtSoGheConTrong = null;
	private JLabel lbMaGhe = null;
	private JTable tbMaGhe = null;
	private JButton btnDelete = null;
	private JButton btnSearch = null;
	private JComboBox cboTenGheTrong = null;
	private JLabel lbGheDatRoi = null;
	private JButton btnThemVe = null;
	private JComboBox cboGheDatRoi = null;
	private JButton btnDeleteVe = null;
	private JLabel lbTieuDe = null;

	/**
	 * This is the default constructor
	 */
	public QuanLyChuyenXeFrame() {
		super();
		initialize();
		loadDataCboTenChuyenXe();
		loadDataSoGheConTrong();
		loadCboGheTrong();
		loadCboGheDatRoi();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(426, 295);
		this.setContentPane(getJContentPane());
		this.setTitle("Quản Lý Chuyến Xe");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			lbTieuDe = new JLabel();
			lbTieuDe.setBounds(new Rectangle(106, 14, 254, 43));
			lbTieuDe.setFont(new Font("DialogInput", Font.BOLD | Font.ITALIC, 24));
			lbTieuDe.setForeground(new Color(138, 8, 8));
			lbTieuDe.setIcon(new ImageIcon("images data/Add-icon_2.png"));
			lbTieuDe.setText("Đặt Vé Xe");
			lbGheDatRoi = new JLabel();
			lbGheDatRoi.setText("Ghế Đặt Rồi :");
			lbGheDatRoi.setSize(new Dimension(116, 16));
			lbGheDatRoi.setLocation(new Point(30, 150));
			lbMaGhe = new JLabel();
			lbMaGhe.setText("Tên Ghế Trống :");
			lbMaGhe.setSize(new Dimension(116, 16));
			lbMaGhe.setLocation(new Point(30, 120));
			lbSoGhe = new JLabel();
			lbSoGhe.setText("Số Ghế Còn Trống :");
			lbSoGhe.setSize(new Dimension(116, 16));
			lbSoGhe.setLocation(new Point(30, 90));
			lbTenChuyenXe = new JLabel();
			lbTenChuyenXe.setText("Tên Chuyến Xe :");
			lbTenChuyenXe.setSize(new Dimension(116, 16));
			lbTenChuyenXe.setLocation(new Point(30, 60));
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.setBackground(new Color(230, 252, 226));
			jContentPane.add(lbTenChuyenXe, null);
			jContentPane.add(getCboTenChuyenXe(), null);
			jContentPane.add(lbSoGhe, null);
			jContentPane.add(getTxtSoGheConTrong(), null);
			jContentPane.add(lbMaGhe, null);
			jContentPane.add(getBtnDelete(), null);
			jContentPane.add(getBtnSearch(), null);
			jContentPane.add(getCboTenGheTrong(), null);
			jContentPane.add(lbGheDatRoi, null);
			jContentPane.add(getBtnThemVe(), null);
			jContentPane.add(getCboGheDatRoi(), null);
			jContentPane.add(getBtnDeleteVe(), null);
			jContentPane.add(lbTieuDe, null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes cboTenChuyenXe	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getCboTenChuyenXe() {
		if (cboTenChuyenXe == null) {
			cboTenChuyenXe = new JComboBox();
			cboTenChuyenXe.setLocation(new Point(146, 60));
			cboTenChuyenXe.setSize(new Dimension(206, 16));

		}
		return cboTenChuyenXe;
	}

	/**
	 * This method initializes txtSoGheConTrong	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtSoGheConTrong() {
		if (txtSoGheConTrong == null) {
			txtSoGheConTrong = new JTextField();
			txtSoGheConTrong.setLocation(new Point(146, 90));
			txtSoGheConTrong.setEnabled(false);
			txtSoGheConTrong.setSize(new Dimension(206, 16));
		}
		return txtSoGheConTrong;
	}

	/**
	 * This method initializes btnDelete	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtnDelete() {
		if (btnDelete == null) {
			btnDelete = new JButton();
			btnDelete.setBounds(new Rectangle(30, 210, 113, 31));
			btnDelete.setText("Delete");
			btnDelete.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					int ketqua = ChuyenXeDAO.deleteChuyenXe(cboTenChuyenXe.getSelectedItem().toString());
					if(ketqua == 1 ){
						JOptionPane.showMessageDialog(null,"Thành Công");
						txtSoGheConTrong.setText("");
						loadDataCboTenChuyenXe();
						loadDataSoGheConTrong();
						cboGheDatRoi.removeAllItems();
						cboTenGheTrong.removeAllItems();
					}else {
						JOptionPane.showMessageDialog(null,"Thất Bại");
					}
				}
			});
		}
		return btnDelete;
	}
	
	public void loadDataCboTenChuyenXe(){
		cboTenChuyenXe.removeAllItems();
		cboTenChuyenXe.addItem("All");
		ArrayList<ChuyenXeModel> listChuyenXe = ChuyenXeDAO.searchAllChuyenXe();			
		for (ChuyenXeModel obj : listChuyenXe) {	
			
				cboTenChuyenXe.addItem(obj.getTenChuyenXe());
					
		}
		
	}
	public void loadDataSoGheConTrong(){
		if(cboTenChuyenXe.getSelectedItem().toString().equals("All")){
		
			ArrayList<SoGheModel> listChuyenXe = SoGheDAO.searchAllSoGhe(cboTenChuyenXe.getSelectedItem().toString());
			txtSoGheConTrong.setText(""+listChuyenXe.size());
			loadCboGheTrong();
			loadCboGheDatRoi();
		}else{
			ArrayList<SoGheModel> listChuyenXe = SoGheDAO.searchAllSoGhe(cboTenChuyenXe.getSelectedItem().toString());
			txtSoGheConTrong.setText(""+listChuyenXe.size());
			loadCboGheTrong();
			loadCboGheDatRoi();
		}
	}
public void loadCboGheTrong(){
	cboTenGheTrong.removeAllItems();
	ArrayList<SoGheModel> listChuyenXe = SoGheDAO.searchAllSoGhe(cboTenChuyenXe.getSelectedItem().toString());
	if(listChuyenXe.size() == 0){
		cboTenGheTrong.addItem("Hết Ghế");
	}
	for (SoGheModel obj : listChuyenXe) {	
		cboTenGheTrong.addItem(obj.getTenGhe());
	}
	
}
public void loadCboGheDatRoi(){
	cboGheDatRoi.removeAllItems();
	ArrayList<SoGheModel> listChuyenXe = SoGheDAO.searchAllSoGheDatRoi(cboTenChuyenXe.getSelectedItem().toString());
	if(listChuyenXe.size() == 0){
		cboGheDatRoi.addItem("Chứa Có Vé Nào");
	}
	for (SoGheModel obj : listChuyenXe) {	
		cboGheDatRoi.addItem(obj.getTenGhe());
	}
	
}
	/**
	 * This method initializes btnSearch	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtnSearch() {
		if (btnSearch == null) {
			btnSearch = new JButton();
			btnSearch.setLocation(new Point(150, 210));
			btnSearch.setText("Tìm Số Ghế");
			btnSearch.setSize(new Dimension(113, 31));
			btnSearch.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if(cboTenChuyenXe.getSelectedItem().toString().equals("All")){
						loadDataSoGheConTrong();
					}else{
						loadDataSoGheConTrong();
					}
				}
			});
		}
		return btnSearch;
	}

	/**
	 * This method initializes cboTenGheTrong	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getCboTenGheTrong() {
		if (cboTenGheTrong == null) {
			cboTenGheTrong = new JComboBox();
			cboTenGheTrong.setLocation(new Point(146, 120));
			cboTenGheTrong.setSize(new Dimension(206, 16));
		}
		return cboTenGheTrong;
	}

	/**
	 * This method initializes btnThemVe	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtnThemVe() {
		if (btnThemVe == null) {
			btnThemVe = new JButton();
			btnThemVe.setPreferredSize(new Dimension(34, 16));
			btnThemVe.setSize(new Dimension(46, 16));
			btnThemVe.setIcon(new ImageIcon("images data/button-ok-icon.png"));
			btnThemVe.setLocation(new Point(360, 120));
			btnThemVe.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					
					if(cboTenGheTrong.getSelectedItem().toString().equals("Hết Ghế")){
						JOptionPane.showMessageDialog(null,"Không Còn Chỗ Trống");
					}else{
						
						int ketQua = SoGheDAO.datCho(cboTenChuyenXe.getSelectedItem().toString(),cboTenGheTrong.getSelectedItem().toString());
						if(ketQua == 1 ){
							JOptionPane.showMessageDialog(null,"Thành Công");
							loadCboGheTrong();
							loadCboGheDatRoi();
							loadDataSoGheConTrong();
						}else{
							JOptionPane.showMessageDialog(null,"Thất Bại");
						}
					}
					
				}
			});
		}
		return btnThemVe;
	}

	/**
	 * This method initializes cboGheDatRoi	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getCboGheDatRoi() {
		if (cboGheDatRoi == null) {
			cboGheDatRoi = new JComboBox();
			cboGheDatRoi.setLocation(new Point(146, 150));
			cboGheDatRoi.setSize(new Dimension(206, 16));
		}
		return cboGheDatRoi;
	}

	/**
	 * This method initializes btnDeleteVe	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtnDeleteVe() {
		if (btnDeleteVe == null) {
			btnDeleteVe = new JButton();
			btnDeleteVe.setLocation(new Point(360, 150));
			btnDeleteVe.setIcon(new ImageIcon("images data/button-cancel-icon.png"));
			btnDeleteVe.setSize(new Dimension(46, 16));
			btnDeleteVe.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if(cboGheDatRoi.getSelectedItem().toString().equals("Chứa Có Vé Nào")){
						JOptionPane.showMessageDialog(null,"Chưa Có Vé Nào ");
					}else {
						int ketQua = SoGheDAO.xoaCho(cboTenChuyenXe.getSelectedItem().toString(),cboGheDatRoi.getSelectedItem().toString());
						if(ketQua == 1 ){
							JOptionPane.showMessageDialog(null,"Thành Công");
							loadCboGheTrong();
							loadCboGheDatRoi();
							loadDataSoGheConTrong();
						}else{
							JOptionPane.showMessageDialog(null,"Thất Bại");
						}
					}
					
				}
			});
		}
		return btnDeleteVe;
	}

}  //  @jve:decl-index=0:visual-constraint="323,120"
