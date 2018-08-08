
package cn.hl.action;

import com.opensymphony.xwork2.Action;



/**
 * 属性驱动方式获取表单数据（基本类型作为属性）
 * 
 * 	将表单提交的数据以Action属性（成员字段）的形式进接收
 * 
 * @author Terry
 *
 */
public class UserAction implements Action{
	private String userName;
	private String account;
	private String pwd;
	
	/**
	 * 请求处理方法
	 */
	@Override
	public String execute(){
		System.out.println("userName = " + userName);
		System.out.println("account = " + account);
		System.out.println("pwd = " + pwd);
		System.out.println("==========================================\n");
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

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}


	@Override
	public String toString() {
		return "UserAction [userName=" + userName + ", account=" + account
				+ ", pwd=" + pwd + "]";
	}
}
