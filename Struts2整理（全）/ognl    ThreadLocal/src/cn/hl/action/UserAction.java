package cn.hl.action;

import com.opensymphony.xwork2.ActionContext;

public class UserAction {
	private String userName;
	private String account;
	private int age;
	/**
	 * 请求处理方法
	 * @return
	 */
	public String execute(){
		
		return "success";
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
	
	
}
