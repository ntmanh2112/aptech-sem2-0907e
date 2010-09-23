package dao;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.ChuyenXeModel;
import model.SoGheModel;
import util.DataUtil;

import common.Constants;

public class SoGheDAO {

	public static ArrayList<SoGheModel> searchAllSoGhe(String maChuyenXe) {
		Constants.initBundle();
		ArrayList<SoGheModel> listSoGhe = new ArrayList<SoGheModel>();
		try {
			CallableStatement csmt = DataUtil
					.getConnection()
					.prepareCall("{call sp_GetSoGheConTrong(?)}");	
			csmt.setString("maChuyenXe", maChuyenXe);
			ResultSet rs = csmt.executeQuery();
			while (rs.next()) {
				SoGheModel model = new SoGheModel();
				model.setId(rs.getString("id"));
				model.setMaChuyenXe(rs.getString("maChuyenXe"));
				model.setTenGhe(rs.getString("tenGhe"));
				model.setTinhTrang(rs.getString("tinhTrang"));
				
				listSoGhe.add(model);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listSoGhe;
	}
	
	public static ArrayList<SoGheModel> searchAllSoGheDatRoi(String maChuyenXe) {
		Constants.initBundle();
		ArrayList<SoGheModel> listSoGheDatRoi = new ArrayList<SoGheModel>();
		try {
			CallableStatement csmt = DataUtil
					.getConnection()
					.prepareCall("{call sp_GetGheDatRoi(?)}");	
			csmt.setString("maChuyenXe", maChuyenXe);
			ResultSet rs = csmt.executeQuery();
			while (rs.next()) {
				SoGheModel model = new SoGheModel();
				model.setId(rs.getString("id"));
				model.setMaChuyenXe(rs.getString("maChuyenXe"));
				model.setTenGhe(rs.getString("tenGhe"));
				model.setTinhTrang(rs.getString("tinhTrang"));
				
				listSoGheDatRoi.add(model);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listSoGheDatRoi;
	}
	
	public static Integer datCho(String maChuyenXe,String tenGhe) {

		Integer result = 0;
		try {
			CallableStatement csmt = DataUtil
					.getConnection()
					.prepareCall("{call sp_DatCho(?,?,?)}");	
			csmt.setString("maChuyenXe", maChuyenXe);
			csmt.setString("maGhe", tenGhe);
			csmt.registerOutParameter("result", java.sql.Types.INTEGER);
			csmt.execute();

			result = csmt.getInt("result");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public static Integer xoaCho(String maChuyenXe,String tenGhe) {

		Integer result = 0;
		try {
			CallableStatement csmt = DataUtil
					.getConnection()
					.prepareCall("{call sp_HuyCho(?,?,?)}");	
			csmt.setString("maChuyenXe", maChuyenXe);
			csmt.setString("maGhe", tenGhe);
			csmt.registerOutParameter("result", java.sql.Types.INTEGER);
			csmt.execute();

			result = csmt.getInt("result");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}
