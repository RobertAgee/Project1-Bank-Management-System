package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

	static Connection conn;
	
	static {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	static Connection makeConnection() {
		String connectionUrl = "jdbc:postgresql://localhost:5432/bank_management_details";
		String userName = "postgres";
		String password = "root";
		try {

			if(conn == null) {
				conn = DriverManager.getConnection(connectionUrl, userName, password); 
			}
			 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
}
