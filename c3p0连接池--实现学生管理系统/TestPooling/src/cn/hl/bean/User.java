package cn.hl.bean;

public class User {
	//JavaBean��Ҫ�أ�
	//1.˽�г�Ա�ֶΣ����͡����������ݱ���һ�£�
	//2.get/set������
	//3.�޲ι��캯����һ����Ϊ����������ģ�
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
