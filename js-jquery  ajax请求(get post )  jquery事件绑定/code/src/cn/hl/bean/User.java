package cn.hl.bean;

public class User {
	private int no;
	private String name;
	private boolean gender;
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(int no, String name, boolean gender) {
		this.no = no;
		this.name = name;
		this.gender = gender;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}
}
