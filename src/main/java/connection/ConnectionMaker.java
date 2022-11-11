package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionMaker {
	//single connection we will have and create
	private static Connection conn = null;

	//?serverTimezone=EST5EDT --> add to end on Mac & Linux
	private static final String URL = "jdbc:mysql://localhost:3306/TVShowTracker";
	
	private static final String USERNAME = "root";
	private static final String PASSWORD = "Root";
	
	private static void makeConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			System.out.println("Connected.");
		} catch (SQLException e) {
			System.out.println("Could not connect to MySQL database.");
		} catch(IllegalAccessException e2) {
			e2.printStackTrace();
		} catch(ClassNotFoundException e3) {
			e3.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		}
	}
	
	
	public static Connection getConnection() {
		if (conn == null) {
			makeConnection();
		}
		
		return conn;
	}
}
