package cn.hl.action;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;

import cn.hl.service.UserService;
import cn.hl.vo.User;

public class UserAction {
	private User user;
	private UserService service = new UserService();
	
	/**
	 * 执行用户登录验证
	 * @return
	 * @throws IOException 
	 */
	public String login() throws IOException{
		//执行登录验证
		int result = service.login(user.getAccount(), user.getPwd());
		
		//验证结果发送给客户端
		HttpServletResponse resp = ServletActionContext.getResponse();
		resp.getWriter().print(result);
		
		return null;
	}
	
	/**
	 * 注销当前用户
	 * @return
	 */
	public String logout(){
		//清除当前用户的Session信息
		ActionContext.getContext().getSession().remove("user");
		
		return "login";
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
