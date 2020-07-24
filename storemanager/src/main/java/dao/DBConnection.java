package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
	private String driver="com.mysql.cj.jdbc.Driver";
	private String url="jdbc:mysql://localhost:3306/";
	private String dbName="storemanager";
	private String userName = "root";
	private String password= "root";

	private Statement statement;
	
	public DBConnection(){
		try{  
			Class.forName(driver);  
			Connection con=DriverManager.getConnection(url+dbName,userName,password);
			statement=con.createStatement();  
			}catch(Exception e){ System.out.println(e);}  
	}  
	
	public ResultSet getData(String sql) {
		try {
			return statement.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void putData(String sql) {
		try {
			statement.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void updateData(String sql) {
		try {
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
