package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
	
	public static Connection getDbConnection() throws SQLException{
		
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver"); //mysql jdbc/driver register
			String url ="jdbc:mysql://localhost:3306/dbtest";  //localhost-computer:mysql database's code/database name
			con = DriverManager.getConnection(url, "root", ""); // username, password
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return con;	
		
	}
}
