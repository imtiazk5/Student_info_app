package bal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import utility.DBConnection;

public class GetId {
		
	static Connection connection = DBConnection.getConnection();
	
	public static void getId(Integer id) throws SQLException {
		
		 String sql;
	      sql = "SELECT employee_id,employee_name,employee_no_of_leaves,employee_salry,Company,Designation,active FROM employee_data WHERE employee_id="+id;
	      Statement stmt = connection.createStatement();
	      
	      ResultSet rs = stmt.executeQuery(sql);

	      while(rs.next()){
	        
	    	 Integer eid = rs.getInt("employee_id");
	         String name = rs.getString("employee_name");
	         double s = rs.getDouble("employee_salry");
	         int dol = rs.getInt("employee_no_of_leaves");
	         String compny = rs.getString("Company");
	         String designation = rs.getString("Designation");
	         Integer ac = rs.getInt("active");
	        
	         //Display values
	         
	         System.out.println("Employee ID:   " +eid);
	         System.out.println("Employee Name: " +name);
	         System.out.println("Company:       " +compny);
	         System.out.println("Salary:        " +s);
	         System.out.println("Designation    " +designation);
	       	 System.out.println("No. of Leaves: " +dol);
	       	 System.out.println("Activie        " +ac);
	         System.out.println("--------------------------------------");
	      }

	      rs.close();
	      stmt.close();
		
		
	}
	
	
}
