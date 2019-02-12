package utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {

	public static Connection getConnection() {
		
		final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	    final String DB_URL = "jdbc:mysql://localhost/office_database";

	   //  Database credentials
	    final String USER = "root";
	    final String PASS = "root";
	   
	   Connection conn = null;
	   Statement stmt = null;
	
	      //STEP 2: Register JDBC driver
	      try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	      //STEP 3: Open a connection
	      System.out.println("Connecting to database...");
	      try {
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      System.out.println("Successfully Connected to DataBase...");
	      System.out.println("\n--------------------------------------");
		return conn;
		
	}
}
