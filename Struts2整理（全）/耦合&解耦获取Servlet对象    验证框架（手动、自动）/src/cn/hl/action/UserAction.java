package cn.hl.action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Struts2验证框架
 * 	必须继承于ActionSupport并重写Validate()方法
 * @author Terry
 *
 */
public class UserAction extends ActionSupport{
	private String userName;
	private String account;
	private String pwd;
	
	/**
	 * 输入验证
	 * 定义验证代码
	 */
	@Override
	public void validate() {
		System.out.println("validate is do......");
	}
	
	/**
	 * 为reg()方法定义的验证代码
	 * 命名方式：validate+方法名
	 */
	public void validateReg(){
		//编写数据验证代码
		// 用户名：不能为空且长度为6~20
		if (userName == null || userName.length() < 6 || userName.length() > 20)
			this.addActionError("用户名不合法");

		// 账号：不能为空且长度为6~20
		if (account == null || account.length() < 6 || account.length() > 20)
			this.addActionError("账号名不合法");

		// 密码：6个长度
		if (pwd.length() != 6)
			this.addActionError("密码应为6个长度内容");
		
		System.out.println("validateReg is do......");
	}

	/**
	 * 请求处理方法
	 * @return
	 */
	public String reg(){
		System.out.println("userName = " + userName);
		System.out.println("account = " + account);
		System.out.println("pwd = " + pwd);
		
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
	
}
