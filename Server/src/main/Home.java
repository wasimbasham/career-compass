package main;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import database.DBConnect;
import login.EmployeeLogin;
import login.EmployerLogin;

public class Home extends DBConnect {

	public void CC() throws SQLException {
		Scanner sc = new Scanner(System.in);
		System.out.println(
				"Login as... \n 1. Admin \n 2. Employer \n 3. Employee \n 4. Sign Up for Emplyer \n 5. Sign up for Employee");
		int login = sc.nextInt();
		sc.nextLine();
		switch (login) {

		case 1:
			System.out.println("Enter you Email Id : ");
			String adminEmail = sc.nextLine();
			System.out.println("Enter Your Password : ");
			String adminPassword = sc.nextLine();

			String query1 = "select email,password from admin where email=? AND password=?;";
			PreparedStatement pst1 = con.prepareStatement(query1);
			pst1.setString(1, adminEmail);
			pst1.setString(2, adminPassword);
			ResultSet rs1 = pst1.executeQuery();
			while (rs1.next()) {
				String user = rs1.getString(1);
				String password = rs1.getString(2);
				if ((adminEmail.equals(user)) && (adminPassword.equals(password))) {
					Profile p = new Profile();
					Jobs j = new Jobs();
					while (true) {
						System.out.println(
								"What you wanna perform...? \n 1. ADD JOB \n 2. VIEW JOB \n 3. UPDATE JOB \n 4. DELETE JOB \n 5. SEARCH JOB \n 6. ADD EMPLOYEE PROFILE \n 7. VIEW EMPLOYEE PROFILE \n 8. UPDATE EMPLOYEE PROFILE \n 9. ADD EMPLOYER \n 10. ADD EMPLOYEE");
						int performAction = sc.nextInt();
						switch (performAction) {
						case 1:
							j.addJob();
							break;
						case 2:
							j.viewJob();
							break;
						case 3:
							j.updateJob();
							break;
						case 4:
							j.deleteJob();
							break;
						case 5:
							j.searchJob();
							break;
						case 6:
							p.addProfile();
							break;
						case 7:
							p.viewProfile();
							break;
						case 8:
							p.updateProfile();
							break;
						case 9:
							EmployerLogin employerLogin = new EmployerLogin();
							employerLogin.insert();
							break;
						case 10:
							EmployeeLogin employeeLogin = new EmployeeLogin();
							employeeLogin.insert();
							break;
						default:
							System.out.println("Invalid Option");
							break;
						}

					}

				}

				else {
					System.out.println("Invalid credentials");
				}
			}
			break;

		case 2:
			System.out.println("Enter you Email Id : ");
			String employerEmail = sc.nextLine();
			System.out.println("Enter Your Password : ");
			String employerPassword = sc.nextLine();

			String query2 = "select email,password from employer_login where email=? AND password=?;";
			PreparedStatement pst2 = con.prepareStatement(query2);
			pst2.setString(1, employerEmail);
			pst2.setString(2, employerPassword);
			ResultSet rs2 = pst2.executeQuery();
			while (rs2.next()) {
				String user = rs2.getString(1);
				String password = rs2.getString(2);
				if ((employerEmail.equals(user)) && (employerPassword.equals(password))) {
					Jobs j = new Jobs();
					while (true) {
						System.out.println(
								"What you wanna perform...? \n 1. ADD JOB \n 2. VIEW JOB \n 3. UPDATE JOB \n 4. DELETE JOB \n 5. SEARCH JOB \n");
						int performAction = sc.nextInt();
						switch (performAction) {
						case 1:
							j.addJob();
							break;
						case 2:
							j.viewJob();
							break;
						case 3:
							j.updateJob();
							break;
						case 4:
							j.deleteJob();
							break;
						case 5:
							j.searchJob();
							break;
						default:
							System.out.println("Invalid Option");
							break;
						}

					}

				}

				else {
					System.out.println("Invalid credentials");
				}
			}
			break;

		case 3:
			System.out.println("Enter you Email Id : ");
			String employeeEmail = sc.nextLine();
			System.out.println("Enter Your Password : ");
			String employeePassword = sc.nextLine();

			String query3 = "select email,password from employee_login where email=? AND password=?;";
			PreparedStatement pst3 = con.prepareStatement(query3);
			pst3.setString(1, employeeEmail);
			pst3.setString(2, employeePassword);
			ResultSet rs3 = pst3.executeQuery();
			while (rs3.next()) {
				String user = rs3.getString(1);
				String password = rs3.getString(2);
				if ((employeeEmail.equals(user)) && (employeePassword.equals(password))) {
					Profile p = new Profile();
					Jobs je = new Jobs();
					while (true) {
						System.out.println(
								"What you wanna perform...? \n 1. ADD PROFILE \n 2. VIEW PROFILE \n 3. UPDATE PROFILE \n 4. SEARCH JOB \n");
						int performAction = sc.nextInt();
						switch (performAction) {
						case 1:
							p.addProfile();
							break;
						case 2:
							p.viewProfile();
							break;
						case 3:
							p.updateProfile();
							break;
						case 4:
							je.searchJob();
							break;
						default:
							System.out.println("Invalid Option");
						}
					}
				}

				else {
					System.out.println("Invalid credentials");
				}

			}
			break;

		case 4:

			EmployerLogin employerLogin = new EmployerLogin();

			employerLogin.insert();

			break;

		case 5:

			EmployeeLogin employeeLogin = new EmployeeLogin();

			employeeLogin.insert();

			break;

		default:
			System.out.println("Invalid Option...");

			break;

		} // switch close
			// sc.close();
	} // cc method close

	public static void main(String[] args) throws SQLException {

		Home h = new Home();
		h.CC();

	}

}
