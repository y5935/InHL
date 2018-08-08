package cn.hl.action;

import com.opensymphony.xwork2.ActionSupport;

public class EpmAction extends ActionSupport{
	private String userName;
	private String account;
	private String pwd;
	private int age;
	
	/**
	 * 请求处理方法
	 * @return
	 */
	public String add(){
		System.out.println("userName = " + userName);
		System.out.println("account = " + account);
		System.out.println("pwd = " + pwd);
		System.out.println("age = " + age);
		
		return SUCCESS;
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
	
}
