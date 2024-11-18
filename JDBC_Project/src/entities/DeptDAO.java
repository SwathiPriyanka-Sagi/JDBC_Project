package entities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DeptDAO {
	
	public void updateDeptLoc(String location, int deptNo) throws SQLException {
		// Write SQL
		String query = "Update dept SET loc = '"+location+"' WHERE deptNo = "+deptNo;
		//Convert SQL Query to String object
		System.out.println(query);
		
		//Establish Connection
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
	}
	
	public void insertDeptLoc(int deptNo, String deptName, String location) throws SQLException {
		 
		String query = "INSERT INTO dept values (" +deptNo+ " ,  '"+deptName+ "' , '" +location + "')";
		System.out.println(query);
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
		
	}
	
	public void deleteDeptLoc(int deptNo) throws SQLException {
		
		String query = "DELETE FROM dept WHERE deptNo = "+deptNo;
		System.out.println(query);
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/trx_03","root","Priya@123");
		
		//Create Statement
		Statement stmt = con.createStatement();
		//Execute Query
		int rowsAffected = stmt.executeUpdate(query);
		ResultSet rs = stmt.executeQuery(query);
		//Process the result
		if(rowsAffected == 1) {
			System.out.println("Query Ok, "+rowsAffected+ "row affected.");
		
		} else {
			
			System.out.println("Query Ok, "+rowsAffected+ "rows affected.");
		}
		
	}
	public void printdeptByID(String deptNo) throws SQLException{
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		String query = "SELECT * FROM dept WHERE deptNo=? +deptNO";
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/trx_03","root","Priya@123");
		stmt = con.createStatement();
		int rowsAffected = stmt.executeUpdate(query);
		rs = stmt.executeQuery(query);
		if(rowsAffected == 1) {
			System.out.println("Query Ok, "+rowsAffected+ "row affected.");
		} else {
			
			System.out.println("Query Ok, "+rowsAffected+ "rows affected.");
		}
	}
	public void printDeptData() throws SQLException {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		String query = "SELECT * FROM dept";
		System.out.println(query);
		try {
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/trx_03","root","Priya@123");
		//Create Statement
		stmt = con.createStatement();
		//Execute Query
		rs = stmt.executeQuery(query);
		System.out.println("+-------+----------+----------+");
		System.out.printf("|%s6 | %-10s | %-8s |\n", "deptNo" ,"dname","loc");
		System.out.println("+-------+----------+----------+");
		while(rs.next()) {
		//	System.out.println("Query Success");
			System.out.printf("|%6d | %-10s | %-8s |\n", rs.getInt("deptNo"), rs.getString("dname"), rs.getString("loc"));
			System.out.println("+-------+-----------+----------+");
//			System.out.println(rs.getInt("deptNo"));
//			System.out.println("Expected: 10");
//			System.out.println(rs.getString("dname"));
//			System.out.println("Expected: Accounting");
//			System.out.println(rs.getString("loc"));
//			System.out.println("Expected: New York");
		}
		}
		 
		finally {
			try {
				rs.close();
				stmt.close();
				con.close();
			} catch (SQLException ex) {
			System.out.println("Exception while closing connections");
		}
	}
	}
	
	//Prepared Statement instead of Statement
	public void updateDeptLocPrepStmt(String location, int deptNo) throws SQLException {
		Connection con = null;
		String query = "Update dept SET loc = ? WHERE deptNo = ?";
		System.out.println(query);
		
		try {
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/trx_03","root","Priya@123");
				PreparedStatement pstmt = con.prepareStatement(query);
				
				pstmt.setString(1, location);
				pstmt.setInt(2, deptNo);
				System.out.println(pstmt);
				int rowsAffected = pstmt.executeUpdate();
				
				if(rowsAffected == 1) {
					System.out.println("Query Ok, "+rowsAffected+ "row affected.");
				
				} else {
					
					System.out.println("Query Ok, "+rowsAffected+ "rows affected.");
				}
				
		} catch(SQLException exc) {		
			System.out.println("Error in SQL Code. Check for Mistakes");
		}
				
	}
	
	
	public void printdeptbyIDprpStatement(String deptNo) throws SQLException {
		String query = "SELECT * FROM dept WHERE deptNo = ?";
		System.out.println(query);
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/trx_03","root","Priya@123");
		pstmt = con.prepareStatement(query);
		pstmt.setInt(1, Integer.parseInt(deptNo));
		rs = pstmt.executeQuery();
		System.out.println("+-------+----------+----------+");
		System.out.printf("|%s6 | %-10s | %-8s |\n", "deptNo" ,"dname","loc");
		System.out.println("+-------+----------+----------+");
		while(rs.next()) {
			System.out.printf("|%6d | %-10s | %-8s |\n", rs.getInt("deptNo"), rs.getString("dname"), rs.getString("loc"));
			System.out.println("+-------+-----------+----------+");
		}
		}catch (SQLException ex) {
			System.out.println("Error in SQL Code.");
		} catch (NullPointerException ex) {
			System.out.println("Received deptNo is not a number");
		} finally {
			try {
				rs.close();
				pstmt.close();
				con.close();
			} catch (SQLException ex) {
			System.out.println("Exception while closing connections");
		} catch (NullPointerException ex) {
			System.out.println("ResultSet was never Initialized");
		}
	}
	}

}
