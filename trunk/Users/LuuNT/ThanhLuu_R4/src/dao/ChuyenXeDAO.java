package dao;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.ChuyenXeModel;

import util.DataUtil;

import common.Constants;

public class ChuyenXeDAO {

	public static int deleteChuyenXe(String maChuyenXe){
		Integer result = 0 ;
		CallableStatement csmt;
		try {
			csmt = DataUtil.getConnection().prepareCall("{call sp_DeleteChuyenXe(?,?)}");
			csmt.setString("maChuyenXe",maChuyenXe);	
			csmt.registerOutParameter("result", java.sql.Types.INTEGER);

			csmt.execute();

			result = csmt.getInt("result");
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
		
	}
	public static ArrayList<ChuyenXeModel> searchAllChuyenXe() {
		Constants.initBundle();
		ArrayList<ChuyenXeModel> listChuyenXe = new ArrayList<ChuyenXeModel>();
		try {
			CallableStatement csmt = DataUtil
					.getConnection()
					.prepareCall("{call sp_GetAllChuyenXe()}");					
			ResultSet rs = csmt.executeQuery();
			while (rs.next()) {
				ChuyenXeModel model = new ChuyenXeModel();
				model.setTenChuyenXe(rs.getString("tenChuyenXe"));
				
				listChuyenXe.add(model);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listChuyenXe;
	}

}
