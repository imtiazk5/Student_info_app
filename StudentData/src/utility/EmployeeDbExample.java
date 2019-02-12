package utility;
import java.util.Scanner;

import bal.EmployeeBAL;
import bal.GetId;
import model.EmployeeModel;

import java.sql.*;


public class EmployeeDbExample {

			public static void main(String args[]) throws SQLException {
				
				mainmanue();
				
				
			}
	
			static Scanner input = new Scanner(System.in);
			
			
			public static void mainmanue() throws SQLException {
				
				Scanner input2 = new Scanner(System.in);
				char ch = 'n';
				do {
				System.out.println("      Main Manue");
				System.out.println("######################");
				System.out.println("1) Show Employee Data");
				System.out.println("2) Show Department Data");
				System.out.println("3) Add New  Employee Data");
				System.out.println("4) get data by id");
				System.out.println("5) Recover Data");
				System.out.println("6) Delete data by id");

				System.out.println("######################");
				
				System.out.println("\n What do you Want?");
				Integer choice =Integer.parseInt(input.next());
				
				switch(choice) {
				
				      case 1:
				    	  		empData();
				    	  		break;
				    	  		
				      case 2:
				    	        depData();
				    	        break;
				      case 3: 
				    	        addEmployee();
				    	        break;
				    	        
				      case 4:
				    	  		getId();
				    	  		break;
				      case 5: 
				    	        deleteEmployeeByEmployeeId();
				    	        break;
				    	        
				      case 6:
				    	  		recoverEmployeeDataById();
				    	  		break;
				    	        
				      default:
				    	        System.out.println("Wrong Choice.....");
				    	        
				}
				System.out.println("Continue to Main Manue...? press y");
						String c = input.next();
						ch = c.charAt(0);

				}while(ch=='y');
				
						
			}
				
            private static void recoverEmployeeDataById() throws SQLException {
						
            
				EmployeeBAL.recoverEmployeeData();
				
				
			}

			private static void getId() throws SQLException {
				Scanner in  = new Scanner(System.in);
				
				System.out.println("Enter Employee Id to get Data....");
				Integer empId = in.nextInt();
				GetId.getId(empId);
				in.close();
			}

            public static void deleteEmployeeByEmployeeId() throws SQLException {
            	
            	Scanner in  = new Scanner(System.in);
				
				System.out.println("Enter Employee Id for delete Record....");
				Integer empId = in.nextInt();
				EmployeeBAL.deleteEmployeeByEmployeeId(empId);
				in.close();
            }

			private static void addEmployee() throws SQLException {
            		Scanner scanner = new Scanner(System.in);
            		char ch = 'n';
            		do {
            		
            		System.out.println("Employee Name : ");
            		String employeeName = scanner.nextLine();
         
            		System.out.println("Employee Company");
            		String employeeCompany = scanner.nextLine();
            		
            		System.out.println("Employee Leaves");
            		Integer employeeLeaves = scanner.nextInt();
            	
            		System.out.println("Employee Salary");
            		Integer employeeSalary = scanner.nextInt();	
            		EmployeeModel employeeModel = new EmployeeModel(employeeName, employeeLeaves, employeeSalary, employeeCompany);
            		EmployeeBAL.addEmployee(employeeModel);
            		empData();

            		System.out.println("Want to continue.... Y/N");
            		ch = scanner.next(".").charAt(0);
            		}while(ch=='y');
            		
            		scanner.close();
            		}



			public static void empData() {
				
				// JDBC driver name and database URL
				    final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
				    final String DB_URL = "jdbc:mysql://localhost/office_database";

				   //  Database credentials
				    final String USER = "root";
				    final String PASS = "root";
				   
				   Connection conn = null;
				   Statement stmt = null;
				   try{
				      //STEP 2: Register JDBC driver
				      Class.forName("com.mysql.jdbc.Driver");

				      //STEP 3: Open a connection
				      System.out.println("Connecting to database...");
				      conn = DriverManager.getConnection(DB_URL,USER,PASS);

				      //STEP 4: Execute a query
				      System.out.println("Creating statement...");
				      stmt = conn.createStatement();
				      String sql;
				      sql = "SELECT employee_id,employee_name,employee_no_of_leaves,employee_salry,Designation,Company,Work_shift,active FROM employee_data where active=1";
				      ResultSet rs = stmt.executeQuery(sql);

				      //STEP 5: Extract data from result set
				      while(rs.next()){
				         //Retrieve by column name
				         Integer id  = rs.getInt("employee_id");
				         String name = rs.getString("employee_name");
				         double s = rs.getDouble("employee_salry");
				         int dol = rs.getInt("employee_no_of_leaves");
				         String designation = rs.getString("Designation");
				         String compny = rs.getString("Company");
				         String ws  = rs.getString("Work_shift");
				         Integer ac = rs.getInt("active");
				         //Display values
				         
				         System.out.println("Employee ID:   " +id);
				         System.out.println("Employee Name: " +name);
				         System.out.println("Designation:   " + designation);
				         System.out.println("Salary:        " +s);
				         System.out.println("Company:       " +compny);
				         System.out.println("Work Shift:    " +ws);
				         System.out.println("active:  " +ac);
				         System.out.println("No. of Leaves: " +dol);
				         System.out.println("\n");
				      }
	
				      //STEP 6: Clean-up environment
				      rs.close();
				      stmt.close();
				      conn.close();
				   }catch(SQLException se){
				      //Handle errors for JDBC
				      se.printStackTrace();
				   }catch(Exception e){
				      //Handle errors for Class.forName
				      e.printStackTrace();
				   }finally{
				      //finally block used to close resources
				      try{
				         if(stmt!=null)
				            stmt.close();
				      }catch(SQLException se2){
				      }// nothing we can do
				      try{
				         if(conn!=null)
				            conn.close();
				      }catch(SQLException se){
				         se.printStackTrace();
				      }//end finally try
				   }//end try
				   System.out.println("Goodbye!");
				//end main
			//end FirstExample

            
				
				
			}
	
        public static void depData() {
        	
        	// JDBC driver name and database URL
        	    final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
        	    final String DB_URL = "jdbc:mysql://localhost/office_database";

        	   //  Database credentials
        	    final String USER = "root";
        	    final String PASS = "root";
        	   
        	   Connection conn = null;
        	   Statement stmt = null;
        	   try{
        	      //STEP 2: Register JDBC driver
        	      Class.forName("com.mysql.jdbc.Driver");

        	      //STEP 3: Open a connection
        	      System.out.println("Connecting to database...");
        	      conn = DriverManager.getConnection(DB_URL,USER,PASS);

        	      //STEP 4: Execute a query
        	      System.out.println("Creating statement...");
        	      stmt = conn.createStatement();
        	      String sql;
        	      sql = "SELECT Department_id,Department_Name,Number_of_Employee,Branch,Company FROM department_data";
        	      ResultSet rs = stmt.executeQuery(sql);

        	      //STEP 5: Extract data from result set
        	      while(rs.next()){
        	         //Retrieve by column name
        	         int id  = rs.getInt("Department_id");
        	         int noe = rs.getInt("Number_of_Employee");
        	         String name = rs.getString("Department_Name");
        	         String branch = rs.getString("Branch");
        	         String company = rs.getString("Company");

        	         //Display values
        	         System.out.println("Department ID:   " + id);
        	         System.out.println("Department_Name: " + name );
        	         System.out.println("Branch:          " + branch);
        	         System.out.println("Company:         " + company);
        	         System.out.println("No of Employee   " + noe );
        	         System.out.println("\n");
        	      }
        	      //STEP 6: Clean-up environment
        	      rs.close();
        	      stmt.close();
        	      conn.close();
        	   }catch(SQLException se){
        	      //Handle errors for JDBC
        	      se.printStackTrace();
        	   }catch(Exception e){
        	      //Handle errors for Class.forName
        	      e.printStackTrace();
        	   }finally{
        	      //finally block used to close resources
        	      try{
        	         if(stmt!=null)
        	            stmt.close();
        	      }catch(SQLException se2){
        	      }// nothing we can do
        	      try{
        	         if(conn!=null)
        	            conn.close();
        	      }catch(SQLException se){
        	         se.printStackTrace();
        	      }//end finally try
        	   }//end try
        	   System.out.println("Goodbye!");
        	//end main
        	//end FirstExample

       }

        
        
        
       


}
