package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.PhongBanModel;
import util.DataUtil;

public class PhongBanDAO {

	public static ArrayList getPhongBan(){
		ArrayList listPhongBan = new ArrayList();;
		try {

			String sql = "select * from PhongBan order by tenphg";
			PreparedStatement ps = DataUtil.getConnection().prepareStatement(sql);
			ResultSet rsKetQua = ps.executeQuery();
			while(rsKetQua.next()){		
				PhongBanModel model = new PhongBanModel();
				model.setMaPHG(rsKetQua.getString("Maphg"));
				model.setTenPHG(rsKetQua.getString("Tenphg"));
				model.setTrPHG(rsKetQua.getString("Trphg"));
				model.setNg_NhanChuc(rsKetQua.getString("Ng_NhanChuc"));
				
				listPhongBan.add(model);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return listPhongBan;
		
	}
	public static Integer insert(String tenPHG,String maPHG , String trPHG , String ng_NhanChuc){
		Integer result = 0 ;
		
		return result;
	}
	public static int insertPhongBan(String tenPHG,String maPHG , String trPHG , String ng_NhanChuc){
		String sql = "insert into phongban values (?,?,?,?)";
		try {
			PreparedStatement ps = DataUtil.getConnection().prepareStatement(sql);
			ps.setString(1,tenPHG);
			ps.setString(2,maPHG);
			ps.setString(3,trPHG);
			ps.setString(4,ng_NhanChuc);
			int ketQua = ps.executeUpdate();

			return ketQua;
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return 0;
		}
		
	}
	public static int updatePhongBan(String tenPHG,String maPHG , String trPHG , String ng_NhanChuc){
		String sql = "update phongban set tenPHG = ?  , trPHG = ?, ng_NhanChuc = ? where maPHG = ?";
		try {
			PreparedStatement ps = DataUtil.getConnection().prepareStatement(sql);
			ps.setString(1,tenPHG);
			ps.setString(2,trPHG);
			ps.setString(3,ng_NhanChuc);
			ps.setString(4,maPHG);
			int ketQua = ps.executeUpdate();

			return ketQua;
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return 0;
		}
	}
	
}
