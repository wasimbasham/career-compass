package login;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import database.DBConnect;

public class EmployeeLogin extends DBConnect {

	public void insert() throws SQLException {
		String query = "insert into employee_login(email,password) values(?,?);";
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Your Email : ");
		String email = sc.next();
		System.out.println("Enter Your Password : ");
		String password = sc.next();
		PreparedStatement pst = con.prepareStatement(query);
		pst.setString(1, email);
		pst.setString(2, password);
		int n = pst.executeUpdate();
		String r = (n > 0) ? "Employee has been created successfully" : "Please insert proper values";
		System.out.println(r);
		sc.close();
	}

}
