package com.masai.DAO;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DBUtil {
	final static String URL;
	final static String username;
	final static String password;

//	================= Load static at the Start of Project ==============
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException ex) {
			System.err.println("Fatal Error! Unable to start application");
			System.exit(1);
		}

		ResourceBundle bundle = ResourceBundle.getBundle("DBdetails");

		URL = bundle.getString("url");
		username = bundle.getString("username");
		password = bundle.getString("password");
	}

//	========================= Establish Database Connection ================	
	static Connection establishDBConnection() throws SQLException {
		return DriverManager.getConnection(URL, username, password);
	}

//	========================== Close Database Connection =================
	static void closeConnection(Connection conn) throws SQLException {
		if (conn != null)
			conn.close();
	}

//	========================== Check ResultSet ===========================
	static boolean isResultSetEmpty(ResultSet rs) throws SQLException {
		return (!rs.isBeforeFirst() && rs.getRow() == 0) ? true : false;
	}
}


