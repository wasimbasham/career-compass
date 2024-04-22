package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {	

	String dbUrl = "jdbc:mysql://localhost:3306/career_compass";
	String dbName = "root";
	String dbPassword = "root";
	public Connection con ;
	public DBConnect()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(dbUrl, dbName, dbPassword);
			System.out.println("\t\t\t\t\t\t Welcome to CAREER COMPASS \n \n");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();

		}
		
		
	}

	

}
