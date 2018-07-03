package cn.hl.bean;

public class User {
	private int userId;
	private String userName;
	private String account;
	private String pwd;
	
	//���캯��
	public User() {
	}
	

	public User(int userId, String userName, String account, String pwd) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.account = account;
		this.pwd = pwd;
	}

	//get/set������
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

	//��дtoString()����
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName
				+ ", account=" + account + ", pwd=" + pwd + "]";
	}
}
