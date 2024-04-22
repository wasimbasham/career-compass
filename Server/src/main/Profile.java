package main;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import login.EmployeeLogin;

public class Profile extends EmployeeLogin {

	public void addProfile() throws SQLException {

		String query = "insert into employee_profile(name,phone_no,email,education,key_skills) values (?,?,?,?,?);";
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your name : ");
		String name = sc.nextLine();
		System.out.println("Enter your phone number : ");
		long number = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter your email : ");
		String email = sc.nextLine();
		System.out.println("Enter your education : ");
		String education = sc.nextLine();
		System.out.println("Enter your key skills : ");
		String keySkills = sc.nextLine();

		PreparedStatement pst = con.prepareStatement(query);
		pst.setString(1, name);
		pst.setLong(2, number);
		pst.setString(3, email);
		pst.setString(4, education);
		pst.setString(5, keySkills);
		int n = pst.executeUpdate();
		String r = (n > 0) ? "Profile Added Successfully" : "Please provide proper values";
		System.out.println(r);
		sc.close();

	}

	public void viewProfile() throws SQLException {
		String query = "select * from employee_profile where email=?";
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your email");
		String email = sc.nextLine();

		PreparedStatement pst = con.prepareStatement(query);
		pst.setString(1, email);
		ResultSet rs = pst.executeQuery();
		System.out.println("PROFILE ID \t NAME \t PHONE NUMBER \t EMAIL \t\t EDUCATION \t KEY SKILLS \t DATE CREATED");
		while (rs.next()) {

			System.out.println(
					rs.getInt(1) + "\t\t\s" + rs.getString(2) + "\t\s" + rs.getLong(3) + "\t\t\s" + rs.getString(4)
							+ "\t\s" + rs.getString(5) + "\t\t\s" + rs.getString(6) + "\t\t\s" + rs.getString(7));
		}
		sc.close();
	}

	public void updateProfile() throws SQLException {
		Scanner sc = new Scanner(System.in);
		System.out.println(
				"What you want to update...?\n 1. Name \n 2. Phone Number \n 3. Education \n 4. Key Skills \n");
		int updateOption = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter your email");
		String email = sc.nextLine();

		switch (updateOption) {

		case 1:
			String query1 = "update employee_profile set name=? where email=?;";

			System.out.println("Enter your updated name : ");
			String updateName = sc.nextLine();
			PreparedStatement pst1 = con.prepareStatement(query1);
			pst1.setString(2, email);
			pst1.setString(1, updateName);
			int n1 = pst1.executeUpdate();
			String r1 = (n1 > 0) ? "Name Updated Successfully" : "Please Insert proper values";
			System.out.println(r1);
			break;

		case 2:
			String query2 = "update employee_profile set phone_no=? where email=?;";

			System.out.println("Enter your updated phone number : ");
			String updatePhoneNumber = sc.nextLine();
			PreparedStatement pst2 = con.prepareStatement(query2);
			pst2.setString(2, email);
			pst2.setString(1, updatePhoneNumber);
			int n2 = pst2.executeUpdate();
			String r2 = (n2 > 0) ? "Phone Number Updated Successfully" : "Please Insert proper values";
			System.out.println(r2);
			break;

		case 3:
			String query3 = "update employee_profile set education=? where email=?;";

			System.out.println("Enter your updated education : ");
			String updateEducation = sc.nextLine();
			PreparedStatement pst3 = con.prepareStatement(query3);
			pst3.setString(2, email);
			pst3.setString(1, updateEducation);
			int n3 = pst3.executeUpdate();
			String r3 = (n3 > 0) ? "Education Updated Successfully" : "Please Insert proper values";
			System.out.println(r3);
			break;

		case 4:
			String query4 = "update employee_profile set key_skills=? where email=?;";

			System.out.println("Enter your updated Key Skills : ");
			String updateKeySkills = sc.nextLine();
			PreparedStatement pst4 = con.prepareStatement(query4);
			pst4.setString(2, email);
			pst4.setString(1, updateKeySkills);
			int n4 = pst4.executeUpdate();
			String r4 = (n4 > 0) ? "Key Skills Updated Successfully" : "Please Insert proper values";
			System.out.println(r4);
			break;

		default:
			System.out.println("Invalid Option");
		}
		sc.close();
	}

}
