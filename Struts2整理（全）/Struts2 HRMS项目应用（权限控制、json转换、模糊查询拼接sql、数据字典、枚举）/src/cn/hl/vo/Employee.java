package cn.hl.vo;

import java.util.Date;





public class Employee {
	private int empId;
	private String empName;
	private boolean gender;
	//private Date birthDay;
	private int DeptId;
	private int positionId;
	private int Education;
	private int degree;
	private int state;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(int empId, String empName, boolean gender, Date birthDay,
			int deptId, int positionId, int education, int degree, int state) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.gender = gender;
		//this.birthDay = birthDay;
		DeptId = deptId;
		this.positionId = positionId;
		Education = education;
		this.degree = degree;
		this.state = state;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	/*
	public Date getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}
	*/
	public int getDeptId() {
		return DeptId;
	}

	public void setDeptId(int deptId) {
		DeptId = deptId;
	}

	public int getPositionId() {
		return positionId;
	}

	public void setPositionId(int positionId) {
		this.positionId = positionId;
	}

	public int getEducation() {
		return Education;
	}

	public void setEducation(int education) {
		Education = education;
	}

	public int getDegree() {
		return degree;
	}

	public void setDegree(int degree) {
		this.degree = degree;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}
	
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName
				+ ", gender=" + gender +  ", DeptId="
				+ DeptId + ", positionId=" + positionId + ", Education="
				+ Education + ", degree=" + degree + ", state=" + state + "]";
	}
	
	/*
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName
				+ ", gender=" + gender + ", birthDay=" + birthDay + ", DeptId="
				+ DeptId + ", positionId=" + positionId + ", Education="
				+ Education + ", degree=" + degree + ", state=" + state + "]";
	}
	*/
}
