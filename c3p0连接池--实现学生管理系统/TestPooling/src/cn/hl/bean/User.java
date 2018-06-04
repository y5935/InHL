package cn.hl.bean;

public class User {
	//JavaBean三要素：
	//1.私有成员字段（类型、命名与数据表中一致）
	//2.get/set访问器
	//3.无参构造函数（一般是为反射所定义的）
	private int userId;
	private String userName;
	private String account;
	private String pwd;
	
	
	public User() {
		
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

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName
				+ ", account=" + account + ", pwd=" + pwd + "]";
	}
	
	
}
