package main;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import login.EmployerLogin;

public class Jobs extends EmployerLogin {

	public void addJob() throws SQLException {
		String query = " insert into jobs(company_name,role,education,job_description,industry_type,department,employment_type,key_skills,about_company) value (?,?,?,?,?,?,?,?,?);";
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your Company Name : ");
		String companyName = sc.nextLine();
		System.out.println("Role : ");
		String role = sc.nextLine();
		System.out.println("Education : ");
		String education = sc.nextLine();
		System.out.println("Job Description : ");
		String jobDescription = sc.nextLine();
		System.out.println("Industry Type : ");
		String industryType = sc.nextLine();
		System.out.println("Department : ");
		String department = sc.nextLine();
		System.out.println("Employement Type (Full-time/Part-time) : ");
		String employementType = sc.nextLine();
		System.out.println("key skills : ");
		String keySkills = sc.nextLine();
		System.out.println("About company : ");
		String aboutCompany = sc.nextLine();

		PreparedStatement pst = con.prepareStatement(query);

		pst.setString(1, companyName);
		pst.setString(2, role);
		pst.setString(3, education);
		pst.setString(4, jobDescription);
		pst.setString(5, industryType);
		pst.setString(6, department);
		pst.setString(7, employementType);
		pst.setString(8, keySkills);
		pst.setString(9, aboutCompany);
		int n = pst.executeUpdate();
		String r = (n > 0) ? "Job Created Successfully" : "Please Insert proper values";
		System.out.println(r);
		sc.close();

	}

	public void viewJob() throws SQLException {
		String query = "select * from jobs";
		PreparedStatement pst = con.prepareStatement(query);
		ResultSet rs = pst.executeQuery();

		System.out.println(
				"JOB ID \t COMPANY NAME \t ROLE \t\t EDUCATION \t JOB DESCRIPTION \t INDUSTRY TYPE \t DEPARTMENT \t EMPLOYMENT TYPE \t KEY SKILLS \t \t\t\t\t\t\t\t\tABOUT COMPANY \t \t\t\tDATE POSTED");
		while (rs.next()) {
			System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t" + rs.getString(4)
					+ "\t" + rs.getString(5) + "\t  " + rs.getString(6) + "\t\t" + rs.getString(7) + "\t  "
					+ rs.getString(8) + "\t\t" + rs.getString(9) + "\t\t" + rs.getString(10) + "\t" + rs.getString(11));

		}

	}

	public void updateJob() throws SQLException {
		Scanner sc = new Scanner(System.in);

		System.out.println(
				"What you want to update...?\n 1. Company Name \n 2. Role \n 3. Education \n 4. Job Description \n 5. Industry Type \n 6. Department \n 7. Employment Type \n 8. Key Skills \n 9. About Company");
		int updateOption = sc.nextInt();
		System.out.println("Enter your Job ID");
		int jobid = sc.nextInt();
		sc.nextLine();

		switch (updateOption) {

		case 1:
			String query1 = "update jobs set company_name=? where job_id=?;";

			System.out.println("Enter your updated company name : ");
			String updateCompany = sc.nextLine();
			PreparedStatement pst1 = con.prepareStatement(query1);
			pst1.setInt(2, jobid);
			pst1.setString(1, updateCompany);
			int n1 = pst1.executeUpdate();
			String r1 = (n1 > 0) ? "Company Name Updated Successfully" : "Please Insert proper values";
			System.out.println(r1);
			break;

		case 2:
			String query2 = "update jobs set role=? where job_id=?;";
			System.out.println("Enter your updated role : ");
			String updateRole = sc.nextLine();
			PreparedStatement pst2 = con.prepareStatement(query2);
			pst2.setInt(2, jobid);
			pst2.setString(1, updateRole);
			int n2 = pst2.executeUpdate();
			String r2 = (n2 > 0) ? "Role Updated Successfully" : "Please Insert proper values";
			System.out.println(r2);
			break;

		case 3:
			String query3 = "update jobs set education=? where job_id=?;";
			System.out.println("Enter your updated education : ");
			String updateEducation = sc.nextLine();
			PreparedStatement pst3 = con.prepareStatement(query3);
			pst3.setInt(2, jobid);
			pst3.setString(1, updateEducation);
			int n3 = pst3.executeUpdate();
			String r3 = (n3 > 0) ? "Education Updated Successfully" : "Please Insert proper values";
			System.out.println(r3);
			break;

		case 4:
			String query4 = "update jobs set job_description=? where job_id=?;";
			System.out.println("Enter your updated job description : ");
			String updateJobDescription = sc.nextLine();
			PreparedStatement pst4 = con.prepareStatement(query4);
			pst4.setInt(2, jobid);
			pst4.setString(1, updateJobDescription);
			int n4 = pst4.executeUpdate();
			String r4 = (n4 > 0) ? "Job Description Updated Successfully" : "Please Insert proper values";
			System.out.println(r4);
			break;

		case 5:
			String query5 = "update jobs set industry_type=? where job_id=?;";
			System.out.println("Enter your updated industry type : ");
			String updateIndustryType = sc.nextLine();
			PreparedStatement pst5 = con.prepareStatement(query5);
			pst5.setInt(2, jobid);
			pst5.setString(1, updateIndustryType);
			int n5 = pst5.executeUpdate();
			String r5 = (n5 > 0) ? "Industry Type Updated Successfully" : "Please Insert proper values";
			System.out.println(r5);
			break;

		case 6:
			String query6 = "update jobs set department=? where job_id=?;";
			System.out.println("Enter your updated department : ");
			String updateDepartment = sc.nextLine();
			PreparedStatement pst6 = con.prepareStatement(query6);
			pst6.setInt(2, jobid);
			pst6.setString(1, updateDepartment);
			int n6 = pst6.executeUpdate();
			String r6 = (n6 > 0) ? "Department Updated Successfully" : "Please Insert proper values";
			System.out.println(r6);
			break;

		case 7:
			String query7 = "update jobs set employment_type=? where job_id=?;";
			System.out.println("Enter your updated employment type : ");
			String updateEmploymentType = sc.nextLine();
			PreparedStatement pst7 = con.prepareStatement(query7);
			pst7.setInt(2, jobid);
			pst7.setString(1, updateEmploymentType);
			int n7 = pst7.executeUpdate();
			String r7 = (n7 > 0) ? "Employment Type Updated Successfully" : "Please Insert proper values";
			System.out.println(r7);
			break;

		case 8:
			String query8 = "update jobs set key_skills=? where job_id=?;";
			System.out.println("Enter your updated key skills : ");
			String updateKeySkills = sc.nextLine();
			PreparedStatement pst8 = con.prepareStatement(query8);
			pst8.setInt(2, jobid);
			pst8.setString(1, updateKeySkills);
			int n8 = pst8.executeUpdate();
			String r8 = (n8 > 0) ? "Key Skills Updated Successfully" : "Please Insert proper values";
			System.out.println(r8);
			break;

		case 9:
			String query9 = "update jobs set about_company=? where job_id=?;";
			System.out.println("Enter your updated about company : ");
			String updateAboutCompany = sc.nextLine();
			PreparedStatement pst9 = con.prepareStatement(query9);
			pst9.setInt(2, jobid);
			pst9.setString(1, updateAboutCompany);
			int n9 = pst9.executeUpdate();
			String r9 = (n9 > 0) ? "About Company Updated Successfully" : "Please Insert proper values";
			System.out.println(r9);
			break;

		default:
			System.out.println("Invalid input");

		}
		sc.close();

	}

	public void deleteJob() throws SQLException {
		Scanner sc = new Scanner(System.in);
		String query = "delete from jobs where job_id=?";
		System.out.println("Enter the Job Id to delete the Job");
		int deleteJob = sc.nextInt();
		PreparedStatement pst = con.prepareStatement(query);
		pst.setInt(1, deleteJob);
		int n = pst.executeUpdate();
		String r = (n > 0) ? "Job has been Deleted Successfully" : "Please Insert proper values";
		System.out.println(r);
		sc.close();

	}

	public void searchJob() throws SQLException {
		Scanner sc = new Scanner(System.in);
		String query = " select * from jobs where concat(company_name,role,education,job_description,industry_type,department,employment_type,key_skills) like ?;";
		System.out.println("Provide your input to search");
		String search = sc.nextLine();
		search = "%" + search + "%";
		PreparedStatement pst = con.prepareStatement(query);
		pst.setString(1, search);
		ResultSet rs = pst.executeQuery();

		System.out.println(
				"JOB ID \t COMPANY NAME \t ROLE \t\t EDUCATION \t JOB DESCRIPTION \t INDUSTRY TYPE \t DEPARTMENT \t EMPLOYMENT TYPE \t KEY SKILLS \t \t\t\t\t\t\t\t\tABOUT COMPANY \t \t\t\tDATE POSTED");
		while (rs.next()) {
			System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t" + rs.getString(4)
					+ "\t" + rs.getString(5) + "\t  " + rs.getString(6) + "\t\t" + rs.getString(7) + "\t  "
					+ rs.getString(8) + "\t\t" + rs.getString(9) + "\t\t" + rs.getString(10) + "\t" + rs.getString(11));

		}
		sc.close();

	}

}
