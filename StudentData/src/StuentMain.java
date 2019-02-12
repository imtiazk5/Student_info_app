import java.util.ArrayList;
import java.util.Scanner;

    public class StuentMain {
	
	static Scanner in = new Scanner(System.in);
	static String str;
	static ArrayList<StudentInfo> arraylist = new ArrayList<>();
	
	
	public static void main(String[] args) {
			
			manue();
	}

	public static void manue() {
		
		char ch = 'n';
		do {
		try {
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("      Main Manue      ");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("1) Enter new record ");
		System.out.println("2) view record ");
		System.out.println("3) Delete record ");
		System.out.println("4) Search record ");
		System.out.println("5) Edit record ");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~");
		
		System.out.println("Enter Choice....");
		int choice = in.nextInt();
		
		switch(choice){
		
		     case 1:
			     	newRecord();
				    break;
				
		     case 2:
			    	viewRecord();
			    	break;
		
	    	 case 3:
			    	deleteRecord();
			    	break;	
			
	    	 case 4:
	    		    searchStudent();
			    	break;	
	    	 case 5:
	    		 	editRecord();
	    		 	break;
			    	
		     default:
				    System.out.println("Invalit Choice.....");
				    
		}
		
		System.out.println("Continue to Main Manue.....y/n");
		ch = in.next(".").charAt(0);
		
		}catch(Exception e) {
			System.out.println("Enter number only....Program Exit...");
		}
 
		}while(ch =='y');
				
	}
	
	
	public static void newRecord() {
		
		
		
		System.out.println("Enter new Regestration No:...");
		 str = in.next();
		
		StudentInfo str = new StudentInfo();
		
		System.out.println("Enter Roll Number...");
		str.setRoll_no(in.nextInt());
		
		System.out.println("Enter Student Name....");
		str.setname(in.next());
		
		System.out.println("Enter Date of admission...");
		str.setDOA(in.next());
		
		System.out.println("Enter class....");
		str.setClaass(in.next());
		
		arraylist.add(str);
	}
	
	public static void viewRecord() {
		
		for (int i = 0; i < arraylist.size(); i++) {
			  StudentInfo studentinfo  = arraylist.get(i);
			
			System.out.println("Student Roll_no: "+studentinfo.getRoll_no());
			System.out.println("Student Name: "+studentinfo.getname());
			System.out.println("Date of addmition: "+studentinfo.getDOA());
			System.out.println("Student's Class: "+studentinfo.getClaass()+"\n");

        }
	}
	
	public static void deleteRecord() {
		
		System.out.println("Enter Roll number to be deleted....");
		int del = in.nextInt();
		Boolean check =deleteStudentByRollNumber(del);
		if(check) {
			System.out.println("Record deleted .. . . .");
		}
		else {
			System.out.println("not found this record  "+del);
		}
	}
	
	
	public static Boolean deleteStudentByRollNumber(Integer studentRollNumber) {
		
		Boolean delete = false;
		for(int i =0 ; i< arraylist.size(); i++) {
			
			StudentInfo info = arraylist.get(i);
			if(info.getRoll_no()==studentRollNumber) {
				arraylist.remove(info);
				delete =true;
				break;
			}
		}
		return delete;
	}
		
	public static StudentInfo searchStudentRecord(Integer roll_no,String Name) {
		StudentInfo info= null;
		for(int i=0;i<arraylist.size();i++) {
			
			 info = arraylist.get(i);
			if(info.getRoll_no()==roll_no && info.getname().equals(Name)) {
				System.out.println("roll" +roll_no+", name "+Name);
				return info;
			}else {
				info = null;
			}
			
			
		}
		return info;

	}	
	
	public static void searchStudent() {
		
		System.out.println("Enter  Roll Number.. ");
		Integer RN = in.nextInt();
		System.out.println("Enter Name ");
		String n = in.next();
		
		StudentInfo Record = searchStudentRecord(RN,n);
		
		if(Record!=null) {
			   
				System.out.println("Record Found....\n");
			
				System.out.println("Student Roll_no: "+Record.getRoll_no());
				System.out.println("Student Name: "+Record.getname());
				System.out.println("Date of addmition: "+Record.getDOA());
				System.out.println("Student's Class: "+Record.getClaass()+"\n");

	        }
	    else
			    System.out.println("Record Deos not Exist....");
		
		
	}	
		
	public static void editRecord() {
		char ch  = 'y';
		do {
		System.out.println("Enter  Roll Number.. ");
		Integer rn = in.nextInt();
		
		StudentInfo record = searchStudentRecord(rn);
		
		if(record!=null) {
			   
				System.out.println("Record Found....Roll NO: "+rn);

				System.out.println("**********************************");
				System.out.println("Student Roll_no: "+record.getRoll_no());
				System.out.println("Student Name: "+record.getname());
				System.out.println("Date of addmition: "+record.getDOA());
				System.out.println("Student's Class: "+record.getClaass()+"\n");
				System.out.println("**********************************");

				System.out.println("------------------------------");
				System.out.println("1) Edit Name. ");
				System.out.println("2) Edit Date of Addimition");
				System.out.println("3) Edit Calss");
				System.out.println("------------------------------");
				
				System.out.println("\nWhat do you want to edit.....");
				
				switch(in.nextInt()) {
				
				         case 1:
				        	    changeName(record);
				        	    break;
				         
				         case 2:
				        	    changeDoa(record);
				        	    break;
				        	    
				         case 3:
				        	 	changeClass(record);
				        	 	break;
				        	 	
				         default:
				        	 System.out.println("Invalit Input....");
				
				}
				
		}
	    else
			    System.out.println("Record Deos not Exist....");

				System.out.println("Want to change other data...? Y/N");
				ch = in.next(".").charAt(0);
		
		}while(ch=='y');
		
		
	}
	
	public static StudentInfo searchStudentRecord(Integer roll_no) {
		StudentInfo info= null;
		for(int i=0;i<arraylist.size();i++) {
			
			 info = arraylist.get(i);
			if(info.getRoll_no()==roll_no) {
				System.out.println("roll" +roll_no);
				return info;
			}else {
				info = null;
			}
			
			
		}
		return info;

	}	
	
	public static void changeName(StudentInfo studentInfo) {
		
	    System.out.println("Enter name to be Edit ");
		Scanner scanner = new Scanner(System.in);
	    String n = scanner.nextLine();
		
		studentInfo.setname(n);
		
	/*	StudentInfo info = null;
		for(int i=0;i<arraylist.size();i++) {
			
			 info = arraylist.get(i);
			if(info.getname().equals(n)) {
				System.out.println("Enter new Name");
				String nn = in.next();
				info.setname(nn);
				
				if(info.getname().equals(nn)) {
					System.out.println("Name Successfully Changed.");
				}
				else {
					System.out.println("Error in Changing name...");
				}
			}
			else {
					System.out.println("Record Name not Found...");
				
			}
			
			
		}*/
	}
	
	
	public static void changeDoa(StudentInfo studentinfo) {
		
		System.out.println("Enter Date to be Edit ");
		Scanner scann = new Scanner(System.in);
		String n = scann.nextLine();
		
		
		studentinfo.setDOA(n);
		
		/*
		StudentInfo info = null;
		for(int i=0;i<arraylist.size();i++) {
			
			 info = arraylist.get(i);
			if(info.getDOA().equals(n)) {
				System.out.println("Enter new Date");
				String nn = in.next();
				info.setDOA(nn);
				
				if(nn.equals(info.getDOA())) {
					System.out.println("Date Successfully Changed.");
				}
				else {
					System.out.println("Error in Changing Date...");
				}
			}
			else {
					System.out.println("Record Date not Found...");
				
			}
		}
	*/
	}
	
	public static void changeClass(StudentInfo studentinfo) {
		
		System.out.println("Enter Class to be Edit ");
		Scanner scann = new Scanner(System.in);
		String n = scann.nextLine();

		
		studentinfo.setClaass(n);
		/*
		StudentInfo info = null;
		for(int i=0;i<arraylist.size();i++) {
			
			 info = arraylist.get(i);
			if(info.getClaass().equals(n)) {
				System.out.println("Enter new Class");
				String nn = in.next();
				info.setClaass(nn);
				
				if(info.getClaass().equals(nn)) {
					System.out.println("Class Successfully Changed.");
				}
				else {
					System.out.println("Error in Changing Class...");
				}
			}
			else {
					System.out.println("Record Class not Found...");
				
			}
		*/
		}
	
	}

	

	
	
	
	
	
	
	

