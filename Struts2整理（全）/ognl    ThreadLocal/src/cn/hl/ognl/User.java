package cn.hl.ognl;

public class User {
	private String userName;
	private String account;
	private int age;
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(String userName, String account, int age) {
		super();
		this.userName = userName;
		this.account = account;
		this.age = age;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "User [userName=" + userName + ", account=" + account + ", age="
				+ age + "]";
	}
}
