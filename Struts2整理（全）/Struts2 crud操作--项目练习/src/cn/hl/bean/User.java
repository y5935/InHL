package cn.hl.bean;

public class User {
	private int userId;
	private String userName;
	private String account;
	private String pwd;
	private int age;
	private boolean gender;
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	public User(int userId, String userName, String account, String pwd,
			int age, boolean gender) {
		this.userId = userId;
		this.userName = userName;
		this.account = account;
		this.pwd = pwd;
		this.age = age;
		this.gender = gender;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName
				+ ", account=" + account + ", pwd=" + pwd + ", age=" + age
				+ ", gender=" + gender + "]";
	}
	
}
