package entities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentDAO {
	
	public void insertStudentName(int rollNo, String firstName, String lastName, String city) {
					
		String query = "INSERT INTO Student values (" +rollNo+ " , '"+firstName+"," +lastName+ "','"+city+ "')";
		System.out.println(query);
		
		try {
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/trx_03","root","Priya@123");
		Statement stmt = con.createStatement();
		int rowsAffected = stmt.executeUpdate(query);
		if(rowsAffected == 1) {
			System.out.println("Query Ok, "+rowsAffected+ "row affected.");
		
		} else {
			
			System.out.println("Query Ok, "+rowsAffected+ "rows affected.");
		}
		} catch(SQLException exc) 
		{
			System.out.println(exc.getMessage());
			
		}

	}
	
	public void updateStudentName(int rollNo, String firstName) {
		
		String query = "UPDATE dept SET firstName = '" +firstName+"' WHERE rollNo = "+rollNo;
		System.out.println(query);
		
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/trx_03","root","Priya@123");
			
			Statement stmt = con.createStatement();
			
			
			int rowsAffected = stmt.executeUpdate(query);
			

			if(rowsAffected == 1) {
				System.out.println("Query Ok, "+rowsAffected+ "row affected.");
				System.out.println("Updated the Name of the Student Succesfully");
			
			} else {
				
				System.out.println("Query Ok, "+rowsAffected+ "rows affected.");
				System.out.println("Updated the details of the Student Succesfully");
			}
		}
		
				
			catch(SQLException exc) 
			{
				System.out.println(exc.getMessage());
				
			}
		
	}
	
public void deleteStudent(int rollNo)  {
		
		String query = "DELETE FROM Student WHERE rollNo = "+rollNo;
		System.out.println(query);
		try {
			
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/trx_03","root","Priya@123");
		
		//Create Statement
		Statement stmt = con.createStatement();
		
		//Execute Query
		int rowsAffected = stmt.executeUpdate(query);
		
		
		//Process the result
		if(rowsAffected == 1) {
			System.out.println("Query Ok, "+rowsAffected+ "row affected.");
		
		} else {
			
			System.out.println("Query Ok, "+rowsAffected+ "rows affected.");
		}
		} catch (SQLException sqe) {
			System.out.println(sqe.getMessage());
		}
		
	}
	

}
