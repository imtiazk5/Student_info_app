package model;

public class EmployeeModel {

	
	
	private Integer employeeId;
	private String employeeName;
	private Integer employeeLeaves;
	private Integer employeeSalary;
	private String employeeDepartment;
	private String employeeCompany;
	private String employeeShift;
	public Integer getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public Integer getEmployeeLeaves() {
		return employeeLeaves;
	}
	public void setEmployeeLeaves(Integer employeeLeaves) {
		this.employeeLeaves = employeeLeaves;
	}
	public Integer getEmployeeSalary() {
		return employeeSalary;
	}
	public void setEmployeeSalary(Integer employeeSalary) {
		this.employeeSalary = employeeSalary;
	}
	public String getEmployeeDepartment() {
		return employeeDepartment;
	}
	public void setEmployeeDepartment(String employeeDepartment) {
		this.employeeDepartment = employeeDepartment;
	}
	public String getEmployeeCompany() {
		return employeeCompany;
	}
	public void setEmployeeCompany(String employeeCompany) {
		this.employeeCompany = employeeCompany;
	}
	public String getEmployeeShift() {
		return employeeShift;
	}
	public void setEmployeeShift(String employeeShift) {
		this.employeeShift = employeeShift;
	}
	
	
	public EmployeeModel(String employeeName , Integer leaves, Integer salary,String copmany) {
		
		this.employeeName = employeeName;
		this.employeeLeaves =leaves;
		this.employeeSalary = salary;
		this.employeeCompany = copmany;
	}
	public EmployeeModel() {
		// TODO Auto-generated constructor stub
	}
}
