package cn.hl.bean;

public class Student {
	//私有成员字段
	private int stuNo;
	private String stuName;
	private boolean gender;
	private int age;
	private String address;
	private String tel;
	//无参构造函数
	public Student() {
		
	}
	//get/set访问器
	public int getStuNo() {
		return stuNo;
	}
	public void setStuNo(int stuNo) {
		this.stuNo = stuNo;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public boolean isGender() {
		return gender;
	}
	public void setGender(boolean gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	private int state;
	
	@Override
	public String toString() {
		return "Student [stuNo=" + stuNo + ", stuName=" + stuName + ", gender="
				+ gender + ", age=" + age + ", address=" + address + ", tel="
				+ tel + ", state=" + state + "]";
	}
	
	
}
