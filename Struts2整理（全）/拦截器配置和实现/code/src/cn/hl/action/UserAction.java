package cn.hl.action;

public class UserAction {
	private String userName;
	private String account;
	
	
	/**
	 * 请求处理方法
	 * @return
	 */
	public String add(){
		System.out.println("userName = " + userName);
		System.out.println("account = " + account);
		System.out.println("add() method is do......");
		
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
	
}
