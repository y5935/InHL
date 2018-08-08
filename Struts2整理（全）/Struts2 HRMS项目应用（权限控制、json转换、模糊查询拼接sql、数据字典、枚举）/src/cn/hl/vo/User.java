package cn.hl.vo;

import java.util.Set;

public class User {
	private int userId;
	private String account;
	private String pwd;
	private String userName;
	private int state;
	
	
	public User() {
	}

	public User(int userId, String account, String pwd, String userName,
			int state) {
		this.userId = userId;
		this.account = account;
		this.pwd = pwd;
		this.userName = userName;
		this.state = state;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", account=" + account + ", pwd="
				+ pwd + ", userName=" + userName + ", state=" + state + "]";
	}
	
}
