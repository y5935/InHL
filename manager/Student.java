package cn.hl.manager;

/**
 * JavaBean
 * 		三要素：
 * 			1、私有成员字段
 * 			2、无参构造函数
 * 			3、公共的访问接口
 * @author X230
 * @version v1.0
 *
 */
public class Student {
	//成员变量、成员字段、成员属性
	private int stuNo;
	private String stuName;
	private char gender;
	private int age;
	private String grade;


	//构造函数
	/**
	 * 无参构造函数
	 * 在框架中一般都是通过反射技术调用的无参构造
	 */
	public Student() {
	}

	/**
	 * 带参构造函数
	 * 初始化学生的基本信息
	 * @param stuNo		：学号
	 * @param stuName	：姓名
	 * @param gender	：性别
	 * @param age		：年龄
	 */
	public Student(int stuNo, String stuName, char gender, int age) {
		this.stuNo = stuNo;
		this.stuName = stuName;
		this.gender = gender;
		this.age = age;
	}

	/**
	 * 带参构造函数
	 * 初始化学生信息
	 * @param stuNo		：学号
	 * @param stuName	：姓名
	 * @param gender	：性别
	 * @param age		：年龄
	 * @param grade		：所属班级
	 */
	public Student(int stuNo, String stuName, char gender, int age, String grade) {
		this.stuNo = stuNo;
		this.stuName = stuName;
		this.gender = gender;
		this.age = age;
		this.grade = grade;
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

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	
}
