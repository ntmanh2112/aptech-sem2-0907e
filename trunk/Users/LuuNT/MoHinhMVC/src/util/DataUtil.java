package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataUtil {

	static private String DATA;
	static private String USERNAME = "sa";
	static private String PASSWORD = "123456";
	static private Connection con;
	static private Statement stm=null;
	public DataUtil(){
		
	}
	public static void connect(){
		try{
			// TODO Auto-generated method stub
			DATA ="jdbc:sqlserver://PC;databaseName=QLNV1";
			
			
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con=DriverManager.getConnection(DATA, USERNAME, PASSWORD);
			stm=con.createStatement();
			
			}
		catch(Exception e){e.printStackTrace();}
	}
	
	public static Connection getConnection(){
		if(con == null){
			connect();
		}
		return con;
	}
	
}



