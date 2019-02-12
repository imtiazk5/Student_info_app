package bal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import model.EmployeeModel;
import utility.DBConnection;

public class EmployeeBAL {

	 static Connection connection = DBConnection.getConnection();

	
	
	 public static void addEmployee(EmployeeModel employeeModel) throws SQLException {
		 	
		 	String sql;
			      sql = "Insert into employee_data(employee_name,employee_no_of_leaves,employee_salry,Company) values(?,?,?,?)";

			      PreparedStatement preparedStatement = connection.prepareStatement(sql);
			      
			      preparedStatement.setString(1, employeeModel.getEmployeeName());
			      preparedStatement.setInt(2, employeeModel.getEmployeeLeaves());
			      preparedStatement.setInt(3, employeeModel.getEmployeeSalary());
			      preparedStatement.setString(4, employeeModel.getEmployeeCompany());
			      
			      preparedStatement.executeUpdate();
			    
			   }
	 
	 public static void display() throws SQLException {
		 

		 String sql;
	      sql = "SELECT employee_name,employee_no_of_leaves,employee_salry,Company FROM employee_data";
	      Statement stmt = connection.createStatement();
	      
	      ResultSet rs = stmt.executeQuery(sql);

	      //STEP 5: Extract data from result set
	      while(rs.next()){
	         //Retrieve by column name
	        // int id  = rs.getInt("employee_id");
	         String name = rs.getString("employee_name");
	         double s = rs.getDouble("employee_salry");
	        // String doj = rs.getString("employee_date_of_join");
	         int dol = rs.getInt("employee_no_of_leaves");
	        // String designation = rs.getString("Designation");
	         String compny = rs.getString("Company");
	        // String ws  = rs.getString("Work_shift");

	         //Display values
	         
	      //   System.out.println("Employee ID:   " +id);
	         System.out.println("Employee Name: " +name);
	       //  System.out.println("Designation:   " + designation);
	         System.out.println("Salary:        " +s);
	         System.out.println("Company:       " +compny);
	       //  System.out.println("Work Shift:    " +ws);
	        // System.out.println("Date of Join:  " +doj);
	         System.out.println("No. of Leaves: " +dol);
	         System.out.println("\n");
	      }

	      //STEP 6: Clean-up environment
	      rs.close();
	      stmt.close();
	 //     conn.close();

		 
		 
	 }
	 
	 //delete record from employee table 
	 
	 public static void deleteEmployeeByEmployeeId(Integer employeeId) throws SQLException {
		 
		 String sql;
	      sql = " UPDATE `employee_data` SET `active`=0 WHERE `employee_id`="+employeeId;
	      Statement stmt = connection.createStatement();
	      
	      stmt.executeUpdate(sql);

		 	
	 }
	 
	 public static void recoverEmployeeData() throws SQLException {
		 
		 
		 String sql;
	      sql = " UPDATE `employee_data` SET `active`=1";
	      Statement stmt = connection.createStatement();
	      
	      stmt.executeUpdate(sql);

		 
		 
	 }
	 
	 
}



