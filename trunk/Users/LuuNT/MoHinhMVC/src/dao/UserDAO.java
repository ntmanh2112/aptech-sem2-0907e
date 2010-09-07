package dao;

import java.sql.CallableStatement;
import java.sql.SQLException;

import util.DataUtil;

public class UserDAO {

	public static Integer checkLogin(String userName , String passWord){
		Integer result = 0 ;
		CallableStatement csmt;
		try {
			csmt = DataUtil.getConnection().prepareCall("{call sp_checklogin(?,?,?)}");
			csmt.setString("username", userName);
			csmt.setString("password", passWord);
			csmt.registerOutParameter("result", java.sql.Types.INTEGER);

			csmt.execute();

			result = csmt.getInt("result");
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
		
	}
}
