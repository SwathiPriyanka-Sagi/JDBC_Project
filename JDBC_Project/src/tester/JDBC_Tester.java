package tester;

import java.sql.SQLException;

import entities.DeptDAO;
import entities.StudentDAO;

public class JDBC_Tester {

	public static void main(String[] args)throws SQLException {
		// TODO Auto-generated method stub

		DeptDAO dao = new DeptDAO();
//		dao.updateDeptLoc("Mumbai", 30);
//		
//		dao.printDeptData();
//		dao.updateDeptLocPrepStmt("New Delhi", 30);
//		dao.printdeptbyIDprpStatement("10");
	  //dao.printdeptbyIDprpStatement("10 OR 1=1");
		dao.printdeptByID("40");
//		
//		DeptDAO dao1 = new DeptDAO();
//		dao1.insertDeptLoc( 40, "HR", "London");
//		
//		DeptDAO dao2 = new DeptDAO();
//		dao2.deleteDeptLoc(40);
//		
//		StudentDAO sdo = new StudentDAO();
//		sdo.insertStudentName(405, "Swathi", "Priyanka", "Hyderabad");
//		
//		StudentDAO sdo1 = new StudentDAO();
//		sdo1.updateStudentName(405, "Swathi");
//		
//		StudentDAO sdo2 = new StudentDAO();
//		sdo2.deleteStudent(405);
	}

}
